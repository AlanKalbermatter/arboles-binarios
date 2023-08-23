package org.utn.binario;

public class NodoABinario {
  private int valor;
  private NodoABinario izquierdo;
  private NodoABinario derecho;

  public NodoABinario(int valor) {
    this.valor = valor;
    izquierdo = null;
    derecho = null;
  }

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public NodoABinario getIzquierdo() {
    return izquierdo;
  }

  public void setIzquierdo(NodoABinario izquierdo) {
    this.izquierdo = izquierdo;
  }

  public NodoABinario getDerecho() {
    return derecho;
  }

  public void setDerecho(NodoABinario derecho) {
    this.derecho = derecho;
  }
}
