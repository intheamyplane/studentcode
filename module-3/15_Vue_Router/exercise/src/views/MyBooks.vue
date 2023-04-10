<template>
  <div>
    <reading-list />
     <router-link to="/addBook" />
    
  </div>
 
</template>



<script>

import ReadingList from '../components/ReadingList.vue';

export default {
  components: {
    ReadingList
  },
};
</script>
    

<style scoped>
</style>