/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete1;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author patri
 */
public class Sistema {
    
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    //Variável que armazena número de clientes
    private static int solucao1;
    private static int solucao2;
    private static int num_clientes = Cliente.GetNumeroClientes();
    
    
    
    //Método de classe que obtém o número de clientes
    
    public static int NumeroDeClientes(){
        return  num_clientes;
    }
    
    
    
    //Listas e vetores do BANCO DE DADOS
    private Funcionario funcionarios[] = new Funcionario[15];
    private List<Adm> adms = new ArrayList<Adm>();
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private List<Pedido> estatistica = new ArrayList<Pedido>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Produto> cardápio = new ArrayList<Produto>();
    private List<Funcionario> novosfuncionarios = new ArrayList<Funcionario>();
    private List<Pedido> intervalo = new ArrayList<Pedido>();
    
    
    
    
    
    //Get para estatística
    
    public List<Pedido> GetEstatistica(){
        return estatistica;
    }
    
   //Get para funcionários
    
    public Funcionario[] GetFuncionarios(){
        return funcionarios;
    }
    
    
    
    //Get para lista de clientes
    
    public List<Cliente> GetClientes(){
        return clientes;
    }
    
    //Get para lista de pedidos
    public List<Pedido> GetPedidos(){
        return pedidos;
    }
    
    //Get para o cardápio
     public List<Produto> GetCardapio(){
        return cardápio;
    }
     
    //Adicionar adm a lista
    public void AddAdm(Adm adm){
        this.adms.add(adm);
    }
    public List<Adm> GetAdms(){
        return this.adms;
    }
    
    
    //Adicionar e obter funcionário ao vetor
    public void AddFunc(Funcionario func, int i){
        this.funcionarios[i] = func;
    }
    public Funcionario getFunc(int i){
        return funcionarios[i];
    }
    public Funcionario[] ListaFuncionarios (){
        return funcionarios;
    }
    //Método do sistema para incluir um funcionário 
    public void AdicionarFuncionario(){
        /**
 *
 * Método para adicionar funcionarios
 */
        System.out.println("Nome:"
                          + "\nTelefone:"
                          + "\nEndereco: "
                          
                                );  
                                String nome = input.nextLine();
                                
                                String telefone = input.nextLine();
                                String endereco = input.nextLine();
                                
                                Funcionario novofunc = new Funcionario(700, "user","senha",nome,telefone,endereco,random.nextInt(100000));
                                this.AddNovoFunc(novofunc);
    }
    
    
    
    
    //Método para excluir funcionário fo vetor
    
     public void RemoverFuncionario(){
          System.out.println("Digite o id do funcionário que deseja remover:");
                                int id = input.nextInt();
                                for(int i=0;i<=14;i++){
                                    if (funcionarios[i].GetId()==id){
                                        funcionarios[i] = null;
                                    }
                                }
             
    }
     
     //Método para adicionar e remover novos funcionários
     public void AddNovoFunc(Funcionario funcionario){
         novosfuncionarios.add(funcionario);
     }
     public void RemoverFunc(Funcionario funcionario){
         novosfuncionarios.add(funcionario);
     }
     
     
     
     //Métodos para adicionar e remover pedidos
     
     public void AdicionarPedido(Pedido pedido){
         System.out.println("Data:"
                 + "\nHorário:"
                 + "\n");
         pedidos.add(pedido);
     }
     public void RemoverPedido(Pedido pedido){
         pedidos.remove(pedido);
     }
     
