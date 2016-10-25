<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<button class="btn btn-primary" id="addUserBtn">Add</button>
<table class="table table-striped" id="userTable">
	<tr><th>User ID</th><th>User Name</th><th>User Age</th><th>Delete Oprate</th><th>Edit Oprate</th></tr>
</table>

<script type="text/javascript">
	//get XMLHttpRequest Object
	var xhr = new XMLHttpRequest();
	//callback
	xhr.onreadystatechange=function(){
		if (xhr.readyState==4 && xhr.status==200){
			var users = JSON.parse(xhr.responseText);
			users.forEach(function(u){
				var tr = document.createElement("tr");
				var td1 = document.createElement("td");
				
				td1.innerHTML = u.id;
				
				var td2 = document.createElement("td");
				
				td2.innerHTML = u.uname;
				
				var td3 = document.createElement("td");
				
				td3.innerHTML = u.age;
				
				var td4 = document.createElement("td");
				
				var del = document.createElement("button");
				del.innerHTML = "Delete"
				del.onclick = function(){

					//alert("123");
					
					var xhr2 = new XMLHttpRequest();
					
					xhr2.onreadystatechange=function(){
						if (xhr2.readyState==4 && xhr2.status==200){
							var isSuccess = JSON.parse(xhr2.responseText);
							//alert(isSuccess);
							location.reload();
						}
					}
					
					// how can i use POST to pass data here ????
					xhr2.open("GET", "user/deleteUser?id=" + u.id);
					xhr2.send(null);
				}
				
				td4.appendChild(del);
				
				var td5 = document.createElement("td");
				
				var edit = document.createElement("button");
				edit.innerHTML = "Edit";
				
				edit.onclick = function(){
					var tr = document.createElement("tr");
					var td1 = document.createElement("td");
					
					var td2 = document.createElement("td");
					var unameInput = document.createElement("input");
					unameInput.value = u.uname;
					td2.appendChild(unameInput);
					
					var td3 = document.createElement("td");
					var ageInput = document.createElement("input");
					ageInput.value = u.age;
					td3.appendChild(ageInput);
					
					var td4 = document.createElement("td");
					var update = document.createElement("button");
					update.innerHTML = "update"
					update.onclick = function(){
						var xhr5 = new XMLHttpRequest();
						
						xhr5.onreadystatechange=function(){
							if (xhr5.readyState==4 && xhr5.status==200){
								var isSuccess = JSON.parse(xhr5.responseText);
								//alert(isSuccess);
								location.reload();
							}
						}
						
						var id = u.id;
						var uname = unameInput.value;
						var age = ageInput.value;
						
						// how can i use POST to pass data here ????
						xhr5.open("GET", "user/updateUser?id=" + id + "&uname=" + uname + "&age=" + age);
						xhr5.send(null);
					}
					
					td4.appendChild(update);
					
					var td5 = document.createElement("td");
					
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					tr.appendChild(td5);
					
					var table = document.getElementById("userTable");
					
					table.appendChild(tr);
				}
				
				td5.appendChild(edit);
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				
				var table = document.getElementById("userTable");
				
				table.appendChild(tr);
			});	
		}			
	}
	xhr.open("GET", "user/listUsers");
	xhr.send(null);		
	
	// Add
	
	document.getElementById("addUserBtn").onclick = function(){
		
		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		
		var td2 = document.createElement("td");
		var unameInput = document.createElement("input");
		td2.appendChild(unameInput);
		
		var td3 = document.createElement("td");
		var ageInput = document.createElement("input");
		td3.appendChild(ageInput);
		
		var td4 = document.createElement("td");
		var add = document.createElement("button");
		add.innerHTML = "Add"
		add.onclick = function(){
			var xhr3 = new XMLHttpRequest();
			
			xhr3.onreadystatechange=function(){
				if (xhr3.readyState==4 && xhr3.status==200){
					var isSuccess = JSON.parse(xhr3.responseText);
					//alert(isSuccess);
					location.reload();
				}
			}
			
			var uname = unameInput.value;
			var age = ageInput.value;
			
			// how can i use POST to pass data here ????
			xhr3.open("GET", "user/addUser?uname=" + uname + "&age=" + age);
			xhr3.send(null);
		}
		
		td4.appendChild(add);
		
		var td5 = document.createElement("td");
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		
		var table = document.getElementById("userTable");
		
		table.appendChild(tr);
		
	}	
</script>


</body>
</html>