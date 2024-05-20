/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import model.Usuario;
import view.JanelaConsultarSaldo;
import view.JanelaVisualizarSaldo;

/**
 *
 * @author albert
 */
public class ControllerConsultarSaldo {
    private Investidor investidor;
    private JanelaVisualizarSaldo exibicao;
    private JanelaConsultarSaldo janela;
    
    public Investidor getInvestidor() {
        return investidor;
    }

    public JanelaVisualizarSaldo getExibicao() {
        return exibicao;
    }

    public void setExibicao(JanelaVisualizarSaldo exibicao) {
        this.exibicao = exibicao;
    }

    public JanelaConsultarSaldo getJanela() {
        return janela;
    }

    public void setJanela(JanelaConsultarSaldo janela) {
        this.janela = janela;
    }

    public ControllerConsultarSaldo(Investidor investidor , JanelaConsultarSaldo janela) {
        this.investidor = investidor;
        this.janela = janela;
        exibicao = new JanelaVisualizarSaldo();
    }
    
    public void consultarSaldo(){
        exibicao.setVisible(true);
        String senhaTxt = janela.getTxtSenha().getText();
        
        if(senhaTxt.equals(investidor.getSenha())){
            
            String textoSaldo = "Nome: " + investidor.getNome() + " " 
                    + investidor.getSobrenome() + "\n" +
                    "CPF: " + investidor.getCpf() + "\n\n" +
                    "Reais: " + investidor
                            .getCarteira().getMoedas()
                            .get(3).getValor()+ "\n" +
                    "Bitcoin: " + investidor
                            .getCarteira().getMoedas()
                            .get(0).getValor() + "\n" +
                    "Ethereum: " + investidor
                            .getCarteira().getMoedas()
                            .get(1).getValor() + "\n" +
                    "Ripple: " + investidor
                            .getCarteira().getMoedas()
                            .get(2).getValor() + "\n";
            exibicao.getTxtSaldo().setText(textoSaldo);
        }else{
            JOptionPane.showMessageDialog(null 
                    , "Senha incorreta...");
        }
    }
}
