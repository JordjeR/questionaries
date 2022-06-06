<template>
  <div class="container">
    <h1>Анкетирование</h1>
    <router-link id="create" to="/create" class="btn btn-primary">Создать анкету</router-link>
    <router-link id="show" to="/show" class="btn btn-danger">Просмотр анкет</router-link>
  </div>
</template>

<script>

import CreateQuestionare from "@/views/CreateQuestionare";
import ShowQuestionare from "@/views/ShowQuestionare";

export default {
  name: "MainPage",

  components: {
    ShowQuestionare,
    CreateQuestionare
  },

  computed: {
    isUser() {
      // return this.$store.state.authMod.
    }
  },
  mounted() {

  }
}
</script>

<style scoped>
#create {
  margin-left: 10px;
}
#show {
  margin-left: 10px;
}
</style>