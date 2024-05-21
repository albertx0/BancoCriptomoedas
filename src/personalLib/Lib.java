/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personalLib;

import model.Investidor;

/**
 *
 * @author albert
 */
public class Lib {
    
    public static String buscarCpf(Investidor investidor){
        return investidor.getCpf();
    }
    
    public static double converterString(String valor){
        return Double.parseDouble(valor);
    }
    
    public static Boolean conferirSaldo(double saldoAtual 
            , double valorTransacao){
        return saldoAtual - valorTransacao >= 0;
    }
    
    public static double buscarSaldo(Investidor investidor){
        return investidor.getCarteira().getReal().getValor();
    }
    
    public static void depositarReal(Investidor investidor , double valor){
        double saldo = buscarSaldo(investidor);
        investidor.getCarteira().getReal().setValor(saldo + valor);
    }
    
    public static void sacarReal(Investidor investidor , double valor){
        double saldo = buscarSaldo(investidor);
        investidor.getCarteira().getReal().setValor(saldo - valor);
    }
    
    public static double depositarBitcoin(Investidor investidor , double valorReal){
        Lib.sacarReal(investidor, valorReal);
        
        double valorComprado = investidor.getCarteira().getBitcoin()
                .comprarMoeda(valorReal);
        double saldoBitcoin = investidor.getCarteira().getBitcoin().getValor();
        investidor.getCarteira().getBitcoin().setValor(saldoBitcoin 
                + valorComprado);
        
        return valorComprado;
    }
    
    public static double depositarEthereum(Investidor investidor , double valorReal){
        double valorComprado = investidor.getCarteira().getEthereum()
                .comprarMoeda(valorReal);
        double saldo = investidor.getCarteira().getEthereum().getValor();
        investidor.getCarteira().getEthereum().setValor(saldo + valorComprado);
        
        return valorComprado;
    }
    
    public static double depositarRipple(Investidor investidor , double valorReal){
        double valorComprado = investidor.getCarteira().getRipple()
                .comprarMoeda(valorReal);
        double saldo = investidor.getCarteira().getRipple().getValor();
        investidor.getCarteira().getRipple().setValor(saldo + valorComprado);
        
        return valorComprado;
    }
}
