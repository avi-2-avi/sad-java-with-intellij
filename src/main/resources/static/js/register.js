// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registerUser () {
    let data = {};
    data.name = document.getElementById('registerName').value;
    data.last_name = document.getElementById('registerLastName').value;
    data.email = document.getElementById('registerEmail').value;
    data.password = document.getElementById('registerPassword').value;

    let repeatPassword = document.getElementById('registerPassword2').value;

    if (repeatPassword !== data.password) {
        alert("The provided passwords are not the same.")
        return;
    }

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': "application/json",
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    alert("The account was created successfully");
    window.location.href = "login.html"
}
