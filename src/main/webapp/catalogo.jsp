<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<c:import url="/Common/header.jsp" />

<body>

	<c:import url="/Common/titulo.jsp" />

	<div class="row">
		<c:import url="/Common/barralateral.jsp" />

		<div class="col-9">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<h2>Catálogo</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<c:forEach items="${ somA }" var="som">
							<form method="get">
								<div class="card">
									<div class="card-header">
										<h5>${ som.nome }</h5>
									</div>
									<div class="card-body">


										<img class="card-img"
											src="assets/img/catalogo/${ som.nomeImagem }">

										<div class="card-title text-center mt-4">
											<div class="badge badge-dark badge-pill">
												<h5>
													<fmt:formatNumber value="${som.preco}" type="currency"
														currencySymbol="R$" />
												</h5>
											</div>

										</div>

									</div>

									<div class="card-footer text-center">
										<div class="btn-group">
											<button type="submit" name="adicionar"
												class="btn btn-primary" value="${ som.codigo }">Adicionar</button>
											<a class="btn btn-info" href="#">Detalhes</a>
										</div>
									</div>
								</div>
							</form>
						</c:forEach>
					</div>

					<div class="col-6 text-right">
						<h5>Filtros</h5>

						<form method="get">
							<div>
								<select name="categoria" class="form-control">
									<option value="0">Subwoofer</option>
									<option value="1">Voz</option>
									<option value="2">Potencia</option>
								</select>
							</div>
							<div>
								<div class="btn grupo">
									<button class="btn btn-primary">Filtrar</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/Common/footer.jsp" />

</body>
</html>
