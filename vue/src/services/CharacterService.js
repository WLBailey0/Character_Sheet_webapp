import axios from "axios";

export default{
    getUserCharacters(id){
        return axios.get(`/characters/${id}`)
    },
    getCharacter(id){
        return axios.get(`/character/${id}`);
    },
    createCharacter(id, character){
        return axios.post(`/character/create/${id}`, character);
    },
}