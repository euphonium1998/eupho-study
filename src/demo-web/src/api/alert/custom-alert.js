import store from '../../store'

// 封装全局消息条方法
export default function customAlert(alertMsg, msgbarColor) {
    store.dispatch('msgbar/openSnackbar', {
        'msg': alertMsg,
        'color': msgbarColor
    })
}