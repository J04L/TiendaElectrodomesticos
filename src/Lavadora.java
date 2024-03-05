public class Lavadora extends Electrodomestico implements Hidraulico{
    int carga;
    int litrosConsumidos;
    int lavadosRealizados;
    int precioLavados;
    public Lavadora(){
        super();
        carga = 5;
        precioFinal();
        gastoAgua();
    }
    public Lavadora(String marca, int precio, int peso) {
        super(marca, precio, peso);
        carga = 5;
        precioFinal();
        gastoAgua();
    }
    public Lavadora(String marca, String color, char consumo_energetico, int peso, int precio_base, int carga) {
        super(marca, color, consumo_energetico, peso, precio_base);
        setCarga(carga);
        precioFinal();
        gastoAgua();
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        if (carga <= 0) this.carga = 5;
        else this.carga = carga;
    }
    public void precioFinal(){
        if (carga >30) precio_base += 30;
    }
    public void gastoAgua(){
        if(carga < 5){
            litrosConsumidos = 10;
            precioLavados = 5;
        } else if (carga < 7) {
            litrosConsumidos = 15;
            precioLavados = 10;
        } else if (carga > 7) {
            litrosConsumidos = 20;
            precioLavados = 15;
        }
    }
    public int[] lavar(int lavados){
        return new int[]{litrosConsumidos*lavados, precioLavados*lavados};
    }
}
