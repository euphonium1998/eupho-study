const TokenName = 'token'

export function getLocalToken() {
    return localStorage.getItem(TokenName);
}

export function setLocalToken(token) {
    localStorage.setItem(TokenName, token);
}

export function removeLocalToken() {
    localStorage.removeItem(TokenName);
}

export function parseToken(encodedToken) {
    let [encodedHeader, encodedPayload, signature] = encodedToken.split('.', 3);
    let header = JSON.parse(atob(encodedHeader));
    let payload = JSON.parse(atob(encodedPayload));
    return {header, payload, signature};
}