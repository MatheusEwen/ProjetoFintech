<header class="row">
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a href="dashboard.jsp" class="navbar-brand"> <img
				src="resources/imgs/logo.svg" alt="logo fintech" class="logo" />
			</a>
			<button class="navbar-toggler" data-bs-toggle="collapse"
				data-bs-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<div class="navbar-nav">
					<a href="movimentacao?acao=listar&email=${user }" class="btn" >Adicionar Receita
						e Despesa</a> <a href="investimentoS?acao=listar&email=${user }" class="btn">Investimentos</a> <a href="metaS?acao=listar&email=${user }"
						class="btn">Metas</a><a href="configuracao.jsp" class="btn">Configurações</a>
				</div>
			</div>
		</div>
	</nav>
</header>