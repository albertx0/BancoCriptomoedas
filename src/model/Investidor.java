/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author albert
 */
public class Investidor extends Usuario{
    private Carteira carteira;

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Investidor(String nome , String sobrenome , String cpf , String senha , Carteira carteira) {
        super(nome , sobrenome , cpf , senha);
        this.carteira = carteira;
    }
}
