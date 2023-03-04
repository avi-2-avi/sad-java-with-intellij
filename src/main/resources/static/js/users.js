// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
  $('#users').DataTable();
});

async function loadUsers () {
  const request = await fetch('users', {
    method: 'GET',
    headers: {
      'Accept': "application/json",
      'Content-Type': 'application/json'
    },
  });
  const users = await request.json();

  let htmlList = '';
  for (let user of users) {
    let htmlUser = '<tr> <td>'+user.id+'</td> <td>'+user.name+' '+user.last_name+'</td> <td>'+user.email+'</td> <td>'+user.telephone+'</td> <td> <a href="#" class="btn btn-danger btclassNamecle"> <i class="fas fa-trash"></iclassName </a> </td> </tr>';
    htmlList += htmlUser;
  }


  document.querySelector("#users tbody").outerHTML = htmlList;
}
