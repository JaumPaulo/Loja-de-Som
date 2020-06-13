package br.com.joaopaulo.AbelVolks.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.joaopaulo.AbelVolks.business.bean.CatalogoBean;
import br.com.joaopaulo.AbelVolks.business.bean.ProdutosBean;

/**
 * Servlet implementation class CatalogoController
 */
@WebServlet("/catalogo")
public class CatalogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CatalogoBean catalogoBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogoController() {
		super();

		// Inicia com produtos padrões
		catalogoBean = new CatalogoBean();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigoCategoria = request.getParameter("categoria");

		// Envia as roupas do catalogo para o front
		request.setAttribute("somA", catalogoBean.getSomFiltrados(codigoCategoria));

		// CLicar m adicionar
		if (request.getParameter("adicionar") != null) {

			HttpSession session = request.getSession();

			// Verificação de um cart, caso precisa se cria mais 1
			if (session.getAttribute("cart") == null) {
				List<ProdutosBean> cart = new ArrayList<>();
				session.setAttribute("cart", cart);
			}

			List<ProdutosBean> cart = (List<ProdutosBean>) session.getAttribute("cart");

			String codigoString = request.getParameter("adicionar");
			Integer codigo = Integer.parseInt(codigoString);

			List<ProdutosBean> todosOsProdutos = catalogoBean.getSom();
			for (ProdutosBean som : todosOsProdutos) {
				if (som.getCodigo().equals(codigo)) {
					cart.add(som);
				}
			}

		}

		// Envia a pagina jsp na requisição
		request.getRequestDispatcher("/catalogo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
