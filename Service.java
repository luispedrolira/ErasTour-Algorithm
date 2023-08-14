/**
 * Universidad del Valle de Guatemala
 * @author Luis Pedro Lira - 23669
 * @version 1.0
 */

import java.util.Random;

public class Service {
    private Random tokenUsuario;
    private Random rangoA;
    private Random rangoB;

    public Service() {
        tokenUsuario = new Random();
        rangoA = new Random();
        rangoB = new Random();
    }
    /**
     * 
     * Retorna de una vez el numero Aleatorio 1 - 15,000 -> El token del usuario
     * @return tokenUsuario
     */
    public int getTokenUsuario() {
        return tokenUsuario.nextInt( 15000) + 1;
    }
    /**
     * Retorna de una vez el numero Aleatorio - 15,000 -> El rango A
     * @return rangoA
     */
    public int getRangoA() {
        return rangoA.nextInt(1, 15000);
    }
    /**
     * Retorna de una vez el numero Aleatorio - 15,000 -> El rango B
     * @return rangoB
     */
    public int getRangoB() {
        return rangoB.nextInt(1, 15000);
    }
}