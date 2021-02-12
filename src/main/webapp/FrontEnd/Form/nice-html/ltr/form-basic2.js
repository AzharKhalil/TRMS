let paramValue = window.location.search;

let urlParam = new URLSearchParams(paramValue)

let params = urlParam.get("reqid")
let params1 = urlParam.get("id")



function submit() {

    let grade = document.getElementById("grade").value


    let data = {
        reqID: params,
        gradeID: grade
    }



    let xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {


            console.log(this.responseText)
            if(this.responseText == 'true'){
                window.location.href=`../../../AfterLogin/nice-html/Dashboard/Dashboard.html?id=${params1}`
                
            }



           
        }
    }
    xhttp.open("POST", "http://localhost:8080/Project1/updategrade.do", true)
    xhttp.setRequestHeader('Content-type','application/json')
    xhttp.send(JSON.stringify(data));
}



