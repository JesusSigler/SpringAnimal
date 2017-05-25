<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

	<h1>Modificar a  un animal</h1>

	<form:form method="POST" modelAttribute="animal">
		<p>
			Race:
			<input type="text" name="race" />
			<form:errors path="name" cssclass="error"></form:errors>
		</p>
		<p>
			Color:
			<input type="text" name="color" />
			<form:errors path="price" cssclass="error"></form:errors>
		</p>

		<input type="submit" value="Guardar"/>
	</form:form>

</body>
</html>