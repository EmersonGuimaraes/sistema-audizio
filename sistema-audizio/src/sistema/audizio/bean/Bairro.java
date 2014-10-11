/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.bean;

/**
 *
 * @author emerson
 */
public class Bairro {
    String cod, nome, cod_cidade;

    public String getCod_cidade() {
        return cod_cidade;
    }

    public void setCod_cidade(String cod_cidade) {
        this.cod_cidade = cod_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }
    
}
