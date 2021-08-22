import router from "../../router";

/**
 * 判断当前角色是否拥有某个路由的权限
 * @param route 待判断路由
 * @param roleType 角色类型
 * @returns {boolean}
 */
function hasRoutePermission(route, roleType) {
    if (route.meta && route.meta.roles) {
        return route.meta.roles.includes(roleType);
    } else {
        return true;
    }
}

// 递归过滤生成当前角色有权限的路由表
/**
 * 传入需要鉴权的路由表，过滤生成一份适合当前角色的路由表
 * @param routes 鉴权路由表，一般是asyncRoutes
 * @param roleType 当前角色
 * @returns Array 过滤后路由表
 */
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

// deprecated
export function addPermittedRoutesIntoRouter(routes, roleType) {
    const permittedRoutes = filterAsyncRoutes(routes, roleType);
    console.log(permittedRoutes);
    router.addRoutes(permittedRoutes);
}