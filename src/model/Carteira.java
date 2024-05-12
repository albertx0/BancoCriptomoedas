/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author albert
 */
public class Carteira {
    private ArrayList<Moedas> moedas = new ArrayList<>();

    public ArrayList<Moedas> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }

    public Carteira() {
        this.moedas = new ArrayList<>();
    }
    
    public void adicionarMoeda(Moedas moeda){
        this.moedas.add(moeda);
    }
}
