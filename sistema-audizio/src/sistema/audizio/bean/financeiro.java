package sistema.audizio.bean;

/**
 *
 * @author ZipNet
 */
public class financeiro extends Processo{
    String cobranca;
    String descricao;
    String despesas;
    String data_pagamento;
    String valor;
    String id_financeiro;

    public String getCobranca() {
        return cobranca;
    }

    public void setCobranca(String cobranca) {
        this.cobranca = cobranca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDespesas() {
        return despesas;
    }

    public void setDespesas(String despesas) {
        this.despesas = despesas;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getId_financeiro() {
        return id_financeiro;
    }

    public void setId_financeiro(String id_processo) {
        this.id_financeiro = id_processo;
    }
    
}


