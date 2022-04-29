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
public class Adm extends Funcionario {
    
    //Construtores da classe administrador
    Adm(double salario, String user, String senha, String nome, String telefone, String endereco, int id){
        super(salario, user, senha, nome, telefone, endereco, id);
    }
    Adm(){
        
    }

    @Override
    public String toString() {
        return "Adm{" + '}';
    }
    
    
}
