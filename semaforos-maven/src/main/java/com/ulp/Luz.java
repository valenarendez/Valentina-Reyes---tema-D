
package com.ulp;

//nace y muere con el semaforo
public class Luz {
  private int numeroDeSerie;
  private String empresaFabricadora;
  private String tipo;
  private String color;
  private Semaforo semaforo;

    public Luz(int numeroDeSerie, String empresaFabricadora, String tipo, String color) {
        this.numeroDeSerie = numeroDeSerie;
        this.empresaFabricadora = empresaFabricadora;
        this.tipo = tipo;
        this.color = color;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getEmpresaFabricadora() {
        return empresaFabricadora;
    }

    public void setEmpresaFabricadora(String empresaFabricadora) {
        this.empresaFabricadora = empresaFabricadora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

   @Override
   public String toString(){
       return "LUZ : ~Serie: " +numeroDeSerie + ", Empresa Fabricadora: " +empresaFabricadora +", tipo: " +tipo+ ", color:" +color;
   }
 
          
    
}
