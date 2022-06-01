<template>
  <div class="container">
    <h1>Home page</h1>
    <p>У вас есть аккаунт?</p>
    <router-link to="/auth"> Да </router-link>
    <router-link to="/auth/register"> Нет</router-link>
  </div>
</template>

<script>
export default {
  name: "Home"
}
</script>

<style scoped>

</style>