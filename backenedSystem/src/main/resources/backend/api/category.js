// queryList
const getCategoryPage = (params) => {
  return $axios({
    url: '/category/page',
    method: 'get',
    params
  })
}

// editPageReverseCheckDetails
const queryCategoryById = (id) => {
  return $axios({
    url: `/category/${id}`,
    method: 'get'
  })
}

// deleteTheCurrentColumn
const deleCategory = (ids) => {
  return $axios({
    url: '/category',
    method: 'delete',
    params: { ids }
  })
}

// modify
const editCategory = (params) => {
  return $axios({
    url: '/category',
    method: 'put',
    data: { ...params }
  })
}

// newInterface
const addCategory = (params) => {
  return $axios({
    url: '/category',
    method: 'post',
    data: { ...params }
  })
}