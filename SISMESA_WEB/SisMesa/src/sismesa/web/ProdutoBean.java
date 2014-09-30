package sismesa.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.CartesianChartModel;

import sismesa.mesa.Mesa;
import sismesa.produto.Produto;
import sismesa.produto.ProdutoRN;
import sismesa.produto.ProdutosVendidos;

public class ProdutoBean implements Serializable {
	private Produto selecionada = new Produto();
	private List<Produto> lista = null;
	private List<ProdutosVendidos> listaprodvend = null;

	public Produto getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Produto selecionada) {
		this.selecionada = selecionada;
	}

	public void salvar() {
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(this.selecionada);
		this.lista = null;
	}
	public void novo() {
		this.selecionada = new Produto();
		this.lista = null;
	}

	public void excluir() { // 1
		ProdutoRN contaRN = new ProdutoRN();
		contaRN.excluir(this.selecionada);
		this.selecionada = new Produto();
		this.lista = null;
	}

	public String editar() {
		ProdutoRN contaRN = new ProdutoRN();
		return contaRN.editar(this.selecionada);
	}

	public List<Produto> getLista() { // 2
		if (this.lista == null) {
			ProdutoRN produtoRN = new ProdutoRN();
			System.out.println(8888888);
			this.lista = produtoRN.listar();
		}
		return this.lista;
	}
	
	public CartesianChartModel getListaProdVend() {
		ProdutoRN produtoRN = new ProdutoRN();
		return produtoRN.prodVendidos();
	}
	
/*	public StreamedContent getGrafico() {
		StreamedContent grafico;
		
		DefaultCategoryDataset dts = new DefaultCategoryDataset();
		dts.setValue(new Double(2345.0), "Valores", "Blumenal");
		dts.setValue(new Double(2590.0), "Produtos", "Chapecó");
		dts.setValue(new Double(2290.0), "Valores", "Criciúma");
		dts.setValue(new Double(2300.0), "Valores", "Florianópolis");
		dts.setValue(new Double(2400.0), "Valores", "Joinvile");
		
		JFreeChart graficoColunas = ChartFactory.createBarChart("Listra de produtos mais vendidos", "Produtos", "Valores", dts, PlotOrientation.VERTICAL, false, true, false);
		File arquivoGrafico = new File("colunas.png");
		try {
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoColunas, 500, 325);
			grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "resources/imagens");
			return grafico;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}*/
}
