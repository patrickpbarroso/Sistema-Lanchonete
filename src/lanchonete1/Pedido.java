/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonete1;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patri
 */
public class Pedido implements Comparable<Pedido> {
    
    private int idPedido;
    private Calendar data_pedido = Calendar.getInstance();//inclui tanto dia, mes, ano e horário
    
    
    private String adicionais;
    private String status;
    
    //Construtores de Pedido
    
    Pedido(int idProduto, Calendar data_pedido, String status, String adicionais){
        this.idPedido = idProduto;
        this.data_pedido = data_pedido;        
        
        this.adicionais = adicionais;
        this.status = status;
    }
    Pedido(){
        
    }
    
    //Método comparable
    
    @Override
    public int compareTo(Pedido other){
        if(this.GetIdPedido()<other.GetIdPedido()){
            return this.GetIdPedido();
        }
        else{return other.GetIdPedido();}
    }
    
    //Métodos get e set para id produto
    
    public void SetIdPedido(int id){
        this.idPedido = id;
    }
    public int GetIdPedido(){
        return idPedido;
    }
    
    //Métodos Get e Set para os atributos de Pedido
    public void SetData(Calendar data){
        this.data_pedido = data;
    }
    public Calendar GetData(){
        return data_pedido;
    }    
    
    public void SetStatus(String status){
        this.status = status;
    }
    public String GetStatus(){
        return status;
    }
    
    
    
    //Método para adicionar e remover adicionais ao pedido
    public void SetAdicionais(String adicional){
        this.adicionais = adicional;
    }
    public String GetAdicional(){
        return adicionais;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", data_pedido=" + data_pedido + ", adicionais=" + adicionais + ", status=" + status + '}';
    }

    

    

    
    
    
    
    
    
}
