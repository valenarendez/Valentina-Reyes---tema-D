
package com.ulp;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeControl {
    
    private String codigo;
    private List<Miembro> miembros;
    private String especialidad;
    private String estado;                                 // ocupado o libre
    private Miembro esResponsable;              //  uno de los miembros
    private List<OrdenDeComposicion> ordenes;

    public EquipoDeControl(String codigo, List<Miembro> miembros, String especialidad, String estado) {
        this.codigo = codigo;
        this.miembros = new ArrayList<>();
        this.especialidad = especialidad;
        this.estado = estado;
        this.esResponsable = null;
        this.ordenes = new ArrayList<>();
        if (miembros != null) {
            for (Miembro miem : miembros) {
                agregarMiembro(miem);     // engancha el equipo y elige responsable
            }
        }
    }
    
    public void agregarMiembro(Miembro miem) {
        miembros.add(miem);
        miem.setEquipo(this);
        if (esResponsable == null) {
            esResponsable = miem;
        }
    }

    public void agregarOrden(OrdenDeComposicion ord) {
        ordenes.add(ord);
    }

    public boolean isLibre() {
        return "libre".equalsIgnoreCase(estado);
    }

    public void informa() {
        System.out.println("Equipo: " + codigo + ". Especialidad: " + especialidad + ". Estado: " + estado);
        for (Miembro miem : miembros) {
            System.out.println("  Miembro: " + miem.getNombre() + ". Puesto: " + miem.getPuesto() + ". Libre: " + miem.isLibre());
        }
    }

    //getters and setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Miembro getEsResponsable() {
        return esResponsable;
    }

    public void setEsResponsable(Miembro esResponsable) {
        this.esResponsable = esResponsable;
    }

    public List<OrdenDeComposicion> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenDeComposicion> ordenes) {
        this.ordenes = ordenes;
    }
    
    
}
