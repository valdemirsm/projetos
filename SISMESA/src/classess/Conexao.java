package classess;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author valdemir
 */
import java.sql.*;
import javax.swing.*;

public class Conexao {

    final private String driver = "org.postgresql.Driver";
    final private String url = "jdbc:postgresql://localhost/sismesa";
    final private String usuario = "postgres";
    final private String senha = "123";
    private Connection conexao;
   // public PreparedStatement stm;
    public ResultSet resultset;

    public Conexao(){

    }
    public Connection conecta() {
        Connection result;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            result = conexao;
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado"+Driver);
            result = null;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexao com a fonte de dados");
            result = null;
        }
        return result;
    }

    public void desconecta() {
        boolean result = true;
        try {
            conexao.close();
        //    JOptionPane.showMessageDialog(null, "Banco fechado");
        } catch (SQLException Fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco de dado");
            result = false;
        }

    }

    public ResultSet executeSQL(String sql) {
        try {
            System.out.println(sql);

            PreparedStatement stm = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            //PreparedStatement stm = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //PreparedStatement stm = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultset = stm.executeQuery();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql," + sqlex + ","
                    + "o sql passado foi " + sql);
        }
        return resultset;
    }
    public void executeUpdate(String sql) {
        try {
            System.out.println(sql);
            PreparedStatement stm = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.executeUpdate();
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando sql," + sqlex + ","
                    + "o sql passado foi " + sql);
        }
    }

}
