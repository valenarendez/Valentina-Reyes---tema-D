
package com.ulp;

import java.time.LocalDate;

public class Denuncia {
    private String codigoDenuncia;
    private LocalDate fechaDenuncia;
    private String calleX;
    private String calleY;
    private String problema;
    private String prioridad;                        // "Alta", "Media" o "Baja"
    
    private Denunciante denunciante;      
    private Semaforo semaforo;            
    private OrdenDeComposicion ordenAsignada; // null hasta que se asigne 

    public Denuncia(String codigoDenuncia, LocalDate fechaDenuncia, String calleX, String calleY, String problema, String prioridad) {
        this.codigoDenuncia = codigoDenuncia;
        this.fechaDenuncia = fechaDenuncia;
        this.calleX = calleX;
        this.calleY = calleY;
        this.problema = problema;
        this.prioridad = prioridad;
        this.ordenAsignada = null;
    }

    public boolean esPrioridadValida() {
        return prioridad != null && (prioridad.equals("Alta") || prioridad.equals("Media") || prioridad.equals("Baja"));
    }

   public void asignarOrden(OrdenDeComposicion orden) throws OrdenYaAsignadaException {
        if (ordenAsignada != null) {
            throw new OrdenYaAsignadaException("Orden ya asignada previamente");
        }
        this.ordenAsignada = orden;
    }
   
    public void notificarReparacion() {
        System.out.println("Mail enviado a " + denunciante.getMail() + " el semaforo "+ semaforo.getNumero() + " ya fue reparado! ");
        }

     public boolean tieneOrden(){ 
         return ordenAsignada != null; 
     }
     
    public String getCodigoDenuncia() {
        return codigoDenuncia;
    }

    public void setCodigoDenuncia(String codigoDenuncia) {
        this.codigoDenuncia = codigoDenuncia;
    }

    public LocalDate getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(LocalDate fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public String getCalleX() {
        return calleX;
    }

    public void setCalleX(String calleX) {
        this.calleX = calleX;
    }

    public String getCalleY() {
        return calleY;
    }

    public void setCalleY(String calleY) {
        this.calleY = calleY;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Denunciante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public OrdenDeComposicion getOrdenAsignada() {
        return ordenAsignada;
    }

    public void setOrdenAsignada(OrdenDeComposicion ordenAsignada) {
        this.ordenAsignada = ordenAsignada;   
    }
    
    @Override
    public String toString(){
        return"Denuncia codigo: "+codigoDenuncia+ ", prioridad: " +prioridad ;
    }
    
}
