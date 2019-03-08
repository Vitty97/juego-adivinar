
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    private String nombre;
    private int puntuacion;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nuevoNombre){
        nombre = nuevoNombre;
        puntuacion = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getNombre(){
        return nombre;
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void setPuntuacion(int intervalo, int numeroIntentos){
        puntuacion = intervalo * 100 - (numeroIntentos * 10);
    }
    
    public String toString(){
        return nombre + " ---> " + puntuacion;
    }
}
