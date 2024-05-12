/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Usuario;
import view.JanelaLogin;
import view.JanelaMenu;

/**
 *
 * @author albert
 */
public class ControllerLogin {
    private JanelaLogin login;
    
    public ControllerLogin(JanelaLogin login){
        this.login = login;
    }
    
    public void login(){
        String cpf = login.getTxtCPF().getText();
        String senha = login.getTxtSenha().getText();
        
        Conexao conn = new Conexao();
        Usuario usuario = new Usuario(null , null , cpf , senha);
        
        try {
            Connection connection = conn.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            ResultSet resultado = usuarioDAO.consultar(usuario);
            
            if(resultado.next()){
                JOptionPane.showMessageDialog(null , "Login feito com sucesso !");
                String nome = resultado.getString("nome");
                String sobrenome = resultado.getString("sobrenome");
//                double saldoReal = resultado.getDouble("saldoreal");
//                double saldoBTC = resultado.getDouble("saldobtc");
//                double saldoETH = resultado.getDouble("saldoeth");
//                double saldoXRP = resultado.getDouble("saldoxrp");
                
                //Moedas moedas = new Moedas();
                
                JanelaMenu menu = new JanelaMenu(usuario);
                menu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null , "Erro ao entrar, CPF ou senha incorretos...");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}