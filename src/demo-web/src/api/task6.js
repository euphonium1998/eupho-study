import request from "@/utils/request";

export function changeNodeId(formData) {
  return request({
    url: '/task6',
    method: 'post',
    headers: {
      "Content-Type": "multipart/form-data"
    },
    withCredentials:true,
    data:formData

  })
}