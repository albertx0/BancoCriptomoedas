/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Usuario;

/**
 *
 * @author albert
 */
public class SaqueDAO {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public SaqueDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void sacar(Investidor investidor , double valorSaque) throws SQLException{
        if(investidor.getCarteira().getReal().getValor() - valorSaque >= 0){
            String cpf = investidor.getCpf();
            String sql = "UPDATE usuario set saldoreal = saldoreal - ? "
                    + "WHERE cpf = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setDouble(1 , valorSaque);
            statement.setString(2 , cpf);
            
            statement.execute();
            
            double saldoReal = investidor.getCarteira().getReal().getValor();
            investidor.getCarteira().getReal().setValor(saldoReal - valorSaque);
            JOptionPane.showMessageDialog(null 
                    , "Saque realizado");
        }else{
            JOptionPane.showMessageDialog(null 
                    , "Saldo Insuficiente...");
        }
    }
}
