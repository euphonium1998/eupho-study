import request from "@/utils/request";

export function changeNodeId() {
  return request({
    url: '/task6',
    method: 'post',
  })
}