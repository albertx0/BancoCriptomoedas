/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Investidor;
import view.JanelaSaque;
import DAO.Conexao;
import DAO.SaqueDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author albert
 */
public class ControllerSaque {
    private JanelaSaque janela;
    private Investidor investidor;

    public JanelaSaque getJanela() {
        return janela;
    }

    public void setJanela(JanelaSaque janela) {
        this.janela = janela;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public ControllerSaque(JanelaSaque janela, Investidor investidor) {
        this.janela = janela;
        this.investidor = investidor;
    }
    
    public void saque(){
        String valorString = janela.getTxtSaque().getText();
        double valorSaque = Double.parseDouble(valorString);
        
        Conexao conn = new Conexao();
        
        try{
            Connection connection = conn.getConnection();
            
            SaqueDAO saque = new SaqueDAO(connection);
            saque.sacar(investidor , valorSaque);
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null
                    , "Falha na conexao...");
        }
        
    }
}
