/*jkh */


function signup(){

let first_name1 = document.getElementById("first_name").value
let last_name1 = document.getElementById("last_name").value
let email1 = document.getElementById("email").value
let username1 = document.getElementById("username").value
let departments1 = document.getElementById("departments").value
let password = document.getElementById("password").value
let role = document.getElementById("roles").value

let employee ={
    employeeFirstName:first_name1,
    employeeLastName:last_name1,
    userName: username1,
    password:password,
    roleId:role,
    email:email1,
    dep_id: departments1
}


let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function(){

    if(this.readyState == 4 && this.status == 200){

        if(this.responseText == "true")

        {
            setTimeout(() => {
                window.location.href="http://localhost:8080/Project1/FrontEnd/signin/signin.html"
            }, 1500);
        }
    }
    }



    xhttp.open("POST", "http://localhost:8080/Project1/signup.do", true);

    xhttp.setRequestHeader('Content-Type','application/json');

    xhttp.send(JSON.stringify(employee));
}




