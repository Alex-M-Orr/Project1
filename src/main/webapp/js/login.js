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
}

function fetchuserinfo(){
  console.log('stylesheet');
  asyncFetch("http://localhost:8080/Project1/userinfo.json", renderDropDown);
}

//fetchuserinfo();
