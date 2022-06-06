<script>
export default {
  name: "Question",
  props: {
    tag: String,
    size: '',
    ind: Number,
  },
  render(createElement, context) {
    return createElement(this.tag, {
          attrs: {
            class: 'small'
          }
        },
        [
          Array.apply(null, {length: this.size}).map(() => {
            return [
                createElement('span', {}, 'Введите кол-во ответов в вопросе: '),
                createElement('input', {
                  attrs: {
                    placeholder: '',
                  }
                }, ''),
                createElement('br')
            ]
          }),
        ]
    );
  }
}
</script>
<style scoped>
</style>