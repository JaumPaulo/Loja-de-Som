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

import com.alexandrecampos.lojaderoupas.business.bean.RoupaBean;

import br.com.joaopaulo.AbelVolks.business.bean.ProdutosBean;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Verificação de um cart, caso precisa se cria mais 1
		if (session.getAttribute("cart") == null) {
			List<ProdutosBean> cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}

		List<ProdutosBean> cart = (List<ProdutosBean>) session.getAttribute("cart");

		request.setAttribute("cart", cart);

		Float total = 0f;
		for (ProdutosBean som : cart) {
			total += som.getPreco();
		}
		request.setAttribute("total", total);

		// Envia a pagina jsp na requisição
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Usuario clicou em remover
		String indexString = request.getParameter("remover");
		int index = Integer.parseInt(indexString) - 1; // Count e 1-based

		// Recupera o cart
		HttpSession session = request.getSession();
		List<ProdutosBean> cart = (List<ProdutosBean>) session.getAttribute("cart");

		// Remove a roupa do carrinho pelo indice
		cart.remove(index);

		doGet(request, response);
	}

}
