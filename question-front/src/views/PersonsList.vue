<template>
  <div>
    <h1>Persons list</h1>
    <hr>
    <PersonItem v-for="(person, i) in allPersons"
                v-bind:person="person"
                v-bind:ind="i"
    />
  </div>
</template>
<script>
import PersonItem from "@/views/PersonItem";
import {mapGetters, mapActions} from "vuex";
import UserService from "@/services/UserService";

export default {
  name: "PersonsList",
  data() {
    return {
      persons: [],
    }
  },
  components: {
    PersonItem,
  },
  computed: mapGetters(["allPersons"]),
  methods: {
    ...mapActions(["fetchPerson"])
  },
  mounted() {
    /*UserService.getUserBoard().then(response => {
      this.persons = response.data;
    })*/
    this.fetchPerson();
  }
}
</script>

<style scoped>
</style>