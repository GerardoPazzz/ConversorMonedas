import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ConsultarAPI consulta = new ConsultarAPI();
    Moneda moneda = null;
    public void mostrarMenu1(){
        boolean salir = false;
        while (!salir) {
            System.out.print(
                    "*******************************************************" +
                            "\nBienvenid@ al conversor de monedas de GerardoPazzz" +
                            "\n\nEscoja una divisa porfavor: " +
                            "\n 1) PEN" +
                            "\n 2) USD" +
                            "\n 3) BRL" +
                            "\n 4) ARS" +
                            "\n 5) CLP" +
                            "\n 0) Salir" +
                            "\nIngrese la opcion deseada: ");
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("©Todos los derechos reservados by: GerardoPazzz ");
                        salir = true;
                        sc.close();
                        break;
                    case 1:
                        moneda = consulta.obtenerMoneda("PEN");
                        System.out.println("-------PEN-------");
                        mostrarMenu2(cantidad());
                        break;
                    case 2:
                        moneda = consulta.obtenerMoneda("USD");
                        System.out.println("-------USD-------");
                        mostrarMenu2(cantidad());
                        break;
                    case 3:
                        moneda = consulta.obtenerMoneda("BRL");
                        System.out.println("-------BRL-------");
                        mostrarMenu2(cantidad());
                        break;
                    case 4:
                        moneda = consulta.obtenerMoneda("ARS");
                        System.out.println("-------ARS-------");
                        mostrarMenu2(cantidad());
                        break;
                    case 5:
                        moneda = consulta.obtenerMoneda("CLP");
                        System.out.println("-------CLP-------");
                        mostrarMenu2(cantidad());
                        break;
                    default:
                        System.out.println("Opcion no valida !!!");
                }
            }catch(InputMismatchException e){
                System.out.println("Ingresar un valor numerico !");
                sc.next();
            }
        }
    }
    public void mostrarMenu2(double cantidad){
        System.out.println("Su valor en USD es: " + cantidad * moneda.USD());
        System.out.println("Su valor en PEN es: " + cantidad * moneda.PEN());
        System.out.println("Su valor en BRL es: " + cantidad * moneda.BRL());
        System.out.println("Su valor en ARS es: " + cantidad * moneda.ARS());
        System.out.println("Su valor en CLP es: " + cantidad * moneda.CLP());
    }
    public double cantidad (){
        System.out.print("Ingrese la cantidad que desee: ");
        return sc.nextDouble();
    }
}
