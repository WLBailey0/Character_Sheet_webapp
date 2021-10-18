<template>
  <div>
      <div v-if="loading">
         <iframe src="https://giphy.com/embed/xT4uQfCi1CRcqtYsqk" width="480" height="480" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/primerstories-xT4uQfCi1CRcqtYsqk">via GIPHY</a></p>
      </div>
      <h2>Add Spell to Spellbook</h2>
      <router-link v-bind:to="{name: 'displayCharacter', params:{id: this.$route.params.id}}">Return to {{character.name}}</router-link>
      <div class = "form">
        
        <form v-on:submit.prevent="createSpell">
            <label>Create Spell</label>
            <label for="name">Name: </label>
            <input type="text" id="name" v-model="spell.spellName">
            
            <label for="hitdice">Hit Dice: </label>
            <input type="text" id="hitdice" v-model="spell.spellDice">

            <label for="level">Spell Level: </label>
            <input type="text" name="level" id="level" v-model="spell.spellLevel">

            <label for="cantrip">Cantrip: </label>
            <input type="checkbox" name="cantrip" id="cantrip" v-model="spell.cantrip">

            <input type="submit" value="submit" v-on:submit.prevent="createSpell">
        </form>
      </div>
      <h3>Known Cantrips:</h3>
      <div v-for="cantrip in cantrips" :key="cantrip.id">
          <h4>{{cantrip.spellName}} 
               <input type="checkbox" name="checked" id="checked" :checked="spell.available" v-on:click="makeAvailable(cantrip.spellId)" v-model="cantrip.available">
          </h4>
          
      </div>
      <h3>Known Spells: </h3>
        <div v-for="spell in spells" :key="spell.id">
            <h4>{{spell.spellName}} | level: {{spell.spellLevel}} 
                <input type="checkbox" name="checked" id="checked" :checked="spell.available" v-on:click="makeAvailable(spell.spellId)" v-model="spell.available"></h4>

        </div>
      <div>

      </div>
  </div>
</template>

<script>
import spellService from '../services/SpellService';
import characterService from '../services/CharacterService';
export default {
  data(){
    return{
      spell: {
        charId: this.$route.params.id,
        spellName: "",
        spellDice: "",
        spellLevel: "",
        cantrip: false,
        usable: true,
        available: false,
      },
      spells:[],
      cantrips:[],
      character:{},
      loading: true
    }
  },
  created(){
      spellService.getSpells(this.$route.params.id).then(result => {
          this.spells = result.data;
          console.log("Created spells")
      });
      spellService.getCantrips(this.$route.params.id).then(result => {
          this.cantrips = result.data;
      });
      characterService.getCharacter(this.$route.params.id).then(result => {
          this.character = result.data;
          this.loading = false;
      })
  },
  methods:{
      createSpell(){
          spellService.addSpell(this.$route.params.id, this.spell).then(response => {
              if(response.status === 200){
                  this.$router.push({name: 'displayCharacter', params:{id: this.$route.params.id}})
              }
          });
      },
      makeAvailable(id){
          spellService.changeAvailable(id)
      }
  }
}
</script>

<style>
.form{
    display: flex;
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
}
</style>