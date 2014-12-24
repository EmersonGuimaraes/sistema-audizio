package sistema.audizio.bean;

/**
 *
 * @author ZipNet
 */
public class Financeiro extends Processo{
    public String id;
    public int id_processo;
    public int id_cliente;
    public String processo;
    public String cliente;
    public String valor;
    public String valor_despesa;
    public String desconto;
    public String vencimento;
    public String situacao;
    public String valor_total;
    public String desc_despesa;
    public String data_pagamento;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the id_processo
     */
    public int getId_processo() {
        return id_processo;
    }

    /**
     * @param id_processo the id_processo to set
     */
    public void setId_processo(int id_processo) {
        this.id_processo = id_processo;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the processo
     */
    public String getProcesso() {
        return processo;
    }

    /**
     * @param processo the processo to set
     */
    public void setProcesso(String processo) {
        this.processo = processo;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the valor_despesa
     */
    public String getValor_despesa() {
        return valor_despesa;
    }

    /**
     * @param valor_despesa the valor_despesa to set
     */
    public void setValor_despesa(String valor_despesa) {
        this.valor_despesa = valor_despesa;
    }

    /**
     * @return the desconto
     */
    public String getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the valor_total
     */
    public String getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the desc_despesa
     */
    public String getDesc_despesa() {
        return desc_despesa;
    }

    /**
     * @param desc_despesa the desc_despesa to set
     */
    public void setDesc_despesa(String desc_despesa) {
        this.desc_despesa = desc_despesa;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }
    
    
    
}


