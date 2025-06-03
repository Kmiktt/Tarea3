package org.example.logica;

import java.util.ArrayList;

/**Objeto encargado de comprar productos con moneda ingresada al inicializarse, y
 * dejar registrado el sabor y el vuelto de la compra si esta es exitosa.
 * La compra solo se realiza al inicializar el objeto, tras su creación solo se
 * puede consultar por el sabor y por el vuelto.*/
public class Comprador{
    private String sabor;
    private int vuelto = 0;
    public Producto manoProd;
    private Expendedor expen;
    private ArrayList<Moneda> monedero;
    /**Metodo constructor, se encarga de intentar comprar el producto indicada con la
     * moneda que se le entrega, registrando el sabor de este y el vuelto que se le devolvió.
     * @param exp Referencia al expendedor al cual se le va a comprar el Producto*/
    public Comprador(Expendedor exp)  {
        expen=exp;
    }

    public void ComprarBebida(int i,int cualBebida) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Moneda m;
        m=monedero.remove(i);
        expen.comprarProducto(m,cualBebida);
    }

    public void getBebida(){
        manoProd=expen.getProducto();
        if (manoProd==null) sabor = null;
        else sabor = manoProd.consumir();
    }

    public void SacarVuelto(){
        Moneda t = expen.getVuelto();
        while (t!=null) {
            vuelto += t.getValor();
            t = expen.getVuelto();
        }
    }

    public String queConsumiste(){
        return sabor;
    }

    public ArrayList<Moneda> getMonedero() {
        return monedero;
    }
}