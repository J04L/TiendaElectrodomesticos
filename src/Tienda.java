import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tienda {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Electrodomestico> tienda = new ArrayList<>();
    public static void main(String[] args){
        int opcion =0;
        while(opcion != 7){
            menu();
            opcion =leerInt("> ");
            switch (opcion){
                case 1:
                    intrLavadora();
                    break;
                case 2:
                    intrTelevision();
                    break;
                case 3:
                    System.out.println(sumarLavadoras());
                    break;
                case 4:
                    System.out.println(sumarElectrodomesticos());
                    break;
                case 5:
                    System.out.println(cantidadHidraulicos());
                    break;
                case 6:
                    hacerLavados();
                    break;
                case 7: break;
                default:
                    System.out.println("-----[ERROR] fuera de rango");
                    break;
            }
        }
    }

    private static void hacerLavados() {
        Random random = new Random();
        int precio =0, litros =0;
        for (Electrodomestico e : tienda){
            if (e instanceof Lavadora lavadora){
                int lavados = random.nextInt(10)+1;
                int[] lavado = lavadora.lavar(lavados);
                litros += lavado[0];
                precio += lavado[1];
            }
        }
        System.out.println("Precio por todos los lavados: " + precio +
                "\nLitros consumidos: " + litros);
    }

    private static int cantidadHidraulicos() {
        int i =0;
        for (Electrodomestico e : tienda){
            if (e instanceof Hidraulico){
                i++;
            }
        }
        return i;
    }

    private static int sumarElectrodomesticos() {
        int i =0;
        for (Electrodomestico e : tienda){
            i+=e.precio_base;
        }
        return  i;
    }

    private static int sumarLavadoras() {
        int i =0;
        for (Electrodomestico e : tienda){
            if (e instanceof Lavadora) i+=e.precio_base;
        }
        return i;
    }
    private static int sumarLavadorasR(int i, int suma){
        if (i == tienda.size()) return 0;
        if(tienda.get(i) instanceof Lavadora){
            return suma + sumarLavadorasR(i+1, suma);
        }else return suma;
    }
    private static void intrTelevision() {
        Electrodomestico.menu();
        int opcion = leerInt("> ");
        switch (opcion){
            case 1:
                tienda.add(new Television());
                break;
            case 2: case 3:
                System.out.print("marca: ");
                String marca = scan.next();
                int precio = leerInt("precio: ");
                int peso = leerInt("peso: ");
                if (opcion ==2) tienda.add(new Television(marca, precio, peso));
                else {
                    System.out.print("color: ");
                    String color = scan.next();
                    char consumo_energetico = leerChar("consumo energético: ");
                    int pulgadas = leerInt("pulgadas: ");
                    System.out.println("Es smartTV? --> ");
                    boolean smartTV = scan.next().equalsIgnoreCase("si");
                    tienda.add(new Television(marca, color, consumo_energetico, peso, precio, pulgadas, smartTV));
                }
                break;
            default:
                System.out.println("-----[ERROR] fuera de rango");
                break;
        }
    }
    private static void intrLavadora() {
        Electrodomestico.menu();
        int opcion = leerInt("> ");
        switch (opcion){
            case 1:
                tienda.add(new Lavadora());
                break;
            case 2: case 3:
                System.out.print("marca: ");
                String marca = scan.next();
                int precio = leerInt("precio: ");
                int peso = leerInt("peso: ");
                if (opcion ==2) tienda.add(new Lavadora(marca, precio, peso));
                else {
                    System.out.print("color: ");
                    String color = scan.next();
                    char consumo_energetico = leerChar("consumo energético: ");
                    int carga = leerInt("carga: ");
                    tienda.add(new Lavadora(marca, color, consumo_energetico, peso, precio, carga));
                }
                break;
            default:
                System.out.println("-----[ERROR] fuera de rango");
                break;
        }
    }
    private static char leerChar(String pregunta){
        String letra = "";
        while(true){
            try{
                System.out.println(pregunta);
                letra = scan.next();
                if (letra.length() == 1) Integer.parseInt(letra);
                System.out.println("-----[ERROR] Se esperaba una letra");
            }catch (NumberFormatException ex){
                return letra.charAt(0);
            }
        }
    }
    private static int leerInt(String pregunta) {
        while(true){
            try {
                System.out.print(pregunta);
                return Integer.parseInt(scan.next());
            }catch (NumberFormatException ex){
                System.out.println("-----[ERROR] No se esperaba una letra");
            }
        }
    }
    public static void menu(){
        System.out.println("""
            1)Introducir Lavadora
            2)Introducir Televisión
            3)Sumar el precio de todas las lavadoras
            4)Sumar el precio total de todos los electrodomésticos
            5) Contar los electrodomésticos que utilicen agua
            6)Hacer lavados con cada lavadora""");
    }
}
