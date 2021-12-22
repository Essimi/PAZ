<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="image/png" href="https://i.pinimg.com/originals/22/e4/e0/22e4e079c332b3f3589f4a8b73545076.png" rel="icon" style="color: tomato;"> 
<title>Video Call App</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<style>
   
</style>

<body>
<div id="header">
<h1>Video Call App</h1>
</div>
<div id="form">

        <input type="text" name="roomId" id="value" placeholder="Enter room id Eg:x2bdfy45v7" value="">
        <input type="button" value="Join Room" id="submit">
       <input type="button" value="Create Room" id="newRoom">
</div>

<script >
    
    var form = document.getElementById("submit")
    form.addEventListener('click', ()=>{
        const x = document.getElementById("value");
        if(x.value == ""){
            //alert("Room id is empty!!!")
            alert("Oops.. ","Room id is empty !!")
        }else{
            //location.replace("http://localhost:3000/"+x.value);
              location.replace("https://192.168.0.52:3000/"+x.value);
            
            x.value = "";
        }
    });

    const y = document.getElementById("newRoom");
    y.addEventListener('click', ()=>{
    	alert("Create New Room","This will create a room.").then((value)=>{
            if(value == true){
                //window.location.href = "http://localhost:3000/";
            	  window.location.href = "https://192.168.0.52:3000/";
            }else{
                alert("Cancelled !!","Room creation cancelled.");
            }
        })
    });
</script>
<em style="font-family: Georgia, 'Times New Roman', Times, serif;
 text-align: center; bottom: 0;
 position: absolute;
  margin: auto; right:0;left: 0;
   color: #333; font-size: x-small;">Developed by Alan R S</em>
</body>
