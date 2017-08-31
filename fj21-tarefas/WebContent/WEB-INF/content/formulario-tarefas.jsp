<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<body>
		<h3>Adicionar tarefas</h3>
		<s:fielderror fieldName="tarefa.descricao"/>
		<form action="adicionaTarefa" method="post">
			Descrição: <br/>
			<textarea name="tarefa.descricao" rows="5" cols="100"></textarea><br/>
			<input type="submit" value="Adicionar">
		</form>
	</body>
</html>