package com.jefferson.notifications;

import javax.swing.*;

public class DevPlusMain {
    static DevPlus devPlus;


    static void main() {


        String nombre = pedirDatos("Ingrese el nombre de la empresa");
        String nit = pedirDatos("Ingrese el nit de la empresa");
        String direccion = pedirDatos("Ingrese la direcciond de la empresa");
        String telefono = pedirDatos("Ingrese el telefono de contacto de la empresa");
        String paginaWeb = pedirDatos("Ingrese la pagina web de la empresa");

        devPlus = new DevPlus(nombre, nit, direccion, telefono,paginaWeb);

        int option = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("~~ DEVPLUS ~~\n"+
                    "¿Que desea realizar hoy?\n" +
                    "\n 1. Gestionar Cliente" +
                    "\n 2. Gestionar Desarrolladores" +
                    "\n 3. Gestionar Proyectos" +
                    "\n 4. Gestionar Servicios Adicional" +
                    "\n 4. Calcular Ingresos" +
                    "\n 0. Salir del sistema"));

            switch (option) {
                case 1:
                    int clienteOption = 0;
                    do {
                        clienteOption = Integer.parseInt(JOptionPane.showInputDialog("~~ GESTIONAR CLIENTES ~~\n"+
                                "Seleccione una opcion\n" +
                                "\n 1. Registrar Cliente" +
                                "\n 2. Mostrar Clientes" +
                                "\n 3. Mostrar Cliente por ID" +
                                "\n 4. Actualizar Cliente" +
                                "\n 5. Eliminar Cliente por Telefono" +
                                "\n 6. Buscar Cliente por Telefono" +
                                "\n 0. Regresar"));
                        switch (clienteOption) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Registrando cliente...");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Mostrando clientes...");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Mostrando cliente...");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Actualizando cliente...");
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Eliminando cliente...");
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null, "Actualizando cliente...");
                                break;
                            case 0:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida");
                        }
                    } while (clienteOption != 0);
                    break;
                case 2:
                    int desarroladorOption = 0;
                    do {
                        desarroladorOption = Integer.parseInt(JOptionPane.showInputDialog("~~ GESTIONAR DESARROLLADORES ~~\n"+
                                "Seleccione una opcion\n" +
                                "\n 1. Registrar Desarrollador" +
                                "\n 2. Mostrar Desarrolladores" +
                                "\n 3. Mostrar Desarrollador por Codigo" +
                                "\n 4. Actualizar Desarollador" +
                                "\n 5. Eliminar Desarollador" +
                                "\n 0. Regresar"));
                        switch (desarroladorOption) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Registrando Desarrollador...");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Mostrando Desarrolladores...");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Mostrtando Desarrollador...");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Actualizando Desarrollador...");
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Eliminando Desarrollador...");
                                break;
                            case 0:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                        }
                    } while (desarroladorOption != 0);
                    break;
                case 3:
                    int proyectoOption = 0;
                    do {
                        proyectoOption = Integer.parseInt(JOptionPane.showInputDialog("~~ GESTIONAR PROYECTOS ~~\n"+
                                "Seleccione una opcion\n" +
                                "\n 1. Registrar Proyecto" +
                                "\n 2. Mostrar Proyectos" +
                                "\n 4. Mostrar Proyecto por Codigo" +
                                "\n 5. Actualizar Proyecto" +
                                "\n 5. Eliminar Proyecto" +
                                "\n 6. Cambiar estado de un proyecto" +
                                "\n 7. Verificar Disponibilidad de Desarrolladores" +
                                "\n 8. Agregar Desarollador a un Proyecto" +
                                "\n 9. Agregar Servicio Adicional" +
                                "\n 10. Calcular Valor de un Proyecto" +
                                "\n 0. Regresar"));
                        switch (proyectoOption) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Registrando Proyecto...");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Mostrando Proyectos...");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Mostrtando Proyecto...");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Actualizando Proyecto...");
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Eliminando Proyecto...");
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null, "Cambiando Estado...");
                                break;
                            case 7:
                                JOptionPane.showMessageDialog(null, "Verificando Disoponibiidad...");
                                break;
                            case 8:
                                JOptionPane.showMessageDialog(null, "Agregando Desarollador...");
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null, "Agregando Servicio Adicional...");
                                break;
                            case 10:
                                JOptionPane.showMessageDialog(null, "Calculando Valor...");
                                break;
                            case 0:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                        }
                    } while (proyectoOption != 0);
                    break;
                case 4:
                    int servicioAdiOption = 0;
                    do {
                        servicioAdiOption = Integer.parseInt(JOptionPane.showInputDialog("~~ GESTIONAR DESARROLLADORES ~~\n"+
                                "Seleccione una opcion\n" +
                                "\n 1. Registrar Servicio Adicional" +
                                "\n 2. Mostrar Servicios Adicionales" +
                                "\n 3. Mostrar Servicio Adicional por Codigo" +
                                "\n 4. Actualizar Servicio Adicional" +
                                "\n 5. Eliminar Servicio Adicional" +
                                "\n 0. Regresar"));
                        switch (servicioAdiOption) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Registrando Servicio Adicional...");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Mostrando Servicios Adicionales...");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Mostrtando Servicio Adicional...");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Actualizando Servicio Adicional...");
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Eliminando Servicio Adicional...");
                                break;
                            case 0:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                        }
                    } while (servicioAdiOption != 0);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "El programa a finalizado :D");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }

        } while (option != 0);

    }


    // funciones basicas

    //pedir datos
    static String pedirDatos(String mensaje){
        return JOptionPane.showInputDialog(mensaje, null);
    }
    //mensajes
    static void mostrarMensaje (String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }


}
