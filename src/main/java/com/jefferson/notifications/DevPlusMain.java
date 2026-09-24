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
                                registrarCliente();
                                break;
                            case 2:
                                mostrarListaClientes();
                                break;
                            case 3:
                                buscarClientePorId();
                                break;
                            case 4:
                                actualizarCliente();
                                break;
                            case 5:
                                eliminarClientePorTelefono();
                                break;
                            case 6:
                                buscarClientePorTelefono();
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
                                registrarDesarrollador();
                                break;
                            case 2:
                                mostrarListaDesarrolladores();
                                break;
                            case 3:
                                buscarDesarrolladorPorCodigo();
                                break;
                            case 4:
                                actualizarDesarrollador();
                                break;
                            case 5:
                                eliminarDesarrollador();
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
                                "\n 0. Regresar"));
                        switch (proyectoOption) {
                            case 1:
                                registrarProyecto();
                                break;
                            case 2:
                                mostrarListaProyectos();
                                break;
                            case 3:
                                buscarProyectoPorCodigo();
                                break;
                            case 4:
                                actualizarProyecto();
                                break;
                            case 5:
                                eliminarProyecto();
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
                        servicioAdiOption = Integer.parseInt(JOptionPane.showInputDialog("~~ GESTIONAR SERVICIOS ADICIONALES ~~\n"+
                                "Seleccione una opcion\n" +
                                "\n 1. Registrar Servicio Adicional" +
                                "\n 2. Mostrar Servicios Adicionales" +
                                "\n 3. Mostrar Servicio Adicional por Codigo" +
                                "\n 4. Actualizar Servicio Adicional" +
                                "\n 5. Eliminar Servicio Adicional" +
                                "\n 0. Regresar"));
                        switch (servicioAdiOption) {
                            case 1:
                                registrarServicioAdicional();
                                break;
                            case 2:
                                mostrarListaServiciosAdicionales();
                                break;
                            case 3:
                                buscarServicioAdicionalPorCodigo();
                                break;
                            case 4:
                                actualizarServicioAdicional();
                                break;
                            case 5:
                                eliminarServicioAdicional();
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


    // ----------------- gestion de clientes -----------------

    //Registrar la informacion del cliente
    private static void registrarCliente() {
        String identificacion = pedirDatos("Ingrese la identificación del cliente:");
        String nombre = pedirDatos("Ingrese el nombre del cliente:");
        String telefono = pedirDatos("Ingrese el teléfono del cliente:");
        String correoElectronico = pedirDatos("Ingrese el correo electrónico del cliente:");
        String paisProcedencia = pedirDatos("Ingrese el país de procedencia del cliente:");
        boolean esFrecuente = pedirDatos("¿Es un cliente frecuente? (S/N):").equalsIgnoreCase("S");

        boolean resultado = devPlus.registrarCliente(identificacion, nombre, telefono, correoElectronico, paisProcedencia, esFrecuente);

        if (resultado) {
            mostrarMensaje("Cliente registrado exitosamente.");
        } else {
            mostrarMensaje("No se pudo registrar el cliente. Verifique que la identificación no esté repetida.");
        }
    }

    //Mostrar la lista completa de clientes
    private static void mostrarListaClientes() {
        mostrarMensaje(devPlus.mostrarListaClientes());
    }

    //Buscar un cliente por telefono
    private static void buscarClientePorTelefono() {
        String telefono = pedirDatos("Ingrese el teléfono del cliente a buscar:");

        mostrarMensaje(devPlus.buscarClientePorTelefono(telefono));
    }

    //Mostrar un cliente por identificacion
    private static void buscarClientePorId() {
        String identificacion = pedirDatos("Ingrese la identificación del cliente a buscar:");

        mostrarMensaje(devPlus.mostrarCliente(identificacion));
    }

    //Actualizar la informacion del cliente
    private static void actualizarCliente() {
        String identificacion = pedirDatos("Ingrese la identificación del cliente a actualizar:");
        String nombre = pedirDatos("Ingrese el nuevo nombre del cliente:");
        String telefono = pedirDatos("Ingrese el nuevo teléfono del cliente:");
        String correoElectronico = pedirDatos("Ingrese el nuevo correo electrónico del cliente:");
        String paisProcedencia = pedirDatos("Ingrese el nuevo país de procedencia del cliente:");
        boolean esFrecuente = pedirDatos("¿Es un cliente frecuente? (S/N):").equalsIgnoreCase("S");

        boolean resultado = devPlus.actualizarCliente(identificacion, nombre, telefono, correoElectronico, paisProcedencia, esFrecuente);

        if (resultado) {
            mostrarMensaje("Cliente actualizado exitosamente.");
        } else {
            mostrarMensaje("No se pudo actualizar el cliente.");
        }
    }

    //Eliminar un cliente por telefono
    private static void eliminarClientePorTelefono() {
        String telefono = pedirDatos("Ingrese el teléfono del cliente a eliminar:");

        boolean resultado = devPlus.eliminarClientePorTelefono(telefono);

        if (resultado) {
            mostrarMensaje("Cliente eliminado exitosamente.");
        } else {
            mostrarMensaje("No se pudo eliminar el cliente.");
        }
    }

    // ----------------- gestion de desarrolladores -----------------

    //Registrar la informacion del desarrollador
    private static void registrarDesarrollador() {
        String codigo = pedirDatos("Ingrese el código del desarrollador:");
        String equipoTrabajo = pedirDatos("Ingrese el equipo de trabajo del desarrollador:");
        String nivel = pedirDatos("Ingrese el nivel del desarrollador (Junior, Semisenior, Senior):");
        int maxProyectosSimultaneos = Integer.parseInt(pedirDatos("Ingrese la cantidad máxima de proyectos simultáneos:"));
        double tarifaDia = Double.parseDouble(pedirDatos("Ingrese la tarifa por día del desarrollador:"));
        String estado = pedirDatos("Ingrese el estado del desarrollador (Disponible, Asignado, Ocupado, En capacitación):");

        boolean resultado = devPlus.registrarDesarrollador(codigo, equipoTrabajo, nivel, maxProyectosSimultaneos, tarifaDia, estado);

        if (resultado) {
            mostrarMensaje("Desarrollador registrado exitosamente.");
        } else {
            mostrarMensaje("No se pudo registrar el desarrollador. Verifique que el código no esté repetido.");
        }
    }

    //Mostrar la lista completa de desarrolladores
    private static void mostrarListaDesarrolladores() {
        mostrarMensaje(devPlus.mostrarListaDesarrolladores());
    }

    //Buscar un desarrollador por codigo
    private static void buscarDesarrolladorPorCodigo() {
        String codigo = pedirDatos("Ingrese el código del desarrollador a buscar:");

        mostrarMensaje(devPlus.mostrarDesarrollador(codigo));
    }

    //Actualizar la informacion del desarrollador
    private static void actualizarDesarrollador() {
        String codigo = pedirDatos("Ingrese el código del desarrollador a actualizar:");
        String equipoTrabajo = pedirDatos("Ingrese el nuevo equipo de trabajo del desarrollador:");
        String nivel = pedirDatos("Ingrese el nuevo nivel del desarrollador (Junior, Semisenior, Senior):");
        int maxProyectosSimultaneos = Integer.parseInt(pedirDatos("Ingrese la nueva cantidad máxima de proyectos simultáneos:"));
        double tarifaDia = Double.parseDouble(pedirDatos("Ingrese la nueva tarifa por día del desarrollador:"));
        String estado = pedirDatos("Ingrese el nuevo estado del desarrollador (Disponible, Asignado, Ocupado, En capacitación):");

        boolean resultado = devPlus.actualizarDesarrollador(codigo, equipoTrabajo, nivel, maxProyectosSimultaneos, tarifaDia, estado);

        if (resultado) {
            mostrarMensaje("Desarrollador actualizado exitosamente.");
        } else {
            mostrarMensaje("No se pudo actualizar el desarrollador.");
        }
    }

    //Eliminar la informacion del desarrollador
    private static void eliminarDesarrollador() {
        String codigo = pedirDatos("Ingrese el código del desarrollador a eliminar:");

        boolean resultado = devPlus.eliminarDesarrollador(codigo);

        if (resultado) {
            mostrarMensaje("Desarrollador eliminado exitosamente.");
        } else {
            mostrarMensaje("No se pudo eliminar el desarrollador.");
        }
    }

    // ----------------- gestion de proyectos -----------------

    //Registrar la informacion del proyecto
    private static void registrarProyecto() {
        String codigo = pedirDatos("Ingrese el código del proyecto:");
        String fechaSolicitud = pedirDatos("Ingrese la fecha de solicitud del proyecto (dd/mm/aaaa):");
        String fechaInicio = pedirDatos("Ingrese la fecha de inicio del proyecto (dd/mm/aaaa):");
        String fechaEntrega = pedirDatos("Ingrese la fecha de entrega del proyecto (dd/mm/aaaa):");
        String estado = pedirDatos("Ingrese el estado del proyecto (Pendiente, Confirmado, En curso, Finalizado, Cancelado):");
        String metodoPago = pedirDatos("Ingrese el método de pago (tarjeta de crédito, transferencia bancaria, efectivo):");
        double valorTotalp = Double.parseDouble(pedirDatos("Ingrese el valor total del proyecto:"));
        String identificacionCliente = pedirDatos("Ingrese la identificación del cliente que contrata el proyecto:");

        boolean resultado = devPlus.registrarProyecto(codigo, fechaSolicitud, fechaInicio, fechaEntrega, estado, metodoPago, valorTotalp, identificacionCliente);

        if (resultado) {
            mostrarMensaje("Proyecto registrado exitosamente.");
        } else {
            mostrarMensaje("No se pudo registrar el proyecto. Verifique el código y que el cliente exista.");
        }
    }

    //Mostrar la lista completa de proyectos
    private static void mostrarListaProyectos() {
        mostrarMensaje(devPlus.mostrarListaProyectos());
    }

    //Buscar un proyecto por codigo
    private static void buscarProyectoPorCodigo() {
        String codigo = pedirDatos("Ingrese el código del proyecto a buscar:");

        mostrarMensaje(devPlus.mostrarProyecto(codigo));
    }

    //Actualizar la informacion del proyecto
    private static void actualizarProyecto() {
        String codigo = pedirDatos("Ingrese el código del proyecto a actualizar:");
        String fechaSolicitud = pedirDatos("Ingrese la nueva fecha de solicitud del proyecto (dd/mm/aaaa):");
        String fechaInicio = pedirDatos("Ingrese la nueva fecha de inicio del proyecto (dd/mm/aaaa):");
        String fechaEntrega = pedirDatos("Ingrese la nueva fecha de entrega del proyecto (dd/mm/aaaa):");
        String estado = pedirDatos("Ingrese el nuevo estado del proyecto (Pendiente, Confirmado, En curso, Finalizado, Cancelado):");
        String metodoPago = pedirDatos("Ingrese el nuevo método de pago (tarjeta de crédito, transferencia bancaria, efectivo):");
        double valorTotalp = Double.parseDouble(pedirDatos("Ingrese el nuevo valor total del proyecto:"));

        boolean resultado = devPlus.actualizarProyecto(codigo, fechaSolicitud, fechaInicio, fechaEntrega, estado, metodoPago, valorTotalp);

        if (resultado) {
            mostrarMensaje("Proyecto actualizado exitosamente.");
        } else {
            mostrarMensaje("No se pudo actualizar el proyecto.");
        }
    }

    //Eliminar la informacion del proyecto
    private static void eliminarProyecto() {
        String codigo = pedirDatos("Ingrese el código del proyecto a eliminar:");

        boolean resultado = devPlus.eliminarProyecto(codigo);

        if (resultado) {
            mostrarMensaje("Proyecto eliminado exitosamente.");
        } else {
            mostrarMensaje("No se pudo eliminar el proyecto.");
        }
    }

    // ----------------- gestion de servicios adicionales -----------------

    //Registrar la informacion del servicio adicional
    private static void registrarServicioAdicional() {
        String codigo = pedirDatos("Ingrese el código del servicio adicional:");
        String nombre = pedirDatos("Ingrese el nombre del servicio adicional:");
        String descripcion = pedirDatos("Ingrese la descripción del servicio adicional:");
        double precio = Double.parseDouble(pedirDatos("Ingrese el precio del servicio adicional:"));
        boolean disponibilidad = pedirDatos("¿El servicio adicional está disponible? (S/N):").equalsIgnoreCase("S");

        boolean resultado = devPlus.registrarServicioAdicional(codigo, nombre, descripcion, precio, disponibilidad);

        if (resultado) {
            mostrarMensaje("Servicio adicional registrado exitosamente.");
        } else {
            mostrarMensaje("No se pudo registrar el servicio adicional. Verifique que el código no esté repetido.");
        }
    }

    //Mostrar la lista completa de servicios adicionales
    private static void mostrarListaServiciosAdicionales() {
        mostrarMensaje(devPlus.mostrarListaServiciosAdicionales());
    }

    //Buscar un servicio adicional por codigo
    private static void buscarServicioAdicionalPorCodigo() {
        String codigo = pedirDatos("Ingrese el código del servicio adicional a buscar:");

        mostrarMensaje(devPlus.mostrarServicioAdicional(codigo));
    }

    //Actualizar la informacion del servicio adicional
    private static void actualizarServicioAdicional() {
        String codigo = pedirDatos("Ingrese el código del servicio adicional a actualizar:");
        String nombre = pedirDatos("Ingrese el nuevo nombre del servicio adicional:");
        String descripcion = pedirDatos("Ingrese la nueva descripción del servicio adicional:");
        double precio = Double.parseDouble(pedirDatos("Ingrese el nuevo precio del servicio adicional:"));
        boolean disponibilidad = pedirDatos("¿El servicio adicional está disponible? (S/N):").equalsIgnoreCase("S");

        boolean resultado = devPlus.actualizarServicioAdicional(codigo, nombre, descripcion, precio, disponibilidad);

        if (resultado) {
            mostrarMensaje("Servicio adicional actualizado exitosamente.");
        } else {
            mostrarMensaje("No se pudo actualizar el servicio adicional.");
        }
    }

    //Eliminar la informacion del servicio adicional
    private static void eliminarServicioAdicional() {
        String codigo = pedirDatos("Ingrese el código del servicio adicional a eliminar:");

        boolean resultado = devPlus.eliminarServicioAdicional(codigo);

        if (resultado) {
            mostrarMensaje("Servicio adicional eliminado exitosamente.");
        } else {
            mostrarMensaje("No se pudo eliminar el servicio adicional.");
        }
    }

}
