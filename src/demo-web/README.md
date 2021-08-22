# demo-web

## Notice

+ 基于 `spring-boot-demo` 仓库中的 `rbac-security-demo` 制作
+ 后端地址在 `@/utils/request.js` 中配置
+ 由于后端 demo 未提供拉取用户信息的接口，到目前为止暂时采用直接解码 Token 的 Payload 部分获取用户角色信息的方法（不安全）

## Utils

### Axios 拦截器

对 `@/utils/request.js` 中的 axios 拦截器做了改动，每次通过这个工具类发送请求时都会自动带上浏览器客户端 `localStorage` 中的 Token.

对 Response 的拦截处理和消息提示还没有写，这里需要前后端约定好自定义错误码.

```javascript
service.interceptors.request.use(
        config => {
          if (localStorage.token) {
            config.headers.authorization = 'Bearer ' + localStorage.token;
          }
          return config;
        }, 
```

### Token Util

`@/utils/token.js`

含设置、获取、删除、解析 Token 的方法

## APIs

`@/api/auth/user.js`

+ 登入
+ 登出
+ 拉取用户信息
+ 获取角色

`@/api/auth/permission.js`

+ 路由鉴权
+ 过滤生成合法路由表

## Global Status

`@/store/modules/user.js`

此处定义了以下全局状态和方法：

+ state
  + 用户名
  + 角色
  + 合法路由表
+ actions
  + 登录
  + 登出
  + 获取角色
  + 生成合法路由表

## Routes

### 路由拦截

所有逻辑位于 `@/router/routerInterceptor.js` 中

### 路由鉴权

关于路由，说明一下大致思路. `@/router/index` 里存放了两份路由表，一份是公用路由表 `defaultRoutes`，一份是需要鉴权的路由表 `asyncRoutes`.

`defaultRoutes` 只包含公用路由，如登入页面、空白主页、404 页面

`asyncRoutes` 则是包含了所有需要鉴权的路由的一份表，其中路由的权限信息由 `meta.roles` 表示，对应的菜单名称由 `meta.menuName` 表示

```javascript
{
  path: 'task4',
          components
:
  {
    main: () => import('../views/demoTasks/Task4'),
  }
,
  meta: {
    roles: ['admin', 'user'],
            menuName
  :
    '任务4'
  }
,
}
,
```

那么在获取到当前用户的角色信息以后，就要根据这个角色来对这份鉴权路由表进行过滤，生成当前用户合法的路由表. 这里使用简单的递归来进行过滤

```javascript
export function filterAsyncRoutes(routes, roleType) {
  let filteredRoutesList = [];
  routes.forEach(route => {

    // 不直接操作route，而是复制一份，否则会改变传进来的原路由表
    let tmp = {...route};

    if (hasRoutePermission(tmp, roleType)) {
      if (route.children) {
        tmp.children = filterAsyncRoutes(route.children, roleType);
      }
      filteredRoutesList.push(tmp);
    }
  });
  return filteredRoutesList;
}
```

### 侧边栏菜单

目前只有 Home 页面需要侧边栏菜单，目前采取在 `Home.vue` 的 `methods` 中加入 `getLinks()` 方法（此方法从全局状态中获取用户合法路由表，稍做处理后生成对应的 list 使用 `v-for`
绑定到视图上），在 Home 页面的 `mounted` 钩子上挂载该方法，使得页面在被渲染时就生成侧边栏菜单.

```javascript
getLinks()
{
  let linkList = [];
  this.$store.state.user.permittedRouteList.forEach(route => {
    if (route.name === 'Home' && route.children) {
      route.children.forEach(subRoute => {
        if (!subRoute.hasOwnProperty('sidebarHidden') || subRoute.sidebarHidden === false) {
          linkList.push(subRoute);
        }
      })
      this.links = linkList;
      return;
    }
  })
}
```

在路由表中，使用 `sidebarHidden` 属性来标识一个路由是否需要被显示在菜单栏上.

```javascript
{
  path: 'user',
          components
:
  {
    main: UserPage
  }
,
  sidebarHidden: true,
          meta
:
  {
    roles: ['user'],
  }
,
}
,
```

## Custom Components

### 全局信息提示条

参考网上方案封装了全局消息条 `Msgbar`，调用时会在顶部弹出消息框（有关闭按钮，默认2s后消失）

在 `App.vue` 中放置的元素 `<Msgbar style="height: 0"></Msgbar>` 不要删除.

组件位置：

+ `@/components/_partial/Msgbar.vue`
+ `@/store/modules/msgbar.js`

调用方法：

```javascript
import customAlert from "./custom-alert";

customAlert('希望提示的消息', '提示框颜色'); // 可选颜色：primary/warning/error/info
```

默认计时为 2s，可在 `@/store/modules/msgbar.js` 中修改
```javascript
state: {
    msg: '',
    visible: false,
    showClose: true,
    timeout: 2000, // Snackbar 弹出后的自动消失计时
    color: ''
}
```