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
public class Apreensao {
    String data_apreensao;
    String data_remocao;
    String reboqueiro;
    String data_estacionamento;
    double valor_diaria;
    double valor;
    String oficial_justica;
    String fone_oficial_justica;
    
    public String getData_apreensao() {
        return data_apreensao;
    }

    public void setData_apreensao(String data_apreensao) {
        this.data_apreensao = data_apreensao;
    }

    public String getData_remocao() {
        return data_remocao;
    }

    public void setData_remocao(String data_remocao) {
        this.data_remocao = data_remocao;
    }

    public String getReboqueiro() {
        return reboqueiro;
    }

    public void setReboqueiro(String reboqueiro) {
        this.reboqueiro = reboqueiro;
    }

    public String getData_estacionamento() {
        return data_estacionamento;
    }

    public void setData_estacionamento(String data_estacionamento) {
        this.data_estacionamento = data_estacionamento;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getOficial_justica() {
        return oficial_justica;
    }

    public void setOficial_justica(String oficial_justica) {
        this.oficial_justica = oficial_justica;
    }

    public String getFone_oficial_justica() {
        return fone_oficial_justica;
    }

    public void setFone_oficial_justica(String fone_oficial_justica) {
        this.fone_oficial_justica = fone_oficial_justica;
    }
    
}
