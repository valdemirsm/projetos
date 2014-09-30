package sismesa.produto;

import java.util.List;

import org.primefaces.model.chart.CartesianChartModel;



public interface ProdutoDAO {
	public void salvar(Produto produto);
	public void excluir(Produto produto);
	public List<Produto> listar();
	public Produto buscaProduto(int codigo);
	public CartesianChartModel prodVendidos();
}
