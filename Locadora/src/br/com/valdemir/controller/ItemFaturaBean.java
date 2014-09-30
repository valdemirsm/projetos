package br.com.valdemir.controller;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import br.com.valdemir.dao.Conexao;
import br.com.valdemir.dao.ItemFaturaDAO;
import br.com.valdemir.model.ItemFatura;

public class ItemFaturaBean {
	private ItemFaturaDAO itemfaturaDAO = new ItemFaturaDAO();
	private ItemFatura itemfatura = new ItemFatura();
	@SuppressWarnings("unused")
	private DataModel<ItemFatura> itensfatura;

	public ItemFaturaBean() {

	}

	public void inserir(ActionEvent evt) {
		itemfaturaDAO = new ItemFaturaDAO();
		itemfaturaDAO.inserir(itemfatura);
		itemfatura = new ItemFatura();
	}

	public ItemFatura getItemFatura() {
		return itemfatura;
	}

	public void setItemFatura(ItemFatura itemfatura) {
		this.itemfatura = itemfatura;
	}

	public List<ItemFatura> getItensFatura() {
		itemfaturaDAO = new ItemFaturaDAO();
		ItemFatura itemfat = new ItemFatura();
		List<ItemFatura> itemFatList = itemfaturaDAO.listar(itemfat);
		return itemFatList;
	}

	public String getSituacao() {
		String situacao;
		if (itemfatura.getSituacao() == 1) {
			situacao = "Emprestado";
		} else {
			situacao = "Devolvido";
		}
		return situacao;
	}

	public void remover(ActionEvent event) {
		int id = (Integer) event.getComponent().getAttributes()
				.get("id_filme_alugado");
		itemfaturaDAO = new ItemFaturaDAO();
		itemfaturaDAO.remover(id);
	}

	public void alterar(ActionEvent evt) {
		int id_filme_alugado = (Integer) evt.getComponent().getAttributes()
				.get("id_filme_alugado");
		int situaca_filme = (Integer) evt.getComponent().getAttributes()
				.get("situaca_filme");
		Date data_pgto = (Date) evt.getComponent().getAttributes()
				.get("data_pgto");
		itemfatura.setId_filme_alugado(id_filme_alugado);
		itemfatura.setSituacao(situaca_filme);
		itemfatura.setData_pagamento(data_pgto);
		itemfaturaDAO = new ItemFaturaDAO();
		itemfaturaDAO.alterar(itemfatura);
	}

	public void altera_status(ActionEvent evt) {
		int situaca_filme = (Integer) evt.getComponent().getAttributes()
				.get("situaca_filme");
		itemfatura.setSituacao(situaca_filme);
		itemfaturaDAO = new ItemFaturaDAO();
		itemfaturaDAO.alterar(itemfatura);
	}

