<template>
  <div >
    <div class="top">
      <h1>{{character.name}}</h1>
      <h1>{{character.charClass}} {{character.level}}</h1>
    </div>
    <div class="actions">
      <button class="long" v-on:click="longRest()">Long Rest</button>
      <button class="lvlUp">Level Up</button>
    </div>
    <div class="main-attr-top">
      <h2>Inititave</h2>
      <h2>Health</h2>
      <h2>Speed</h2>
    </div>
    <div class="main-attr-top">
      <h4>{{character.inititave}}</h4>
      <h3>{{character.health}}</h3>
      <h4>{{character.speed}}</h4>
    </div>
    <div class="btn">
      <button v-on:click="healthUp()">+</button>
      <button v-on:click="healthDown()" >-</button>
    </div>
    <h3 class="spell">Cantrips</h3>
    <div class="spells" v-for="cantrip in cantrips" :key="cantrip.id">
      <h4>{{cantrip.spellName}}</h4>
      <h4>{{cantrip.spellDice}} </h4>
    </div>
    <h3 class="spell">Spells</h3>
    <div class="spells" v-for="spell in spells" :key="spell.id" :class="{'used': !spell.usable}">
      <h4>{{spell.spellName}}</h4>
      <h4>{{spell.spellDice}}</h4>
      <h4>lvl: {{spell.spellLevel}} 
        
      </h4>
      <input type="checkbox" name="checked" id="checked" :checked="spell.usable" v-on:click="check(spell.spellId)" v-model="spell.usable">
      
    </div>
  </div>
</template>

<script>
import characterService from '../services/CharacterService';
import spellService from '../services/SpellService';
export default {
  data(){
    return{
     
      character: {
      },
      cantrips: [],
      spells: [],
      loading: true,
    }
  },
  created(){
    this.character.id = this.$route.params.id
    characterService.getCharacter(this.character.id).then(result => {
      this.character = result.data;
    });
    spellService.getAvailableSpells(this.character.id).then(result => {
      this.spells = result.data;
    });
    spellService.getCantrips(this.character.id).then(result => {
      this.cantrips = result.data;
    });

  },
  methods:{
    check(id){
       spellService.changeUsable(id);
    },
    healthUp(){
      characterService.healthUp(this.character.charId).then(
        this.character.health += 1
      );
    },
    healthDown(){
      characterService.healthDown(this.character.charId).then(
        this.character.health -= 1
      );
    },
    longRest(){
      characterService.characterLongRest(this.$route.params.id).then(
        this.character.health = this.character.baseHealth
      );
      spellService.spellLongRest(this.$route.params.id).then(this.spells.forEach(spell => {
        spell.usable = true;
      }))
      
    },
  },
}

</script>

<style>
.top{
  display: flex;
  direction: row;
  justify-content: space-around;
}
.actions{
  display: flex;
  justify-content: space-evenly;
}
button{
  background-color: #f2cc8f;
  font-weight: strong;
}
.main-attr-top{
  display: flex;
  direction: row;
  justify-content: space-around;
}
.spells{
  display: flex;
  justify-content: center;
  border: 1px solid black;
  width: 200px;
  height: 75px;
  margin: auto;
  background-color: #e07a5f;
}
.spells > h4{
  padding: 5px;
}
.spell{
  text-align: center;
}
.used{
  background: #3d405b;;
}
.btn{
  display: flex;
  justify-content: center;
}
input{
  margin-top: 35px;
}
</style>