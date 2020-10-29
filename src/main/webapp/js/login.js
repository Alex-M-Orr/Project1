function renderDropDown(user){
  console.log(user);
  let madd = document.getElementById('myAccountDropDown');
  if(user === "no session"){
    console.log("wack");
    const loginA = document.createElement("a");
    const dividerDiv = document.createElement("div");
    const registerA = document.createElement("a");

    loginA.setAttribute("class", "dropdown-item");
    loginA.setAttribute("href", "#loginModal");
    loginA.setAttribute("data-toggle", "modal");
    loginA.innerText = "Login";

    dividerDiv.setAttribute("class", "dropdown-divider");

    registerA.setAttribute("class", "dropdown-item");
    registerA.setAttribute("href", "#registerModal");
    registerA.setAttribute("data-toggle", "modal");
    registerA.innerText = "Register";

    madd.append(loginA, dividerDiv, registerA);
  }
  else if(user.userRoleId===1){
    const requestRimbA = document.createElement("a");
    const viewReimbA = document.createElement("a");
    const dividerDiv = document.createElement("div");
    const logoutA = document.createElement("a");

    requestRimbA.setAttribute("class", "dropdown-item");
    requestRimbA.setAttribute("href", "requestReimbursement.page");
    requestRimbA.innerText = "Request Reimbursement";

    viewReimbA.setAttribute("class", "dropdown-item");
    viewReimbA.setAttribute("href", "viewReimbursements.page");
    viewReimbA.innerText = "View Reimbursements";

    dividerDiv.setAttribute("class", "dropdown-divider");

    logoutA.setAttribute("class", "dropdown-item");
    logoutA.setAttribute("href", "logout.page");
    logoutA.innerText = "Logout";

    madd.append(requestRimbA, viewReimbA, dividerDiv, logoutA);
  }
  else if(user.userRoleId===2){
    const viewReimbA = document.createElement("a");
    const dividerDiv = document.createElement("div");
    const logoutA = document.createElement("a");

    viewReimbA.setAttribute("class", "dropdown-item");
    viewReimbA.setAttribute("href", "viewReimbursements.page");
    viewReimbA.innerText = "View Reimbursements";

    dividerDiv.setAttribute("class", "dropdown-divider");

    logoutA.setAttribute("class", "dropdown-item");
    logoutA.setAttribute("href", "logout.page");
    logoutA.innerText = "Logout";

    madd.append(viewReimbA, dividerDiv, logoutA);

  }
}

function fetchuserinfo(){
  console.log('stylesheet');
  asyncFetch("http://18.191.119.230:8081/Project1-alpha/userinfo.json", renderDropDown);
}

fetchuserinfo();
