<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<script>
var pk = ${pk};
var hasError = false;

window.onload = function() {
	var divResult = document.getElementById('resultMsg');
	var id = document.getElementById("id");
	var idLabel = document.getElementById("ida");
	var name = document.getElementById("name");
	var balance = document.getElementById("balance");
	var birthday = document.getElementById("birthday");
	var xhr = new XMLHttpRequest();

	xhr.open("GET", "<c:url value='/members/" + pk + "' />", true);
	xhr.send();	
	var message = "";
	xhr.onreadystatechange = function() {
	 // 伺服器請求完成
	    if (xhr.readyState == 4 && xhr.status == 200) {
		   var memberBean = JSON.parse(xhr.responseText);
		   id.value = memberBean.id;
		   idLabel.innerHTML = memberBean.id;
		   name.value = memberBean.name;
		   balance.value = memberBean.balance;
		   birthday.value = memberBean.birthday;
	    }
     }
   
   var updateData = document.getElementById("updateData");
   var deleteData = document.getElementById("deleteData");

   deleteData.addEventListener('click', (e)=> {
	   var result = confirm("確定刪除此筆記錄(帳號:" + id.value + ")?");
	   if (result) {
		    var xhr2 = new XMLHttpRequest();
	   		xhr2.open("DELETE", "<c:url value='/members/' />" + pk, true);
	   		xhr2.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	   		xhr2.send();
	   		xhr2.onreadystatechange = function() {
						// 伺服器請求完成
	   		if (xhr2.readyState == 4 && (xhr2.status == 200 || xhr2.status == 204) ) {
	      		result = JSON.parse(xhr2.responseText);
	      		if (result.fail) {
			 		divResult.innerHTML = "<font color='red' >"
						+ result.fail + "</font>";
		  		} else if (result.success) {
		  			window.location.href = "http://localhost:8080/SpringRest21/showAllMembersAjax";
	      		}                                                             
			} 
		      
		  }
	   } 
   });

   updateData.onclick = function() {
		hasError = false;
   		// 讀取欄位資料	  
		var idValue = document.getElementById("id").value;
		var nameValue = document.getElementById("name").value;
		var balanceValue = document.getElementById("balance").value;
		var birthdayValue = document.getElementById("birthday").value;
		var div0 = document.getElementById('result0c');
		var div1 = document.getElementById('result1c');
		var div2 = document.getElementById('result2c');
		var div3 = document.getElementById('result3c');
		if (!idValue){
			setErrorFor(div0, "請輸入帳號");
   		} 	else {
      		div0.innerHTML = "";
   		}
		if (!nameValue){
			setErrorFor(div1, "請輸入姓名");
		} else {
			div1.innerHTML = "";
		}
   		if (!balanceValue){
			setErrorFor(div2, "請輸入餘額");
		} else {
	   		var objRegex = /^\d+$|(^-?\d\d*\.\d\d*$)|(^-?\.\d\d*$)/;  
			if(!objRegex.test(balanceValue))    {  
				setErrorFor(div2, "餘額欄必須是數值");
       		} else { 
           		div2.innerHTML = "";
       		}
   		}
   		if (!birthdayValue){
			setErrorFor(div3, "請輸入生日");  
   		} else if(!dateValidation(birthdayValue)) {
			setErrorFor(div3, "生日格式錯誤，正確格式為yyyy-MM-dd");
   		} else {
       		div3.innerHTML = "";
   		}
   		if (hasError){
       		return false;
   		}
   		var xhr1 = new XMLHttpRequest();
   		xhr1.open("PUT", "<c:url value='/members/' />" + pk, true);
		var jsonMember = {
			"pk": pk, 					
			"id": idValue, 	
			"name": nameValue,
			"balance": balanceValue,
			"birthday": birthdayValue
   		}
   		xhr1.setRequestHeader("Content-Type", "application/json");
   		xhr1.send(JSON.stringify(jsonMember));
   		console.log(JSON.stringify(jsonMember));
	
   
   		xhr1.onreadystatechange = function() {
				// 伺服器請求完成
   		if (xhr1.readyState == 4 && (xhr1.status == 200 || xhr1.status == 201) ) {
      		result = JSON.parse(xhr1.responseText);
      		if (result.fail) {
		 		divResult.innerHTML = "<font color='red' >"
					+ result.fail + "</font>";
	  		} else if (result.success) {
				divResult.innerHTML = "<font color='GREEN'>"
					+ result.success + "</font>";
				div0.innerHTML = "";	
				div1.innerHTML = "";
				div2.innerHTML = "";
				div3.innerHTML = "";
	 		} else {
				if (result.idError) {
          			div0.innerHTML = "<font color='green' size='-2'>"
	     				+ result.idError + "</font>";
				} else {
          			div0.innerHTML = "";
				}
				if (result.nameError) {
	      			div1.innerHTML = "<font color='green' size='-2'>"
						+ result.nameError + "</font>";
				} else {
	      			div1.innerHTML = "";
	   			}
				if (result.balanceError) {
          			div2.innerHTML = "<font color='green' size='-2'>"
						+ result.balanceError + "</font>";
				} else {
          			div2.innerHTML = "";
    			}
				if (result.birthdayError) {
	    			div3.innerHTML = "<font color='green' size='-2'>"
						+ result.birthdayError + "</font>";
				} else {
          			div3.innerHTML = "";
				}
      		}
		} 
  	    
    }
   }
}

