<template>
  <div>
    <v-row no-gutters>
      <v-col cols="3">
        selectAllProductNote
      </v-col>
      <v-col cols="2">
        <v-btn @click="getAllProductNote">
          点击
        </v-btn>
      </v-col>
    </v-row>
    <v-data-table
      :headers="productNoteHeaders"
      :items="productNotes"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </div>
</template>

<script>
import {selectAllProductNote} from '@/api/demo'
import axios from "axios";
export default {
  name: "Example",
  data: () => ({
    productNoteHeaders: [
      {
        text: 'noteId',
        value: 'noteId'
      },
      {
        text: 'prodId',
        value: 'prodId'
      },
      {
        text: 'noteDate',
        value: 'noteDate'
      },
      {
        text: 'noteText',
        value: 'noteText'
      },
    ],
    productNotes: [],

  }),
  methods: {
    getAllProductNote() {
      selectAllProductNote().then( res => {
        // console.log(res.data);
        //clear
        this.productNotes = []
        res.data.forEach(item => {
          this.productNotes.push({
            noteId: item.noteId,
            prodId: item.prodId,
            noteDate: item.noteDate,
            noteText: item.noteText
          })
        })
        console.log(res);
      })
    }
  }
}
</script>

<style scoped>

</style>