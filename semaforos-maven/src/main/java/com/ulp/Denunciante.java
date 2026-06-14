
package com.ulp;

import java.util.ArrayList;
import java.util.List;


public class Denunciante {
    
private String nombre;
    private String mail;
    private List<Denuncia> denuncias;

    public Denunciante(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.denuncias = new ArrayList<>();
    }

    public void agregarDenuncia(Denuncia denu) {
        denuncias.add(denu);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }
    
    @Override
    public String toString(){
        return "~ nombre del denunciante: "+nombre+ ", mail: " +mail ;
    }
}
