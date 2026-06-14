
package com.ulp;


public class GestionSemaforosService {

    //registra las denuncias y las guarda en el historial, tambien lo engancha con el denunciante si  es q tiene
    public void registrarDenuncia(Semaforo semaforo, Denuncia denuncia) {
        denuncia.setSemaforo(semaforo);
        semaforo.agregarDenuncia(denuncia);
        if (denuncia.getDenunciante() != null) {
            denuncia.getDenunciante().agregarDenuncia(denuncia);
        }
    }

  //cuantas denuncias tiene el semaforo
    public int cantidadDenunciasDeSemaforo(Semaforo semaforo) {
        return semaforo.getNumeroDenuncias();
    }
}
