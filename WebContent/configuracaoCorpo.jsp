<div class="row inf mt-3">
	<div class="bloco1 col-md-4 mt-1">
		<div style="align-items: center; ">
			<h1>Excluir conta</h1>
			<p style="color: red" >Essa ação é irreversível tem certeza disso? </p>
			<div  style="display: flex; align-items: center; justify-content: center;" >
				
				<div class="submit">
			<button type="button" class="btn btnProprio" type="button" data-bs-toggle="modal" data-bs-target="#modalExcluirUsu">
				<b style="color:red;">Exluir</b>
			</button>
		</div>
			</div>
		</div>
	</div>
	
</div>

<div class="modal fade" id="modalExcluirUsu" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmação</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja realmente Excluir o usuário ${user }?
      </div>
      <div class="modal-footer">
      <form action="usuario" method="post">
      	<input type="hidden" value="excluir" name="acao">
		<input type="hidden" value="${user }" name="email">
      	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Excluir</button>
      </form>
        </div>
    </div>
  </div>
</div>