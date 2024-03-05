public abstract class Electrodomestico {
    /*
    marca, precioBase, color, consumo energético (letras entre A y F) y peso.

    Lavadora 1 --> lavadora static Nombre __> a Lavadora1.getNombre() == a
    lavadora2  Nombre __> b lavadora2.getNombre() ==b Lavadora1.getNombre() ==b
    lavadora Nombre __> c
    lavadora Nombre __> d
    lavadora Nombre __> e
     */
    protected String marca;
    protected String color;
    protected char consumo_energetico;
    protected int peso;
    protected int precio_base;
    public static String[] tiposColores = {"blanco", "negro", "rojo", "azul", "gris"};
    public static String tiposConsumos = "ABCDEF";
    public Electrodomestico(){
        marca = "Samsung";
        color = "blanco";
        consumo_energetico = 'F';
        setPrecio_base(100);
        peso = 5;
    }
    public Electrodomestico(String marca, int precio, int peso){
        this.marca = marca;
        setPeso(peso);
        setPrecio_base(precio);
        color = "blanco";
        consumo_energetico = 'F';
    }

    public Electrodomestico(String marca, String color, char consumo_energetico, int peso, int precio_base) {
        this.marca = marca;
        setColor(color);
        setConsumo_energetico(consumo_energetico);
        setPeso(peso);
        setPrecio_base(precio_base);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        int i =0;
        boolean correcto = false;
        while(i< tiposColores.length){
            correcto = color.equalsIgnoreCase(tiposColores[i]);
            if (correcto) {
                this.color = color;
                break;
            }
            i++;
        }
        if (!correcto) this.color = "blanco";

    }

    public char getConsumo_energetico() {
        return consumo_energetico;
    }

    public void setConsumo_energetico(char consumo_energetico) {
        if(tiposConsumos.contains((consumo_energetico + "").toUpperCase())) {
            this.consumo_energetico = (consumo_energetico + "").toUpperCase().charAt(0);
        }
        else this.consumo_energetico = 'F';
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if(peso <= 0) this.peso = 5;
        else this.peso = peso;
    }

    public int getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(int precio_base) { //-1000
        if (precio_base<= 0) precio_base = 100;
        switch (consumo_energetico){
            case 'F':
                precio_base += 10; //30
                break;
            case 'A':
                precio_base += 100;
                break;
            case 'B':
                precio_base += 80;
                break;
            case 'C':
                precio_base += 60;
                break;
            case 'D':
                precio_base += 50;
                break;
            case 'E':
                precio_base += 30;
                break;
        }
        if (peso < 20) peso+=10;
        else if(peso < 50) peso +=50;
        else if (peso < 80) peso +=80;
        else peso += 100;

        this.precio_base = precio_base;
    }
    public static void menu(){
        System.out.println("""
                1) Por defecto
                2) Con marca, precio y peso
                3) Con todos los valores""");
    }

}
