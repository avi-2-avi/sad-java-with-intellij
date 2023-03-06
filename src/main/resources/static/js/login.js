// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function loginSession () {
    let data = {};
    data.email = document.getElementById('loginEmail').value;
    data.password = document.getElementById('loginPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': "application/json",
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const response = await request.text();
    if (response !== "FAIL") {
        localStorage.token = response;
        localStorage.email = data.email;
        window.location.href = "users.html"
    } else {
        alert("The credentials are incorrect. Please, try again.");
    }
}
