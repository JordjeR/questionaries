<template>
  <b-form @submit="onSubmit">
    <input type="text"
           v-model="person"
           @keyup.enter="onSubmit"
    />
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
          name: this.person
        }
        this.$store.dispatch('addPerson', newPerson);
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