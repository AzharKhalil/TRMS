//Getting Parameter from URL
let parameter = window.location.search;


let urlparam = new URLSearchParams(parameter);



let params = urlparam.get("id");


//End of Getting parameter

document.getElementById("dashboardlink").setAttribute("href", `Dashboard.html?id=${params}`)
document.getElementById("reimblink").setAttribute("href", `reimbursmentStatus.html?id=${params}`)





function autorun() {

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {


        if (this.readyState == 4 && this.status == 200) {


            console.log(this.responseText);
            let jsondata = JSON.parse(this.responseText)
            console.log(jsondata)

            //Calculations

             available = jsondata.reimbursment_status;
             pending = 0;
             used = 1000 - jsondata.reimbursment_status


            //


           
            document.getElementById("reimbavailable").innerHTML = `$${available}`

            document.getElementById("usedreimb").innerHTML = `$${used}`

            
        }

    }

    xhttp.open("GET", `http://localhost:8080/Project1/dashboard.do?id=${params}`, true)

    xhttp.send();
}

autorun()

function apply() {
    //console.log("clicked")
    window.location.href = `../../../Form/nice-html/ltr/form-basic.html?id=${params}&`
}
