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
       
       Real real = null;
       Bitcoin bitcoin = null;
       Ethereum ethereum = null;
       Ripple ripple = null;
       
       if(resultadoUsuario.next()){
       while(resultado.next()){
           String nomeCripto = resultado.getString("nome");
           double preco = resultado.getDouble("preco");
           double saldo = resultadoUsuario.getDouble("saldo" + nomeCripto);
           
           switch(nomeCripto){
               
               case "real":
                   real = new Real(preco , saldo);
                   break;
               case "bitcoin":
                   bitcoin = new Bitcoin(preco , saldo);
                   break;
               case "ethereum":
                   ethereum = new Ethereum(preco, saldo);
                   break;
               case "ripple":
                   ripple = new Ripple(preco , saldo);
                   break;
               
           }
       }
    }
       investidor.setCarteira(new Carteira(real , bitcoin , ethereum , ripple));
       conn.close();
   }
}
