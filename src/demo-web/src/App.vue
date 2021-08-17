<template>
  <v-app>
    <v-main>
      <router-view/>
      <Msgbar style="height: 0"></Msgbar>
    </v-main>
  </v-app>
</template>

<script>
import Msgbar from '@/components/_partial/Msgbar.vue'

export default {
  name: 'App',
  components: {
    Msgbar
  },

  data: () => ({
    //
  }),

};
</script>
