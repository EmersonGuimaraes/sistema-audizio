/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.bean;

/**
 *
 * @author ZipNet
 */
public class Veiculo {
    
    String ano_fabricacao;
    String ano_modelo;
    String cor;
    String modelo;
    String placa;
    String marca;
    String estado;
    String id;
    int id_processo;

    public void setId_processo(int id_processo) {
        this.id_processo = id_processo;
    }

    public int getId_processo() {
        return id_processo;
    }
    
    
    public String getAnoFabricacao() {
        return ano_fabricacao;
    }

    public void setAnoFabricacao(String ano) {
        this.ano_fabricacao = ano;
    }
    public String getAnoModelo() {
        return ano_modelo;
    }

    public void setAnoModelo(String ano) {
        this.ano_modelo = ano;
    }
    
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

 
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
