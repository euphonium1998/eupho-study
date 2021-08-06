import request from "@/utils/request";

export function changeNodeId(data) {
  return request({
    url: '/productNote/updateNoteTextByNoteId',
    method: 'post',
    data

  })
}