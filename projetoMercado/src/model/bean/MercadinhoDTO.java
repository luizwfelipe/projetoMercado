package model.bean;

import java.sql.Date;
import java.sql.Time;

public class MercadinhoDTO {
    //Tabela usuario
    private int idUsuario;
    private String nome;
    private String login;
    private String senha;
    private String telefone;
    private String endereco;
    //----------------------------------
    //Tabela admin
    private int idAdmin;
    private String nomeAdm;
    private String loginAdm;
    private String senhaAdm;
    //----------------------------------
    //Tabela produto
    private int idProduto;
    private String nomeProduto;
    private String descricao;
    private float preco;
    private int estoque;
    private String categoria;
    //----------------------------------
    //Tabela venda
    private int idVenda;
    private int idProdutoVenda;
    private String nomeVenda;
    private int quantidade;
    private float precoVenda;    
    //----------------------------------
    //Tabela backupUsuario
    private int idBackup;
    private String nomeBackup;
    private String loginBackup;
    private String senhaBackup;
    private String telefoneBackup;
    private String enderecoBackup;
    private Time exclusaoUsuario;

    public MercadinhoDTO() {
    }

    public MercadinhoDTO(int idUsuario, String nome, String login, String senha, String telefone, String endereco, int idAdmin, String nomeAdm, String loginAdm, String senhaAdm, int idProduto, String nomeProduto, String descricao, float preco, int estoque, int idVenda, int idProdutoVenda, String nomeVenda, int quantidade, float precoVenda, int idBackup, String nomeBackup, String loginBackup, String senhaBackup, String telefoneBackup, String enderecoBackup, Time exclusaoUsuario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idAdmin = idAdmin;
        this.nomeAdm = nomeAdm;
        this.loginAdm = loginAdm;
        this.senhaAdm = senhaAdm;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.idVenda = idVenda;
        this.idProdutoVenda = idProdutoVenda;
        this.nomeVenda = nomeVenda;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.idBackup = idBackup;
        this.nomeBackup = nomeBackup;
        this.loginBackup = loginBackup;
        this.senhaBackup = senhaBackup;
        this.telefoneBackup = telefoneBackup;
        this.enderecoBackup = enderecoBackup;
        this.exclusaoUsuario = exclusaoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomeAdm() {
        return nomeAdm;
    }

    public void setNomeAdm(String nomeAdm) {
        this.nomeAdm = nomeAdm;
    }

    public String getLoginAdm() {
        return loginAdm;
    }

    public void setLoginAdm(String loginAdm) {
        this.loginAdm = loginAdm;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProdutoVenda() {
        return idProdutoVenda;
    }

    public void setIdProdutoVenda(int idProdutoVenda) {
        this.idProdutoVenda = idProdutoVenda;
    }

    public String getNomeVenda() {
        return nomeVenda;
    }

    public void setNomeVenda(String nomeVenda) {
        this.nomeVenda = nomeVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getIdBackup() {
        return idBackup;
    }

    public void setIdBackup(int idBackup) {
        this.idBackup = idBackup;
    }

    public String getNomeBackup() {
        return nomeBackup;
    }

    public void setNomeBackup(String nomeBackup) {
        this.nomeBackup = nomeBackup;
    }

    public String getLoginBackup() {
        return loginBackup;
    }

    public void setLoginBackup(String loginBackup) {
        this.loginBackup = loginBackup;
    }

    public String getSenhaBackup() {
        return senhaBackup;
    }

    public void setSenhaBackup(String senhaBackup) {
        this.senhaBackup = senhaBackup;
    }

    public String getTelefoneBackup() {
        return telefoneBackup;
    }

    public void setTelefoneBackup(String telefoneBackup) {
        this.telefoneBackup = telefoneBackup;
    }

    public String getEnderecoBackup() {
        return enderecoBackup;
    }

    public void setEnderecoBackup(String enderecoBackup) {
        this.enderecoBackup = enderecoBackup;
    }

    public Time getExclusaoUsuario() {
        return exclusaoUsuario;
    }

    public void setExclusaoUsuario(Time exclusaoUsuario) {
        this.exclusaoUsuario = exclusaoUsuario;
    }  
}
