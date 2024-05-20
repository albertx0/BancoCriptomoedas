/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Investidor;
import view.JanelaConsultarSaldo;
import view.JanelaDeposito;
import view.JanelaMenu;
import view.JanelaSaque;

/**
 *
 * @author albert
 */
public class ControllerMenu {
    private Investidor investidor;

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public ControllerMenu(JanelaMenu menu, Investidor investidor) {
        this.investidor = investidor;
        
        menu.getLblRecepcao().setText("Bem vindo, " + investidor.getNome() 
                + " " + investidor.getSobrenome() + " !");
        menu.setVisible(true);
    }
    
    public void consultarSaldo(){
        JanelaConsultarSaldo consultarSaldo = new JanelaConsultarSaldo(investidor);
        consultarSaldo.setVisible(true);
    }
    public void depositarReal(){
        JanelaDeposito depositarReal = new JanelaDeposito(investidor);
        depositarReal.setVisible(true);
    }
    public void sacarReal(){
        JanelaSaque sacarReal = new JanelaSaque(investidor);
        sacarReal.setVisible(true);
    }
}
