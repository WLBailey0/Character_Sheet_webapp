<template>
  <div class="home">
    <h1> Create or Select character</h1>
    <router-link v-bind:to="{
      name: 'createCharacter',
      params: {id: this.$store.state.user.id}}">Create Character</router-link><br><br>
    <div v-for="character in characters" :key="character.id">
      <router-link v-bind:to="{
        name: 'displayCharacter',
        params: {id: character.charId}}">
        <strong>{{character.name}}</strong> {{character.charClass}} {{character.level}}
        </router-link>

    </div>
  </div>
</template>

<script>
import characterService from '../services/CharacterService'
export default {
  name: "home",
  data() {
    return {
      characters: [],
    }
  },
  created(){
    this.getUserCharacters();
  },
  methods: {
    getUserCharacters(){
      characterService.getUserCharacters(this.$store.state.user.id).then(result =>{
        this.characters = result.data;
      })
    }
  }
};
</script>
