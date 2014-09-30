package sismesa.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;


import org.primefaces.component.dashboard.Dashboard;
import org.primefaces.component.panel.Panel;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;



import sismesa.mesa.Mesa;
import sismesa.mesa.MesaRN;

public class MesaBean implements Serializable{
	private Mesa selecionada = new Mesa();
	private List<Mesa> lista = null;
	private List<Mesa> listaAcerto = null;
	private DashboardModel dashboardBean;
	

	public Mesa getSelecionada() {
		return selecionada;
	}
	
	public void setSelecionada(Mesa selecionada) {
		System.out.println("setSelecionada()"+selecionada.getIdmesa());
		this.selecionada = selecionada;
	}

	public void salvar() {
		MesaRN mesaRN = new MesaRN();
		mesaRN.salvar(this.selecionada);
		this.lista = null;
	}
	
	public void novo() {
		this.selecionada = new Mesa();
		this.lista = null;
	}

	public String excluir() { // 1
		System.out.println("excluir()"+this.selecionada.getIdmesa());
		MesaRN mesaRN = new MesaRN();
		mesaRN.excluir(this.selecionada);
		this.selecionada = new Mesa();
		this.lista = null;
		return "";
	}

	public String editar() {
		MesaRN mesaRN = new MesaRN();
		return mesaRN.editar(this.selecionada);
	}

	public List<Mesa> getLista() { // 2
		if (this.lista == null) {
			MesaRN mesaRN = new MesaRN();
			this.lista = mesaRN.listar();
		}
		return this.lista;
	}
	
	
	public List<Mesa> getListaAcerto() {
		MesaRN mesaRN = new MesaRN();
		this.listaAcerto = mesaRN.listar();
		return this.listaAcerto;
	}

	public void mesaValueChangeListener(){   
		this.selecionada.setVlr_total(this.selecionada.getQtde()*this.selecionada.getVlr_unit());
		System.out.println("valdemir dos santos macedo");
    }  
	
	
	public Dashboard getDashboardBean() {
		FacesContext fc = FacesContext.getCurrentInstance();
        Application application = fc.getApplication();
        
        Dashboard dashboard = (Dashboard) application.createComponent(fc, "org.primefaces.component.Dashboard", "org.primefaces.component.DashboardRenderer");
        dashboard.setId("dashboard");
        
        DashboardModel model = new DefaultDashboardModel();
        for( int i = 0; i < 4; i++ ) {
            DashboardColumn column = new DefaultDashboardColumn();
            model.addColumn(column);
        }
        
        dashboard.setModel(model);
        
        int itens = getListaAcerto().size();
        for( int i = 0; i < itens; i++ ) {
            Panel panel = (Panel) application.createComponent(fc, "org.primefaces.component.Panel", "org.primefaces.component.PanelRenderer");
            panel.setId("measure_" + i);
            panel.setHeader(getListaAcerto().get(i).getDescricao());
            panel.setClosable(true);
            panel.setToggleable(true);
            
            HtmlCommandLink button = new HtmlCommandLink();
            button.setValue("Delete" + i);
            button.setOnblur("dlgAcerto.show()");
            panel.getChildren().add(button);
            
         
            
            dashboard.getChildren().add(panel);
            DashboardColumn column = model.getColumn(i%4);
            column.addWidget(panel.getId());

        }
        return dashboard;
	}

	public void handleReorder(DashboardReorderEvent event) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("Reordered: " + event.getWidgetId());
		message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
