<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="view row mt-3">
	<div class="bloco1 col">
		<form action="movimentacao" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${receitaEdicao.cdMovimentacao}" name="codigo">
				<input
				type="hidden" value="${user }" name="email">
			<div class="row mb-3">
				<label for="descricao" class="mt-3">Descrição ${codigo}</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="descricao"
						name="descricao" value="${receitaEdicao.nmTitulo }">
				</div>
			</div>
			<div class="row mb-3">
				<label for="valor" class="">Valor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="valor" name="valor" value="${receitaEdicao.valor }">
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
				</div>
			</fieldset>
			<button type="submit" class="btn btnProprio mb-3">Cadastrar</button>
		</form>
	</div>
	
</div>
