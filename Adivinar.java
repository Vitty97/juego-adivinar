import java.util.*;
import java.time.LocalTime;
/**
 * Write a description of class Adivinar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Adivinar
{

    /**
     * Constructor for objects of class Adivinar
     */
    public Adivinar()
    {
        // initialise instance variables

    }

    /**
    El programa pide al usuario su nombre. luego pide al usuario
    el numero de inicio y el de fin y elige un numero aleatorio entre ambos (ambos incluidos).
    A continuación permite al usuario adivinar el numero en
    sucesivos intentos. Cuando el usuario adivina el numero
    el programa le da una puntuacion en funcion del tiempo (version
    dificil) o del numero de intentos (version facil).
    Al final muestra el cuadro de honor y vuelve a empezar preguntando el
    nombre del nuevo jugador
     */

    public void iniciarJuego() {                
        Random random = new Random();
        int numeroIntentos = 0;        
        String continuar = "si";
        ArrayList<Jugador> cuadroDeHonor = new ArrayList();
        while(continuar.equals("si")){  
            Scanner entrada = new Scanner(System.in);
            System.out.println("Indica tu nombre");
            Jugador jugador = new Jugador(entrada.nextLine());
            System.out.println("Indica el intervalo de numeros (primero numero inicial)");
            int numeroInicial = entrada.nextInt();
            int numeroFinal = entrada.nextInt();
            int numeroAleatorio = random.nextInt(numeroFinal - numeroInicial + 1) + numeroInicial;
            boolean jugando = true;
            while(jugando){            
                System.out.println("Introducce un numero");
                int numeroActual = entrada.nextInt();
                if(numeroActual >= numeroInicial && numeroActual <= numeroFinal){
                    if(numeroActual == numeroAleatorio){
                        System.out.println("Has acertado");
                        jugando = false;
                        jugador.setPuntuacion((numeroFinal + 1) + numeroInicial, numeroIntentos);
                    }
                    else{
                        System.out.println("Vuelve a probar");
                        numeroIntentos++;
                    }
                }
                else{
                    System.out.println("Numero no valido"); 
                }
            }
            
            cuadroDeHonor.add(jugador);
            int i = 0;
            while (i < cuadroDeHonor.size()){
                int j = i;
                Jugador jugadorIntermedio = cuadroDeHonor.get(i);
                int posicion = i;
                while (j > 0 && cuadroDeHonor.get(j - 1).getPuntuacion() <= jugadorIntermedio.getPuntuacion()){
                    posicion = j-1;
                    j  --;
                }
                if (posicion != i){
                    cuadroDeHonor.add(posicion, jugadorIntermedio);
                    cuadroDeHonor.remove(i +1);
                }
                i ++;
            }
            System.out.println("********** PUNTUACIONES **********");
            for(Jugador jugadorActual : cuadroDeHonor){
                System.out.println("*" + jugadorActual + "*");
            }
            System.out.println("**********************************");
            System.out.println("¿Continuar? si/no");
            Scanner entradaDos = new Scanner(System.in);
            continuar = entradaDos.nextLine();
        }
    }

}
