package org.example.logica;

/** Encargado de almacenar Productos, recibir Monedas y entregar el
producto apropiado si el valor de la moneda es mayor o igual al del
producto*/
public class Expendedor {
    private Producto producto=null;
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snicker;
    private Deposito<Moneda> monVu;
    private Deposito<Moneda> monDepot;

    /**Constructor de Expendedor.
     * Recibe la cantidad i de productos que va a tener cada deposito,
     * y le entrega a cada deposito de Producto i del producto correspondiente.
     * @param i La cantidad de productos que tendrá cada depósito.*/
    public Expendedor(int i){
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta = new Deposito<Producto>();
        super8 = new Deposito<Producto>();
        snicker = new Deposito<Producto>();
        monVu = new Deposito<Moneda>();
        Producto b;
        for (int x =0; x<i; x++){
            b= new CocaCola("COCA"+Integer.toString((int)(Math.random() * 1000)));
            coca.add(b);
            b = new Sprite("SPRT"+Integer.toString((int)(Math.random() * 1000)));
            sprite.add(b);
            b = new Fanta("FNTA"+Integer.toString((int)(Math.random() * 1000)));
            fanta.add(b);
            b = new Snickers("SNCK"+Integer.toString((int)(Math.random() * 1000)));
            snicker.add(b);
            b = new Super8("SUPR"+Integer.toString((int)(Math.random() * 1000)));
            super8.add(b);
        }
    }
    /**El expendedor recibe una moneda y el número del producto a comprar,
     * y checkea si es que este numero concuerda con el de algún producto (asignados
     * en el enum). Si es asi, calcula el vuelto a devolver, y devuelve el producto
     * si el vuelto es mayor o igual a 0. En caso de tener vuelto mayor a 0, agrega
     * monedas al deposito de monedas para que el comprador despues recupere.
     * @param m Moneda ingresada al expendedor, se obtiene su valor con m.getValor()
     * @param x Numero ingresado al expendedor, se utiliza para checkear que producto
     * quiere comprar el comprador*/
    public void comprarProducto(Moneda m, int x) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        Producto p=null;
        int vuelto=0;
        boolean check = false;
        if (m!=null) {
            if (x == Productos.COCACOLA.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.COCACOLA.getPrecio();
                if (vuelto>=0){
                    p = coca.get();
                }
            }
            if (x == Productos.SPRITE.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.SPRITE.getPrecio();
                if (vuelto>=0){
                    p = sprite.get();
                }
            }
            if (x == Productos.FANTA.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.FANTA.getPrecio();
                if (vuelto>=0){
                    p = fanta.get();
                }
            }
            if (x == Productos.SNICKER.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.SNICKER.getPrecio();
                if (vuelto>=0){
                    p = snicker.get();
                }
            }
            if (x == Productos.SUPER8.getNum()){
                check = true;
                vuelto = m.getValor()-Productos.SUPER8.getPrecio();
                if (vuelto>=0){
                    p = super8.get();
                }
            }
            // dependiendo del problema se lanza la excepción correspondiente:
            if (!check){
                monVu.add(m);
                throw new NoHayProductoException();
            }
            if (vuelto<0){
                monVu.add(m);
                throw new PagoInsuficienteException();
            }
            if (p==null){
                monVu.add(m);
                throw new NoHayProductoException();
            }
            //vuelto
            Moneda place;
            while(vuelto-1000>=0){
                place = new Moneda1000();
                monVu.add(place);
                vuelto-=1000;
            }
            while(vuelto-500>=0){
                place = new Moneda500();
                monVu.add(place);
                vuelto-=500;
            }
            while(vuelto-100>=0){
                place = new Moneda100();
                monVu.add(place);
                vuelto-=100;
            }
            monDepot.add(m);
        }
        else throw new PagoIncorrectoException();
        producto=p;
    }
    /** Getter de moneda en deposito de vuelto, null si no quedan monedas
     * @return Moneda de vuelto */
    public Moneda getVuelto(){
        return monVu.get();
    }

    //saca el producto de la cajita
    public Producto getProducto() {
        Producto aux=producto;
        producto=null;
        return aux;
    }

    public <T> Deposito<Producto> getCoca(){
        return coca;
    }

    public Deposito<Producto> getSuper8() {
        return super8;
    }

    public Deposito<Producto> getFanta() {
        return fanta;
    }

    public Deposito<Producto> getSnicker() {
        return snicker;
    }

    public Deposito<Producto> getSprite() {
        return sprite;
    }
}