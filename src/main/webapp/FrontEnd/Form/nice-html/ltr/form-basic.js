// var date = new Date();
// console.log(date)
// let month = date.getMonth()+1
// let day = date.getDate()
// let year = date.getFullYear()
// console.log(month)
// console.log(month+'/'+day+'/'+year)
// let validDate = +month+'/'+day+'/'+year

// console.log(validDate );
// document.getElementById("date").value = validDate.toString()



console.log("start");
console.log("wejh")
var val



let photo = document.getElementById("inputGroupFile01")
let selectedfiles;
photo.onchange = () =>{
    selectedfiles = photo.files[0];
    console.log(selectedfiles);
    document.getElementById("chosenfile").innerHTML=`${selectedfiles.name}`
}

// getting emp id from url;

let stringParam = window.location.search;

let urlParam = new URLSearchParams(stringParam)

let params = urlParam.get("id")

//






//

function check(){
   
 
    console.log(request)
}


function submit(){


    console.log("subitted")

    
    let date1 = document.getElementById("date").value
    let cost1 = document.getElementById("cost").value
    let desc = document.getElementById("description").value
    let eventype1 = document.getElementById("eventType").value
    let img = document.getElementById("inputGroupFile01").value

   
    
    let request = {
        emp_id:params,
        date: date1,
        cost:cost1,
        description:desc,
        eventType:eventype1,
        image: "selectedimage"
    }
    

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status == 200){
        console.log("wqehj")

            console.log(this.responseText);
            
            console.log("project")
            submit2();

            
            
             

        }
    }
    
    xhttp.open("POST", "http://localhost:8080/Project1/addrequest.do",true);

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));


}

var reimbval;
var costval;



// Geting employee by id
function empbyid(){
    

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status == 200){
     

            console.log(this.responseText);
            let data = JSON.parse(this.responseText)
            console.log(data)

            //
            document.getElementById("ar").value=`${data.reimbursment_status}`
            //
            //


            document.getElementById("cost").addEventListener("change",function(){reimbval = data.reimbursment_status; 
            costval = document.getElementById("cost").value});
            //
           
        }
    }
    
    xhttp.open("GET", `http://localhost:8080/Project1/dashboard.do?id=${params}`,true);


    xhttp.send();
}
empbyid();



document.getElementById("eventType").addEventListener("change",
function(){

    let con = document.getElementById("eventType").value
    console.log(con)


    if(con == 1){
        val = (costval*80)/100
    }
    else if(con == 2){
        val = (costval*60)/100
    }
    else if(con == 3){
        val = (costval*75)/100
    }
    else if(con == 4){
        val = (costval*100)/100
    }
    else if(con == 5){
        val = (costval*90)/100
    }
    else if(con == 6){
        val = (costval*30)/100
    }

    console.log(val)

    if(val>reimbval){
        document.getElementById("cr").value="Not Enough Reimbursment Available"
        document.getElementById("submit").style.visibility="hidden"

    }
    else{
        document.getElementById("cr").value=`${val}`
    }
   
    
   

   
})


function submit2()
{

    console.log("sbmit2")
    
      //updating emplloyee
       let val2 = reimbval - val
       console.log(val2)

      let employees = {
        emp_id: params,
        reimbursment_status:val2
    }

    let xhttp1 = new XMLHttpRequest();

    xhttp1.onreadystatechange = function (){
        if(this.readyState == 4 && this.status == 200){
       

            console.log(this.responseText);
            if(this.responseText=='true'){
             window.location.href=`../../../AfterLogin/nice-html/Dashboard/Dashboard.html?id=${params}`
            }
        }
    }
    
    xhttp1.open("POST", "http://localhost:8080/Project1/updateemp.do",true);

    xhttp1.setRequestHeader('Content-Type', 'application/json');

    xhttp1.send(JSON.stringify(employees));
    
}