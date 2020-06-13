package br.com.joaopaulo.AbelVolks.business.bean;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBean {

	private final String SUBWOOFER = "SubWoofer";
	private final String VOZ = "Voz";
	private final String POTENCIA = "Potencia";

	private List<ProdutosBean> pSom;

	public CatalogoBean() {
		// Inicia a lista de roupas com algumas roupas
		pSom = new ArrayList<>();
		pSom.add(novoSom("Auto Falantes Sub", SUBWOOFER, 550f, "autofalantes.jpg"));
		pSom.add(novoSom("Par Auto Falantes 6x9", VOZ, 305f, "6x9.jpg"));
		pSom.add(novoSom("Super Tweeter", VOZ, 99f, "tweeter.jpg"));
		pSom.add(novoSom("Auto Falantes Mid", SUBWOOFER, 230f, "mediograve.jpg"));
		pSom.add(novoSom("Taramps HD 3000", POTENCIA, 589f, "modulo.jpg"));
		pSom.add(novoSom("Modulo SounDigital 3000", POTENCIA, 479f, "modulosound.jpg"));
	}

	// Funação Auxiliar, criar novos produtos
	private ProdutosBean novoSom(String nome, String categoria, Float preco, String nomeImagem) {
		// Calcular o codigo com o tamanho da lista de produtos
		Integer codigo = pSom.size();

		ProdutosBean produtosBean = new ProdutosBean();
		produtosBean.setCodigo(codigo);
		produtosBean.setNome(nome);
		produtosBean.setCategoria(categoria);
		produtosBean.setPreco(preco);
		produtosBean.setNomeImagem(nomeImagem);

		return produtosBean;
	}

	public List<ProdutosBean> getSom() {
		return pSom;
	}

	public void setSom(List<ProdutosBean> som) {
		this.pSom = som;
	}

	public List<ProdutosBean> getSomFiltrados(String codigoCategoria) {
		// Pessoa ainda não escolheu nada
		if (codigoCategoria == null) {
			return pSom;
		}
		// Transforma, ex, String "0" em inteiro 0.
		int codigo = Integer.parseInt(codigoCategoria);

		List<ProdutosBean> somFiltrados = new ArrayList<>();

		// 0 Subwooofer
		// 1 Voz
		// 2 Potencia

		for (ProdutosBean som : pSom) {
			if (codigo == 0) {
				if (SUBWOOFER.equals(som.getCategoria())) {
					somFiltrados.add(som);
				}
			} else if (codigo == 1) {
				if (VOZ.equals(som.getCategoria())) {
					somFiltrados.add(som);
				}
			} else if (codigo == 2) {
				if (POTENCIA.equals(som.getCategoria())) {
					somFiltrados.add(som);
				}

			}
		}

		return somFiltrados;
	}
}
