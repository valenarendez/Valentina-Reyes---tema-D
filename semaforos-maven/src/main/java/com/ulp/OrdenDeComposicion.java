
package com.ulp;

import java.time.LocalDate;

public class OrdenDeComposicion {
    private int nroDeOrden;
    private LocalDate fechaReparacionProgramada;
    private LocalDate fechaReparacionEfectiva; // null hasata estar reparado
    private String detalle;
    private Denuncia denuncia;
    private EquipoDeControl equipo;
    private String estado; //pendiente, completa

    public OrdenDeComposicion(int nroDeOrden, LocalDate fechaReparacionProgramada, LocalDate fechaReparacionEfectiva, String detalle, Denuncia denuncia) {
        this.nroDeOrden = nroDeOrden;
        this.fechaReparacionProgramada = fechaReparacionProgramada;
        this.fechaReparacionEfectiva = fechaReparacionEfectiva;
        this.detalle = detalle;
        this.denuncia = denuncia;
        this.equipo = null;            
        this.estado = "Pendiente";
    }
        
    public void imprimir() {
        System.out.println("~~~~ Orden N° " + nroDeOrden + " : ");
        System.out.println(" Fecha programada : " + fechaReparacionProgramada);
        System.out.println("Fecha efectiva   : " + fechaReparacionEfectiva);
        System.out.println("Detalle    : " + detalle);
        System.out.println("Estado     : " + estado);
    }

    // completar, el equipo pasa a libre,
    // los miembros pasan a libres, se notifica al denunciante,
    // se imprime la orden.
    public void completar(LocalDate fechaEfectiva) {
        setFechaReparacionEfectiva(fechaEfectiva);

        if (equipo != null) {
            equipo.setEstado("Libre");
            for (Miembro m : equipo.getMiembros()) {
                m.setLibre(true);
            }
        }

        if (denuncia != null) {
            denuncia.notificarReparacion();
        }

        imprimir();
    }

    //Getters and setters 

    public int getNroDeOrden() {
        return nroDeOrden;
    }

    public void setNroDeOrden(int nroDeOrden) {
        this.nroDeOrden = nroDeOrden;
    }

    public LocalDate getFechaReparacionProgramada() {
        return fechaReparacionProgramada;
    }

    public void setFechaReparacionProgramada(LocalDate fechaReparacionProgramada) {
        this.fechaReparacionProgramada = fechaReparacionProgramada;
    }

    public LocalDate getFechaReparacionEfectiva() {
        return fechaReparacionEfectiva;
    }

    public void setFechaReparacionEfectiva(LocalDate fechaReparacionEfectiva) {
        this.fechaReparacionEfectiva = fechaReparacionEfectiva;
        this.estado = "Completa";
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public EquipoDeControl getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDeControl equipo) {
        this.equipo = equipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "Orden de composición N°: " +nroDeOrden + ", estado: " +estado;
    }
    
    
}
