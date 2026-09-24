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
                    "\n 3. Gestionar Proyecto" +
                    "\n 4. Gestionar Servicios Adicional" +
                    "\n 0. Salir del sistema"));

            switch (option) {
                case 1:
                    int clienteOption = 0;
                    do {
                        clienteOption = Integer.parseInt(JOptionPane.showInputDialog("~~ GESTIONAR CLIENTE ~~\n"+
                                "Seleccione una opcion\n" +
                                "\n 1. Registrar Cliente" +
                                "\n 2. Mostrar Clientes" +
                                "\n 3. Buscar Cliente por Telefono" +
                                "\n 4. Buscar Cliente por ID" +
                                "\n 5. Actualizar Cliente" +
                                "\n 0. Regresar"));
                        switch (clienteOption) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Registrando cliente...");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Mostrando cliente...");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Buscando cliente...");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Buscando cliente...");
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Actualizando cliente...");
                                break;
                            case 0:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida en menú cliente.");
                        }
                    } while (clienteOption != 0);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
