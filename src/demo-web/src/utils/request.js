import axios from "axios";
import {Notification} from 'element-ui';
import customAlert from "../api/alert/custom-alert";

const service = axios.create({
  baseURL: 'http://localhost:16666',
  /*baseURL: 'http://47.97.202.211:16666,'*/ // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000 // request timeout
})

// request interceptor
service.interceptors.request.use(

    config => {
    if (localStorage.token) {
      config.headers.authorization = 'Bearer ' + localStorage.token;
    }
    return config;
  },

  error => {
    console.log(error) // for debug
    console.log('err');
    return Promise.reject(error)
  }
)


// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
   */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    if (response.data.code !== 200) {
      customAlert(response.data.message, 'error');
    }
    return response;
  },

  error => {
    console.log('err' + error) // for debug
    Notification({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service