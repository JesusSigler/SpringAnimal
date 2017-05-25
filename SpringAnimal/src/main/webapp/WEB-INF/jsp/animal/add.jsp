<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

	<h1>Agregar a un Animal</h1>

	<form:form method="POST" modelAttribute="animal">
		<p>
			Race:
			<input type="text" name="race" />
			<form:errors path="race" cssclass="error"></form:errors>
		</p>
		<p>
			Color:
			<input type="text" name="color" />
			<form:errors path="color" cssclass="error"></form:errors>
		</p>

		<input type="submit" value="insertar"/>
	</form:form>

</body>
</html>