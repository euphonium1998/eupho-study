import request from "@/utils/request";

export function selectByPordId(prod_id) {
  return request({
    // url: '/productNote/updateNoteTextByNoteId',
    url: '/product/selectVendorByProdId',
    method: 'get',
    params: {
      id: prod_id
    }
    // headers: {
    //   "Content-Type": "multipart/form-data"
    // },
    // withCredentials:true,
    // data:formData
    
  })
}