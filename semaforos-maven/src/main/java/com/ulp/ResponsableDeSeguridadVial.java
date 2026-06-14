
package com.ulp;

import java.time.LocalDate;

public class ResponsableDeSeguridadVial {

    private String nombre;

    public ResponsableDeSeguridadVial(String nombre) {
        this.nombre = nombre;
    }

 //crea una orden de composicion para la denuncia y se la asigna.  Si la denuncia ya tenia orden, asignarOrden() lanza la excepcion
    public OrdenDeComposicion asignarOrden(Denuncia denuncia, int nroOrden, LocalDate fechaProgramada, String detalle) throws OrdenYaAsignadaException {
        OrdenDeComposicion orden = new OrdenDeComposicion(nroOrden, fechaProgramada, null, detalle, denuncia);
        denuncia.asignarOrden(orden);
        return orden;
    }

   ///asocia un equipo de control a la orden y lo pasa a ocupado
    public void asignarEquipo(OrdenDeComposicion orden, EquipoDeControl equipo) {
        orden.setEquipo(equipo);
        equipo.agregarOrden(orden);
        equipo.setEstado("ocupado");
        for (Miembro m : equipo.getMiembros()) {
            m.setLibre(false);
        }
    }

       //libera al equipo 
    public void dejarLibreEquipo(EquipoDeControl equipo) {
        equipo.setEstado("Libre");
        for (Miembro m : equipo.getMiembros()) {
            m.setLibre(true);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
