<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="view row mt-3">
	<div class="bloco1 col">
		<form action="movimentacao" method="post">
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
				<label for="valor" class="">Valor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="valor" name="valor">
				</div>
			</div>
			<fieldset class="row mb-3">
				<legend class="col-form-label col-sm-2 pt-0">Tipo</legend>
				<div class="col-sm-10">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="tipo"
							id="gridRadios1" value="receita" checked> <label
							class="form-check-label" for="gridRadios1"> Receita </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="tipo"
							id="gridRadios2" value="despesa"> <label
							class="form-check-label" for="gridRadios2"> Despesa </label>
					</div>
				</div>
			</fieldset>
			<button type="submit" class="btn btnProprio mb-3">Cadastrar</button>
		</form>
	</div>
	<div class="bloco2 col mt-2 mb-3">
		<br />
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Descrição Receita</th>
					<th scope="col">Data</th>
					<th scope="col">Valor</th>
					<th scope="col">ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${receitas }" var="r">
				<tr>
					<td>${r.nmTitulo }</td>
					<td>${r.dtMovimentacao }</td>
					<td>${r.valor }</td>
					<td>
						<c:url value="movimentacao" var="linkReceita">
							<c:param name="acao" value="abrir-form-edicao-receita" />
							<c:param name="codigo" value="${r.cdMovimentacao }" />
						</c:url>
						<a href="${linkReceita}" class="acao">
						<button class="acao">
							<i><img src="resources/imgs/pencil-square.svg" alt="editar"></i>
						</button>
						</a>
						<button class="acao" type="button" data-bs-toggle="modal" data-bs-target="#modalExcluirReceita" onclick="codigoExcluirReceita.value = ${r.cdMovimentacao}">
							<i><img src="resources/imgs/x-circle.svg" alt="excluir"></i>
						</button>
					</td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="bloco2 col mt-2 mb-3" style="margin-left: 10px;">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Descrição despesa</th>
					<th scope="col">Data</th>
					<th scope="col">Valor</th>
					<th scope="col">ação</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${despesas }" var="d">
				<tr>
					<td>${d.nmTitulo }</td>
					<td>${d.dtMovimentacao }</td>
					<td>${d.valor}</td>
					<td>
					<c:url value="movimentacao" var="linkDespesa">
							<c:param name="acao" value="abrir-form-edicao-despesa" />
							<c:param name="codigoDespesa" value="${d.cdMovimentacao }" />
						</c:url>
						<a href="${linkDespesa}" class="acao">
						<button class="acao">
							<i><img src="resources/imgs/pencil-square.svg" alt="editar"></i>
						</button>
						</a>
						<button class="acao" type="button" data-bs-toggle="modal" data-bs-target="#modalExcluirDespesa" onclick="codigoExcluirDespesa.value = ${d.cdMovimentacao}">
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
<div class="modal fade" id="modalExcluirReceita" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmação</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja realmente Excluir a receita?
      </div>
      <div class="modal-footer">
      <form action="movimentacao" method="post">
      <input type="hidden" name="acao" value="excluir"> 
      <input type="hidden" name="codigoReceitaExcluir" id="codigoExcluirReceita">
		<input type="hidden" name="tipo" value="receita">
		<input type="hidden" name="email" value="${user }">
      	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Excluir</button>
      </form>
        </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalExcluirDespesa" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmação</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja realmente Excluir a despesa?
      </div>
      <div class="modal-footer">
      <form action="movimentacao" method="post">
      <input type="hidden" name="acao" value="excluir"> 
      <input type="hidden" name="codigoDespesaExcluir" id="codigoExcluirDespesa">
		<input type="hidden" name="tipo" value="despesa">
		<input type="hidden" name="email" value="${user }">
      	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Excluir</button>
      </form>
        </div>
    </div>
  </div>
</div>
