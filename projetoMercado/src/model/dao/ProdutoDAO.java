package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.MercadinhoDTO;

public class ProdutoDAO {
    public List<MercadinhoDTO> readProdutos() {
        List<MercadinhoDTO> listaProduto = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT idProduto, nomeProduto, descricao, preco, estoque, categoria FROM produto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                MercadinhoDTO produto = new MercadinhoDTO();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nomeProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setCategoria(rs.getString("categoria"));
                listaProduto.add(produto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaProduto;
    }
    
    public void create(MercadinhoDTO p) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO produto (nomeProduto, descricao, preco, estoque, categoria) VALUES (?, ?, ? ,? ,?)");
            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());
            stmt.setInt(4, p.getEstoque());
            stmt.setString(5, p.getCategoria());
            
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            
            JOptionPane.showMessageDialog(null, "Produto criado com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int idProduto) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
        stmt.setInt(1, idProduto);
        stmt.executeUpdate();
        stmt.close();
        conexao.close();
        JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void update(MercadinhoDTO p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE produto SET nomeProduto = ?, descricao = ?, preco = ?, estoque = ?, categoria = ? WHERE idProduto = ? ");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());
            stmt.setInt(4, p.getEstoque());
            stmt.setString(5, p.getCategoria());
            stmt.setInt(6, p.getIdProduto());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");

            stmt.close();
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int consultarEstoque(int idProduto) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int estoque = 0;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT estoque FROM produto WHERE idProduto = ?");
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();
            if (rs.next()) {
                estoque = rs.getInt("estoque");
            }
        } catch (SQLException ex) {
            System.err.println("Erro na consulta de estoque " + ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return estoque;
    }

 
   public void diminuirEstoque(int idProduto, int quantidadeVendida) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("UPDATE produto SET estoque = estoque - ? WHERE idProduto = ?");
            stmt.setInt(1, quantidadeVendida);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
            System.out.println("Estoque atualizado");
        } catch (SQLException ex) {
            System.err.println("Estoque com erro " + ex);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
