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
public class Cliente implements Comparable<Cliente>{
    
    //Atributos do cliente
    
    private String nome;
    private String telefone;
    private String endereco;
    private int id;
    private static int num_clientes;
    
    //Construtores da classe
    
    Cliente(String nome, String telefone, String endereco, int id){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.id = id;
        num_clientes = num_clientes + 1;
    }
    
    Cliente(){
        num_clientes = num_clientes +1;
        
    }
    //Método comparable um dos atributos
    
    @Override
    public int compareTo(Cliente other){
        if(this.id<other.id){
            return this.id;
        }
        else{return other.id;}
    }
    @Override
    public boolean equals(Object obj) {
    if (obj instanceof Cliente) {
      Cliente qualquer = (Cliente) obj;
      if(qualquer.id == this.id)
          return true;
    } 
      return false;
    
  }
     
    
    
    //Método Get para numero de clientes
    
    public static int GetNumeroClientes(){
        return num_clientes;
    }
    
    //Métodos Get e Set para todos os atributos de Cliente
    
    public void SetNome(String nome){
        this.nome = nome;
    }
    public String GetNome(){
        return nome;
    }
    
    public void SetTelefone(String telefone){
        this.telefone = telefone;
    }
    public String GetTelefone(){
        return telefone;
    }
    
    public void SetEndereco(String endereco){
        this.endereco = endereco;
    }
    public String GetEndereco(){
        return endereco;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return id;
    }
    
    //Método toString sobrescrito
    
    @Override
    public String toString(){
        
        String txt;
        txt = String.format("\nNome: %s "
                + "\nTelefone: %s"
                + "\nEndereco: %s"
                + "\nId do Cliente: %s", GetNome(),GetTelefone(),GetEndereco(),GetId());
        return txt;
    }
}
