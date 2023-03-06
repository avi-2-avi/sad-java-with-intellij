// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
  $('#users').DataTable();
  updateUserEmail();
});

function updateUserEmail() {
  document.getElementById('email-user').outerHTML = localStorage.email;
}

async function loadUsers () {
  const request = await fetch('api/users', {
    method: 'GET',
    headers: getHeaders()
  });
  const users = await request.json();

  let htmlList = '';
  for (let user of users) {
    let deleteButton = '<a href="#" onclick="deleteUser('+ user.id +')" class="btn btn-danger btclassNamecle"> <i class="fas fa-trash"></i> </a>'

    let telephone = user.telephone == null ? '-' : user.telephone;
    let htmlUser = '<tr> <td>' + user.id + '</td> <td>' + user.name + ' ' + user.last_name + '</td> <td>' + user.email + '</td> <td>' + telephone + '</td> <td>' + deleteButton + '</td> </tr>';
    htmlList += htmlUser;
  }


  document.querySelector("#users tbody").outerHTML = htmlList;
}

function getHeaders() {
  return {
    'Accept': "application/json",
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  }
}

async function deleteUser(id) {

  if (!confirm("Would you like to delete the user?")) {
    return;
  }

  const request = await fetch('api/users/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload();
}