export default function authHeader() {
    let user = JSON.parse(localStorage.getItem('user'));
    if (user && user.token) {
        debugger
        return { Authorization: 'Bearer:' + user.token };
    } else {
        return {};
    }
}