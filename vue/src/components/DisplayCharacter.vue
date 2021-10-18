<template>
  <div>
    <div class="top">
      <h2>{{character.name}}</h2>
      <h2>{{character.charClass}} {{character.level}}</h2>
    </div>
    <div class="main-attr-top">
      <h3>Inititave</h3>
      <h3>Health</h3>
      <h3>Speed</h3>
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
        <input type="checkbox" name="checked" id="checked" :checked="spell.usable" v-on:click="check(spell.spellId)" v-model="spell.usable">
      </h4>
      
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
    spellService.getAvailableCantrips(this.character.id).then(result => {
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
  },
}
//<button v-on:click="check(spell.spellId)" v-bind="spell.usable">Use</button>
// <input type="checkbox" name="checked" id="checked" :checked="spell.usable" v-on:checked="check(spell.spellId)" v-model="spell.usable">
</script>

<style>
.top{
  display: flex;
  direction: row;
  justify-content: space-around;
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
}
.spells > h4{
  padding: 10px;
}
.spell{
  text-align: center;
}
.used{
  background: red;
}
.btn{
  display: flex;
  justify-content: center;
}
</style>