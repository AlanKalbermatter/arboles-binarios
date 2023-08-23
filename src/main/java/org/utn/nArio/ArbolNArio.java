package org.utn.nArio;

import org.utn.nArio.NodoNArio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArbolNArio<T> {
  NodoNArio<T> raiz;

  public ArbolNArio(T valor) {
    raiz = new NodoNArio<>(valor);
  }

  public void agregarHijo(NodoNArio<T> padre, T valorHijo) {
    NodoNArio<T> nuevoHijo = new NodoNArio<>(valorHijo);
    padre.agregarHijo(nuevoHijo);
  }

  public NodoNArio<T> obtenerRaiz() {
    return raiz;
  }

  public int altura() {
    return calcularAltura(raiz);
  }

  private int calcularAltura(NodoNArio<T> nodo) {
    if (nodo == null) {
      return 0;
    }

    int alturaMax = 0;
    for (NodoNArio<T> hijo : nodo.getHijos()) {
      int alturaHijo = calcularAltura(hijo);
      alturaMax = Math.max(alturaMax, alturaHijo);
    }

    return alturaMax + 1;
  }

  public List<T> recorridoEnAmplitud() {
    List<T> resultado = new ArrayList<>();
    if (raiz == null) {
      return resultado;
    }

    Queue<NodoNArio<T>> cola = new LinkedList<>();
    cola.add(raiz);

    while (!cola.isEmpty()) {
      NodoNArio<T> nodo = cola.poll();
      resultado.add(nodo.getValor());

      for (NodoNArio<T> hijo : nodo.getHijos()) {
        cola.add(hijo);
      }
    }

    return resultado;
  }

  public int contarNodos() {
    return contarNodos(raiz);
  }

  private int contarNodos(NodoNArio<T> nodo) {
    if (nodo == null) {
      return 0;
    }

    int contador = 1;
    for (NodoNArio<T> hijo : nodo.getHijos()) {
      contador += contarNodos(hijo);
    }

    return contador;
  }

  public boolean contiene(T valor) {
    return contiene(raiz, valor);
  }

  private boolean contiene(NodoNArio<T> nodo, T valor) {
    if (nodo == null) {
      return false;
    }

    if (nodo.getValor().equals(valor)) {
      return true;
    }

    for (NodoNArio<T> hijo : nodo.getHijos()) {
      if (contiene(hijo, valor)) {
        return true;
      }
    }

    return false;
  }

}
