/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.audizio.bean;

/**
 *
 * @author Raylan Alves
 */
public class Advogado extends Pessoa {
    String oab;
    String area_atuacao;
    String idAdvogado;
    
    public String getIdAdvogado(){
        return idAdvogado;
    }
    
    public void setIdAdvogado(String id){
        this.idAdvogado = id;
    }
    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public String getArea_atuacao() {
        return area_atuacao;
    }

    public void setArea_atuacao(String area_atuacao) {
        this.area_atuacao = area_atuacao;
    }
}
