<template>
  <div>
    <form v-on:submit.prevent="create">
      <label for="name">Name: </label>
      <input type="text" id="name" v-model="spell.spellName">
      
      <label for="hitdice">Hit Dice: </label>
      <input type="text" id="hitdice" v-model="spell.spellDice">

      <label for="level">Spell Level: </label>
      <input type="text" name="level" id="level" v-model="spell.spellLevel">

      <label for="cantrip">Cantrip: </label>
      <input type="checkbox" name="cantrip" id="cantrip" v-model="spell.cantrip">

      <input type="submit" value="submit" v-on:submit.prevent="create">




    </form>
  </div>
</template>

<script>
import spellService from '../services/SpellService';
export default {
  data(){
    return{
      spell: {
        charId: this.$route.params.id,
        spellName: "",
        spellDice: "",
        spellLevel: "",
        cantrip: false,
        usable: true
      },
    }
  },
  methods:{
      create(){
          spellService.addSpell(this.$route.params.id, this.spell).then(response => {
              if(response.status === 200){
                  this.$router.push({name: 'displayCharacter', params:{id: this.$route.params.id}})
              }
          })
      }
  }
}
</script>

<style>
label{
    display: inline-block;
    float: left;
    clear: left;
    width: 250px;
    text-align: right;
}
input {
  display: inline-block;
  float: left;
}
</style>