<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<script>
	var stateObject = {
		"India" : {
			"Delhi" : [ "new Delhi", "North Delhi" ],
			"Kerala" : [ "Thiruvananthapuram", "Palakkad" ],
			"Goa" : [ "North Goa", "South Goa" ],
		},
		"Australia" : {
			"South Australia" : [ "Dunstan", "Mitchell" ],
			"Victoria" : [ "Altona", "Euroa" ]
		},
		"Canada" : {
			"Alberta" : [ "Acadia", "Bighorn" ],
			"Columbia" : [ "Washington", "" ]
		},
	}
	window.onload = function() {
		var countySel = document.getElementById("countySel"), stateSel = document
				.getElementById("stateSel"), districtSel = document
				.getElementById("districtSel");
		for ( var country in stateObject) {
			countySel.options[countySel.options.length] = new Option(country,
					country);
		}
		countySel.onchange = function() {
			stateSel.length = 1; // remove all options bar first
			districtSel.length = 1; // remove all options bar first
			if (this.selectedIndex < 1)
				return; // done
			for ( var state in stateObject[this.value]) {
				stateSel.options[stateSel.options.length] = new Option(state,
						state);
			}
		}
		countySel.onchange(); // reset in case page is reloaded
		stateSel.onchange = function() {
			districtSel.length = 1; // remove all options bar first
			if (this.selectedIndex < 1)
				return; // done
			var district = stateObject[countySel.value][this.value];
			for (var i = 0; i < district.length; i++) {
				districtSel.options[districtSel.options.length] = new Option(
						district[i], district[i]);
			}
		}
	}
</script>
</head>
<body>

	<h1>Enter Information of User</h1>
	${msg}
	<form:form action="register" method="post" modelAttribute="user">

		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>

		<form:label path="password">Password</form:label>
		<form:input path="password" />
		<br>



		<input type="submit" name="submit" value="submit" />

	</form:form>

</body>
</html>