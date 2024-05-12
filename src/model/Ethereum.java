/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author albert
 */
public class Ethereum extends Moedas implements Tarifacao{
    
    public Ethereum(double preco , double valor){
        super("eth" , preco , valor);
    }
    
    @Override
    public double comprarMoeda(double valorReal){
        return (valorReal / preco) * 0.99;
    }
    
    @Override
    public double venderMoeda(double valorCripto){
        double valorReal = (valorCripto * preco) * 0.98;
        this.valor -= valorCripto;
        
        return valorReal;
    }
}