function signin() {



    let username = document.getElementById("username").value
    let password = document.getElementById("password").value






    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        

        if (this.readyState == 4 && this.status == 200) {




            let response = JSON.parse(this.responseText)
            if (response.isfetched) {






                console.log(response)
                //data = this.responseText;
                document.getElementById("message").innerHTML = "<span></span>"
                gotoDashboard(response);





            }
            else {
                document.getElementById("message").innerHTML = `<span>Wrong Username or Password!</span>`
            }

        }




    }

    xhttp.open("GET", "http://localhost:8080/Project1/signin.do?username=" + username + "&password=" + password, true)

    xhttp.send();



}


function gotoDashboard(response) {

    setTimeout(() => { window.location.href = `../AfterLogin/nice-html/Dashboard/Dashboard.html?id=${response.emp_id}` }, 1500)


}



