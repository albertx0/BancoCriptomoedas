/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.CompraDAO;
import javax.swing.JOptionPane;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import model.Investidor;
import view.Janela1ComprarCriptomoedas;
import view.Janela2ComprarCriptomoedas;
import personalLib.Lib;
/**
 *
 * @author albert
 */
public class ControllerComprarCriptomoedas {
    private Janela1ComprarCriptomoedas janela1;
    private Janela2ComprarCriptomoedas janela2;
    private Investidor investidor;

    public Janela1ComprarCriptomoedas getJanela1() {
        return janela1;
    }

    public void setJanela1(Janela1ComprarCriptomoedas janela1) {
        this.janela1 = janela1;
    }

    public Janela2ComprarCriptomoedas getJanela2() {
        return janela2;
    }

    public void setJanela2(Janela2ComprarCriptomoedas janela2) {
        this.janela2 = janela2;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public ControllerComprarCriptomoedas(Janela1ComprarCriptomoedas janela1 
            , Investidor investidor) {
        this.janela1 = janela1;
        this.investidor = investidor;
    }
    
    public ControllerComprarCriptomoedas(Janela2ComprarCriptomoedas janela2 
            , Investidor investidor){
        this.janela2 = janela2;
        this.investidor = investidor;
    }
    
    public void conferirSenha(){
        if(investidor.getSenha().equals(janela1.getTxtSenha().getText())){
            janela2 = new Janela2ComprarCriptomoedas(investidor);
            janela2.setVisible(true);
            janela1.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null 
                    , "Senha incorreta...");
        }
    }
    
    public void efetuarCompra(){
        double valorCompra = Lib.converterString
            (janela2.getTxtValor().getText());
        
        double saldoAtual = Lib.buscarSaldo(investidor);
        
        String criptomoeda = (String)janela2.getBoxCripto().getSelectedItem();
        criptomoeda = criptomoeda.toLowerCase();
        if(Lib.conferirSaldo(saldoAtual, valorCompra)){
            Conexao conn = new Conexao();
            
            try{
                Connection connection = conn.getConnection();
                CompraDAO compra = new CompraDAO(connection);
                
                double valorOperacao = 0;
                
                switch(criptomoeda){
                    case "bitcoin":
                        valorOperacao =
                        Lib.depositarBitcoin(investidor, valorCompra);
                        break;
                    case "ethereum":
                        valorOperacao =
                        Lib.depositarEthereum(investidor , valorCompra);
                        break;
                    case "ripple":
                        valorOperacao =
                        Lib.depositarRipple(investidor, valorCompra);
                        break;
                }
                System.out.println(valorOperacao);
                
                compra.comprarMoeda(investidor, criptomoeda, valorOperacao 
                        , valorCompra);
                JOptionPane.showMessageDialog(null 
                        , "Compra efetuada com sucesso !");
            } catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null
                        , "Erro de conexao...");
            }
        }else{
            JOptionPane.showMessageDialog(null
                    , "Saldo insuficiente para efetuar a compra...");
        }
    }
}
