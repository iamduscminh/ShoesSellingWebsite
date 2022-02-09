// login
const signUpButton = document.getElementById("signUp");
const signInButton = document.getElementById("signIn");
const login_container = document.getElementById("container");

signUpButton.addEventListener("click", () => {
  login_container.classList.add("right-panel-active");
});

signInButton.addEventListener("click", () => {
  login_container.classList.remove("right-panel-active");
});
