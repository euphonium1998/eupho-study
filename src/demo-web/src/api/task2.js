import request from "@/utils/request";

export function saveCustomer(customer) {
    return request({
        url: '/customers/saveCustomer',
        method: 'post',
        data: customer
    })
}