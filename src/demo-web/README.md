# demo-web

## Utils
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

## API
`@/api/auth/authentication.js` 封装了负责登入和登出的请求

## Custom Component

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