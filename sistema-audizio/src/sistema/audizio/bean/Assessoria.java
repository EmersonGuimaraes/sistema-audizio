/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.audizio.bean;

/**
 *
 * @author zipnet
 */
public class Assessoria {
    public String id;
    public String nome;
    public String cidade;
    public String bairro;
    public String endereco;
    public String nome_advogado;
    public String telefone_assessoria;
    public int cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome_advogado() {
        return nome_advogado;
    }

    public void setNome_advogado(String nome_advogado) {
        this.nome_advogado = nome_advogado;
    }

    public String getTelefone_assessoria() {
        return telefone_assessoria;
    }

    public void setTelefone_assessoria(String telefone_assessoria) {
        this.telefone_assessoria = telefone_assessoria;
    }
    
    
    
}
