/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;




/**
 *
 * @author patri
 */
public class Lanchonete1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); 
        Random random = new Random();
        
        Sistema MinhaLanchonete = new Sistema();
       ;
        
        //Criar os administradores
        Adm adm1 = new Adm(900, "adm1", "1234567","Patrick", "988390948", "Rua Adalmo 681", 1);
        Adm adm2 = new Adm(900, "adm2", "7654321","Livia", "998569900", "Rua Doce 186", 2);
        
        //Adicionando os 2 adms a lista de adms
        MinhaLanchonete.AddAdm(adm1);
        MinhaLanchonete.AddAdm(adm2);
        
        
        
        
        
        //Cria 10 funcionários de mandeira estática no sistema
        Funcionario colab0 = new Funcionario(800,"colab0","01234","Mariano","98456722","Rua10",3);
        Funcionario colab1 = new Funcionario(700,"colab1","01234","Julio","88855799","Rua1",4);
        Funcionario colab2 = new Funcionario(700,"colab2","01234","Ana","98456789","Rua2",5);
        Funcionario colab3 = new Funcionario(700,"colab3","01234","Junia","98357799","Rua3",6);
        Funcionario colab4 = new Funcionario(700,"colab4","01234","Carlos","99456719","Rua4",7);
        Funcionario colab5 = new Funcionario(700,"colab5","01234","Pompeu","88551199","Rua5",8);
        Funcionario colab6 = new Funcionario(700,"colab6","01234","Eduarda","988456761","Rua6",9);
        Funcionario colab7 = new Funcionario(700,"colab7","01234","Leia","98456748","Rua7",10);
        Funcionario colab8 = new Funcionario(700,"colab8","01234","Horalice","88406790","Rua8",11);
        Funcionario colab9 = new Funcionario(800,"colab9","01234","Edson","98456734","Rua9",12);
        Funcionario colab10 = new Funcionario(800,"colab10","01234","Edson","98456734","Rua9",13);
        Funcionario colab11= new Funcionario(800,"colab11","01234","Edson","98456734","Rua9",14);
        Funcionario colab12 = new Funcionario(800,"colab12","01234","Edson","98456734","Rua9",15);
        Funcionario colab13 = new Funcionario(800,"colab13","01234","Edson","98456734","Rua9",16);
        Funcionario colab14 = new Funcionario(800,"colab14","01234","Edson","98456734","Rua9",17);
        
        
        MinhaLanchonete.AddFunc(colab0, 0);
        MinhaLanchonete.AddFunc(colab1, 1);
        MinhaLanchonete.AddFunc(colab2, 2);
        MinhaLanchonete.AddFunc(colab3, 3);
        MinhaLanchonete.AddFunc(colab4, 4);
        MinhaLanchonete.AddFunc(colab5, 5);
        MinhaLanchonete.AddFunc(colab6, 6);
        MinhaLanchonete.AddFunc(colab7, 7);
        MinhaLanchonete.AddFunc(colab8, 8);
        MinhaLanchonete.AddFunc(colab9, 9);
        MinhaLanchonete.AddFunc(colab10, 10);
        MinhaLanchonete.AddFunc(colab11, 11);
        MinhaLanchonete.AddFunc(colab12, 12);
        MinhaLanchonete.AddFunc(colab13, 13);
        MinhaLanchonete.AddFunc(colab14, 14);
        Cliente cliente1 = new Cliente("Paulo","370","Pao",40);
        MinhaLanchonete.GetClientes().add(cliente1);
        
        
        
        
        
        //**LISTA DOS 10 FUNCIONÁRIOS CADASTRADOS PREVIAMENTE*/
        
        
        Funcionario MeusFunc[] = new Funcionario [10];
        MeusFunc = MinhaLanchonete.ListaFuncionarios();
        
        
        // LOGIN DE ADMINISTRADORES E FUNCIONÁRIOS USANDO-SE USER E SENHA
        System.out.println("User: ");
        String user = input.nextLine(); 
    
        
        //SE FOR ADM
        if( user.equals(adm1.GetUser()) || user.equals(adm2.GetUser()) 
               ){
            System.out.println("Senha: ");
            String senha = input.nextLine();
            if (senha.equals(adm1.GetSenha())||senha.equals(adm2.GetSenha())){
                System.out.println("OLÁ, ADMINISTRADOR, o que deseja fazer? "
                        + "\n(1) Gerenciar Funcionários"
                        + "\n(2) Gerenciar Clientes"
                        + "\n(3) Gerenciar Lanches e Produtos"
                        + "\n(4) Meus Dados");
                int num = input.nextInt();
                
                switch(num){
                    //Caso em que se seleciona para gerenciar funcionários
                    case 1:
                        System.out.println("(1) Adicionar Funcionário"
                        + "\n(2) Remover funcionário"
                        );
                        num = input.nextInt();
                        switch(num){
                            case 1:
                                MinhaLanchonete.AdicionarFuncionario();
                                
                                break;
                            case 2:
                                MinhaLanchonete.RemoverFuncionario();
                                break;
                            
                                
                        }
                    
                    break;
                    //Caso em que se seleciona gerenciar cleintes
                    case 2:
                        System.out.println("(1) Adicionar Cliente"
                                + "\n(2) Remover Cliente"
                                + "\n(3) Editar Cliente");
                        num = input.nextInt();
                        switch(num){
                            case 1:
                            //Caso em que se seleciona adicionar cliente   
                                MinhaLanchonete.AdicionarCliente();
                                
                                break;
                                
                            case 2:
                            //Caso em que se seleciona remover cliente   
                                MinhaLanchonete.RemoverClienteId();
                            break;
                            case 3:
                                MinhaLanchonete.EditarClienteId();
                }
                    break;
                    //Caso em que se seleciona para gerenciar produtos/lanches (lanche é um produto)
                    case 3:
                        System.out.println("(1) Adicionar produto"
                                + "\n(2) Remover produto"
                                + "\n(3) Editar produto");
                        num = input.nextInt();
                        switch(num){
                            case 1:
                                MinhaLanchonete.AdicionarProduto();
                                
                            case 2:
                                MinhaLanchonete.RemoverProduto();
                            
                            case 3:
                                MinhaLanchonete.EditarProdutoId();
                                    }
                    break;
                    case 4: 
                        MinhaLanchonete.EditarMeusDados();
                    break;
                //Caso em que se seleciona Gerenciar lanches/produtos
            }
            }
        }
        //SE FOR FUNCIONÁRIO
       else for(int i=0;i<=9;i++) if(user.equals(MeusFunc[i].GetUser())){
                System.out.println("Senha: ");
            String senha = input.nextLine();
            if (senha.equals(MeusFunc[i].GetSenha())||senha.equals(MeusFunc[i].GetSenha())){
                System.out.println("OLÁ, FUNCIONÁRIO, o que deseja? "
                        + "\n(1)Gerenciar pedidos"
                        + "\n(2)Meus Dados"
                        + "\n(3)Estatísticas"
                        );
            }
            int m = input.nextInt();
            switch(m){
                case 1:
                    System.out.println("(1)Adicionar pedido"
                            + "\n(2)Remover pedido"
                            + "\n(3)Alterar pedido"
                            + "\n(4)Imprimir extrato de pedido"
                            + "\n(5)Pesquisar pedidos num intervalo de datas e horas");
                    m = input.nextInt();
                    switch(m){
                        case 1:
                            MinhaLanchonete.AdicionarPedido();
                        case 2:
                            MinhaLanchonete.RemoverPedido();
                        case 3:
                            MinhaLanchonete.EditarPedido();
                        case 4:
                            
                        case 5:
                            MinhaLanchonete.PesquisarIntervalo();
                    }
                case 2:
                    MinhaLanchonete.EditarMeusDados2();
                case 3:            
                    MinhaLanchonete.Estatistica();
                }
            }
            
   
        
    
    }
}   
      
        
    

