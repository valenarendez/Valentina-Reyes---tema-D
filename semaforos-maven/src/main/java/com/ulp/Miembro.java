
package com.ulp;

public class Miembro {
    private int id;
    private String nombre;
    private String puesto;
    private boolean libre;                           // true = libre,  false = ocupado
    private boolean esResponsable;        //uno de los 4 es true
    private EquipoDeControl equipo;

    public Miembro(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.libre = false;            // arranca ocupado mientras trabaja
        this.esResponsable = false;
        this.equipo = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public boolean isEsResponsable() {
        return esResponsable;
    }

    public void setEsResponsable(boolean esResponsable) {
        this.esResponsable = esResponsable;
    }

    public EquipoDeControl getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDeControl equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString(){
        return " Id del miembro : " +id + ", nombre: " +nombre+ ", estado: " +libre+ ", responsable: " + esResponsable ; 
    }
    
    
}
