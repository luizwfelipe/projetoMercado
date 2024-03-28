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

public class VendaDAO {
     public List<MercadinhoDTO> readVendas(){
        List<MercadinhoDTO> listaVenda = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT idVenda, idProduto, nome, quantidade, preco FROM venda");
            
            rs = stmt.executeQuery();
                     
            while (rs.next()) {
                MercadinhoDTO venda = new MercadinhoDTO();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setIdProdutoVenda(rs.getInt("idProduto"));
                venda.setNomeVenda(rs.getString("nome"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setPrecoVenda(rs.getFloat("preco"));                
                listaVenda.add(venda);
            }
            
            rs.close();
            stmt.close();
            conexao.close();    
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVenda;   
    }
    
    
    public void create(MercadinhoDTO venda) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        
        stmt = conexao.prepareStatement("INSERT INTO venda (idProduto, nome, quantidade, preco) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, venda.getIdProdutoVenda());
        stmt.setString(2, venda.getNomeVenda());
        stmt.setInt(3, venda.getQuantidade());
        stmt.setFloat(4, venda.getPrecoVenda());
        
        stmt.executeUpdate(); 

        stmt.close();
        conexao.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void delete(int idVenda) {
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        
        stmt = conexao.prepareStatement("DELETE FROM venda WHERE idVenda = ?");
        stmt.setInt(1, idVenda);
        
        stmt.executeUpdate(); 

        stmt.close();
        conexao.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
}