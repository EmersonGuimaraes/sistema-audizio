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
public class Processo {
    String processo;
    String data_inicio;
    String data_termino;
    String reboqueiro;
    String data_estacionamento;
    String fone_advogado;
    String cliente;
    int idCliente;
    String advogado; 
    int idAdvogado;
    String acao;
    String idVeiculo;
    String idProcesso;
    String situacao;
    String situacao_atual;
    String comarca;
    String vara;
   
    
    public String getIdProcesso(){
        return idProcesso;
    }
    public void setIdProcesso(String id){
        this.idProcesso = id;
    }
    
    public String getSituacao(){
        return situacao;
    }
    public void setSituacao(String situcao){
        this.situacao = situcao;
    }

    public String getSituacao_atual() {
        return situacao_atual;
    }

    public void setSituacao_atual(String situacao_atual) {
        this.situacao_atual = situacao_atual;
    }
    
    public String getProcesso(){
        return processo;
    }
    public void setProcesso(String processo){
        this.processo = processo;
    }
    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
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

    public String getFone_advogado() {
        return fone_advogado;
    }

    public void setFone_advogado(String fone_advogado) {
        this.fone_advogado = fone_advogado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAdvogado() {
        return advogado;
    }

    public void setAdvogado(String advogado) {
        this.advogado = advogado;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    public String getIdVeiculo(){
        return idVeiculo;
    }
    
    public void setIdVeiculo(String id){
        this.idVeiculo = id;
    }
    
     public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdAdvogado(int idAdvogado) {
        this.idAdvogado = idAdvogado;
    }

    public int getIdAdvogado() {
        return idAdvogado;
    }
    
    
    
    
}