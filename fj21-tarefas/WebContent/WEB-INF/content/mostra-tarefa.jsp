<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<body>
		<h3>Alterar tarefa - ${tarefa.id}</h3>
		<form action="alteraTarefa" method="post">
			<input type="hidden" name="tarefa.id" value="${tarefa.id}" />
			Descrição:<br/>
			<textarea rows="5" cols="100" name="tarefa.descricao">
				${tarefa.descricao}
			</textarea>
			<br/>
			Finalizado?  <input type="text" name="tarefa.dataFinalizacao" value='<fmt:formatDate value="${tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy"/>'/>
			<br/>
			<input type="submit" value="Alterar"/>
		</form>
	</body>
</html>