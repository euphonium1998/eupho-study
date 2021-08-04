import request from "@/utils/request";

export function selectAllProductNote() {
  return request({
    url: '/productNote/selectAllProductNote',
    method: 'get',
  })
}