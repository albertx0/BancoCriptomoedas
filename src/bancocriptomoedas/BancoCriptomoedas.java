package bancocriptomoedas;

import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import view.JanelaLogin;

public class BancoCriptomoedas {

    public static void main(String[] args) {
        Conexao conexaoDAO = new Conexao();
        
        try{
            Connection conexao = conexaoDAO.getConnection();
            conexao.close();
            JanelaLogin janela = new JanelaLogin();
            janela.setVisible(true);
        } catch (SQLException e){
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }   
}
