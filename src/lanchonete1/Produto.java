/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete1;

/**
 *
 * @author patri
 */
public class Produto {
    
    public String descricao;
    public int id_produto;
    public double preco;
    
    //Construtores
    Produto(String descricao, int id, double preco){
        this.descricao = descricao;
        this.id_produto = id;
        this.preco = preco;
    }
    Produto(){
        
    }
    
    //Métodos Get e Set
    public void SetDescricao(String descricao){
        this.descricao = descricao;
    }
    public String GetDescricao(){
        return descricao;
    }
    
    public void SetIdProduto(int id){
        this.id_produto = id;
    }
    public int GetIdProduto(){
        return id_produto;
    }
    
    public void SetPreco(double preco){
        this.preco = preco;
    }
    public double GetPreco(){
        return preco;
    }
    //Override do toString

    @Override
    public String toString() {
        return "Produto{" + "descricao=" + descricao 
                + ", id_produto=" + id_produto 
                + ", preco=" + preco + '}';
    }
    
}
