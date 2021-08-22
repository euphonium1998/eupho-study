
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
            link
            :to="link.path"
        >
          <v-list-item-content>
            <v-list-item-title>{{ link.meta.menuName }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Application</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-btn outlined
             color="blue-grey"
             @click="test"
      >
        Test
      </v-btn>
      <v-btn icon @click="userInfoPage">
        <v-icon>mdi-account</v-icon>
      </v-btn>
      <v-btn icon @click="userLogout">
        <v-icon>mdi-logout-variant</v-icon>
      </v-btn>
    </v-app-bar>


    <!-- 给应用提供合适的间距 -->
    <v-container fluid>

      <!-- 如果使用 vue-router -->
      <router-view name="main"></router-view>
    </v-container>

  </v-app>
</template>

<script>
import request from "../utils/request";
import customAlert from "../api/alert/custom-alert";

export default {
  name: 'Home',
  data: () => ({
    cards: ['Today', 'Yesterday'],
    drawer: null,
    link: [
      ['mdi-numeric-0', 'Example'],
      ['mdi-numeric-1', 'Task1'],
      ['mdi-numeric-2', 'Task2'],
      ['mdi-numeric-3', 'Task3'],
      ['mdi-numeric-4', 'Task4'],
      ['mdi-numeric-5', 'Task5'],
      ['mdi-numeric-6', 'Task6'],
    ],
    links: []
  }),
  mounted: function () {
    this.getLinks();
  },
  methods: {
    // 根据全局状态中的当前用户路由表生成对应侧边栏（尚不完善，未封装）
    getLinks() {
      let linkList = [];
      this.$store.state.user.permittedRouteList.forEach(route => {
        if (route.name === 'Home' && route.children) {
          route.children.forEach(subRoute => {
            if (!subRoute.hasOwnProperty('sidebarHidden') || subRoute.sidebarHidden === false) {
              linkList.push(subRoute);
            }
          })
          this.links = linkList;
          return;
        }
      })
    },

    jumpToTask(index) {
      if (index === 0) {
        this.$router.push('/home/example')
      } else {
        this.$router.push('/home/task' + index.toString())
      }
    },

    jumpToLogin() {
      this.$router.replace({ path: '/login' });
    },

    userLogout() {
      this.$store.dispatch('user/logout');
      this.$router.replace({
        path: '/login'
      })
    },

    //用于测试接口权限认证
    test() {
      request({
        url: '/demo/test',
        method: 'get',
      }).then(resp => {
        console.log(resp);
        customAlert(resp.data.message);
      })
    },

    userInfoPage() {
      this.$router.push({
        path: '/home/user'
      })
    }
  },

  computed: {}
}
</script>