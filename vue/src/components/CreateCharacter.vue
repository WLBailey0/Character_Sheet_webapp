<template>
<div>
  <form class="form" v-on:submit.prevent="create">
    <div>
      <label for="name">Name:</label>
      <input type="text" id="name" v-model="character.name">
    </div>
    <div>
      <label for="class">Class:</label>
      <input type="text" id="class" v-model="character.charClass">
    </div>
    <div>
      <label for="health">Health: </label>
      <input type="text" v-model="character.health">
    </div>
    <div>
      <label for="ac">Armor Class:</label>
      <input type="text" id="ac" v-model="character.armorClass">
    </div>
    <div>
      <label for="hd">Hit Dice:</label>
      <input type="text" id="hd" v-model="character.hitDice">
    </div>
    <div>
      <label for="init">Inititave: </label>
      <input type="text" name="init" id="init" v-model="character.inititave">
    </div>
    <div>
      <label for="speed">Speed: </label>
      <input type="text" v-model="character.speed">
    </div>
    <div>
      <label for="proficiency">Proficiency: </label>
      <input type="text" v-model="character.proficiency">
    </div>
    <div>
      <label for="level">Level: </label>
      <input type="text" name="level" id="level" v-model="character.level">
    </div>
    <div>
      <input type="submit" name="submit" id="submit" v-on:submit.prevent="create">
    </div>
  </form>
</div>
</template>

<script>
import characterService from '../services/CharacterService';
export default {
  data(){
    return{
      character:{
        name: "",
        health: "",
        inititave: "",
        speed: "",
        hitDice: "",
        armorClass: "",
        proficiency: "",
        charClass:"",
        level: 1,
        id: this.$route.params.id
      }
    }
  },
  methods:{
    create(){
      characterService.getCharacter(this.$route.params.id, this.character).then(response => {
        if(response.status === 200){
          this.$router.push({name: 'home'});
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