<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
	</head>
	<body>
		<script type="text/javascript">
			function finalizaAgora(id){
				$.post("finalizaTarefa", {'id':id}, function(){
					$("#tarefa_"+id).html("Tarefa finalizada");
				});
			}
			
			function removeTarefa(id){
				$.post("removeTarefa", {'id': id}, function(){
					$("#tarefa_"+id).closest("tr").hide();
				});				
			}
		</script>
		<a href="tarefaForm">Criar nova tarefa</a>
		<br/><br/>
		<table>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizado?</th>
				<th>Data de finalização</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<c:if test="${tarefa.finalizado eq false}">
						<td id="tarefa_${tarefa.id}">
							<a href="#" onclick="finalizaAgora(${tarefa.id})">
								Finaliza agora!
							</a>
						</td>
					</c:if>
					<c:if test="${tarefa.finalizado eq true}">
						<td>Finalizado</td>
					</c:if>
					<td>
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<!-- <a href="removeTarefa?tarefa.id=${tarefa.id}">Remover</a> -->
						<a href="#" onclick="removeTarefa(${tarefa.id})">Remover</a>
					</td>
					<td>
						<a href="mostraTarefa?tarefa.id=${tarefa.id}">Alterar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>