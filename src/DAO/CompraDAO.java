/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import model.Investidor;
import personalLib.Lib;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author albert
 */
public class CompraDAO {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public CompraDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void comprarMoeda(Investidor investidor , String criptomoeda 
            , double valorCripto , double valorReal) throws SQLException{
        String cpf = Lib.buscarCpf(investidor);
        String row = "saldo" + criptomoeda;
        
        String sql = "UPDATE usuario set " + row + " = " + row + " + ?, "
                + "saldoreal = saldoreal - ? WHERE cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setDouble(1 , valorCripto);
        statement.setDouble(2 , valorReal);
        statement.setString(3 , cpf);
       
        statement.execute();
        
        conn.close();
    }
}
