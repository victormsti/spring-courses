<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>Student form</title>
<body>
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />

		<br>
		<br>
		
		Last Name: <form:input path="lastName" />

		<br>
		<br>
		
		Country: 
		
		<form:select path="country">

			<%-- 			<form:option value="Brazil" label="Brazil" /> --%>
			<%-- 			<form:option value="France" label="France" /> --%>
			<%-- 			<form:option value="Germany" label="Germany" /> --%>
			<%-- 			<form:option value="India" label="India" /> --%>

			<form:options items="${student.countryOptions}" />

		</form:select>

		<br>
		<br>
		
		Favorite Language:
		
		<%-- 		Java <form:radiobutton path="favoriteLanguage" value="Java"/> --%>
		<%-- 		C# <form:radiobutton path="favoriteLanguage" value="C#"/> --%>
		<%-- 		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/> --%>
		<%-- 		Ruby <form:radiobutton path="favoriteLanguage" value="ruby"/> --%>

		<form:radiobuttons path="favoriteLanguage"
			items="${student.favoriteLanguageOptions}" />
		
		<br><br>

		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		MAC OS<form:checkbox path="operatingSystems" value="MAC OS" />
		MC Windows<form:checkbox path="operatingSystems" value="MS Windows" />
		
		<br><br>
		
		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>