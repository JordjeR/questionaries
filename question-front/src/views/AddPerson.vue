<template>
  <b-form @submit.prevent="onSubmit">
    <input type="text" v-model="person"/>
    <b-button id="create" variant="success" type="submit">Create</b-button>
  </b-form>
</template>

<script>
export default {
  name: "AddPerson",
  data() {
    return {
      person: ''
    }
  },
  methods: {
    onSubmit() {
        const newPerson = {
          id: 3,
          name: this.person
        }
        this.$emit('add-person', newPerson);
        this.person = '';
    }
  }
}
</script>

<style scoped>
  #create {
    margin-left: 5px;
  }
</style>