package com.ulp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class GestionSemaforosTest {
  
    private GestionSemaforosService service;
    private Semaforo semaforo;
    
    @BeforeEach 
    public void setUp() {
        service = new GestionSemaforosService();
        semaforo = new Semaforo(1, "encendido", "Av. Tobar garcía", "Basic LED");
    }

    @AfterEach
    public void tearDown() {
        service = null;
        semaforo = null;
        System.out.println("Test finalizado: recursos liberados.");
    }

  
    @Test
    public void testComposicionEstrictaDeLuces() {
        assertEquals(3, semaforo.getLuces().size(), "El semaforo debe tener exactamente 3 luces.");

        // La luz en la posicion 0 debe ser la MISMA instancia guardada, internamente (composicion real, no una copia).
        Luz luzGuardada = semaforo.getLuces().get(0);
        Luz luzConsultada = semaforo.getLuces().get(0);
        assertSame(luzGuardada, luzConsultada, "Debe devolver la misma referencia, no una copia.");
    }

    @Test
    public void testOrdenYaAsignadaLanzaExcepcion() throws OrdenYaAsignadaException {
        Denuncia denuncia = new Denuncia("D-001", LocalDate.now(), "Calle X", "Calle Y", "Semaforo apagado", "Alta");

        OrdenDeComposicion primera = new OrdenDeComposicion( 1, LocalDate.now(), null, "Primera orden", denuncia);
        OrdenDeComposicion segunda = new OrdenDeComposicion( 2, LocalDate.now(), null, "Segunda orden", denuncia);

        denuncia.asignarOrden(primera); //primera asig

         OrdenYaAsignadaException ex = assertThrows( OrdenYaAsignadaException.class, () -> denuncia.asignarOrden(segunda));

        assertEquals("Orden ya asignada previamente", ex.getMessage());
    }
    
    
    @Test
    public void testFlujoDeReparacionExitoso() {
        List<Miembro> miembros = new ArrayList<>();
        miembros.add(new Miembro(1, "Ana", "Tecnica"));
        miembros.add(new Miembro(2, "Beto", "Tecnico"));
        miembros.add(new Miembro(3, "Caro", "Tecnica"));
        miembros.add(new Miembro(4, "Dario", "Tecnico"));

        EquipoDeControl equipo = new EquipoDeControl("EQ-1", miembros, "Electricidad", "ocupado");

        // Denuncia con denunciante y semaforo para poder notificar al reparar
        Denuncia denuncia = new Denuncia("D-019", LocalDate.now(), "Calle 5", "Calle 13", "Luz quemada", "Media");
        denuncia.setSemaforo(semaforo);
        denuncia.setDenunciante(new Denunciante("Valen", "valen@mail.com"));

        OrdenDeComposicion orden = new OrdenDeComposicion( 10, LocalDate.now(), null, "Cambio de luz", denuncia);
        orden.setEquipo(equipo);

        orden.completar(LocalDate.now()); //el responsable carga la fecha efectiva, la reparacion se completa.

         assertEquals("Libre", equipo.getEstado(),  "El equipo debe quedar libre tras completar la orden"); //equipo libre

        for (Miembro m : equipo.getMiembros()) {
            assertTrue(m.isLibre(),"El miembro " + m.getNombre() + " debe quedar libre");
        }
    }

   
    @ParameterizedTest
    @ValueSource(strings = {"Alta", "Media", "Baja"})
    public void testPrioridadesValidas(String prioridad) {
        Denuncia denuncia = new Denuncia("D-019", LocalDate.now(), "Calle 5", "Calle 13", "Problema generico", prioridad);

        assertTrue(denuncia.esPrioridadValida(), "La prioridad '" + prioridad + "' deberia ser valida.");
    }
    
 // 3 denuncias diferentes sobre el MISMO semaforo
    @Test
    public void testContadorHistoricoDeDenuncias() {
        Denuncia d1 = new Denuncia("D-101", LocalDate.now(), "A", "B", "p1", "Alta");
        Denuncia d2 = new Denuncia("D-102", LocalDate.now(), "A", "B", "p2", "Media");
        Denuncia d3 = new Denuncia("D-103", LocalDate.now(), "A", "B", "p3", "Baja");
       
        service.registrarDenuncia(semaforo, d1);
        service.registrarDenuncia(semaforo, d2);
        service.registrarDenuncia(semaforo, d3);

        assertEquals(3, service.cantidadDenunciasDeSemaforo(semaforo), "El semaforo debe registrar exactamente 3 denuncias en su historico.");
    }
}
