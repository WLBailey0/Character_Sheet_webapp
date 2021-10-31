import axios from 'axios';

export default {
    getCharAttributes(id){
        return axios.get(`/character/attributes/${id}`)
    },


}