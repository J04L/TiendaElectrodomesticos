public class Television extends Electrodomestico {
    int pulgadas;
    boolean smartTV;

    public Television() {
        super();
        pulgadas = 50;
        smartTV = true;
    }

    public Television(String marca, int precio, int peso) {
        super(marca, precio, peso);

    }

    public Television(String marca, String color, char consumo_energetico, int peso, int precio_base, int pulgadas, boolean smartTV) {
        super(marca, color, consumo_energetico, peso, precio_base);
        this.pulgadas = pulgadas;
        this.smartTV = smartTV;
        precioFinal();
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        if(pulgadas <=0) this.pulgadas = 50;
        else this.pulgadas = pulgadas;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    public void setSmartTV(boolean smartTV) {
        this.smartTV = smartTV;
    }
    public void precioFinal(){
        if (pulgadas >40) precio_base += (int) (precio_base*0.3);
        if (smartTV) precio_base += 50;
    }
}
