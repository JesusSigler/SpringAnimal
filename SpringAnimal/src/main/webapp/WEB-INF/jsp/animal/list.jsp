<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<body>

	<h1>Listar Animales</h1>
	
	<c:forEach items="${animalList}" var="animal">
		<p>
			${animal.race}: ${animal.color}
		</p>
	</c:forEach>

</body>
</html>