function setErrorFor(input, message){
	input.innerHTML = "<font color='red' size='-2'>" + message + "</font>";
    hasError = true;
}

function dateValidation(str) {
	  var re = new RegExp("^([0-9]{4})[.-]{1}([0-9]{1,2})[.-]{1}([0-9]{1,2})$");
	  var days = [0, 31, 28, 31, 30,  31, 30, 31, 31, 30, 31, 30, 31];
	  var strDataValue;
	  var valid = true;
	  if ((strDataValue = re.exec(str)) != null) {
	    var y, m, d;
	    y = parseFloat(strDataValue[1]);
	    if (y <= 0 || y > 9999) { /*年*/
	      return false;
	    } 
	    m = parseFloat(strDataValue[2]);
	    
	    if (m < 1 || m > 12) { /*月*/
	        return false;
	    }
	    d = parseFloat(strDataValue[3]);
	    if ( y % 4 == 0 && y % 100 != 0 || y % 400 == 0 ){
	       days[2] = 29;
	    }  else {
	       days[2] = 28;
	    }
	    if (d <= 0 || d > days[m]) { /*日*/
	      valid = false;
	    }
	  } else {
	    valid = false;
	  }  
	  return valid;
	}

	function isEmail(email) {
		return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
	}
</script>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />" type="text/css" />	
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<div align='center'>
<h2>修改會員資料</h2>
<div id='resultMsg' style="height:18px; font-weight: bold;"></div>
	<fieldset style='display: inline-block; width: 820px;'> 
	<legend>請修改下列資料</legend>
	<table border='1'>
	<tr height='60'>
		<td width='200'><input type="hidden" name="id" id='id'><br></td>
		<td width='400'>
			&nbsp;帳號: <label id='ida'></label><br>
		</td>
		<td width='200'>
			<div id='result0c' style="height: 10px;"></div><br>
			<div id='result0s' style="height: 10px;"></div>
		</td>
	</tr>
	<tr height='60'>
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;姓名: <input type="text" name="name" id='name'><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result1c' style="height: 10px;"></div><br>
			<div id='result1s' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;餘額: <input type="text" name="balance" id='balance'><br>
		</td>
		<td width='200' style="vertical-align:top">
			<div id='result2c' style="height: 10px;"></div><br>
			<div id='result2s' style="height: 10px;"></div>
		</td>	
	</tr>
	<tr height='60'>		
		<td width='200'>&nbsp;</td>
		<td width='400'>
			&nbsp;生日: <input type="text" name="birthday" id='birthday' size='24'>
		</td>	
		<td width='200'>
			<div id='result3c' style="height: 10px;"></div><br>
			<div id='result3s' style="height: 10px;"></div>			
		</td>	
	</tr>
	<tr height='50'>		
		<td colspan='3' align='center'>
			<button id='updateData'>更新</button>
			<button id='deleteData'>刪除</button>
		</td>
	</tr>		
			</table>
		</fieldset>
	<hr>	
	<p>	
	<a href="<c:url value='/showAllMembersAjax/' />">回前頁</a>
<hr>
</div>

</body>
</html>