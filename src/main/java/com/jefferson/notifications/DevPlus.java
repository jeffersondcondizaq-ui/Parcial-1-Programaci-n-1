package com.jefferson.notifications;

public class DevPlus {
    public String nombre;
    public String nit;
    public String direccion;
    public String telefono;
    public String paginaWeb;

    private Proyecto[] listProyecto;
    private Desarrollador[] listDesarrollador;
    private ServicioAdicional[] listServicioAdicional;
    private Cliente[] listCliente;

    public DevPlus(String nombre, String nit, String direccion, String telefono, String paginaWeb) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.listProyecto = new Proyecto[10];
        this.listDesarrollador = new Desarrollador[10];
        this.listServicioAdicional = new ServicioAdicional[10];
        this.listCliente = new Cliente[10];
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Proyecto[] getListProyecto() {
        return listProyecto;
    }

    public void setListProyecto(Proyecto[] listProyecto) {
        this.listProyecto = listProyecto;
    }

    public Desarrollador[] getListDesarrollador() {
        return listDesarrollador;
    }

    public void setListDesarrollador(Desarrollador[] listDesarrollador) {
        this.listDesarrollador = listDesarrollador;
    }

    public ServicioAdicional[] getListServicioAdicional() {
        return listServicioAdicional;
    }

    public void setListServicioAdicional(ServicioAdicional[] listServicioAdicional) {
        this.listServicioAdicional = listServicioAdicional;
    }

    public Cliente[] getListCliente() {
        return listCliente;
    }

    public void setListCliente(Cliente[] listCliente) {
        this.listCliente = listCliente;
    }

    //    --------------------------funcionalidades

    //C - Registrar/Crear un cliente
    public boolean registrarCliente(String identificacion, String nombre, String telefono,
                                     String correoElectronico, String paisProcedencia, boolean esFrecuente) {

        if (encontrarIndexClientePorId(identificacion) == -1) {
            Cliente nuevoCliente = new Cliente(identificacion, nombre, telefono, correoElectronico, paisProcedencia, esFrecuente);

            for (int i = 0; i < listCliente.length; i++) {
                if (listCliente[i] == null) {
                    listCliente[i] = nuevoCliente;
                    return true;
                }
            }
        }

        return false;
    }

    //R - Mostrar un cliente por identificacion
    public String mostrarCliente(String identificacionMostrar) {
        String mensaje;
        int index = encontrarIndexClientePorId(identificacionMostrar);

        if (index != -1) {
            Cliente clienteEncontrado = listCliente[index];

            mensaje = "Cliente encontrado:\n" +
                    "\nIdentificación: " + clienteEncontrado.getIdentificacion() +
                    "\nNombre: " + clienteEncontrado.getNombre() +
                    "\nTeléfono: " + clienteEncontrado.getTelefono() +
                    "\nCorreo electrónico: " + clienteEncontrado.getCorreoElectronico() +
                    "\nPaís de procedencia: " + clienteEncontrado.getPaisProcedencia() +
                    "\nCliente frecuente: " + (clienteEncontrado.isEsFrecuente() ? "Sí" : "No");
        } else {
            mensaje = "El cliente no se encuentra en la lista.";
        }

        return mensaje;
    }

    //R - Mostrar todos los clientes
    public String mostrarListaClientes() {
        String mensaje = "Lista de clientes:\n";

        for (int i = 0; i < listCliente.length; i++) {
            if (listCliente[i] != null) {
                mensaje += "\nIdentificación: " + listCliente[i].getIdentificacion() +
                        "\nNombre: " + listCliente[i].getNombre() +
                        "\nTeléfono: " + listCliente[i].getTelefono() +
                        "\nCorreo electrónico: " + listCliente[i].getCorreoElectronico() +
                        "\nPaís de procedencia: " + listCliente[i].getPaisProcedencia() +
                        "\nCliente frecuente: " + (listCliente[i].isEsFrecuente() ? "Sí" : "No") + "\n";
            }
        }

        return mensaje;
    }

    //R - Buscar un cliente por telefono
    public String buscarClientePorTelefono(String telefonoBuscar) {
        String mensaje;
        int index = encontrarIndexClientePorTelefono(telefonoBuscar);

        if (index != -1) {
            Cliente clienteEncontrado = listCliente[index];

            mensaje = "Cliente encontrado:\n" +
                    "\nIdentificación: " + clienteEncontrado.getIdentificacion() +
                    "\nNombre: " + clienteEncontrado.getNombre() +
                    "\nTeléfono: " + clienteEncontrado.getTelefono() +
                    "\nCorreo electrónico: " + clienteEncontrado.getCorreoElectronico() +
                    "\nPaís de procedencia: " + clienteEncontrado.getPaisProcedencia() +
                    "\nCliente frecuente: " + (clienteEncontrado.isEsFrecuente() ? "Sí" : "No") +
                    "\nNúmero de teléfono perfecto: " + (esPerfecto(clienteEncontrado.getTelefono()) ? "Sí" : "No");
        } else {
            mensaje = "El cliente no se encuentra en la lista.";
        }

        return mensaje;
    }

