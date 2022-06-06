<template>
  <div id="app">
    <h1>Person application</h1>
    <router-view/>
  </div>
</template>

<script>
import PersonsList from "@/views/PersonsList";
import AddPerson from "@/views/AddPerson";
import PersonsService from "@/services/PersonsService";

export default {
  name: 'App',
  components: {
    AddPerson,
    PersonsList
  },
  methods: {
    addPerson(person) {
      PersonsService.addPerson(person);
    }
  }
}
</script>

<style>
#app {
  text-align: center;
  margin-top: 60px;
  color: black;
}
</style>