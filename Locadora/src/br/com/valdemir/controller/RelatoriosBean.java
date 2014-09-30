package br.com.valdemir.controller;
import java.awt.Desktop;
import java.io.File;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
import javax.servlet.ServletContext;   
import br.com.valdemir.dao.Conexao;
import net.sf.jasperreports.engine.*;   

  
  
public class RelatoriosBean {   
    public static void execute(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {           
        try {   
            File reportFile = new File(sc.getRealPath("/relatorios/"));
            Conexao con = new Conexao();
            JasperPrint impressao = JasperFillManager.fillReport(reportFile.toString()+"/rel_filmes_faturados.jasper"	,null, con.getConn());
            JasperExportManager.exportReportToPdfFile(impressao, reportFile.toString()+"/rel_filmes_faturados.pdf");
            Desktop.getDesktop().open(new File(reportFile.toString()+"/rel_filmes_faturados.pdf"));
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}  