    //Determina si el numero de telefono es un numero perfecto
    //(un numero perfecto es igual a la suma de sus divisores propios,
    // por ejemplo: 6, 28, 496, 8128)
    public static boolean esPerfecto(String numeroValidar) {
        int numero = Integer.parseInt(numeroValidar);
        if (numero <= 1) {
            return false;
        }

        int suma = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }

        return suma == numero;
    }


    //U - Actualizar/Modificar un cliente
    public boolean actualizarCliente(String identificacionActualizar, String nombre, String telefono,
                                      String correoElectronico, String paisProcedencia, boolean esFrecuente) {
        boolean respuesta = false;
        int index = encontrarIndexClientePorId(identificacionActualizar);

        if (index != -1) {
            listCliente[index].setNombre(nombre);
            listCliente[index].setTelefono(telefono);
            listCliente[index].setCorreoElectronico(correoElectronico);
            listCliente[index].setPaisProcedencia(paisProcedencia);
            listCliente[index].setEsFrecuente(esFrecuente);

            respuesta = true;
        }

        return respuesta;
    }

    //D - Eliminar/Quitar un cliente por telefono
    public boolean eliminarClientePorTelefono(String telefonoEliminar) {
        boolean respuesta = false;
        int index = encontrarIndexClientePorTelefono(telefonoEliminar);

        if (index != -1) {
            listCliente[index] = null;
            respuesta = true;
        }

        return respuesta;
    }

    public int encontrarIndexClientePorId(String identificacionBuscar) {
        for (int i = 0; i < listCliente.length; i++) {
            if (listCliente[i] != null && listCliente[i].getIdentificacion().equals(identificacionBuscar)) {
                return i;
            }
        }

        return -1;
    }

    public int encontrarIndexClientePorTelefono(String telefonoBuscar) {
        for (int i = 0; i < listCliente.length; i++) {
            if (listCliente[i] != null && listCliente[i].getTelefono().equals(telefonoBuscar)) {
                return i;
            }
        }

        return -1;
    }

    //    --------------------------CRUD Desarrollador

    //C - Registrar/Crear un desarrollador
    public boolean registrarDesarrollador(String codigo, String equipoTrabajo, String nivel,
                                           int maxProyectosSimultaneos, double tarifaDia, String estado) {

        if (encontrarIndexDesarrolladorPorCodigo(codigo) == -1) {
            Desarrollador nuevoDesarrollador = new Desarrollador(codigo, equipoTrabajo, nivel, maxProyectosSimultaneos, tarifaDia, estado);

            for (int i = 0; i < listDesarrollador.length; i++) {
                if (listDesarrollador[i] == null) {
                    listDesarrollador[i] = nuevoDesarrollador;
                    return true;
                }
            }
        }

        return false;
    }

    //R - Mostrar un desarrollador por codigo
    public String mostrarDesarrollador(String codigoMostrar) {
        String mensaje;
        int index = encontrarIndexDesarrolladorPorCodigo(codigoMostrar);

        if (index != -1) {
            Desarrollador desarrolladorEncontrado = listDesarrollador[index];

            mensaje = "Desarrollador encontrado:\n" +
                    "\nCódigo: " + desarrolladorEncontrado.getCodigo() +
                    "\nEquipo de trabajo: " + desarrolladorEncontrado.getEquipoTrabajo() +
                    "\nNivel: " + desarrolladorEncontrado.getNivel() +
                    "\nMáx. proyectos simultáneos: " + desarrolladorEncontrado.getMaxProyectosSimultaneos() +
                    "\nTarifa por día: " + desarrolladorEncontrado.getTarifaDia() +
                    "\nEstado: " + desarrolladorEncontrado.getEstado();
        } else {
            mensaje = "El desarrollador no se encuentra en la lista.";
        }

        return mensaje;
    }

    //R - Mostrar todos los desarrolladores
    public String mostrarListaDesarrolladores() {
        String mensaje = "Lista de desarrolladores:\n";

        for (int i = 0; i < listDesarrollador.length; i++) {
            if (listDesarrollador[i] != null) {
                mensaje += "\nCódigo: " + listDesarrollador[i].getCodigo() +
                        "\nEquipo de trabajo: " + listDesarrollador[i].getEquipoTrabajo() +
                        "\nNivel: " + listDesarrollador[i].getNivel() +
                        "\nMáx. proyectos simultáneos: " + listDesarrollador[i].getMaxProyectosSimultaneos() +
                        "\nTarifa por día: " + listDesarrollador[i].getTarifaDia() +
                        "\nEstado: " + listDesarrollador[i].getEstado() + "\n";
            }
        }

        return mensaje;
    }

    //U - Actualizar/Modificar un desarrollador
    public boolean actualizarDesarrollador(String codigoActualizar, String equipoTrabajo, String nivel,
                                            int maxProyectosSimultaneos, double tarifaDia, String estado) {
        boolean respuesta = false;
        int index = encontrarIndexDesarrolladorPorCodigo(codigoActualizar);

        if (index != -1) {
            listDesarrollador[index].setEquipoTrabajo(equipoTrabajo);
            listDesarrollador[index].setNivel(nivel);
            listDesarrollador[index].setMaxProyectosSimultaneos(maxProyectosSimultaneos);
            listDesarrollador[index].setTarifaDia(tarifaDia);
            listDesarrollador[index].setEstado(estado);

            respuesta = true;
        }

        return respuesta;
    }

    //D - Eliminar/Quitar un desarrollador
    public boolean eliminarDesarrollador(String codigoEliminar) {
        boolean respuesta = false;
        int index = encontrarIndexDesarrolladorPorCodigo(codigoEliminar);

        if (index != -1) {
            listDesarrollador[index] = null;
            respuesta = true;
        }

        return respuesta;
    }

    public int encontrarIndexDesarrolladorPorCodigo(String codigoBuscar) {
        for (int i = 0; i < listDesarrollador.length; i++) {
            if (listDesarrollador[i] != null && listDesarrollador[i].getCodigo().equals(codigoBuscar)) {
                return i;
            }
        }

        return -1;
    }

    //    --------------------------CRUD Servicio Adicional

    //C - Registrar/Crear un servicio adicional
    public boolean registrarServicioAdicional(String codigo, String nombre, String descripcion,
                                               double precio, boolean disponibilidad) {

        if (encontrarIndexServicioAdicionalPorCodigo(codigo) == -1) {
            ServicioAdicional nuevoServicio = new ServicioAdicional(codigo, nombre, descripcion, precio, disponibilidad);

            for (int i = 0; i < listServicioAdicional.length; i++) {
                if (listServicioAdicional[i] == null) {
                    listServicioAdicional[i] = nuevoServicio;
                    return true;
                }
            }
        }

        return false;
    }

    //R - Mostrar un servicio adicional por codigo
    public String mostrarServicioAdicional(String codigoMostrar) {
        String mensaje;
        int index = encontrarIndexServicioAdicionalPorCodigo(codigoMostrar);

        if (index != -1) {
            ServicioAdicional servicioEncontrado = listServicioAdicional[index];

            mensaje = "Servicio adicional encontrado:\n" +
                    "\nCódigo: " + servicioEncontrado.getCodigo() +
                    "\nNombre: " + servicioEncontrado.getNombre() +
                    "\nDescripción: " + servicioEncontrado.getDescripcion() +
                    "\nPrecio: " + servicioEncontrado.getPrecio() +
                    "\nDisponibilidad: " + (servicioEncontrado.isDisponibilidad() ? "Sí" : "No");
        } else {
            mensaje = "El servicio adicional no se encuentra en la lista.";
        }

        return mensaje;
    }

    //R - Mostrar todos los servicios adicionales
    public String mostrarListaServiciosAdicionales() {
        String mensaje = "Lista de servicios adicionales:\n";

        for (int i = 0; i < listServicioAdicional.length; i++) {
            if (listServicioAdicional[i] != null) {
                mensaje += "\nCódigo: " + listServicioAdicional[i].getCodigo() +
                        "\nNombre: " + listServicioAdicional[i].getNombre() +
                        "\nDescripción: " + listServicioAdicional[i].getDescripcion() +
                        "\nPrecio: " + listServicioAdicional[i].getPrecio() +
                        "\nDisponibilidad: " + (listServicioAdicional[i].isDisponibilidad() ? "Sí" : "No") + "\n";
            }
        }

        return mensaje;
    }

    //U - Actualizar/Modificar un servicio adicional
    public boolean actualizarServicioAdicional(String codigoActualizar, String nombre, String descripcion,
                                                double precio, boolean disponibilidad) {
        boolean respuesta = false;
        int index = encontrarIndexServicioAdicionalPorCodigo(codigoActualizar);

        if (index != -1) {
            listServicioAdicional[index].setNombre(nombre);
            listServicioAdicional[index].setDescripcion(descripcion);
            listServicioAdicional[index].setPrecio(precio);
            listServicioAdicional[index].setDisponibilidad(disponibilidad);

            respuesta = true;
        }

        return respuesta;
    }

    //D - Eliminar/Quitar un servicio adicional
    public boolean eliminarServicioAdicional(String codigoEliminar) {
        boolean respuesta = false;
        int index = encontrarIndexServicioAdicionalPorCodigo(codigoEliminar);

        if (index != -1) {
            listServicioAdicional[index] = null;
            respuesta = true;
        }

        return respuesta;
    }

    public int encontrarIndexServicioAdicionalPorCodigo(String codigoBuscar) {
        for (int i = 0; i < listServicioAdicional.length; i++) {
            if (listServicioAdicional[i] != null && listServicioAdicional[i].getCodigo().equals(codigoBuscar)) {
                return i;
            }
        }

        return -1;
    }

    //    --------------------------CRUD Proyecto

    //C - Registrar/Crear un proyecto
    public boolean registrarProyecto(String codigo, String fechaSolicitud, String fechaInicio, String fechaEntrega,
                                      String estado, String metodoPago, double valorTotalp, String identificacionCliente) {

        int indexCliente = encontrarIndexClientePorId(identificacionCliente);

        if (indexCliente != -1 && encontrarIndexProyectoPorCodigo(codigo) == -1) {
            Cliente clienteProyecto = listCliente[indexCliente];
            Proyecto nuevoProyecto = new Proyecto(codigo, fechaSolicitud, fechaInicio, fechaEntrega, estado, metodoPago, valorTotalp, clienteProyecto);

            for (int i = 0; i < listProyecto.length; i++) {
                if (listProyecto[i] == null) {
                    listProyecto[i] = nuevoProyecto;
                    return true;
                }
            }
        }

        return false;
    }

    //R - Mostrar un proyecto por codigo
    public String mostrarProyecto(String codigoMostrar) {
        String mensaje;
        int index = encontrarIndexProyectoPorCodigo(codigoMostrar);

        if (index != -1) {
            Proyecto proyectoEncontrado = listProyecto[index];

            mensaje = "Proyecto encontrado:\n" +
                    "\nCódigo: " + proyectoEncontrado.getCodigo() +
                    "\nFecha de solicitud: " + proyectoEncontrado.getFechaSolicitud() +
                    "\nFecha de inicio: " + proyectoEncontrado.getFechaInicio() +
                    "\nFecha de entrega: " + proyectoEncontrado.getFechaEntrega() +
                    "\nEstado: " + proyectoEncontrado.getEstado() +
                    "\nMétodo de pago: " + proyectoEncontrado.getMetodoPago() +
                    "\nValor total: " + proyectoEncontrado.getValorTotalp() +
                    "\nCliente: " + proyectoEncontrado.getCliente().getNombre() +
                    " (" + proyectoEncontrado.getCliente().getIdentificacion() + ")";
        } else {
            mensaje = "El proyecto no se encuentra en la lista.";
        }

        return mensaje;
    }

    //R - Mostrar todos los proyectos
    public String mostrarListaProyectos() {
        String mensaje = "Lista de proyectos:\n";

        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null) {
                mensaje += "\nCódigo: " + listProyecto[i].getCodigo() +
                        "\nFecha de solicitud: " + listProyecto[i].getFechaSolicitud() +
                        "\nFecha de inicio: " + listProyecto[i].getFechaInicio() +
                        "\nFecha de entrega: " + listProyecto[i].getFechaEntrega() +
                        "\nEstado: " + listProyecto[i].getEstado() +
                        "\nMétodo de pago: " + listProyecto[i].getMetodoPago() +
                        "\nValor total: " + listProyecto[i].getValorTotalp() +
                        "\nCliente: " + listProyecto[i].getCliente().getNombre() + "\n";
            }
        }

        return mensaje;
    }

    //U - Actualizar/Modificar un proyecto
    public boolean actualizarProyecto(String codigoActualizar, String fechaSolicitud, String fechaInicio,
                                       String fechaEntrega, String estado, String metodoPago, double valorTotalp) {
        boolean respuesta = false;
        int index = encontrarIndexProyectoPorCodigo(codigoActualizar);

        if (index != -1) {
            listProyecto[index].setFechaSolicitud(fechaSolicitud);
            listProyecto[index].setFechaInicio(fechaInicio);
            listProyecto[index].setFechaEntrega(fechaEntrega);
            listProyecto[index].setEstado(estado);
            listProyecto[index].setMetodoPago(metodoPago);
            listProyecto[index].setValorTotalp(valorTotalp);

            respuesta = true;
        }

        return respuesta;
    }

    //D - Eliminar/Quitar un proyecto
    public boolean eliminarProyecto(String codigoEliminar) {
        boolean respuesta = false;
        int index = encontrarIndexProyectoPorCodigo(codigoEliminar);

        if (index != -1) {
            listProyecto[index] = null;
            respuesta = true;
        }

        return respuesta;
    }

    public int encontrarIndexProyectoPorCodigo(String codigoBuscar) {
        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null && listProyecto[i].getCodigo().equals(codigoBuscar)) {
                return i;
            }
        }

        return -1;
    }

}
