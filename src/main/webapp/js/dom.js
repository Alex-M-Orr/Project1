const mockedUsers = [
  {
    userId:1,
    userFirstName:"Alex",
    userLastName: "Orr",
    userEmail:"Alex@gmail.com",
    userRole: 1
  },
  {
    userId:2,
    userFirstName:"Dean",
    userLastName: "Jopsop",
    userEmail:"DJ@gmail.com",
    userRole: 2
  }
]

function renderTable(users){
  for(const user of users){
    console.log(user);
    const tr = document.createElement("tr");
    const idTd = document.createElement("td");
    const fnameTd = document.createElement("td");
    const lnameTd = document.createElement("td");
    const emailTd = document.createElement("td");
    const roleTd = document.createElement("td");

    idTd.innerText = user.userID;
    fnameTd.innerText = user.userFirstName;
    lnameTd.innerText = user.userLastName;
    emailTd.innerText = user.userEmail;
    roleTd.innerText = user.userRoleId;
    tr.append(idTd, fnameTd, lnameTd, emailTd, roleTd);
    console.log(tr);
    document.getElementById("ListAllUsers").appendChild(tr);
  }
}
// renderTable(mockedUsers);
asyncFetch("http://localhost:8080/Project1/userslist.json", renderTable);
