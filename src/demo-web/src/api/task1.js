import request from "@/utils/request";

export function selectProductByPrice(priceLowerBoundParam) {
    return request({
        url: '/product/selectProductByPrice',
        method: 'get',
        params: priceLowerBoundParam
    })
}