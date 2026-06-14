
package com.ulp;

import java.util.ArrayList;
import java.util.List;


public class Semaforo {
    private int numero;
    private String estado; //apagado- ecendido
    private String ubicacion;
    private String tipoDeFaro; //Basic Led - Smart Led
    private int cuentaRegresiva; //segundos, 0 si es basic led    
    private List<Luz> luces;
    private List<Denuncia> denuncias;

    public Semaforo(int numero, String estado, String ubicacion, String tipoDeFaro) {
        this.numero = numero;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.tipoDeFaro = tipoDeFaro;
        this.cuentaRegresiva = "Smart LED".equals(tipoDeFaro) ? 30 : 0;
        this.luces = new ArrayList<>();
        this.denuncias = new ArrayList<>();

        crearLuces();
    }

     private void crearLuces() {
         Luz rojo = new Luz(1, "Lucesita","Led", "Rojo");
         rojo.setSemaforo(this);
         luces.add(rojo);
         
         Luz amarillo = new Luz(2, "Lucesita","Led", "Amarillo");
         amarillo.setSemaforo(this);
         luces.add(amarillo);
         
         Luz verde = new Luz(3, "Lucesita","Led", "Verde");
         verde.setSemaforo(this);
         luces.add(verde);
               
    }
    
     //historico denuncias
     public void agregarDenuncia(Denuncia denu) {
        denuncias.add(denu);
    }

    public int getNumeroDenuncias() {
        return denuncias.size();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoDeFaro() {
        return tipoDeFaro;
    }

    public void setTipoDeFaro(String tipoDeFaro) {
        this.tipoDeFaro = tipoDeFaro;
    }

    public int getCuentaRegresiva() {
        return cuentaRegresiva;
    }

    public void setCuentaRegresiva(int cuentaRegresiva) {
        this.cuentaRegresiva = cuentaRegresiva;
    }

    public List<Luz> getLuces() {
        return luces;
    }

    public void setLuces(List<Luz> luces) {
        this.luces = luces;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    @Override
    public String toString(){
        return " ~ SEMÁFORO ~  número:" +numero+ ", estado: " +estado+ ", tipo de faro: " +tipoDeFaro+ ", cuenta regresiva: " +cuentaRegresiva;
    }
    
}