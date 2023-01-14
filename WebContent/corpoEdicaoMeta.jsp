<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="view row mt-3">
	<div class="bloco1 col">
		<form action="metaS" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${user }" name="email">
				<input
				type="hidden" value="${metaEdicao.cdMeta }" name="codigo">
			<div class="row mb-3">
				<label for="descricao" class="mt-3">Descrição meta</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="descricao"
						name="descricao" value="${metaEdicao.titulo }">
				</div>
			</div>
			<div class="row mb-3">
				<label for="valor" class="">Valor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="valor" name="valor" value="${metaEdicao.vlMeta }">
				</div>
			</div>
			<button type="submit" class="btn btnProprio mb-3">Cadastrar</button>
		</form>
	</div>
</div>


