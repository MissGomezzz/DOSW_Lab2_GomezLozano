package Laboratorio2.reto2;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HamburguesaPersonalizadaTest {

    private Map<String, Integer> preciosBase() {
        Map<String, Integer> precios = new LinkedHashMap<>();
        precios.put("Pan", 3000);
        precios.put("Carne", 10000);
        precios.put("Queso", 5000);
        precios.put("Lechuga", 800);
        precios.put("Tomate", 900);
        precios.put("Mayonesa", 500);
        precios.put("BBQ", 600);
        return precios;
    }

    @Test
    void build_conPanYCarne_noDebeLanzarExcepcion() {
        HamburguesaPersonalizada h = new HamburguesaPersonalizada.Builder()
                .conPan("Pan")
                .conCarne("Carne")
                .build();

        assertNotNull(h);
    }

    @Test
    void build_sinPan_debeLanzarExcepcion() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () ->
                new HamburguesaPersonalizada.Builder()
                        .conCarne("Carne")
                        .build()
        );

        assertTrue(ex.getMessage().toLowerCase().contains("pan"));
    }

    @Test
    void build_sinCarne_debeLanzarExcepcion() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () ->
                new HamburguesaPersonalizada.Builder()
                        .conPan("Pan")
                        .build()
        );

        assertTrue(ex.getMessage().toLowerCase().contains("carne"));
    }

    @Test
    void calcularTotal_conQuesoVegetalesYSalsas_debeSumarCorrecto() {
        Map<String, Integer> precios = preciosBase();

        HamburguesaPersonalizada h = new HamburguesaPersonalizada.Builder()
                .conPan("Pan")          // 3000
                .conCarne("Carne")      // 10000
                .conQueso("Queso")      // 5000
                .agregarVegetales("Lechuga") // 800
                .agregarVegetales("Tomate")  // 900
                .agregarSalsas("Mayonesa")   // 500
                .agregarSalsas("BBQ")        // 600
                .build();

        int totalEsperado = 3000 + 10000 + 5000 + 800 + 900 + 500 + 600; // 20800
        assertEquals(totalEsperado, h.calcularTotal(precios));
    }

    @Test
    void calcularTotal_ingredienteNoCatalogado_debeValerCero() {
        Map<String, Integer> precios = preciosBase();

        HamburguesaPersonalizada h = new HamburguesaPersonalizada.Builder()
                .conPan("Pan")               // 3000
                .conCarne("Carne")           // 10000
                .agregarVegetales("Aguacate") // no está en el mapa => 0
                .agregarSalsas("Sriracha")    // no está en el mapa => 0
                .build();

        int totalEsperado = 3000 + 10000;
        assertEquals(totalEsperado, h.calcularTotal(precios));
    }
}
