<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="view row mt-3">
	<div class="bloco1 col">
		<form action="investimentoS" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${user }" name="email">
				<input
				type="hidden" value="${investimentoEdicao.cdInv }" name="codigo">
			<div class="row mb-3">
				<label for="nomeI" class="mt-3">Nome Investimento</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nomeI"
						name="nomeI" value="${investimentoEdicao.nmAplicacao }">
				</div>
			</div>
			<div class="row mb-3">
				<label for="valor" class="">Valor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="valor" name="valor" value="${investimentoEdicao.vlAplicacao }">
				</div>
			</div>
			<div class="form-group mb-3">
				<label for="id-dtAplicacao">Data da aplicação</label> <input
					type="datetime" name="dtAplicacao" id="id-dtAplicacao"
					class="form-control" value='<fmt:formatDate value="${investimentoEdicao.dtAplicacao.time }" pattern="dd/MM/yyyy"/>'>
			</div>
			<div class="form-group">
				<label for="id-dtVencimento">Data do vencimento</label> <input
					type="datetime" name=dtVencimento id="id-dtVencimento"
					class="form-control" value='<fmt:formatDate value="${investimentoEdicao.dtVencimento.time }" pattern="dd/MM/yyyy"/>'>
			</div>
			<div class="row mb-3">
				<label for="banco" class="mt-3">Nome Banco</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="banco"
						name="banco" value="${investimentoEdicao.nmBanco }">
				</div>
			</div>
			<button type="submit" class="btn btnProprio mb-3">Cadastrar</button>
		</form>
	</div>
</div>


