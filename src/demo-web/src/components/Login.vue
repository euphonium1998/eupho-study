<template>
  <div>
    <v-form v-model="valid" ref="customerForm" lazy-validation>
      <v-container id="customerFormContainer">



        <h1 class="text-h3">登录</h1>
        <p class="text-subtitle-1">使用您的账户名和密码来登录系统</p>

<!--        <v-row>-->
<!--          <v-col>-->
<!--            <v-alert-->
<!--                :value="isAlertSeen"-->
<!--                color="success"-->
<!--                dark-->
<!--                border="top"-->
<!--                icon="mdi-check-bold"-->
<!--                transition="scale-transition"-->
<!--                dismissible-->
<!--            >-->
<!--              {{ alertMessage }}-->
<!--            </v-alert>-->
<!--          </v-col>-->
<!--        </v-row>-->

        <v-row dense>
          <v-col>
            <v-text-field
                v-model="user.usernameOrEmailOrPhone"
                :rules="rules.basicRules"
                label="用户名"
                hide-details="auto"
                required
                outlined
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row dense>
          <v-col>
            <v-text-field
                v-model="user.password"
                :rules="rules.basicRules"
                label="密码"
                hide-details="auto"
                type="password"
                required
                outlined
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row dense>
          <v-col>
            <v-checkbox
                v-model="user.rememberMe"
                label="记住我"
            ></v-checkbox>
          </v-col>
        </v-row>

        <v-row justify-md="end">
          <v-col cols="12" md="3">
            <v-btn block color="primary" height="50px" @click="submit">
              <v-icon>mdi-login-variant</v-icon> Login
            </v-btn>
          </v-col>
          <v-col cols="12" md="3">
            <v-btn block
                   outlined
                   height="50px"
                   @click="resetForm"
            >
              <v-icon>mdi-reload</v-icon> Reset
            </v-btn>
          </v-col>
        </v-row>



        <v-dialog
            v-model="alertDialog"
            width="500"
        >
          <v-card>
            <v-card-title
                class="headline grey lighten-2"
            >
              Message
            </v-card-title>

            <v-card-text>
              <v-container>
                <p class="text-body-1">{{ alertMessage }}</p>
              </v-container>

            </v-card-text>

            <v-divider></v-divider>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                  color="primary"
                  text
                  @click="alertDialog = false"
              >
                Got it
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>


      </v-container>
    </v-form>
  </div>
</template>

<script>
import customAlert from "../api/alert/custom-alert";
import authentication from "../api/auth/authentication";

export default {
  name: "Login",
  components: {
  },
  data: () => ({
    valid: false,
    user: {
      usernameOrEmailOrPhone: '',
      password: '',
      rememberMe: false,
    },
    rules: {
      basicRules: [
        v => !!v || 'Required'
      ],
    },
    isAlertSeen: false,
    alertMessage: '',
    alertDialog: false
  }),
  methods: {
    submit() {
      if(this.$refs.customerForm.validate()) {
        authentication.login(this.user.usernameOrEmailOrPhone, this.user.password, false).then(resp => {
          if (resp.data.code === 200) {
            localStorage.setItem('token', resp.data.data.token);
            this.$router.replace({
              path: '/'
            })
          } else {
            customAlert(resp.data.message, 'warning');
          }
        })

      }
    },
    resetForm() {
      this.$refs.customerForm.reset();
      this.isAlertSeen = false;
    }
  }
}
</script>

<style scoped>
#customerFormContainer {
  max-width: 550px;
}
</style>