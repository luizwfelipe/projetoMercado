package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.MercadinhoDTO;

public class ProdutoDAO {
    public List<MercadinhoDTO> readProdutos() {
        List<MercadinhoDTO> listaProduto = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT idProduto, nomeProduto, descricao, preco, estoque FROM produto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                MercadinhoDTO produto = new MercadinhoDTO();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nomeProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setEstoque(rs.getInt("estoque"));
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
