<template>
  <div>
    <v-snackbar top
                dark
                v-model="visible"
                :color="color"
    >


        {{ msg }}

        <template v-slot:action="{ attrs }">
          <v-btn
              v-if="showClose"
              text
              @click="close"
              v-bind="attrs"
              icon
          >
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </template>



    </v-snackbar>
  </div>
</template>

<script>
export default {
  computed: {
    visible() {
      return this.$store.state.msgbar.visible;
    },
    showClose() {
      return this.$store.state.msgbar.showClose;
    },
    color() {
      return this.$store.state.msgbar.color;
    },
    msg() {
      return this.$store.state.msgbar.msg;
    }
  },
  methods: {
    close() {
      this.$store.commit('msgbar/CLOSE_SNACKBAR')
    }
  }
}
</script>

<style scoped>

</style>