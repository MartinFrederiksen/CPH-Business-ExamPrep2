const URLs = {
    "Home": "/",
    "Login": "/login",
    "JokesV1" : "/jokesv1",
    "NoMatch": "*"
}

function URLSettings() {
    const getURL = (key) => { return URLs[key] }

    return {
        getURL
    }
}
export default URLSettings();


