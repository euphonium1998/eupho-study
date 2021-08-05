<template>
  <div>
    
    <v-container class="my-5">
      <p class="font-weight-black">SWX's part.</p>
        <p class="font-weight-regular">将productnotes表格中note_id_x为x的那一行的note_text修改为y。其中x和y均为输入。x为int，y为string
        </p>
        <v-row>
          <v-col>
            <v-form ref="form" v-model="valid" lazy-validation>
              <v-text-field v-model="formMess.note_id_x"
                            :rules="prodRules"
                            label="note_id_x"
                            required
              ></v-text-field>
              <v-text-field v-model="formMess.note_id_y"
                            :rules="prodRules"
                            label="note_id_y"
                            required
              ></v-text-field>
              <v-btn
                :disabled="!valid"
                color="success"
                class="mr-4"
                @click="validated"
              >
                replace
              </v-btn>
            </v-form>
          </v-col>
        </v-row>
    </v-container>

  </div>
</template>

<script>
import {changeNodeId} from '@/api/task6'
import axios from "axios";
  export default {
    data () {
      return {
        valid:true,
        formMess:{
          note_id_x: '',
          note_id_y: ''
        },
        
        note_id_y: '',
        prodRules: [
        v => !!v || 'prid_id is required',
        //这里可以加入判断数字的地方
      ],
      }
    },
    methods:{
      validated(){
        let formData = new FormData();
        for(var key in this.formMess){
          formData.append(key,this.formMess[key]);
        }
        changeNodeId(formData).then(res =>{
          console.log(res);
        })
        // axios({
        //   method:"post",
        //   url: '/task6',
        //   headers: {
        //     "Content-Type": "multipart/form-data"
        //   },
        //   withCredentials:true,
	      //   data:formData
        // }).then((res)=>{
        //   console.log(res);
        // });
        
        
      },
    }
  }
</script>

<style scoped>

</style>