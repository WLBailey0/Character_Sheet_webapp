import axios from "axios";

export default{
    getCantrips(id){
        return axios.get(`/spells/cantrip/${id}`);
    },
    getSpells(id){
        return axios.get(`/spells/${id}`);
    },
    changeUsable(id){
        return axios.put(`/spells/usable/${id}`);
    },
    addSpell(id, spell){
        return axios.post(`/spells/${id}`, spell)
    }
}