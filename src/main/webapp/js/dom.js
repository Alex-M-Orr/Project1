var filterTable=0;

function renderReimbursementTable(reimbursements){
  document.getElementById("listAllReimbursements").innerHTML = "";
  for(const reimbursement of reimbursements){
    if(reimbursement.reimbStatusId != filterTable && filterTable!=0){
      continue;
    }
    let status;
    switch (reimbursement.reimbStatusId) {
      case 1:
        status = "Pending";
        break;
      case 2:
        status = "Approved";
        break;
      case 3:
        status = "Denied";
        break;
      default:
        console.log(status);
    }
    const tr = document.createElement("tr");
    const idTd = document.createElement("td");
    const amountTd = document.createElement("td");
    const descriptionTd = document.createElement("td");
    const subDateTd = document.createElement("td");
    const resDateTd = document.createElement("td");
    const authorTd = document.createElement("td");
    const resolverTd = document.createElement("td");
    const statusTd = document.createElement("td");
    const typeTd = document.createElement("td");

    idTd.innerText = reimbursement.reimbId;
    amountTd.innerText = reimbursement.reimbAmount;
    descriptionTd.innerText = reimbursement.reimbDescription;
    subDateTd.innerText = reimbursement.reimbSubmitted.month + " "
                        + reimbursement.reimbSubmitted.dayOfMonth + " "
                        + reimbursement.reimbSubmitted.year;
    if(reimbursement.reimbResolved != null){
      resDateTd.innerText = reimbursement.reimbResolved.month + " "
                        + reimbursement.reimbResolved.dayOfMonth + " "
                        + reimbursement.reimbResolved.year;
    }
    else {
      resDateTd.innerText = reimbursement.reimbResolved;
    }
    authorTd.innerText = reimbursement.reimbAuthor;
    resolverTd.innerText = reimbursement.reimbResolver;
    statusTd.innerText = status;
    typeTd.innerText = reimbursement.reimbTypeId;

    tr.append(idTd, amountTd, descriptionTd, subDateTd, resDateTd, authorTd, resolverTd, statusTd, typeTd);
    document.getElementById("listAllReimbursements").append(tr);
  }
}
function renderUsersTable(users){
  for(const user of users){
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
    document.getElementById("ListAllUsers").appendChild(tr);
  }
}
// renderTable(mockedUsers);

function setFilter(){
  filterTable = document.getElementById("requestFilter").value;
  asyncFetch("http://localhost:8080/Project1/reimbursementlist.json", renderReimbursementTable);
}
function fetchReimbTable(){
  asyncFetch("http://localhost:8080/Project1/reimbursementlist.json", renderReimbursementTable);
}


asyncFetch("http://localhost:8080/Project1/userslist.json", renderUsersTable);
