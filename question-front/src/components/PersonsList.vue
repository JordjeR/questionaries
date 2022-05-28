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
import PersonItem from "@/components/PersonItem";
import {mapGetters, mapActions} from "vuex";

export default {
  name: "PersonsList",
  components: {
    PersonItem,
  },
  computed: mapGetters(["allPersons"]),
  methods: {
    ...mapActions(["fetchPerson"])
  },
  mounted() {
    this.fetchPerson();
  }
}
</script>

<style scoped>
</style>