
//Getting Parameter from URL
let parameter = window.location.search;


let urlparam = new URLSearchParams(parameter);


let params = urlparam.get("id");


//End of Getting parameter

document.getElementById("reimblink").setAttribute("href", `reimbursmentStatus.html?id=${params}`)
document.getElementById("dashboardlink").setAttribute("href", `Dashboard.html?id=${params}`)

function autorun() {


    // Elements from Hml page

    //let fName = document.getElementById("firstname").innerHTML;

    //End of getting elements fro Html page


    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {

            let jsondata = JSON.parse(this.responseText);

            if (jsondata.isfetched) {

                console.log(jsondata)
                document.getElementById("firstname").innerHTML = `${jsondata.employeeFirstName}`;
                document.getElementById("lastname").innerHTML = `${jsondata.employeeLastName}`;
                document.getElementById("username").innerHTML = `${jsondata.userName}`;
                document.getElementById("email").innerHTML = `${jsondata.email}`;

                switch (jsondata.dep_id) {
                    case 1: {
                        document.getElementById("department").innerHTML = "Computer Science";
                        break;

                    }
                    case 2: {
                        document.getElementById("department").innerHTML = "Software Engineering";
                        break;
                    }
                    case 3: {
                        document.getElementById("department").innerHTML = "Electrical Engineering";
                        break;
                    }
                }

                switch (jsondata.roleId) {
                    case 1: {

                        document.getElementById("role").innerHTML = "Employee";
                        break;
                    }

                    case 2: {
                        document.getElementById("role").innerHTML = "Supervisor";
                        break;
                    }
                    case 3: {
                        document.getElementById("role").innerHTML = "Department Head";
                        break;
                    }
                    case 4: {
                        document.getElementById("role").innerHTML = "Benefits Coordinator";
                        break;
                    }
                }




            }
            requestNotificationStatus(jsondata)
        }
    }

    xhttp.open("GET", `http://localhost:8080/Project1/dashboard.do?id=${params}`, true)

    xhttp.send();


}

autorun();



function requestNotificationStatus(empJsondata) {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText)
            let data = JSON.parse(this.responseText)


            let table = " ";
            data.map((value) => {



                if (value.emp_id == params) {

                    

                    document.getElementById("notreq").innerHTML = "<a></a>"
                    let status;
                    switch (value.reimb_status) {
                        case 1: {
                            status = "Submitted To Supervisor"
                            break;
                        }
                        case 2: {
                            status = "Pending HOD Approal"
                            break;
                        }
                        case 3: {
                            status = "Sent to Benefits Coordinator"
                            break;
                        }
                        case 4: {
                            status = "Approved"
                            break;
                        }
                    }


                    table = table + `<tr>
                <th scope="row">${value.reqID}</th>
                <td>Reimbursment Request</td>
                <td>${status}</td>
                <td><button onclick="form2(${value.reqID})">Edit/View</button></td>
            </tr>
                
                
                
                `
                }
            })
            document.getElementById("reqtable").innerHTML = table

            // Supervisor Notifications

            if(empJsondata.roleId == 2){
                document.getElementById("notification").style.visibility="visible"


                let count=0;
            let table1 = " ";
            data.map((value) => {



                if (value.reimb_status == 1) {

                    document.getElementById("nonot").innerHTML="<a></a>"
                    count = count + 1
                


                    table1 = table1 + `<tr>
                    <th scope="row">${count}</th>
                    <td colspan="2">Reimbursment Request${value.reqID}</td>
                    <td><button onclick="viewForm(${value.reqID})">View</button></td>
                </tr>`
                }
            })
            document.getElementById("notifications").innerHTML=table1;
            }

            // Head Of Department

            if(empJsondata.roleId == 3){
                document.getElementById("notification").style.visibility="visible"


                let count=0;
            let table1 = " ";
            data.map((value) => {



                if (value.reimb_status == 2) {

                    document.getElementById("nonot").innerHTML="<a></a>"
                    count = count + 1
                


                    table1 = table1 + `<tr>
                    <th scope="row">${count}</th>
                    <td colspan="2">Reimbursment Request</td>
                    <td><button onclick="viewForm(${value.reqID})">View</button></td>
                </tr>`
                }
            })
            document.getElementById("notifications").innerHTML=table1;
            }

            //Benco
            if(empJsondata.roleId == 4){
                document.getElementById("notification").style.visibility="visible"


                let count=0;
            let table1 = " ";
            data.map((value) => {



                if (value.reimb_status == 3) {

                    document.getElementById("nonot").innerHTML="<a></a>"
                    count = count + 1
                


                    table1 = table1 + `<tr>
                    <th scope="row">${count}</th>
                    <td colspan="2">Reimbursment Request</td>
                    <td><button onclick="viewForm(${value.reqID})">View</button></td>
                </tr>`
                }
            })
            document.getElementById("notifications").innerHTML=table1;
            }



        }


    }








    xhttp.open("GET", "http://localhost:8080/Project1/getAllrequests.do", true)

    xhttp.send()

}

function logout(){
    window.location.href="../../../signin/signin.html";
}


function viewForm(reqID){
    window.location.href=`../Form/nice-html/ltr/request-viewer.html?id=${params}&reqid=${reqID}`;
}

function form2(reqID){
    window.location.href=`../../../Form/nice-html/ltr/form-basic2.html?id=${params}&reqid=${reqID}`;
}