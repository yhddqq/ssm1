// 从 Vue 全局构建版本中获取 createApp 函数
const { createApp } = Vue;

const app = createApp({
    data() {
        return {
            newBook: {
                type: '',
                name: '',
                description: ''
            },
            updateBookData: {
                id: null,
                type: '',
                name: '',
                description: ''
            },
            deleteBookId: null,
            getBookId: null,
            currentBook: null,
            books: [],
            addMessage: '',
            updateMessage: '',
            deleteMessage: ''
        };
    },
    methods: {
        addBook() {
            axios.post('/books', this.newBook)
                .then(response => {
                    const result = response.data;
                    if (result.code === 20011) {
                        this.addMessage = 'Book added successfully!';
                        this.newBook = {
                            type: '',
                            name: '',
                            description: ''
                        };
                    } else {
                        this.addMessage = result.msg || 'Failed to add book.';
                    }
                })
                .catch(() => {
                    this.addMessage = 'Failed to add book.';
                });
        },
        updateBook() {
            axios.put('/books', this.updateBookData)
                .then(response => {
                    const result = response.data;
                    if (result.code === 20031) {
                        this.updateMessage = 'Book updated successfully!';
                        this.updateBookData = {
                            id: null,
                            type: '',
                            name: '',
                            description: ''
                        };
                    } else {
                        this.updateMessage = result.msg || 'Failed to update book.';
                    }
                })
                .catch(() => {
                    this.updateMessage = 'Failed to update book.';
                });
        },
        deleteBook() {
            axios.delete(`/books/${this.deleteBookId}`)
                .then(response => {
                    const result = response.data;
                    if (result.code === 20021) {
                        this.deleteMessage = 'Book deleted successfully!';
                        this.deleteBookId = null;
                    } else {
                        this.deleteMessage = result.msg || 'Failed to delete book.';
                    }
                })
                .catch(() => {
                    this.deleteMessage = 'Failed to delete book.';
                });
        },
        getBookById() {
            axios.get(`/books/${this.getBookId}`)
                .then(response => {
                    const result = response.data;
                    if (result.code === 20041) {
                        this.currentBook = result.data;
                        this.books = [];
                    } else {
                        alert(result.msg || 'Failed to get book.');
                    }
                })
                .catch(() => {
                    alert('Failed to get book.');
                });
        },
        getAllBooks() {
            axios.get('/books')
                .then(response => {
                    const result = response.data;
                    if (result.code === 20041) {
                        this.books = result.data;
                        this.currentBook = null;
                    } else {
                        alert(result.msg || 'Failed to get all books.');
                    }
                })
                .catch(() => {
                    alert('Failed to get all books.');
                });
        }
    }
});

// 监听 DOMContentLoaded 事件
document.addEventListener('DOMContentLoaded', () => {
    // 挂载应用到 DOM 元素
    app.mount('#app');
});