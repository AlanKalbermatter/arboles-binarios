package org.utn.nArio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArbolNArioTests {

  @Test
  public void testAltura() {
    ArbolNArio<String> arbol = new ArbolNArio<>("A");
    NodoNArio<String> raiz = arbol.obtenerRaiz();

    assertEquals(1, arbol.altura());

    arbol.agregarHijo(raiz, "B");
    arbol.agregarHijo(raiz, "C");
    arbol.agregarHijo(raiz, "D");

    NodoNArio<String> nodoB = raiz.getHijos().get(0);
    arbol.agregarHijo(nodoB, "E");
    arbol.agregarHijo(nodoB, "F");

    NodoNArio<String> nodoC = raiz.getHijos().get(1);
    arbol.agregarHijo(nodoC, "G");

    assertEquals(3, arbol.altura());
  }

  @Test
  public void testContarNodos() {
    ArbolNArio<Integer> arbol = new ArbolNArio<>(1);
    NodoNArio<Integer> raiz = arbol.obtenerRaiz();

    assertEquals(1, arbol.contarNodos());

    arbol.agregarHijo(raiz, 2);
    arbol.agregarHijo(raiz, 3);
    arbol.agregarHijo(raiz, 4);

    NodoNArio<Integer> nodoB = raiz.getHijos().get(0);
    arbol.agregarHijo(nodoB, 5);
    arbol.agregarHijo(nodoB, 6);

    NodoNArio<Integer> nodoC = raiz.getHijos().get(1);
    arbol.agregarHijo(nodoC, 7);

    assertEquals(7, arbol.contarNodos());
  }

  @Test
  public void testContiene() {
    ArbolNArio<String> arbol = new ArbolNArio<>("A");
    NodoNArio<String> raiz = arbol.obtenerRaiz();

    assertFalse(arbol.contiene("B"));

    arbol.agregarHijo(raiz, "B");
    arbol.agregarHijo(raiz, "C");
    arbol.agregarHijo(raiz, "D");

    NodoNArio<String> nodoB = raiz.getHijos().get(0);
    arbol.agregarHijo(nodoB, "E");
    arbol.agregarHijo(nodoB, "F");

    assertTrue(arbol.contiene("B"));
    assertTrue(arbol.contiene("F"));
    assertFalse(arbol.contiene("X"));
  }
}
