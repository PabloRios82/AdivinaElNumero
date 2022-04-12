import java.util.Scanner;

public class AdivinaElNumero {
    private Scanner entrada=new Scanner(System.in);
    private boolean juegoActivo=true;

    public void jugar(){

        String nombreJugador=obtenerNombreJugador();

        while(juegoActivo){
            int intentos=0;
            int min=0;
            int max=100;
            int numeroJuego=obtenerNumeroAleatorio(1,100);
            System.out.println(numeroJuego);
            System.out.printf("%s, he escogido un numero entre %d y %d, adivinalo\n",nombreJugador,min,max);
            int numeroJugador;
            do {
                numeroJugador=escogerNumero();
                mensaje(numeroJuego,numeroJugador);
                intentos++;
            }while(numeroJuego!=numeroJugador);
            System.out.printf("Has Ganado!!!\nFelicitaciones!!!\nIntentos %d\n",intentos);
            juegoActivo=jugarNuevamente();
        }
    }

    private int obtenerNumeroAleatorio(int min,int max){
        return min+(int)(Math.random() * (max-min) +1);
    }

    private String obtenerNombreJugador(){
        System.out.println("Hola, Cual es tu nombre?");
        String nombreJugador=entrada.nextLine();
        System.out.printf("Bienvenido %s, vamos a comenzar\n",nombreJugador);
        return nombreJugador;
    }

   private int escogerNumero(){
       System.out.println("Escoja un numero");
       return entrada.nextInt();
   }

   private void mensaje (int numeroJuego, int numeroJugador){
       if (numeroJuego < numeroJugador) {
           System.out.println("El numero es muy alto, intenta otra vez");
       } else if (numeroJuego > numeroJugador) {
           System.out.println("El numero es muy bajo, intenta otra vez");
       }
   }

   public boolean jugarNuevamente(){
       System.out.println("Quiere jugar nuevamente?\n1. Si\n2. No\n");
       int respuesta=entrada.nextInt();
       if(respuesta==1){
           System.out.println("Genial! Juguemos otra vez!\n");
           return true;
       }else {
           System.out.println("Fin del juego! Gracias por participar!\n");
           return false;
       }
   }
}
