(function (win) {
  axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
  // Create an Axios instance
  const service = axios.create({
    // The request in Axios is configured with the baseURL option, which indicates the public part of the request URL
    baseURL: '/',
    // overtime
    timeout: 1000000
  })
  // Request interceptor
  service.interceptors.request.use(config => {

    if (config.method === 'get' && config.params) {
      let url = config.url + '?';
      for (const propName of Object.keys(config.params)) {
        const value = config.params[propName];
        var part = encodeURIComponent(propName) + "=";
        if (value !== null && typeof(value) !== "undefined") {
          if (typeof value === 'object') {
            for (const key of Object.keys(value)) {
              let params = propName + '[' + key + ']';
              var subPart = encodeURIComponent(params) + "=";
              url += subPart + encodeURIComponent(value[key]) + "&";
            }
          } else {
            url += part + encodeURIComponent(value) + "&";
          }
        }
      }
      url = url.slice(0, -1);
      config.params = {};
      config.url = url;
    }
    return config
  }, error => {
      console.log(error)
      Promise.reject(error)
  })

  // Response interceptor
  service.interceptors.response.use(res => {
      console.log('---Response interceptor---',res)
      // If no status code is set, the status succeeds by default
      const code = res.data.code;
      // Getting error messages
      const msg = res.data.msg
      console.log('---code---',code)
      if (res.data.code === 0 && res.data.msg === '未登录') {// 返回登录页面

        console.log('---/backend/page/login/login.html---',code)
        localStorage.removeItem('userInfo')
        window.top.location.href = '/backend/page/login/login.html'
      } else {
        return res.data
      }
    },
    error => {
      console.log('err' + error)
      let { message } = error;
      if (message == "Network Error") {
        message = "The connection to the back-end interface is abnormal";
      }
      else if (message.includes("timeout")) {
        message = "The system interface request timed out";
      }
      else if (message.includes("Request failed with status code")) {
        message = "System interface" + message.substr(message.length - 3) + "abnormal";
      }
      window.ELEMENT.Message({
        message: message,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(error)
    }
  )
  win.$axios = service
})(window);
