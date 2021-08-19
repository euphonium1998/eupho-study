<template>
  <div>
      <v-form v-model="valid" ref="customerForm" lazy-validation>
        <v-container id="customerFormContainer">



          <h1 class="text-h3">Add Customer</h1>
          <p class="text-subtitle-1">Add a new customer to the database</p>

          <v-row>
            <v-col>
              <v-alert
                  :value="isAlertSeen"
                  color="success"
                  dark
                  border="top"
                  icon="mdi-check-bold"
                  transition="scale-transition"
                  dismissible
              >
                {{ alertMessage }}
              </v-alert>
            </v-col>
          </v-row>


          <v-row>
            <v-col cols="12" md="5">
              <v-text-field
                  v-model="customer.custName"
                  :rules="rules.nameRules"
                  label="Name"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
            <v-col cols="12" md="7">
              <v-text-field
                  v-model="customer.custEmail"
                  :rules="rules.emailRules"
                  label="Email"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="12" md="4">
              <v-text-field
                  v-model="customer.custCountry"
                  :rules="rules.basicRules"
                  label="Country"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
            <v-col cols="12" md="4">
              <v-text-field
                  v-model="customer.custState"
                  :rules="rules.basicRules"
                  label="State"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
            <v-col cols="12" md="4">
              <v-text-field
                  v-model="customer.custCity"
                  :rules="rules.basicRules"
                  label="City"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="12" md="6">
              <v-text-field
                  v-model="customer.custAddress"
                  :rules="rules.basicRules"
                  label="Address"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
            <v-col cols="12" md="6">
              <v-text-field
                  v-model="customer.custZip"
                  :rules="rules.basicRules"
                  label="Zip"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row>
            <v-col>
              <v-text-field
                  v-model="customer.custContact"
                  :rules="rules.basicRules"
                  label="Contact"
                  hide-details="auto"
                  required
                  outlined
              ></v-text-field>
            </v-col>
          </v-row>

          <v-row justify-md="end">
            <v-col cols="12" md="3">
              <v-btn block color="primary" height="50px" @click="submit">
                <v-icon>mdi-check-bold</v-icon> Submit
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

        </v-container>
      </v-form>


  </div>
</template>

<script>
import {saveCustomer} from "../../api/task2";

export default {
  name: "Task2",
  data: () => ({
    valid: false,
    customer: {
      custName: '',
      custAddress: '',
      custCity: '',
      custState: '',
      custZip: '',
      custCountry: '',
      custContact: '',
      custEmail: ''
    },
    rules: {
      basicRules: [
          v => !!v || 'Required'
      ],
      nameRules: [
        v => !!v || 'Name is required'
      ],
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+/.test(v) || 'E-mail must be valid',
      ],
    },
    isAlertSeen: false,
    alertMessage: ''
  }),
  methods: {
    submit() {
      if(this.$refs.customerForm.validate()) {
        saveCustomer(this.customer).then(resp => {
          if (resp.status === 200) {
            this.alertMessage = "Operation Completed";
            this.isAlertSeen = true;
            this.$refs.customerForm.reset();
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
  max-width: 650px;
}
</style>