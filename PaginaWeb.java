/**
 * Universidad del Valle de Guatemala
 * @author Luis Pedro Lira - 23669
 * @version 1.0
 */


import java.util.concurrent.TimeUnit;
import java.util.Random;

public class PaginaWeb {
    public static void main(String[] args) {
       boolean isRunning = true;
       Comprador comprador = new Comprador();
       Localidad localidad1 = new Localidad("Localidad 1", 100);
       Localidad localidad2 = new Localidad("Localidad 2", 500);
       Localidad localidad3 = new Localidad("Localidad 3", 1000);
       
       while (isRunning) {
            System.out.println("\n========= ERAS TOUR by Taylor Swift =========");
            System.out.println("1. Nuevo comprador\n2. Nueva solicitud de boletos\n3. Consultar Disponibilidad Total\n4. Consultar Disponibilidad Individual\n5. Reporte de caja\n6. Consultar Presupuesto Sobrante\n7. Salir\n");
            System.out.print("Ingrese una opcion: ");
            int opcion = Integer.parseInt(System.console().readLine());

            switch (opcion){
                case 1: 
                    comprador = nuevoComprador();
                    break;
                case 2:
                    if (comprador.getNombre() == null) {
                        System.out.println("Debe crear un comprador primero");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    } else {
                        nuevaSolicitud(localidad1, localidad2, localidad3, comprador);
                        break;
                    }
                    
                case 3:
                    disponibilidadTotal(localidad1, localidad2, localidad3);
                    break;
                case 4:
                    disponibilidadIndividual(localidad1, localidad2, localidad3);
                    break;
                case 5:
                    reporteCaja(localidad1, localidad2, localidad3);
                    break;
                case 6:
                    presupuestoPendiente(comprador);
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
       }
    }

    /** OPCIÓN 1
     * 
     * Retorna un nuevo comprador, se instancia un nuevo comprador 
     * y se le piden los datos al usuario.
     * @return comprador
     */

    private static Comprador nuevoComprador() {
        System.out.println("======= NUEVO COMPRADOR =======");
        Comprador comprador = new Comprador();
        System.out.println("Ingrese su nombre: ");
        comprador.setNombre(System.console().readLine());
        System.out.println("Ingrese su email: ");
        comprador.setEmail(System.console().readLine());
        System.out.println("Ingrese la cantidad de boletos que desea comprar: ");
        comprador.setCantidadBoletos(Integer.parseInt(System.console().readLine()));
        System.out.println("Ingrese su presupuesto: ");
        comprador.setPresupuesto(Integer.parseInt(System.console().readLine()));
        System.out.println("Creando nuevo comprador. Por favor, espere...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Comprador creado con exito!");

        return comprador;
    }
    /** OPCIÓN 2
     * 
     * Crea una nueva solicitud de boletos, se hace todo el proceso de validacion:
     *   --> Las validaciones para ver si el usuario puede comprar una entrada o no
     *   --> se hace en orden de PRIORIDAD, es decir, primero se valida si existen todavia entradas
     *   --> en la localidad solicitada; luego se valida las entradas que quiere el usuario
     *   --> existen en la localidad solicitada; y por ultimo se valida si el presupuesto del
     *   --> usuario es suficiente para comprar dichas entradas.
     * @param comprador
     * @param localidad
     * @param control
     * @return control
     */

    private static void nuevaSolicitud(Localidad localidad1, Localidad localidad2, Localidad localidad3, Comprador comprador) {
        System.out.println("======= NUEVA SOLICITUD =======");
        Service service = new Service();

        if ((service.getTokenUsuario() >= service.getRangoA()) && (service.getTokenUsuario() <= service.getRangoB())){
            Random random = new Random();
            int numeroAleatorio = random.nextInt(3) + 1;

            boolean control = true;
            switch (numeroAleatorio){
                case 1: // Se asigna la localidad 1
                    System.out.println("SE TE ASIGNO LA LOCALIDAD 1!! Espere un momento...");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
        }
                    if (control == true){
                        control = validarDisponibilidad(comprador, localidad1, control);
                        
                        if (control == true){
                            control = validarBoletos(comprador, localidad1, control);

                            if (control == true){
                                control = validarPresupuesto(comprador, localidad1, control);

                                if (control == true){
                                    comprador.setPresupuesto(comprador.restarPresupuesto(localidad1.getPrecioLocalidad(), comprador.getCantidadBoletos()));
                                    localidad1.comprarEntrada(comprador.getCantidadBoletos());
                                    localidad1.setEntradasVendidas(comprador.getCantidadBoletos());
                                    System.out.println("FELICIDADES " + comprador.getNombre() + ", SU SOLICITUD FUE ACEPTADA!!");
                                }
                            }
                        }
                    }
                    break;

                case 2: // Se asigna la localidad 2
                    System.out.println("SE TE ASIGNO LA LOCALIDAD 2!! Espere un momento...");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    if (control == true){
                        control = validarDisponibilidad(comprador, localidad2, control);
                        
                        if (control == true){
                            control = validarBoletos(comprador, localidad2, control);

                            if (control == true){
                                control = validarPresupuesto(comprador, localidad2, control);

                                if (control == true){
                                    comprador.setPresupuesto(comprador.restarPresupuesto(localidad2.getPrecioLocalidad(), comprador.getCantidadBoletos()));
                                    localidad2.comprarEntrada(comprador.getCantidadBoletos());
                                    localidad2.setEntradasVendidas(comprador.getCantidadBoletos());
                                    System.out.println("FELICIDADES " + comprador.getNombre() + ", SU SOLICITUD FUE ACEPTADA!!");
                                }
                            }
                        }
                    }
                    break;

                case 3: // Se asigna la localidad 3
                    System.out.println("SE TE ASIGNO LA LOCALIDAD 3!! Espere un momento...");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }        

                    if (control == true){
                        control = validarDisponibilidad(comprador, localidad3, control);
                        
                        if (control == true){
                            control = validarBoletos(comprador, localidad3, control);

                            if (control == true){
                                control = validarPresupuesto(comprador, localidad3, control);

                                if (control == true){
                                    comprador.setPresupuesto(comprador.restarPresupuesto(localidad3.getPrecioLocalidad(), comprador.getCantidadBoletos()));
                                    localidad3.comprarEntrada(comprador.getCantidadBoletos());
                                    localidad3.setEntradasVendidas(comprador.getCantidadBoletos());
                                    System.out.println("FELICIDADES " + comprador.getNombre() + ", SU SOLICITUD FUE ACEPTADA!!");
                                }
                            }
                        }
                    }
                    break;
                    
            }
        } else {
            System.out.println("Lo sentimos "+comprador.getNombre()+", su solicitud no fue aceptada. Por favor, intente de nuevo mas tarde.");
        }
        
    }
    
    /** OPCIÓN 3
     * 
     * Muestra la disponibilidad total de entradas de todas las localidades.
     * @param localidad1
     * @param localidad2
     * @param localidad3
     */
    
    private static void disponibilidadTotal(Localidad localidad1, Localidad localidad2, Localidad localidad3) {
        System.out.println("======= DISPONIBILIDAD TOTAL =======");
        System.out.println("Consultando disponibilidad total. Por favor, espere...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("L O C A L I D A D ==== D I S P O N I B L E S ==== V E N D I D A S");
        System.out.println(localidad1.getNombreLocalidad()+"                     "+localidad1.getEntradasDisponibles()+"                       "+localidad1.getEntradasVendidas());
        System.out.println(localidad2.getNombreLocalidad()+"                     "+localidad2.getEntradasDisponibles()+"                       "+localidad2.getEntradasVendidas());
        System.out.println(localidad3.getNombreLocalidad()+"                     "+localidad3.getEntradasDisponibles()+"                       "+localidad3.getEntradasVendidas());
    }
    
    /** OPCIÓN 4
     * 
     * Muestra la disponibilidad de entradas de una localidad en específico.
     * @param localidad1
     * @param localidad2
     * @param localidad3
     */

    private static void disponibilidadIndividual(Localidad localidad1, Localidad localidad2, Localidad localidad3){
        System.out.println("======= DISPONIBILIDAD INDIVIDUAL =======");
        System.out.println("¿Qué localidad desea consultar?");
        String localidadAConsultar = System.console().readLine();

        switch (localidadAConsultar){
            case "Localidad 1":
                System.out.println("Consultando disponibilidad de la localidad 1. Por favor, espere...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D I S P O N I B L E S ==== V E N D I D A S");
                System.out.println("         "+localidad1.getEntradasDisponibles()+"                        "+localidad1.getEntradasVendidas());
                break;
            
            case "Localidad 2":
                System.out.println("Consultando disponibilidad de la localidad 2. Por favor, espere...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D I S P O N I B L E S ==== V E N D I D A S");
                System.out.println("         "+localidad2.getEntradasDisponibles()+"                        "+localidad1.getEntradasVendidas());
                break;
            
            case "Localidad 3":
                System.out.println("Consultando disponibilidad de la localidad 3. Por favor, espere...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D I S P O N I B L E S ==== V E N D I D A S");
                System.out.println("         "+localidad3.getEntradasDisponibles()+"                        "+localidad1.getEntradasVendidas());
                break;

            default:
                System.out.println("La localidad ingresada no existe. Por favor, intente de nuevo.");
                break;
        }
        
    }
    
    /** OPCIÓN 5
     * 
     * Crea un reporte de caja, con las entradas vendidas y el ingreso total de cada localidad.
     * @param localidad1
     * @param localidad2
     * @param localidad3
     */

    private static void reporteCaja(Localidad localidad1, Localidad localidad2, Localidad localidad3){
        System.out.println("======= REPORTE DE CAJA =======");
        System.out.println("Consultando reporte de caja. Por favor, espere...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("L O C A L I D A D ==== V E N D I D A S ==== I N G R E S O");
        System.out.println(localidad1.getNombreLocalidad()+"                  "+localidad1.getEntradasVendidas()+"                 "+localidad1.getEntradasVendidas()*localidad1.getPrecioLocalidad());
        System.out.println(localidad2.getNombreLocalidad()+"                  "+localidad2.getEntradasVendidas()+"                 "+localidad2.getEntradasVendidas()*localidad2.getPrecioLocalidad());
        System.out.println(localidad3.getNombreLocalidad()+"                  "+localidad3.getEntradasVendidas()+"                 "+localidad3.getEntradasVendidas()*localidad3.getPrecioLocalidad());

    }

    /** OPCIÓN 6
     * 
     * Muestra al usuario cuanto dinero tiene disponible para comprar entradas.
     * @param comprador
     */

    private static void presupuestoPendiente(Comprador comprador){
        System.out.println("======= PRESUPUESTO PENDIENTE =======");
        System.out.println("Consultando presupuesto pendiente. Por favor, espere...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El presupuesto pendiente de "+comprador.getNombre()+" es de: $"+comprador.getPresupuesto());

    }


    /** VALIDACIONES DE COMPRA ↓
     * 
     * Se hacen 3 diferentes validaciones:
     * 1. Validar si hay entradas disponibles para la localidad seleccionada.
     * 2. Validar si existen entradas disponibles que el usuario quiere comprar.
     * 3. Validar si el presupuesto del usuario es suficiente para comprar las entradas.
     * @param comprador
     * @param localidad
     * @param control
     * @return control -> variable de control que se uso para validar las 3 condiciones.
     */
    private static boolean validarDisponibilidad(Comprador comprador, Localidad localidad, boolean control) {
        if (localidad.getEntradasDisponibles() > 0) {
            return control = true;
        } else {
            System.out.println("Lo sentimos "+comprador.getNombre()+", ya no hay más entradas disponibles en esta localidad.");
            return control = false;
        }
    }

    private static boolean validarBoletos(Comprador comprador, Localidad localidad, boolean control){
        if (comprador.getCantidadBoletos() <= localidad.getEntradasDisponibles()) {
            return control = true;
        } else {
            System.out.println("Lo sentimos "+comprador.getNombre()+", las entradas solicitadas exceden el limite de entradas disponibles.");
            return control = false;
        }
    }

    private static boolean validarPresupuesto(Comprador comprador, Localidad localidad, boolean control){
        if (comprador.getPresupuesto() >= localidad.getPrecioLocalidad()) {
            return control = true;
        } else {
            System.out.println("Lo sentimos "+comprador.getNombre()+", su presupuesto no es suficiente para comprar las entradas solicitadas.");
            return control = false;
        }
    }
}