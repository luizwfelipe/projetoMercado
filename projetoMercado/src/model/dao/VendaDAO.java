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
    public List<MercadinhoDTO> read(){
        List<MercadinhoDTO> listaVenda = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT v.idVenda, v.idProduto, p.nome, v.quantidade, p.preco \n" +
                                            "FROM venda v \n" +
                                            "JOIN produto p ON v.idProduto = p.idProduto");
            
            rs = stmt.executeQuery();
                     
            while (rs.next()) {
                MercadinhoDTO venda = new MercadinhoDTO();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setIdProduto(rs.getInt("idProduto"));
                venda.setNome(rs.getString("nome"));
                venda.setQuantidadeProduto(rs.getInt("quantidade"));
                venda.setPreco(rs.getFloat("preco"));                
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
        
        stmt = conexao.prepareStatement("INSERT INTO venda (dataVenda, precoTotal, quantidade, idUsuario, idProduto) VALUES (CURDATE(), ?, ? ,? ,?)");
        stmt.setDate(1,venda.getDataVenda());
        stmt.setFloat(2, venda.getPrecoTotal());
        stmt.setInt(3, venda.getQuantidadeProduto());
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}