package ProyectoFinal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProyectoFinal {
        public static void main(String[] args) {
            List<String> idActivos=crearidActivos();
            List<String> nombreActivos=crearnombreActivos();
            List<String> estadoActivos=crearestadoActivos();
            List<String> asignadoActivos=crearasignadoActivos();

            Scanner scanner = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);

            // Credenciales
            String nombreUsuario = "admin";
            String contrasena = "admin123";

            // Usuario
            System.out.print("Ingrese su nombre de usuario: ");
            String inputNombreUsuario = scan.nextLine();

            // Clave
            System.out.print("Ingrese su contraseña: ");
            String inputContrasena = scan.nextLine();

            if (inputNombreUsuario.equals(nombreUsuario) && inputContrasena.equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + nombreUsuario + "!");
                int opcion;

                do {
                    System.out.println("\n******* MENÚ PRINCIPAL **********");
                    System.out.println("1. Registrar Nuevo Activo");
                    System.out.println("2. Actualizar Estado de Activo");
                    System.out.println("3. Informe de Activos");
                    System.out.println("4. Salir");
                    System.out.println("********************************");
                    System.out.println("\nIngrese la opción deseada: ");
                    opcion = scanner.nextInt();


                    switch (opcion) {
                        case 1:
                            registraractivo(idActivos,nombreActivos,estadoActivos,asignadoActivos);
                            break;
                        case 2:
                            actualizaractivo(idActivos,estadoActivos,asignadoActivos);
                            break;
                        case 3:
                            informe(idActivos,nombreActivos,estadoActivos);
                            break;
                        case 4:
                            System.out.println("Sesión Finalizada");
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                            break;
                    }
                } while (opcion != 4);

                scanner.close();

            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos. Por favor, intente nuevamente.");
            }


        }



        private static List<String> crearidActivos() {
            List<String> Activos=new ArrayList<>();
            Activos.add("PC-001");
            Activos.add("LI-001");
            Activos.add("ME-001");
            Activos.add("PC-002");
            return Activos;
        }
        private static List<String> crearnombreActivos() {
            List<String> Activos=new ArrayList<>();
            Activos.add("Laptop");
            Activos.add("Licencia");
            Activos.add("Memoria");
            Activos.add("Laptop");
            return Activos;
        }
        private static List<String> crearestadoActivos() {
            List<String> Activos=new ArrayList<>();
            Activos.add("Asignado");
            Activos.add("Asignado");
            Activos.add("Asignado");
            Activos.add("Sin asignar");
            return Activos;
        }
        private static List<String> crearasignadoActivos() {
            List<String> Activos=new ArrayList<>();
            Activos.add("Sitemas");
            Activos.add("Sistemas");
            Activos.add("Contabilidad");
            Activos.add("");
            return Activos;
        }

        public static void registraractivo(List<String> idActivos,List<String> nombreActivos,List<String> estadoActivos,List<String> asignadoActivos) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n*** REGISTRO de ACTIVOS ***");
            System.out.println("Ingresar ID de Activo");
            String id = scanner.nextLine();
            idActivos.add(id);
            System.out.println("Ingresar Nombre de Activo");
            String nombre = scanner.nextLine();
            nombreActivos.add(nombre);
            System.out.println("Ingresar Estado de Activo");
            String estado = scanner.nextLine();
            estadoActivos.add(estado);
            System.out.println("Ingresar Area Asignada de Activo");
            String area = scanner.nextLine();
            asignadoActivos.add(area);
            System.out.println("\nSe registro Activo con éxito");

        }


    private static void informe(List<String> idActivos, List<String> nombreActivos, List<String> estadoActivos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*** INFORME ACTIVOS ***");
        System.out.println("1. Activos por Estado");
        System.out.println("2. Activos por Stock");
        System.out.println("3. Regresar");
        System.out.println("*************************");
        System.out.print("\nIngrese la opción deseada: ");
        int opcion = scanner.nextInt();
        List<String> filtroEstado = new ArrayList<String>();
        switch (opcion) {
            case 1:
                System.out.println("\n******** INFORME DE ACTIVOS POR ESTADO ********");
                System.out.println("-------------------------------");
                System.out.println("| ID | Nombre Activo | Estado |");
                for(int i = 0; i < nombreActivos.size() ; i++){
                    filtroEstado.add("| "+idActivos.get(i)+" | "+nombreActivos.get(i)+" | "+estadoActivos.get(i)+" |");
                    System.out.println(filtroEstado.get(i));
                }
                System.out.println("-------------------------------");
                break;
            case 2:
                List<String> listaStock = new ArrayList<String>();
                for (int i=0;  i<nombreActivos.size();i++) {
                    if (!listaStock.contains(nombreActivos.get(i))) {
                        listaStock.add(nombreActivos.get(i));
                    }
                }
                System.out.println("\n******** INFORME DE ACTIVOS POR STOCK ********");
                System.out.println("-------------------------");
                System.out.println("|  Activo   | STOCK |");
                System.out.println("---------------------");
                for(int i = 0; i < listaStock.size(); i++) {
                    int contador = contadorStock(nombreActivos, listaStock.get(i));
                    System.out.println(listaStock.get(i) + ": " + contador);
                }
                System.out.println("-------------------------");
                break;
            case 3:
                break;
            default:
                System.out.println("Opcion incorrecta");
        }

    }

        public static int contadorStock(List<String> array, String elemento) {
            int contador = 0;

            for (int i = 0; i < array.size() ; i++) {
                if ((array.get(i)).equals(elemento)) {
                    contador++;
                }
            }
            return contador;
        }

        public static void actualizaractivo(List<String> idActivos,List<String> estadoActivos,List<String> asignadoActivos) {
            Scanner scanner = new Scanner(System.in);
            boolean encontrado=false;
            int indiceIdActivo=0;
            //scanner.useDelimiter("\n");
            System.out.println("\n*** ACTUALIZACION de ACTIVOS ***");
            System.out.println("Ingresar ID de Activo");
            String idString = scanner.nextLine();
            for (int i=0;i<idActivos.size();i++){
                if(idActivos.get(i).equals(idString)){
                    indiceIdActivo = idActivos.indexOf(idString);
                    encontrado=true;
                    break;
                }}
            if(encontrado){
                System.out.println("Modificando:" + idString);
                System.out.println("Ingresar Estado de Activo");
                String estadoActivo = scanner.nextLine();
                estadoActivos.set(indiceIdActivo, estadoActivo);
                System.out.println("Ingresar Area Asignada de Activo");
                String asignadoActivo = scanner.nextLine();
                asignadoActivos.set(indiceIdActivo, asignadoActivo);
                System.out.println("\nSe Actualizo el Activo Correctamente");
            }else{
                System.out.println("\nNo se encontro el ID de Activo");
            }
        }
    }
