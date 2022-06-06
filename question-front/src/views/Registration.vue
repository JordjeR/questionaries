<template>
  <div class="container">
    <h2>Регистрация пользователя</h2>
    <form @submit.prevent="onSubmit">
      <div class="form-group">
        <label for="username">Имя пользователя</label>
        <input type="text"
               v-model="username" class="form-control" id="username" placeholder="Введите имя пользователя"
               name="username" required>
      </div>

      <div class="form-group">
        <label for="firstName">Имя</label>
        <input type="text"
               v-model="firstName" class="form-control" id="firstName" placeholder="Введите Ваше имя" name="firstName"
               required>
      </div>

      <div class="form-group">
        <label for="lastName">Фамилия</label>
        <input type="text"
               v-model="lastName" class="form-control" id="lastName" placeholder="Введите Вашу фамилию" name="lastName"
               required>
      </div>

      <div class="form-group">
        <label for="login">Email</label>
        <input type="email"
               v-model="login" class="form-control" id="login" placeholder="Введите email" name="login" required>
      </div>

      <div class="form-group">
        <label for="password">Пароль</label>
        <input type="password"
               v-model="password" class="form-control" id="password" placeholder="Введите пароль" name="password"
               required>
      </div>
      <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
      <router-link to="/" type="href" class="btn btn-link">Назад</router-link>
    </form>
  </div>
</template>

<script>
export default {
  name: "Registration",
  data() {
    return {
      username: '',
      firstName: '',
      lastName: '',
      login: '',
      password: ''
    }
  },
  computed: {
  },
  mounted() {
  },
  methods: {
    onSubmit() {
      const user = {
        username: this.username,
        firstName: this.firstName,
        lastName: this.lastName,
        login: this.login,
        password: this.password
      }
      this.$store.dispatch("authMod/register", user);
      this.$router.push('/auth/login');
    }
  }
}
</script>

<style scoped>
</style>