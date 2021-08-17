import store from '../../store'

export default function customAlert(alertMsg, msgbarColor) {
    store.dispatch('msgbar/openSnackbar', {
        'msg': alertMsg,
        'color': msgbarColor
    })
}