<template>
  <div>
    <v-container fluid>
      <v-row justify-md="center">
        <v-col cols="10" sm="8" md="4">
          <v-text-field
              label="Get Product List By Price"
              placeholder="Enter priceLowerBound"
              v-model="price"
              solo
              hide-details="auto"
          ></v-text-field>
        </v-col>
        <v-col cols="2" sm="4" md="2">
          <v-btn
              block
              large
              color="primary"
              @click="getProductsByPrice"
          >
            <v-icon>mdi-magnify</v-icon>
          </v-btn>
        </v-col>
      </v-row>

      <v-row justify-md="center">
        <v-col cols="12" md="6">
          <v-data-table
              :headers="productHeaders"
              :items="products"
              :items-per-page="10"
          ></v-data-table>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import {selectProductByPrice} from "../../api/task1";

export default {
  name: "Task1",
  data() {
    return {
      price: '',
      isQueryLoading: false,
      productHeaders: [
        {
          text: 'prodName',
          sortable: false,
          value: 'prodName',
        },
        {
          text: 'prodDesc',
          //align: 'start',
          sortable: false,
          value: 'prodDesc',
        },
      ],
      products: [
        {
          prodName: 'None',
          prodDesc: 'Empty'
        },
      ],
    }
  },
  methods: {
    getProductsByPrice() {
      selectProductByPrice({
        priceLowerBound: this.price
      }).then(resp => {
        // console.log(resp);
        this.products = resp.data;
      })
    }
  }
}
</script>

<style scoped>

</style>