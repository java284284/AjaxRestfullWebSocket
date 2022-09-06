<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />
<script type="text/javascript">
let name = null;
let dob = null;
let salary = null;
let inputFileToLoad = null;
let submitdata = null
let fileDataURL = null;
let textAreaFileContents = null;
let xhr = new XMLHttpRequest();
window.addEventListener('load', function(){
	
	
	inputFileToLoad = document.getElementById("inputFileToLoad");
	submitdata = document.getElementById("submitdata");
	
	
	textAreaFileContents = document.getElementById("textAreaFileContents");
	
	inputFileToLoad.addEventListener('change', loadImageFileAsURL);
	submitdata.addEventListener('click', checkAndSendData);
	
	
});


function checkAndSendData(){
	name = document.getElementById("name").value;
	dob = document.getElementById("dob").value;
	salary = document.getElementById("salary").value;
	let obj = {
		'name': name,	
		'birthday': dob,	
		'salary': salary,	
		'fileDataUrl': fileDataURL	
	}
	let json = JSON.stringify(obj);
	
	
	xhr.addEventListener('readystatechange', processResponse);
	xhr.open('POST', "<c:url value='/uploadData' />" , true);
	xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	xhr.send(json);
	
	console.log("name=" + name + ", dob=" + dob  + ", salary=" + salary );
	console.log("fileDataUrl=" + fileDataURL);
	console.log("json=" + json);
}

function processResponse(){
	
}


function loadImageFileAsURL(){
    let filesSelected = document.getElementById("inputFileToLoad").files;
    if (filesSelected.length > 0)
    {
        let fileToLoad = filesSelected[0];
		
        let fileReader = new FileReader();

        fileReader.onload = function(fileLoadedEvent) 
        {
            
        	fileDataURL = fileLoadedEvent.target.result;
            textAreaFileContents.innerHTML = fileLoadedEvent.target.result;
            console.log("name=" + fileLoadedEvent.name);
            console.log("type=" + fileLoadedEvent.type );
        };

        fileReader.readAsDataURL(fileToLoad);
    }
}

</script>
        
        
        
    </head>

    <body>
    <div align='center'>
    
    <h3>傳送JSON資料</h3>
    <hr>
    <table style="width:520px; border: 1px solid black">
    <tr><td>
	姓名: <input type='text' id='name' name='name' style="width:450px;" value='王立沙'>
	</td></tr>
	<tr><td>
	生日: <input type='text' id='dob' name='dob' style="width:150px;" value='1985-5-10'>
	</td></tr>
	<tr><td>
	薪水: <input type='text' id='salary' name='salary' style="width:100px;" value='35000'>
	</td></tr>
	<tr><td>
	照片: <input id="inputFileToLoad" type="file" onchange="loadImageFileAsURL();" />
	<tr><td>
    </table>
    <input type='submit' id='submitdata'><br>
    <hr>
    <p>File Contents as DataURL:</p>
    <textarea id="textAreaFileContents" style="width:640;height:240" ></textarea>
	<hr>
	<a href="<c:url value='/ch04/' />">回前頁</a>
    </div>


    </body>
</html>
