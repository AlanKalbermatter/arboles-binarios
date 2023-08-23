package org.utn.binario;

import org.junit.jupiter.api.Test;
import org.utn.binario.ArbolBinario;

import static org.junit.jupiter.api.Assertions.*;

public class ArbolBinarioTests {

  @Test
  public void testRecorridoInorden() {
    ArbolBinario arbol = crearArbolEjemplo();
    assertEquals("2 3 4 5 6 7 8 ", arbol.recorridoInorden());
  }

  @Test
  public void testRecorridoPreorden() {
    ArbolBinario arbol = crearArbolEjemplo();
    assertEquals("5 3 2 4 7 6 8 ", arbol.recorridoPreorden());
  }

  @Test
  public void testRecorridoPostorden() {
    ArbolBinario arbol = crearArbolEjemplo();
    assertEquals("2 4 3 6 8 7 5 ", arbol.recorridoPostorden());
  }

  @Test
  public void testRecorridoAmplitud() {
    ArbolBinario arbol = crearArbolEjemplo();
    assertEquals("5 3 7 2 4 6 8 ", arbol.recorridoAmplitud());
  }

  @Test
  public void testEliminarNodo() {
    ArbolBinario arbol = crearArbolEjemplo();
    arbol.eliminar(5);
    assertEquals("2 3 4 6 7 8 ", arbol.recorridoInorden());
  }

  private ArbolBinario crearArbolEjemplo() {
    ArbolBinario arbol = new ArbolBinario();
    arbol.insertar(5);
    arbol.insertar(3);
    arbol.insertar(7);
    arbol.insertar(2);
    arbol.insertar(4);
    arbol.insertar(6);
    arbol.insertar(8);
    return arbol;
  }
}
