module.exports = {
    devServer: {
        port: 8088,
        proxy: {
            '/^': {
                target: 'http://localhost:8080',
            }
        }
    },
}