import axios from "axios";

export default{
    getCantrips(id){
        return axios.get(`/spells/cantrip/${id}`);
    },
    getSpells(id){
        return axios.get(`/spells/${id}`);
    },
    getAvailableCantrips(id){
        return axios.get(`/spells/available/cantrips/${id}`);
    },
    getAvailableSpells(id){
        return axios.get(`/spells/available/spells/${id}`);
    },
    changeUsable(id){
        return axios.put(`/spells/usable/${id}`);
    },
    addSpell(id, spell){
        return axios.post(`/spells/${id}`, spell);
    },
    changeAvailable(id){
        return axios.put(`/spells/available/${id}`);
    },
    spellLongRest(id){
        return axios.put(`/spells/long-rest/${id}`);
    },
}