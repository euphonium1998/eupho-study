<template>
  <div>
    <v-container class="my-5">
      <p class="font-weight-black">SWX's part.</p>
        <p class="font-weight-regular">查询prod_id为x的vendor_name和vendor_address。输入x类型为int.</p>
        <v-row>
          <v-col>
            <v-form ref="form" v-model="valid" lazy-validation>
              <v-text-field v-model="formMess.prod_id"
                            :rules="prodRules"
                            label="prod_id"
                            required
              ></v-text-field>
              <v-btn
                :disabled="!valid"
                color="success"
                class="mr-4"
                @click="validated"
              >
                查询
              </v-btn>
            </v-form>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-data-table
              :headers="vendorHeaders"
              :items="vendor"
              :items-per-page="5"
              class="elevation-1 text-center"
            ></v-data-table> 
          </v-col>
        </v-row>
    </v-container>

  </div>
</template>

<script>

import axios from "axios";

  export default {
    data () {
      return {
        valid:true,
        formMess:{
          prod_id: '',
        },
        prodRules: [
        v => !!v || 'prid_id is required',
        //这里可以加入判断数字的地方
      ],

        vendorHeaders: [
          {
            text: 'prod_id',
            align: 'start',
            sortable: false,
            value: 'prod_id',
          },
          { text: 'vendor_name', value: 'vendor_name' },
          { text: 'vendor_address', value: 'vendor_address' },
        ],
        vendor: [],
      }
    },
    methods:{
      validated(){
        
        // this.$refs.form.validated()
        let formData = new FormData();
        console.log("gethere")
        for(var key in this.formMess){
          console.log(key)
          console.log(this.formMess[key])
          formData.append(key, this.formMess[key]);
        }
        console.log("formData")

        axios({
          method:"post",
          url: '/task5',
          headers: {
            "Content-Type": "multipart/form-data"
          },
          withCredentials:true,
	        data:formData
        }).then((res)=>{
          this.vendor = []
          res.data.forEach(element => {
            this.vendor.push({
              prod_id: element.prod_id,
              vendor_name: element.vendor_name,
              vendor_address: vendor_address
            })
          });
          console.log(res);
        });
        // selectByPordId().then(res =>{
        //   this.vendor = []
        //   res.data.forEach(element => {
        //     this.vendor.push({
        //       prod_id: element.prod_id,
        //       vendor_name: element.vendor_name,
        //       vendor_address: vendor_address
        //     })
        //   });
        //   console.log(res);
        // })
      },
    }
  }
</script>

<style scoped>

</style>