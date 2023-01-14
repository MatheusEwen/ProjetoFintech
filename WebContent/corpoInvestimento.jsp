<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="view row mt-3">
	<div class="bloco1 col">
		<form action="investimentoS" method="post">
			<input type="hidden" value="cadastrar" name="acao"> <input
				type="hidden" value="${user }" name="user">
			<div class="row mb-3">
				<label for="nomeI" class="mt-3">Nome Investimento</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="descricao"
						name="nomeI">
				</div>
			</div>
			<div class="row mb-3">
				<label for="valor" class="">Valor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="valor" name="valor">
				</div>
			</div>
			<div class="form-group mb-3">
				<label for="id-dtAplicacao">Data da aplicação</label> <input
					type="datetime" name="dtAplicacao" id="id-dtAplicacao"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id-dtVencimento">Data do vencimento</label> <input
					type="datetime" name=dtVencimento id="id-dtVencimento"
					class="form-control">
			</div>
			<div class="row mb-3">
				<label for="banco" class="mt-3">Nome Banco</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="banco"
						name="banco">
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
					<th scope="col">Nome</th>
					<th scope="col">Valor</th>
					<th scope="col">Data Aplicação</th>
					<th scope="col">Data Vencimento</th>
					<th scope="col">Banco</th>
					<th scope="col">Acao</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${investimentos }" var="i">
				<tr>
					<td>${i.nmAplicacao }</td>
					<td>${i.vlAplicacao }</td>
					<td><fmt:formatDate value="${i.dtAplicacao.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td><fmt:formatDate value="${i.dtVencimento.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td>${i.nmBanco }</td>
					<td>
						<c:url value="investimentoS" var="linkI">
							<c:param name="acao" value="abrir-form-edicao-inv" />
							<c:param name="codigo" value="${i.cdInv }" />
						</c:url>
						<a href="${linkI}" class="acao">
						<button class="acao">
							<i><img src="resources/imgs/pencil-square.svg" alt="editar"></i>
						</button>
						</a>
						<button class="acao" type="button" data-bs-toggle="modal" data-bs-target="#modalExcluirInv" onclick="codigoExcluirInv.value = ${i.cdInv}">
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
<div class="modal fade" id="modalExcluirInv" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmação</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja realmente Excluir o investimento?
      </div>
      <div class="modal-footer">
      <form action="investimentoS" method="post">
      <input type="hidden" name="acao" value="excluir"> 
      <input type="hidden" name="codigoExcluirInv" id="codigoExcluirInv">
		<input type="hidden" name="email" value="${user }">
      	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Excluir</button>
      </form>
        </div>
    </div>
  </div>
</div>
