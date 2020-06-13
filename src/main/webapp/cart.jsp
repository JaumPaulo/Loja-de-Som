<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<c:import url="/Common/header.jsp" />

<body>
	<div class="container-fluid">

		<c:import url="/Common/titulo.jsp" />

		<div class="row">
			<c:import url="/Common/barralateral.jsp" />

			<div class="col-9">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<h3>Carrinho de Compras</h3>
						</div>
					</div>
				</div>

				<table class="table table-bordered table-hover table-striped">
					<thead class="thead thead-dark">
						<tr>
							<th class="text-center">Nome</th>
							<th class="text-center">Preço</th>
							<th class="text-center">Imagem</th>
							<th />
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${ cart }" var="som" varStatus="index">
							<tr>
								<td class="text-center align-middle">${ som.nome }</td>
								<td class="text-center align-middle"><fmt:formatNumber
										value="${ som.preco }" type="currency" currencySymbol="R$" /></td>

								<td class="text-center align-middle"><img
									style="width: 10vw; height: auto;"
									src="assets/img/catalogo/${ som.nomeImagem }"></td>
								<td class="text-center align-middle">
									<form method="post">
										<button class="btn btn-danger" name="remover" value="${ index.count }">Remover</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>

					<tfoot class="bg-dark text-white">
						<tr>
							<th class="text-center">Total</th>
							<th class="text-center"><fmt:formatNumber value="${ total }"
									type="currency" currencySymbol="R$" /></th>
							<th />
							<th />

						</tr>
					</tfoot>

				</table>

			</div>

		</div>

	</div>

	<c:import url="/Common/footer.jsp" />

</body>
</html>