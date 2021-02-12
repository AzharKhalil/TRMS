let paramValue = window.location.search;

let urlParam = new URLSearchParams(paramValue)

let params = urlParam.get("reqid")

let params1 = urlParam.get("id")



let response;

function getRequest(){


    let xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function(){
   
        if(this.readyState == 4 && this.status == 200){
   
            
             response = JSON.parse(this.responseText);
             console.log(response)
             let gardes;
             if(response.gradeID == 0){
                 gardes = "Not Declared yet"
             }
             else if(response.gradeID == 1){
                 gardes ="A"
             }
             else if(response.gradeID){
                 gardes = "B"
             }
             else if(response.gradeID == 3){
                 gardes = "C"
             }
             else if(response.gradeID){
                 gardes = "Fail"
             }
            gettingEmp(response)
            
            console.log(response.emp_id)
            document.getElementById("date").value=response.date
            document.getElementById("cost").value=response.cost
            document.getElementById("description").value = response.description
            document.getElementById("eventType").value = response.eventType
            document.getElementById("gradingformat").value = gardes
            let c = response.reimb_status
            if(c == 4){
                document.getElementById("submit").style.visibility="hidden"
            }
        }
    }
    xhttp.open("GET", `http://localhost:8080/Project1/getbyid.do?reqid=${params}`, true)
    xhttp.send();


 
}

getRequest();


function approve(){

    let data = {

        reqID : response.reqID,
        reimb_status:response.reimb_status
    }

    let xhttp = new XMLHttpRequest()

    xhttp.onreadystatechange = function(){

        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText)
            if(this.response=='true'){
                window.location.href=`../../../Dashboard/Dashboard.html?id=${params1}`
            }

        }
    }
    xhttp.open("POST", "http://localhost:8080/Project1/updatereq.do", true)

    xhttp.setRequestHeader('Content-Type', 'application/json')
    xhttp.send(JSON.stringify(data))
}

function gettingEmp(response)
{
    document.getElementById("regno").value=`${response.emp_id}` 
    
    let xhttp = new XMLHttpRequest()

    xhttp.onreadystatechange = function(){

        if(this.readyState == 4 && this.status == 200)
        {
            
            let data = JSON.parse(this.responseText)
            document.getElementById("firstname").value = `${data.employeeFirstName}`
            document.getElementById("lastname").value =`${data.employeeLastName}`
        }
    }

    xhttp.open("GET", `http://localhost:8080/Project1/dashboard.do?id=${response.emp_id}`, true)

    xhttp.send()
}