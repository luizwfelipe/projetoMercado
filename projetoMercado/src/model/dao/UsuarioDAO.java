/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import java.sql.Connection;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.MercadinhoDTO;
/**
 *
 * @author Senai
 */
public class UsuarioDAO {
    public List<MercadinhoDTO> read() {
        List<MercadinhoDTO> usuarioList = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                MercadinhoDTO usuario = new MercadinhoDTO();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEndereco(rs.getString("endereco"));
                usuarioList.add(usuario);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioList;
    }
    public void create(MercadinhoDTO login) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, login, senha, telefone, endereco) VALUES (?, ?, ? ,? ,?)");
            stmt.setString(1, login.getNome());
            stmt.setString(2, login.getLogin());
            stmt.setString(3, login.getSenha());
            stmt.setString(4, login.getTelefone());
            stmt.setString(5, login.getTelefone());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public Boolean login(String login, String senha) {
        Boolean validar = false;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                validar = true;
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validar;
    }
    public void delete(int idUsuario) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
        stmt.setInt(1, idUsuario);
        stmt.executeUpdate();
        stmt.close();
        conexao.close();
        JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void update(MercadinhoDTO u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, login = ?, senha = ?, telefone = ?, endereco = ? WHERE idUsuario = ? ");

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTelefone());
            stmt.setString(5, u.getEndereco());
            stmt.setInt(6, u.getIdUsuario());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");

            stmt.close();
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