     //Métodos para adicionar e remover cliente
     public void AdicionarCliente(){
         System.out.println("Nome:"
                                        + "\nTelefone:"
                                        + "\nEndereco: "
                                        + "\nId:");
                                String nome = input.nextLine();
                                String telefone = input.nextLine();
                                String endereco = input.nextLine();
                                int id = input.nextInt();
                                Cliente novocliente = new Cliente(nome,telefone,endereco,id);
                                clientes.add(novocliente);
     }
     public void RemoverCliente(Cliente cliente){
         clientes.remove(cliente);
     }
     public void RemoverClienteId(){
         System.out.println("Digite o id do cliente a se remover:");
                                int id = input.nextInt();
                                
                                try{
                                boolean test = false;  
                                Cliente remover = new Cliente();
                                remover.SetId(id);
                                
                                int indice = this.GetClientes().indexOf(remover);
                                
                                if ( indice != -1){
                                this.GetClientes().remove(this.GetClientes().get(indice));
                                test = true;}
                                
                        
                                if(test == true){
                                System.out.println("Removido.");
                                }else{
                                System.out.println("Não encontrado.");
                                }
                            }
                            catch (Exception excpt){
                                    excpt.getStackTrace();
                                    }
     }
     //MÉTODO PARA EDITAR DADOS DO CLIENTE RECEBENDO SEU ID
     public void EditarClienteId(){
         System.out.println("Digite o id do cliente a se editar:");
                                String id = input.nextLine();
                                
                                  
                                Cliente editar = new Cliente();
                                editar.SetId(Integer.parseInt(id));
                                
                                int indice = this.GetClientes().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("O que deseja alterar do cliente?"
                                        + "\n(1)Nome"
                                        + "\n(2)Telefone"
                                        + "\n(3)Endereço"
                                        + "\n(4)Id ");
                                String n = input.nextLine();
                                switch(n){
                                    case "1":
                                        System.out.println("Insira novo nome:");
                                        String novonome = input.nextLine();
                                        this.GetClientes().get(indice).SetNome(novonome);
                                    break;
                                    case "2":
                                        System.out.println("Insira novo telefone:");
                                        String novotelefone = input.nextLine();
                                        this.GetClientes().get(indice).SetTelefone(novotelefone);
                                    break;
                                    case "3":
                                        System.out.println("Insira novo Endereço:");
                                        String novoend = input.nextLine();
                                        this.GetClientes().get(indice).SetEndereco(novoend);
                                    break;
                                    case "4":
                                        System.out.println("Insira novo Id:");
                                        String novoID = input.nextLine();
                                        this.GetClientes().get(indice).SetId(Integer.parseInt(id));
                                }
                                    
                                
                                }
                                
                        
                                
     }
     
     
     //Métodos para adicionar e remover produtos do cardápio
     public void AdicionarProduto(){
         System.out.println("Descrição:"
                 + "\nId:"
                 + "\nPreço: ");
                 
         String descri = input.nextLine();
         int id = input.nextInt();
         double preco = input.nextDouble();
         
         Produto novoproduto = new Produto(descri,id,preco);
         this.cardápio.add(novoproduto);
         
         
         this.cardápio.add(novoproduto);
     }
     public void RemoverProduto( ){
         System.out.println("Digite o id do produto a se remover:");
                                int id = input.nextInt();
                                
                                try{
                                boolean test = false;  
                                Produto remover = new Produto();
                                remover.SetIdProduto(id);
                                
                                int indice = this.GetCardapio().indexOf(remover);
                                
                                if ( indice != -1){
                                this.GetCardapio().remove(this.GetCardapio().get(indice));
                                test = true;}
                                
                        
                                if(test == true){
                                System.out.println("Removido.");
                                }else{
                                System.out.println("Não encontrado.");
                                }
                            }
                            catch (Exception excpt){
                                    excpt.getStackTrace();
                                    }
     }
     
     //Método para Editar dados de um produto
     
     public void EditarProdutoId(){
         System.out.println("Digite o id do produto a se editar:");
                                String id = input.nextLine();
                                
                                 
                                Produto editar = new Produto();
                                editar.SetIdProduto(Integer.parseInt(id));
                                
                                int indice = this.GetCardapio().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("O que deseja alterar do produto?"
                                        + "\n(1)Descrição"
                                        + "\n(2)Id"
                                        + "\n(3)Preço"
                                        );
                                String n = input.nextLine();
                                switch(n){
                                    case "1":
                                        System.out.println("Insira nova descrição:");
                                        String novonome = input.nextLine();
                                        this.GetCardapio().get(indice).SetDescricao(novonome);
                                    break;
                                    case "2":
                                        System.out.println("Insira novo ID:");
                                        int novoID = input.nextInt();
                                        this.GetCardapio().get(indice).SetIdProduto(novoID);
                                    break;
                                    case "3":
                                        System.out.println("Insira novo preço:");
                                        double novopreco = input.nextDouble();
                                        this.GetCardapio().get(indice).SetPreco(novopreco);
                                    break;
                                    
                                }
                               }
                                
                        
                                
     }
    
     //Método para pesquisar pedido
     public void PesquisarPedido(Pedido pedido1){
         
         
         for(int i = 0; i < pedidos.size(); i++)
{
    if (pedido1 == pedidos.get(i)){ System.out.println(pedido1.GetStatus());
}
           
     }
         
     
}
    public void EditarMeusDados(){
        System.out.println("Digite seu id:");
                                String id = input.nextLine();
                                
                                  
                                Adm editar = new Adm();
                                editar.SetId(Integer.parseInt(id));
                                
                                
                                int indice = this.GetAdms().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("O que deseja alterar?"
                                        + "\n(1)User"
                                        + "\n(2)Senha"
                                        );
                                String n = input.nextLine();
                                switch(n){
                                    case "1":
                                        System.out.println("Insira novo user:");
                                        String novouser = input.nextLine();
                                        this.GetAdms().get(indice).SetUser(novouser);
                                    break;
                                    case "2":
                                        System.out.println("Insira nova senha:");
                                        String novasenha = input.nextLine();
                                        this.GetAdms().get(indice).SetSenha(novasenha);
                                    break;
                                }
                                    
                                
                                
                                }
                        
                                
                                
                            }
    //Método para adicionar pedido
    public void AdicionarPedido(){
        System.out.println("Id do pedido:"
                 + "\nAdicionais:"
                
                  );
                 
         String idPedido = input.nextLine();
         String adicionais = input.nextLine();
         Calendar data = Calendar.getInstance();
         
         
         Pedido novopedido = new Pedido(Integer.parseInt(idPedido),data,"Pedido feito",adicionais);
         this.pedidos.add(novopedido);
         
         
        
        
    }
    //Método para remover pedido
    public void RemoverPedido(){
        System.out.println("Digite o id do pedido a se remover:");
                                int id = input.nextInt();
                                
                                try{
                                boolean test = false;  
                                Pedido remover = new Pedido();
                                remover.SetIdPedido(id);
                                
                                int indice = this.GetPedidos().indexOf(remover);
                                
                                if ( indice != -1){
                                this.GetPedidos().remove(this.GetPedidos().get(indice));
                                test = true;}
                                
                        
                                if(test == true){
                                System.out.println("Removido.");
                                }else{
                                System.out.println("Não encontrado.");
                                }
                            }
                            catch (Exception excpt){
                                    excpt.getStackTrace();
                                    }
        
    }
        
    //Método para editar pedido
    
    public void EditarPedido(){
        System.out.println("Digite o id do pedido que deseja alterar:");
                                String id = input.nextLine();
                                
                                  
                                Pedido editar = new Pedido();
                                editar.SetIdPedido(Integer.parseInt(id));
                                
                                
                                int indice = this.GetPedidos().indexOf(editar);
                                
                                if ( indice != -1){
                                    
                                System.out.println("O que deseja alterar?"
                                        + "\n(1)Id do pedido"
                                        + "\n(2)Adicionais"
                                        );
                                String n = input.nextLine();
                                switch(n){
                                    case "1":
                                        System.out.println("Insira novo Id para o pedido:");
                                        String novoID = input.nextLine();
                                        this.GetPedidos().get(indice).SetIdPedido(Integer.parseInt(novoID));
                                    break;
                                    case "2":
                                        System.out.println("Insira nova lista de adicionais:");
                                        String novosadicionais = input.nextLine();
                                        this.GetPedidos().get(indice).SetAdicionais(novosadicionais);
                                    break;
                                }
                                    
                                
                                
                                }
    }
    
    public List<Pedido> PesquisarIntervalo(){
        
        
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        System.out.println("Digita a primeira data: (dia, mês e ano ");
        
        int l = input.nextInt();
        int k = input.nextInt();
        int p = input.nextInt();
        
        c1.set(l,k,p);
        
        System.out.println("Digita a segunda data: (dia, mês e ano ");
        
        l = input.nextInt();
        k = input.nextInt();
        p = input.nextInt();                                       
        
        
        
        
		
                
        for (Pedido pedido: this.pedidos){
           int h = pedido.GetData().compareTo(c1);
           int j = pedido.GetData().compareTo(c2);
           if (h>0&&j<0){
               intervalo.add(pedido);
               
           }
        }
        
        return intervalo;
        
    }
    
    public void EditarMeusDados2(){
        System.out.println("Digite seu id:");
                                String id = input.nextLine();
                                
                                  
                                Funcionario editar = new Funcionario();
                                editar.SetId(Integer.parseInt(id));
                                
                                
                                for(int i=0;i<15;i++){
                                
                                if ( this.funcionarios[i].GetId()==editar.GetId()){
                                    
                                System.out.println("O que deseja alterar?"
                                        + "\n(1)User"
                                        + "\n(2)Senha"
                                        );
                                String n = input.nextLine();
                                switch(n){
                                    case "1":
                                        System.out.println("Insira novo user:");
                                        String novouser = input.nextLine();
                                        this.funcionarios[i].SetUser(novouser);
                                    break;
                                    case "2":
                                        System.out.println("Insira nova senha:");
                                        String novasenha = input.nextLine();
                                        this.funcionarios[i].SetSenha(novasenha);
                                    break;
                                }
                                    
                                
                                
                                }
                        
                                }
                                
                            }
    //Métodos para obter estatística dos pedidos de um dia
    public void Estatistica(){
       /**Método para obter estatística dos pedidos de um dia*/
        System.out.println("Digite a data da qual se quer obter a estatística: (dia, mês e ano) ");
        int dia = input.nextInt();
        int mes = input.nextInt();
        int ano = input.nextInt();
        int num = 0;
        
        Calendar date = Calendar.getInstance();
        date.set(dia,mes,ano);
        
        for(Pedido pedido: this.pedidos){
          int h = pedido.GetData().compareTo(date);
          if(h!=0){
              estatistica.add(pedido);
              num = num + 1;
            
        }
    
    }
        System.out.printf("Nesse dia foram feitos %s pedidos.", num);
    
    
    }
    
    //Json
     public void DadosClientes()throws IOException{
        FileWriter filewriter = new FileWriter("C:\\clientes.json");
        for (Cliente cliente: this.GetClientes() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(cliente);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class).log(Level.SEVERE,null,ex);
            }
        }
    } 
     public void DadosAdms()throws IOException{
        FileWriter filewriter = new FileWriter("adm.json");
        for (Adm adm: this.GetAdms() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(adm);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class).log(Level.SEVERE,null,ex);
            }
        }
    }
     public void DadosPedidos()throws IOException{
        FileWriter filewriter = new FileWriter("C:\\pedidos.json");
        for (Pedido pedido: this.GetPedidos() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(pedido);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class).log(Level.SEVERE,null,ex);
            }
        }
    }
     public void DadosProdutos()throws IOException{
        FileWriter filewriter = new FileWriter("C:\\Users\\patri\\OneDrive\\Documentos\\NetBeansProjects\\Lanchonete1\\produtos.json");
        for (Produto produto: this.GetCardapio() ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try{
                String json = gson.toJson(produto);
                
                filewriter.write(json);
                filewriter.flush();
                
                System.out.println(json);
            }catch(IOException ex){
                Logger.getLogger(Sistema.class).log(Level.SEVERE,null,ex);
            }
        }
    }
}
     
     

