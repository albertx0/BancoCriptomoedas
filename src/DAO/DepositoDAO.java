/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Investidor;
import model.Usuario;

/**
 *
 * @author albert
 */
public class DepositoDAO {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public DepositoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void depositar(Investidor investidor , double valorDeposito) throws SQLException{
        String cpf = investidor.getCpf();
        String sql = "update usuario set saldoReal = saldoReal + ? where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setDouble(1 , valorDeposito);
        statement.setString(2 , cpf);
        
        statement.execute();
        conn.close();
    }
}
