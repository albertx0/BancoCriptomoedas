/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author albert
 */
public class Bitcoin extends Moedas implements Tarifacao{
    
    public Bitcoin(double preco , double valor , double taxaVenda , double taxaCompra){
        super("btc" , preco , valor);
    }
    
    @Override
    public double comprarMoeda(double valorReal){
        return (valorReal / preco) * 0.98;
    }
    
    @Override
    public double venderMoeda(double valorCripto){
        double valorReal = (valorCripto * preco) * 0.97;
        this.valor -= valorCripto;
        
        return valorReal;
    }
}