	public void imprimir(ActionEvent evt) {
		Date data_retirada_ini = (Date) evt.getComponent().getAttributes()
				.get("data_retirada_ini");
		Date data_retirada_fin = (Date) evt.getComponent().getAttributes()
				.get("data_retirada_fin");
		int id_cliente = (Integer) evt.getComponent().getAttributes()
				.get("id_cliente");
		int id_filme = (Integer) evt.getComponent().getAttributes()
				.get("id_filme");

		try {
			if (data_retirada_ini != null && data_retirada_fin != null) {
				Date data_retirada_ini_sql = new java.sql.Date(
						data_retirada_ini.getTime());
				Date data_retirada_fin_sql = new java.sql.Date(
						data_retirada_fin.getTime());
				/*
				 * File relative = new
				 * File("Locadora/WebContent/relatorios/rel_filmes_faturados.jasper"
				 * ); System.out.println(relative.getPath());
				 * System.out.println(relative.getName());
				 */

				/*
				 * File myFile = new
				 * File("relatorios/rel_filmes_faturados.jasper");
				 * System.out.println(myFile.getAbsolutePath());
				 */

				/*
				 * File file = new File(
				 * "workspace/Locadora/WebContent/relatorios/rel_filmes_faturados.jasper"
				 * ); file = file.getAbsoluteFile(); System.out.println(file);
				 */

				/*
				 * File file = new File("dir" + File.separatorChar +
				 * "rel_filmes_faturados.jasper"); file =
				 * file.getAbsoluteFile(); System.out.println(file);
				 */

				Conexao conn = new Conexao();
				Connection conexao = conn.getConn();
				String sql = "";
				if (id_cliente != 0 && id_filme != 0) {
					sql = "SELECT CAST(FATURA.DATA_RETIRADA AS DATE) AS DATA_RETIRADA, "
							+ "ITEM_FATURA.ID_FILME_ALUGADO AS ID_FILME_ALUGADO, "
							+ "FATURA.ID_FATURA AS ID_FATURA, ITEM_FATURA.SITUACAO AS SITUACAO, FILME.NOME AS FILME_NOME, "
							+ "CLIENTE.NOME AS CLIENTE_NOME,  ITEM_FATURA.DATA_DEVOLUCAO AS DATA_DEVOLUCAO, "
							+ "ITEM_FATURA.PRECO_FILME AS PRECO_FILME FROM ITEM_FATURA, FATURA, FILME, CLIENTE "
							+ "WHERE ITEM_FATURA.ID_FATURA = FATURA.ID_FATURA AND FATURA.ID_CLIENTE = CLIENTE.ID_CLIENTE AND ITEM_FATURA.ID_FILME = FILME.ID_FILME AND FATURA.ID_CLIENTE = "
							+ id_cliente
							+ " AND ITEM_FATURA.ID_FILME = "
							+ id_filme
							+ " AND CAST(FATURA.DATA_RETIRADA AS DATE) BETWEEN '"
							+ data_retirada_ini_sql
							+ "' AND '"
							+ data_retirada_fin_sql
							+ "' GROUP BY CAST(FATURA.DATA_RETIRADA AS DATE), ITEM_FATURA.ID_FILME_ALUGADO";
				}
				if (id_cliente == 0 && id_filme != 0) {
					sql = "SELECT CAST(FATURA.DATA_RETIRADA AS DATE) AS DATA_RETIRADA, "
							+ "ITEM_FATURA.ID_FILME_ALUGADO AS ID_FILME_ALUGADO, "
							+ "FATURA.ID_FATURA AS ID_FATURA, ITEM_FATURA.SITUACAO AS SITUACAO, FILME.NOME AS FILME_NOME, "
							+ "CLIENTE.NOME AS CLIENTE_NOME,  ITEM_FATURA.DATA_DEVOLUCAO AS DATA_DEVOLUCAO, "
							+ "ITEM_FATURA.PRECO_FILME AS PRECO_FILME FROM ITEM_FATURA, FATURA, FILME, CLIENTE "
							+ "WHERE ITEM_FATURA.ID_FATURA = FATURA.ID_FATURA AND FATURA.ID_CLIENTE = CLIENTE.ID_CLIENTE AND ITEM_FATURA.ID_FILME = FILME.ID_FILME AND ITEM_FATURA.ID_FILME = "
							+ id_filme
							+ " AND CAST(FATURA.DATA_RETIRADA AS DATE) BETWEEN '"
							+ data_retirada_ini_sql
							+ "' AND '"
							+ data_retirada_fin_sql
							+ "' GROUP BY CAST(FATURA.DATA_RETIRADA AS DATE), ITEM_FATURA.ID_FILME_ALUGADO";
				}
				if (id_cliente != 0 && id_filme == 0) {
					sql = "SELECT CAST(FATURA.DATA_RETIRADA AS DATE) AS DATA_RETIRADA, "
							+ "ITEM_FATURA.ID_FILME_ALUGADO AS ID_FILME_ALUGADO, "
							+ "FATURA.ID_FATURA AS ID_FATURA, ITEM_FATURA.SITUACAO AS SITUACAO, FILME.NOME AS FILME_NOME, "
							+ "CLIENTE.NOME AS CLIENTE_NOME,  ITEM_FATURA.DATA_DEVOLUCAO AS DATA_DEVOLUCAO, "
							+ "ITEM_FATURA.PRECO_FILME AS PRECO_FILME FROM ITEM_FATURA, FATURA, FILME, CLIENTE "
							+ "WHERE ITEM_FATURA.ID_FATURA = FATURA.ID_FATURA AND FATURA.ID_CLIENTE = CLIENTE.ID_CLIENTE AND ITEM_FATURA.ID_FILME = FILME.ID_FILME AND FATURA.ID_CLIENTE = "
							+ id_cliente
							+ " AND CAST(FATURA.DATA_RETIRADA AS DATE) BETWEEN '"
							+ data_retirada_ini_sql
							+ "' AND '"
							+ data_retirada_fin_sql
							+ "' GROUP BY CAST(FATURA.DATA_RETIRADA AS DATE), ITEM_FATURA.ID_FILME_ALUGADO";

				}
				if (id_cliente == 0 && id_filme == 0) {
					sql = "SELECT CAST(FATURA.DATA_RETIRADA AS DATE) AS DATA_RETIRADA, "
							+ "ITEM_FATURA.ID_FILME_ALUGADO AS ID_FILME_ALUGADO, "
							+ "FATURA.ID_FATURA AS ID_FATURA, ITEM_FATURA.SITUACAO AS SITUACAO, FILME.NOME AS FILME_NOME, "
							+ "CLIENTE.NOME AS CLIENTE_NOME,  ITEM_FATURA.DATA_DEVOLUCAO AS DATA_DEVOLUCAO, "
							+ "ITEM_FATURA.PRECO_FILME AS PRECO_FILME FROM ITEM_FATURA, FATURA, FILME, CLIENTE "
							+ "WHERE ITEM_FATURA.ID_FATURA = FATURA.ID_FATURA AND FATURA.ID_CLIENTE = CLIENTE.ID_CLIENTE AND ITEM_FATURA.ID_FILME = FILME.ID_FILME AND "
							+ " CAST(FATURA.DATA_RETIRADA AS DATE) BETWEEN '"
							+ data_retirada_ini_sql
							+ "' AND '"
							+ data_retirada_fin_sql
							+ "' GROUP BY CAST(FATURA.DATA_RETIRADA AS DATE), ITEM_FATURA.ID_FILME_ALUGADO";

				}
				
				PreparedStatement stm = conexao.prepareStatement(sql);
				ResultSet rs = stm.executeQuery();

				JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);

				File reportFile = new File(
						"D:/Apostilas java ee/workspace/Locadora/WebContent/relatorios/");
				Conexao con = new Conexao();
				JasperPrint impressao = JasperFillManager.fillReport(
						reportFile.toString() + "/rel_filmes_faturados.jasper",
						null, jrRs);
				JasperExportManager.exportReportToPdfFile(impressao,
						reportFile.toString() + "/rel_filmes_faturados.pdf");
				Desktop.getDesktop().open(
						new File(reportFile.toString()
								+ "/rel_filmes_faturados.pdf"));
				
				con.fecharConexao();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
