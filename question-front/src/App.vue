<template>
  <div id="app">
    <AddPerson @add-person="addPerson"/>
    <PersonsList/>
  </div>
</template>

<script>
import PersonsList from "@/components/PersonsList";
import AddPerson from "@/components/AddPerson";
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