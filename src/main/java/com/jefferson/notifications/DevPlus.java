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

    public DevPlus(String nombre, String nit, String direccion, String telefono, String paginaWeb, Proyecto[] listProyecto, Desarrollador[] listDesarrollador, ServicioAdicional[] listServicioAdicional, Cliente[] listCliente) {
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

}
