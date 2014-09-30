package sismesa.mesa;

import java.util.List;


public interface MesaDAO {
	public void salvar(Mesa mesa);
	public void excluir(Mesa mesa);
	public List<Mesa> listar();
	public List<Mesa> listarAbertas();
}
