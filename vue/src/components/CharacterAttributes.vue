<template>
  <div>
      <h1>ATTR</h1>
  </div>
</template>

<script>
import attributeService from '../services/AttributesService';
export default {
    data(){
        return{
            attributes: {

            },
        }
    },
    created(){
        attributeService.getCharAttributes(this.$route.params.id).then(results => {
            this.attributes = results.data;
        })
    }
}
</script>

<style>

</style>