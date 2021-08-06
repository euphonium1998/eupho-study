import request from "@/utils/request";

export function changeNodeId(data) {
  return request({
    url: '/productNote/updateNoteTextByNoteId',
    method: 'post',
    // headers: {
    //   "Content-Type": "multipart/form-data"
    // },
    // withCredentials:true,
    data

  })
}