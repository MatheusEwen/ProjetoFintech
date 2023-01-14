<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="view row mt-3">
	<div class="bloco1 col">
		<form action="metaS" method="post">
			<input type="hidden" value="cadastrar" name="acao"> <input
				type="hidden" value="${user }" name="user">
			<div class="row mb-3">
				<label for="descricao" class="mt-3">Descrição</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="descricao"
						name="descricao">
				</div>
			</div>
			<div class="row mb-3">
				<label for="valor" class="">Valor Necessário</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="valor" name="valor">
				</div>
			</div>
			<button type="submit" class="btn btnProprio mb-3">Cadastrar</button>
		</form>
	</div>
	<div class="bloco2 col mt-2 mb-3">
		<br />
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Descrição da meta</th>
					<th scope="col">Valor</th>
					<th scope="col">Acao</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${metas }" var="m">
				<tr>
					<td>${m.titulo }</td>
					<td>${m.vlMeta }</td>
					<td>
						<c:url value="metaS" var="linkM">
							<c:param name="acao" value="abrir-form-edicao-meta" />
							<c:param name="codigo" value="${m.cdMeta }" />
						</c:url>
						<a href="${linkM}" class="acao">
						<button class="acao">
							<i><img src="resources/imgs/pencil-square.svg" alt="editar"></i>
						</button>
						</a>
						<button class="acao" type="button" data-bs-toggle="modal" data-bs-target="#modalExcluirMeta" onclick="codigoExcluirMeta.value = ${m.cdMeta}">
							<i><img src="resources/imgs/x-circle.svg" alt="excluir"></i>
						</button>
					</td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalExcluirMeta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmação</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja realmente Excluir a Meta?
      </div>
      <div class="modal-footer">
      <form action="metaS" method="post">
      <input type="hidden" name="acao" value="excluir"> 
      <input type="hidden" name="codigoExcluirMeta" id="codigoExcluirMeta">
		<input type="hidden" name="email" value="${user }">
      	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Excluir</button>
      </form>
        </div>
    </div>
  </div>
</div>
