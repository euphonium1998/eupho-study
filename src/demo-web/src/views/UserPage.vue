<template>
  <div>
    <v-container>
      <v-row>
        <v-col>
          <v-card class="pa-6 mx-auto" max-width="600" elevation="1">
            <section class="py-4">
              <h1 class="text-h4">用户信息</h1>
              <span class="text-subtitle-1 grey--text">在此处查看和修改您的个人信息</span>
            </section>
            <v-divider></v-divider>
            <section class="py-5 text-center">
              <v-row>
                <v-col cols="12">
                  <v-avatar color="grey" size="62">
                    <span class="white--text headline">{{ avaterText }}</span>
                  </v-avatar>
                </v-col>
                <v-col cols="12">
                  <span class="text-h5">{{ user.username }}</span>
                </v-col>
              </v-row>
            </section>
            <section class="mx-3 my-2">
              <v-row align="center" justify="start">
                <v-col cols="1">
                  <v-icon>mdi-phone</v-icon>
                </v-col>
                <v-col cols="8">
                  <span>{{ user.phone }}</span>
                </v-col>
              </v-row>
              <v-row align="center" justify="start">
                <v-col cols="1">
                  <v-icon>mdi-email</v-icon>
                </v-col>
                <v-col cols="8">
                  <span>{{ user.email }}</span>
                </v-col>
              </v-row>
            </section>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "UserPage",
  data: () => ({
    user: {
      username: '未知用户',
      phone: '13612535073',
      email: '1096119575@qq.com'
    }
  }),
  computed: {
    avaterText() {
      return this.user.username.substr(0, 1);
    }
  }
}
</script>

<style scoped>
</style>