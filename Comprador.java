/**
 * Universidad del Valle de Guatemala
 * @author Luis Pedro Lira - 23669
 * @version 1.0
 */

public class Comprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private int presupuesto;

    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @return cantidadBoletos
     */
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }
    /**
     * 
     * @param cantidadBoletos
     */
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }
    /**
     * 
     * @return presupuesto
     */
    public int getPresupuesto() {
        return presupuesto;
    }
    /**
     * 
     * @param presupuesto
     */
    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
    /**
     * 
     * Al presupuesto actual se le resta: 
     *  Lo que tiene actualmente presupuesto 
     *  MENOS
     *  el precio de la localidad dependiendo de las entradas del usuario.
     * @param precioLocalidad
     * @param entradasUsuario
     * @return presupuesto
     */
    public int restarPresupuesto(int precioLocalidad, int entradasUsuario) {
        presupuesto = presupuesto - (precioLocalidad*entradasUsuario);
        return presupuesto;
    }
}