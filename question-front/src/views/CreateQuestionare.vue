<template>
  <div class="container small">
    <h1>Создание анкеты</h1>

    <div class="card small">
      <p>Сколько вы хотите добавить вопросов c множественным выбором?</p>
      <span class="small">
        <input type="number"
               class="me-lg-2"
               v-model="size"/>
        <button class="btn-outline-success"
                @click="sizeArray">Добавить</button>
      </span>
      <br>
      <Question
          v-if="isClick"
          v-bind:tag="'span'"
          v-bind:size="size">
      </Question>
      <hr>
      <p>Сколько вопросов с одиночным выбором?
        <input type="text" v-model="singleChoice">
      </p>
    </div>
  </div>
</template>

<script>
import Question from "@/views/Question";
export default {
  name: "CreateQuestionare",
  components: {Question},
  data() {
    return {
      ind: Number,
      multipleChoice: '',
      singleChoice: '',
      answer: Number,
      inputArray: [],
      inputValue: '',
      size: '',
      isClick: false,
    }
  },
  computed: {
  },
  methods: {
    sizeArray() {
      this.isClick = true;
      return this.size;
    },
  },
}
</script>

<style scoped>
</style>