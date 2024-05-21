/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
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
    
        public void consultarSaldo() {
        exibicao.setVisible(true);
        String senhaTxt = janela.getTxtSenha().getText();

        if (senhaTxt.equals(investidor.getSenha())) {
            DecimalFormat formatoCripto = new DecimalFormat("#0.00000");
            DecimalFormat formatoReal = new DecimalFormat("#0.00");
            String textoSaldo = "Nome: " + investidor.getNome() + " " 
                + investidor.getSobrenome() + "\n" +
                "CPF: " + investidor.getCpf() + "\n\n" +
                "Reais: " + formatoReal.format
        (investidor.getCarteira().getReal().getValor()) + "\n" +
                "Bitcoin: " + formatoCripto.format
        (investidor.getCarteira().getBitcoin().getValor()) + "\n" +
                "Ethereum: " + formatoCripto.format
        (investidor.getCarteira().getEthereum().getValor()) + "\n" +
                "Ripple: " + formatoCripto.format
        (investidor.getCarteira().getRipple().getValor()) + "\n";

            exibicao.getTxtSaldo().setText(textoSaldo);
        } else {
            JOptionPane.showMessageDialog(null
                    , "Senha incorreta...");
        }
}

}
