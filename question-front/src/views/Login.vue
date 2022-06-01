<template>
  <div class="container mt-4">
    <h2>Вход</h2>
    <div class="col-md-4 mx-auto">
<!--      <form @submit.p.prevent="onSubmit">-->
      <form @submit.prevent="onSubmit">
        <div class="form-group">
          <label for="username">Имя пользователя</label>
          <input type="text"
                 v-model="username" class="form-control" id="username"
                 placeholder="Введите имя пользователя" name="username" required style="margin-bottom: 10px">
        </div>

        <div class="form-group">
          <label for="password">Пароль</label>
          <input type="password"
                 v-model="password" class="form-control" id="password" placeholder="Введите пароль" name="password" required>
        </div>

        <button type="submit" style="margin-top: 10px" class="btn btn-primary">Войти</button>

        <router-link to="/" style="margin-top: 10px; margin-left: 10px" class="btn btn-link">Назад</router-link>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Auth",
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    onSubmit() {
      const user = {
        username: this.username,
        password: this.password
      }
      if (user.username && user.password) {
        this.$store.dispatch('authMod/login', user).then(() => {
              this.$router.push('/api/persons');
            },
            error => {
              this.loading = false;
              this.message =
                  (error.response && error.response.data) ||
                  error.message ||
                  error.toString();
            }
        );
      }
    }
  }
}
</script>

<style scoped>

</style>