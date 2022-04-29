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
public class Funcionario extends Cliente {
    
    private double salario;
    private String user;
    private String senha;
    
    //Construtores da classe funcionário
    Funcionario(double salario, String user, String senha, String nome, String telefone, String endereco, int id){
        super(nome, telefone, endereco, id);
        this.salario = salario;
        this.user = user;
        this.senha = senha;
    }
    Funcionario(){
        
    }
    //Métodos Get e Set para os atributos de funcionário
    
    public void SetSalario(double salario){
        this.salario = salario;
    }
    public double GetSalario(){
        return salario;
    }
    //Get e set para user

    /**
     *
     * @param user
     */
    public void SetUser(String user){
        this.user = user;
    }
    public String GetUser(){
        return user;
    }
    //Get e set para senha

    /**
     *
     * @param senha
     */
    public void SetSenha(String senha){
        this.senha = senha;
    }
    public String GetSenha(){
        return senha;
    }
    //Override do toString

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + '}';
    }
    
    
    
}
