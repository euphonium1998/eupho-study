<template>
  <v-app id="inspire">

    <v-navigation-drawer
        v-model="drawer"
        app
    >
      <v-sheet
          color="grey lighten-4"
          class="pa-4"
      >
        <v-avatar
            class="mb-4"
            color="grey darken-1"
            size="64"
        >
          <v-icon dark large>
            mdi-account-circle
          </v-icon>
        </v-avatar>

        <div>demo-web</div>
      </v-sheet>

      <v-divider></v-divider>

      <v-list>
        <v-list-item
            v-for="(link, index) in links"
            :key="link[0]"
            link
            @click="jumpToTask(index)"
        >
          <v-list-item-icon>
            <v-icon>{{ link[0] }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ link[1] }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Application</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <!-- 给应用提供合适的间距 -->
      <v-container fluid>

        <!-- 如果使用 vue-router -->
        <router-view name="main"></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'Home',
  data: () => ({
    cards: ['Today', 'Yesterday'],
    drawer: null,
    links: [
      ['mdi-numeric-0', 'Example'],
      ['mdi-numeric-1', 'Task1'],
      ['mdi-numeric-2', 'Task2'],
      ['mdi-numeric-3', 'Task3'],
      ['mdi-numeric-4', 'Task4'],
      ['mdi-numeric-5', 'Task5'],
      ['mdi-numeric-6', 'Task6'],
    ],
  }),
  methods: {
    jumpToTask(index) {
      if (index === 0) {
        this.$router.push('/home/example')
      } else {
        this.$router.push('/home/task' + index.toString())
      }
    }
  }
}
</script>