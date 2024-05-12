/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Usuario;

/**
 *
 * @author albert
 */
public class UsuarioDAO {
    private Connection conn;
    
    public UsuarioDAO(Connection conn){
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE cpf = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultado = statement.getResultSet();
           
        conn.close();
        return resultado;
    }
}