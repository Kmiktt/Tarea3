package org.example.logica;

//Clase Principal, usamos esta clase para polimorfismo
public abstract class Producto{
    String serie;
    public Producto(String x){
        serie=x;
    }
    //Metodo que entrega el sabor
    public abstract String consumir();
    //metodo que entrega el numero se serie
    public String getSerie() {
        return serie;
    }
}
//Para todas las bebidas, no incluye ningún metodo especifico
abstract class Bebida extends Producto{
    public Bebida(String x){
        super(x);
    }
}
//Para todos los dulces, no incluye ningún metodo especifico
abstract class Dulce extends Producto {
    public Dulce (String x){
        super(x);
    }

}
class Sprite extends Bebida {
    public Sprite(String x){
        super(x);
    }

    public String consumir(){
        return ("Sprite");
    }
}
class CocaCola extends Bebida {
    public CocaCola(String x){
        super(x);
    }
    public String consumir(){
        return ("CocaCola");
    }
}
class Fanta extends Bebida {
    public Fanta(String x){
        super(x);
    }
    public String consumir(){
        return ("Fanta");
    }
}
class Super8 extends Dulce {
    public Super8(String x){
        super(x);
    }
    public String consumir(){return ("Super8");}
}
class Snickers extends Dulce {
    public Snickers(String x){
        super(x);
    }
    public String consumir(){return ("Snickers");}
}