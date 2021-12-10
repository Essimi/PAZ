<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="image/png" href="https://i.pinimg.com/originals/22/e4/e0/22e4e079c332b3f3589f4a8b73545076.png" rel="icon" style="color: tomato;"> 
<title>화상회의</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<style>
    body{
        background-color: antiquewhite;
        height: 100%;
        
    }
#video-header{
    width: 100%; 
    text-align: center; 
    height: 100%; 
    font-size: xx-large; 
    color:tomato; 
    
}
@media screen and (max-width: 900px) {
    #form{
        width: 100%;
    }
  }
  
  /* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
  @media screen and (max-width: 600px) {
    #form{
        width: 100%;
    }
  }
#form{
    background-color: #333;
    color: yellow;
    height: 400px;
    width: 400px;
    overflow: hidden;
    margin: auto;
    align-content: center;
    text-align: center;
    padding: 20px 20px;
    text-align: center;
    
}
input:nth-child(odd){
    padding: 20px 20px;
    background-color: #333;
    color: tomato;
}
input:nth-child(even){
    padding: 10px 20px;
    border: none;
    background-color: tomato;
    color: #333;
}
input{
    position: relative;
    width: 100%;
    outline: none;
    margin-top: 10px;
    left: 0;
    right: 0;
    display: block;

}

	#content {
		padding:30px;
		text-align: -webkit-center;
	}
	
	.invoice {
		padding:30px;
		border-radius: 10px;
		border-top : 3px solid #17a2b8;
		width: 50%;
	}
	

</style>

<body>


<div class="invoice mb-3">
	<div id="video-header">
	<h1>화상회의</h1>
	</div>
	<div id="form">
	
	        <input type="text" name="roomId" id="value" placeholder="화상회의  방 제목" value="">
	        <input type="button" value="방 들어가기" id="submit">
	       <input type="button" value="방 만들기" id="newRoom">
	</div>
</div>


<script >
    
    var form = document.getElementById("submit")
    form.addEventListener('click', ()=>{
        const x = document.getElementById("value");
        if(x.value == ""){
            //alert("Room id is empty!!!")
            swal("참여할 수 없습니다.","방 코드를 입력해주세요.")
        }else{
            location.replace("https://192.168.0.52:3000/"+x.value);
//             location.replace("https://videocallappwebrtc.herokuapp.com/"+x.value);
            
            x.value = "";
        }
    });

    const y = document.getElementById("newRoom");
    y.addEventListener('click', ()=>{
        swal("Create New Room","방이 생성되었습니다.").then((value)=>{
            if(value == true){
                window.location.href = "https://192.168.0.52:3000/";
//                 window.location.href = "https://videocallappwebrtc.herokuapp.com/";
            }else{
                swal("Cancelled !!","Room creation cancelled.");
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

