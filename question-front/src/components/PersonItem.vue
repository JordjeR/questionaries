<template>
  <li>
    {{ person.id }} - {{ person.name }}
  </li>
</template>

<script>
export default {
  name: "PersonItem",
  props: {
    person: {
      type: Object,
      require: true
    }
  }
}
</script>

<style scoped>

</style>