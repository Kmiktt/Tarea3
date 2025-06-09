package org.example.logica;

import org.example.GUI.PanelExpendedor;

import java.util.ArrayList;

/**Objeto encargado de comprar productos con moneda ingresada al inicializarse, y
 * dejar registrado el sabor y el vuelto de la compra si esta es exitosa.
 * La compra solo se realiza al inicializar el objeto, tras su creación solo se
 * puede consultar por el sabor y por el vuelto.*/
public class Comprador{
    public Producto manoProd;
    private Expendedor expen;
    private ArrayList<Moneda> monedero;
    /**Metodo constructor, se encarga de intentar comprar el producto indicada con la
     * moneda que se le entrega, registrando el sabor de este y el vuelto que se le devolvió.
     * @param exp Referencia al expendedor al cual se le va a comprar el Producto*/
    public Comprador(Expendedor exp)  {
        expen=exp;
        monedero = new ArrayList<Moneda>();
    }

    public void ComprarBebida(int i,int cualBebida) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        expen = PanelExpendedor.getExpendedor();
        Moneda m;
        m=monedero.remove(i);
        expen.comprarProducto(m,cualBebida);
    }

    public void getBebida(){
        manoProd=expen.getProducto();
    }
    /**
    Metodo que Saca el vuelto del Expendedor asignado y lo deja en su monedero
     */
    public void SacarVuelto(){
        Moneda t = expen.getVuelto();
        while (t!=null) {
            monedero.add(t);
            t = expen.getVuelto();
        }
    }
    /**
     Metodo que agrega una moneda asignada en su monedero
     * @param o Referencia a Moneda que quieras agregar
     */
    public void AgregarMoneda(Moneda o){
        monedero.add(o);
        monedero.sort(null);
        monedero.reversed();
    }

    public ArrayList<Moneda> getMonedero() {
        return monedero;
    }
}