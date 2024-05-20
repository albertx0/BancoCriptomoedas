/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import DAO.DepositoDAO;
import DAO.PrecoCriptoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Investidor;
import view.JanelaDeposito;

/**
 *
 * @author albert
 */
public class ControllerDeposito {
    private JanelaDeposito janela;
    private Investidor investidor;

    public JanelaDeposito getJanela() {
        return janela;
    }

    public void setJanela(JanelaDeposito janela) {
        this.janela = janela;
    }

    public ControllerDeposito(JanelaDeposito janela , Investidor investidor) {
        this.janela = janela;
        this.investidor = investidor;
    }
    
    public void deposito(){
        String valorString = janela.getTxtDeposito().getText();
        double valorDeposito = Double.parseDouble(valorString);
        Conexao conn = new Conexao();
            
        try{
            Connection connection = conn.getConnection();
            DepositoDAO depositoDAO = new DepositoDAO(connection);
            depositoDAO.depositar(investidor, valorDeposito);
            JOptionPane.showMessageDialog(null, 
                    "Deposito feito com sucesso !");
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null , 
                    "Falha na conexao...");
        }
    }
}
