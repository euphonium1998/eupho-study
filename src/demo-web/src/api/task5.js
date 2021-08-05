import request from "@/utils/request";

export function selectByPordId(formData) {
  return request({
    url: '/task5',
    method: 'post',
    headers: {
      "Content-Type": "multipart/form-data"
    },
    withCredentials:true,
    data:formData
  })
}