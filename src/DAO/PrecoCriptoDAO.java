/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import model.Usuario;

/**
 *
 * @author albert
 */
public class PrecoCriptoDAO {
    private Connection conn;

    public PrecoCriptoDAO(Connection conn) {
        this.conn = conn;
    }
    
   public void consultarPreco(Investidor investidor) throws SQLException {
       String sql = "SELECT * FROM moedas";
       
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.execute();
       
       ResultSet resultado = statement.getResultSet();
       
       sql = "SELECT * FROM usuario where cpf = ?";
       statement = conn.prepareStatement(sql);
       
       statement.setString(1 , investidor.getCpf());
       statement.execute();
       
       ResultSet resultadoUsuario = statement.getResultSet();
       
       investidor.setCarteira(new Carteira());
       
       if(resultadoUsuario.next()){
       while(resultado.next()){
           String nomeCripto = resultado.getString("nome");
           double preco = resultado.getDouble("preco");
           double saldo = resultadoUsuario.getDouble("saldo" + nomeCripto);
           System.out.println(saldo);
           switch(nomeCripto){
               
               case "real":
                   System.out.println("0");
                   Real real = new Real(preco , saldo);
                   investidor.getCarteira().getMoedas().add(real);
                   break;
               case "bitcoin":
                   System.out.println("1");
                   Bitcoin bitcoin = new Bitcoin(preco , saldo);
                   investidor.getCarteira().getMoedas().add(bitcoin);
                   break;
               case "ethereum":
                   System.out.println("2");
                   Ethereum ethereum = new Ethereum(preco, saldo);
                   investidor.getCarteira().getMoedas().add(ethereum);
                   break;
               case "ripple":
                   System.out.println("3");
                   Ripple ripple = new Ripple(preco , saldo);
                   investidor.getCarteira().getMoedas().add(ripple);
                   break;
               
           }
       }
       }
       conn.close();
   }
}
