import request from "@/utils/request";

export function selectByPordId(prod_id) {
  return request({
    url: '/product/selectVendorByProdId',
    method: 'get',
    params: {
      id: prod_id
    }
    
  })
}