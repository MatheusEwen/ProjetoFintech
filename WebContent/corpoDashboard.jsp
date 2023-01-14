<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row inf mt-3">
        <div class="bloco1 col-md-4 mt-1">
          <div>
            <h1>Seu saldo atual</h1>
            <p class="conteudo1"><fmt:formatNumber value="${saldo }" type="currency"  /></p>
          </div>
        </div>
        <div class="bloco2 col-md-3 mt-1">
          <div class="mt-3">
            <h1 class="mb-3">Objetivos</h1>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Descrição</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${metasUsu }" var="m" varStatus="movieLoopCount">
                <tr>
                  <th scope="row">${movieLoopCount.count }</th>
                  <td>${m.titulo }</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="bloco3 col-md-4 mt-1">
          <div class="mt-3">
            <h1>Histórico das ultimas movimentações</h1>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Descrição</th>
                  <th scope="col">Tipo</th>
                  <th scope="col">Valor</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${receitaUsu }" var="r" varStatus="movieLoopCount">
                <tr>
                  <th scope="row" style="color: green">${movieLoopCount.count }</th>
                  <td>${r.nmTitulo }</td>
                  <td>Receita</td>
                  <td>${r.valor }</td>
                </tr>
                </c:forEach>
                <c:forEach items="${despesaUsu }" var="d" varStatus="movieLoopCount">
                <tr>
                  <th scope="row" style="color: red">${movieLoopCount.count }</th>
                  <td>${d.nmTitulo }</td>
                  <td>Despesa</td>
                  <td>${d.valor }</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>