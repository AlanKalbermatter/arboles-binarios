package org.utn.nArio;

import java.util.ArrayList;
import java.util.List;

public class NodoNArio<T> {
  private T valor;
  private List<NodoNArio<T>> hijos;

  public NodoNArio(T valor) {
    this.valor = valor;
    hijos = new ArrayList<>();
  }

  public void agregarHijo(NodoNArio<T> hijo) {
    hijos.add(hijo);
  }

  public T getValor() {
    return valor;
  }

  public void setValor(T valor) {
    this.valor = valor;
  }

  public List<NodoNArio<T>> getHijos() {
    return hijos;
  }

  public void setHijos(List<NodoNArio<T>> hijos) {
    this.hijos = hijos;
  }
}
