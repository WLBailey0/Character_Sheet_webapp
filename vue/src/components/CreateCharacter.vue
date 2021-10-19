<template>
  <div>
    <div class="form">
      <form  v-on:submit.prevent="create">
      
          <label for="name">Name:</label>
          <input type="text" id="name" v-model="character.name">
      
          <label for="class">Class:</label>
          <input type="text" id="class" v-model="character.charClass">
        
          <label for="health">Health: </label>
          <input type="text" v-model="character.health">
      
          <label for="ac">Armor Class:</label>
          <input type="text" id="ac" v-model="character.armorClass">
      
          <label for="hd">Hit Dice:</label>
          <input type="text" id="hd" v-model="character.hitDice">
      
          <label for="init">Inititave: </label>
          <input type="text" name="init" id="init" v-model="character.inititave">
      
          <label for="speed">Speed: </label>
          <input type="text" v-model="character.speed">
      
          <label for="proficiency">Proficiency: </label>
          <input type="text" v-model="character.proficiency">
      
          <label for="level">Level: </label>
          <input type="text" name="level" id="level" v-model="character.level">
      
          <input type="submit" name="submit" id="submit" v-on:submit.prevent="create">
      
      </form>
    </div>
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
        userId: this.$route.params.id
      }
    }
  },
  methods:{
    create(){
      characterService.createCharacter(this.$route.params.id, this.character).then(this.$router.push({name: 'home', params: {id: this.$route.params.id}}))
    }
  }
}
</script>

<style>
.form{
  display: flex;
  flex-direction: column;

}

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
  width: 200px;
}

</style>