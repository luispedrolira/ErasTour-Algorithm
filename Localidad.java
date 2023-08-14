/**
 * Universidad del Valle de Guatemala
 * @author Luis Pedro Lira - 23669
 * @version 1.0
 */

public class Localidad {

    private String nombreLocalidad;
    private int entradasDisponibles;
    private int precioLocalidad;
    private int entradasVendidas;


    public Localidad(String nombreLocalidad, int precioLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
        this.entradasDisponibles = 20;
        this.precioLocalidad = precioLocalidad;
    }
    /**
     * 
     * @return entradasDisponibles
     */
    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }
    /** 
     * 
     * @param entradasDisponibles the entradasDisponibles to set
     */
    public void setEntradasDisponibles(int entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
    }
    /**
     * 
     * @return nombreLocalidad
     */
    public String getNombreLocalidad() {
        return nombreLocalidad;
    }
    /**
     * 
     * @param nombreLocalidad the nombreLocalidad to set
     */
    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }
    /**
     * 
     * @return precioLocalidad
     */
    public int getPrecioLocalidad() {
        return precioLocalidad;
    }
    /**
     * 
     * @param precioLocalidad
     */
    public void setPrecioLocalidad(int precioLocalidad) {
        this.precioLocalidad = precioLocalidad;
    }
    /**
     * 
     * @param entradasVendidas the entradasVendidas to set
     */
    public int getEntradasVendidas() {
        return entradasVendidas;
    }
    /**
     * 
     * @param entradasVendidas
     */
    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = this.entradasVendidas + entradasVendidas;
    }
    /***
     * 
     * @param entradasUsuario
     */

    public synchronized void comprarEntrada(int entradasUsuario) {
        if (entradasDisponibles > 0) {
            setEntradasDisponibles(entradasDisponibles - entradasUsuario);
            System.out.println("Entrada comprada!!");
        } else {
            System.out.println("No quedan entradas");
        }
    }
}