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
    String idAdvogado;
    int cod;
    public String getIdAdvogado(){
        return idAdvogado;
    }
    
    public void setIdAdvogado(String id){
        this.idAdvogado = id;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }
    
    
}
