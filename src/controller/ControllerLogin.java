    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import DAO.PrecoCriptoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Ripple;
import model.Usuario;
import view.JanelaLogin;
import view.JanelaMenu;
import controller.ControllerConsultarSaldo;
import model.Investidor;
import model.Real;
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
            
            Investidor investidor = usuarioDAO.consultarUsuario(usuario);

            if(investidor != null){
                JOptionPane.showMessageDialog(null , "Login feito com sucesso !");
                
                PrecoCriptoDAO precos = new PrecoCriptoDAO(connection);
                precos.consultarPreco(investidor);
                
                JanelaMenu menu = new JanelaMenu(investidor);
                
                login.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null , 
                        "Erro ao entrar, CPF ou senha incorretos...");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
