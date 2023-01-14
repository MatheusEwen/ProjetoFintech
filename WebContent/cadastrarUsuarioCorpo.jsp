<div>
	<h2>Crie sua conta de graça!!!</h2>
	<form class="form-horizontal" action="usuario" method="post">
	<input type="hidden" value="cadastrar" name="acao">
		<div class="row mb-3">
			<label for="nome" class="control-label">Nome:</label> <input
				type="text" class="form-control" id="nome" name="nome" />
		</div>
		<div class="row mb-3">
			<label for="email" class="control-label">Email:</label> <input
				type="email" class="form-control" id="email" name="email"/>
		</div>
		<div class="row mb-3">
			<label for="pwd" class="control-label">Senha:</label> <input
				type="password" id="pwd" class="form-control" name="senha"/>
		</div>
		<div class="row mb-3">
			<label for="saldo" class="control-label">Saldo (insira o que
				você já tem):</label> <input type="text" id="saldo" class="form-control" name="saldo" />
		</div>
		<div class="submit">
			<button type="submit" class="btn btnProprio">
				<b>Cadastrar</b>
			</button>
		</div>
	</form>
</div>