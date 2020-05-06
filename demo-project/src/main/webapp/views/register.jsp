<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	var stateObject = {
		"India" : {
			"West Bengal" : ["Kolkata", "Siliguri", "Durgapur", "Kharagpur", "Bardhaman"],
			"Maharashtra" : ["Mumbai", "Puna", "Nagpur", "Thane", "Nashik"],
			"Karnataka" : ["Bengaluru", "Mysore", "Mangalore", "Bijapur", "Belgaum"],
			"Uttar Pradesh" : ["Lucknow", "Kanpur", "Agra", "Varanasi", "Bareilly"]
		},
		"USA" : {
			"Alabama" : [ "Birmingham", "Huntsville", "Montgomery", "Mobile", "Hoover"],
			"Alaska" : [ "Anchorage", "Juneau", "Fairbanks", "Badger" ],
			"California" : [ "Los Angeles", "San Diego", "San Jose", "San Francisco", "Oakland" ],
			"Hawaii" : [ "Maui", "Oahu", "Hawaii Island" ],
		},
		"Australia" : {
			"Victoria" : [ "Melbourne", "Geelong", "Ballarat", "Sunbury", "Sale" ],
			"Queensland" : [ "Brisbane", "Caloundra", "Gladstone", "Logan City", "Hervey Bay" ],
			"New South Wales" : [ "Albury", "Broken Hill", "Dubbo", "Grafton", "Sydney", "Newcastle" ]
		},
	}
	window.onload = function() {
		var countySel = document.getElementById("countrySelect"), stateSel = document
				.getElementById("stateSelect"), districtSel = document
				.getElementById("citySelect");
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
<body class="m-3">

	<h1>Enter Information of User</h1>
	${msg}
	<form:form action="register" method="post" modelAttribute="user">

		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>

		<form:label path="company">Company</form:label>
		<form:input path="company" />
		<br>

		<form:label path="contact">Contact Number</form:label>
		<form:input path="contact" required="required" />
		<br>

		<form:label path="gender">Gender</form:label>
		<form:radiobuttons path="gender" items="${gender}" />
		<br>
		
		<form:label path="country">Country</form:label>
		<form:select path="country" id="countrySelect">
			<form:option value="" selected="selected">Select Country</form:option>
		</form:select>
		<br>
		
		<form:label path="state">State</form:label>
		<form:select path="state" id="stateSelect">
			<form:option value="" selected="selected">Select State</form:option>
		</form:select>
		<br>
		
		<form:label path="city">City</form:label>
		<form:select path="city" id="citySelect">
			<form:option value="" selected="selected">Select City</form:option>
		</form:select>	
		<br>
		
		<input type="submit" name="submit" value="Submit" />

	</form:form>

</body>
</html>