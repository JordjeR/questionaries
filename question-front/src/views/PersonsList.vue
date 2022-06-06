<template>
  <div>
    <h1>Persons list</h1>
    <hr>
    <AddPerson/>
    <hr>
    <PersonItem
        v-for="person in allPersons" v-bind:person="person"/>
    <hr>
    <button type="button" class="btn btn-danger" @click="logout">Выйти из аккаунта</button>
  </div>
</template>
<script>
import PersonItem from "@/views/PersonItem";
import AddPerson from "@/views/AddPerson";

export default {
  name: "PersonsList",
  data() {
    return {
      persons: [],
    }
  },
  components: {
    AddPerson,
    PersonItem,
  },
  computed: {
    allPersons() {
      return this.$store.getters.allPersons;
    }
  },
  methods: {
    fetchPerson() {
      this.$store.dispatch("fetchPerson");
    },
    logout() {
      this.$store.dispatch("authMod/logout")
          .then(() => this.$router.push("/auth/login"))
          .catch(error => console.log("Произошла ошибка" + error));
    }
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