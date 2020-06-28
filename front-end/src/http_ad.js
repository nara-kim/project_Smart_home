import axios from 'axios'

export default axios.create({
  baseURL: 'http://118.40.211.166',
  headers: {
    'Content-type': 'application/json'
  }
})
