async function login(){
  console.log("login called");
  const user = {
    username: document.getElementsByName("username"),
    password: document.getElementsByName("password")
  }
  const fetched = await fetch("http://localhost:8080/Project1/login.page", {
    method: 'post',
    body: JSON.stringify(user)
  });
  // const json = await fetched.json();
}
// document.getElementById("loginButton").addEventListener("click", login());
