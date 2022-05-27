<template>
  <div>
    <h1>Persons list</h1>
    <hr>
    <PersonItem v-for="person of persons"
                v-bind:person="person"
    />
  </div>
</template>
<script>
import PersonsService from "@/services/PersonsService";
import PersonItem from "@/components/PersonItem";

export default {
  name: "PersonsList",

  components: {
    PersonItem,
    PersonsService
  },
  data() {
    return {
      persons: []
    }
  },
  methods: {
    getPersons() {
      PersonsService.getPersons().then(response => {
        this.persons = response.data;
      })
    }
  },

  created() {
    this.getPersons();
  }
}
</script>
<style scoped>
</style>