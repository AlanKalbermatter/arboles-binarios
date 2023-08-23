package org.utn;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario {
  NodoABinario raiz;

  public ArbolBinario() {
    raiz = null;
  }

  public void insertar(int valor) {
    raiz = insertarRec(raiz, valor);
  }

  private NodoABinario insertarRec(NodoABinario nodo, int valor) {
    if (nodo == null) {
      return new NodoABinario(valor);
    }

    if (valor < nodo.getValor()) {
      nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
    } else if (valor > nodo.getValor()) {
      nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
    }

    return nodo;
  }

  public void eliminar(int valor) {
    raiz = eliminarRec(raiz, valor);
  }

  private NodoABinario eliminarRec(NodoABinario nodo, int valor) {
    if (nodo == null) {
      return nodo;
    }

    if (valor < nodo.getValor()) {
      nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), valor));
    } else if (valor > nodo.getValor()) {
      nodo.setDerecho(eliminarRec(nodo.getDerecho(), valor));
    } else {
      if (nodo.getIzquierdo() == null) {
        return nodo.getDerecho();
      } else if (nodo.getDerecho() == null) {
        return nodo.getIzquierdo();
      }

      nodo.setValor(encontrarMinimoValor(nodo.getDerecho()));
      nodo.setDerecho(eliminarRec(nodo.getDerecho(), nodo.getValor()));
    }

    return nodo;
  }

  private int encontrarMinimoValor(NodoABinario nodo) {
    int minValor = nodo.getValor();
    while (nodo.getIzquierdo() != null) {
      minValor = nodo.getIzquierdo().getValor();
      nodo = nodo.getIzquierdo();
    }
    return minValor;
  }

  public String recorridoPreorden() {
    StringBuilder result = new StringBuilder();
    recorridoPreorden(raiz, result);
    return result.toString();
  }

  private void recorridoPreorden(NodoABinario nodo, StringBuilder result) {
    if (nodo != null) {
      result.append(nodo.getValor()).append(" ");
      recorridoPreorden(nodo.getIzquierdo(), result);
      recorridoPreorden(nodo.getDerecho(), result);
    }
  }

  public String recorridoInorden() {
    StringBuilder result = new StringBuilder();
    recorridoInorden(raiz, result);
    return result.toString();
  }

  private void recorridoInorden(NodoABinario nodo, StringBuilder result) {
    if (nodo != null) {
      recorridoInorden(nodo.getIzquierdo(), result);
      result.append(nodo.getValor()).append(" ");
      recorridoInorden(nodo.getDerecho(), result);
    }
  }

  public String recorridoPostorden() {
    StringBuilder result = new StringBuilder();
    recorridoPostorden(raiz, result);
    return result.toString();
  }

  private void recorridoPostorden(NodoABinario nodo, StringBuilder result) {
    if (nodo != null) {
      recorridoPostorden(nodo.getIzquierdo(), result);
      recorridoPostorden(nodo.getDerecho(), result);
      result.append(nodo.getValor()).append(" ");
    }
  }

  public String recorridoAmplitud() {
    StringBuilder result = new StringBuilder();
    if (raiz == null) {
      return result.toString();
    }

    Queue<NodoABinario> cola = new LinkedList<>();
    cola.add(raiz);

    while (!cola.isEmpty()) {
      NodoABinario nodo = cola.poll();
      result.append(nodo.getValor()).append(" ");

      if (nodo.getIzquierdo() != null) {
        cola.add(nodo.getIzquierdo());
      }
      if (nodo.getDerecho() != null) {
        cola.add(nodo.getDerecho());
      }
    }

    return result.toString();
  }
}
