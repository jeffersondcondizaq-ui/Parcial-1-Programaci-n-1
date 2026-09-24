package com.jefferson.notifications;

public class Proyecto {

    private String codigo;
    private String fechaSolicitud;
    private String fechaInicio;
    private String fechaEntrega;
    private String estado;
    private String metodoPago;
    private double valorTotalp;

    private Cliente cliente;
    private Desarrollador[] listDesarrolador;
    private ServicioAdicional[] listServicioAdicional;

    public Proyecto(String codigo, String fechaSolicitud, String fechaInicio, String fechaEntrega, String estado, String metodoPago, double valorTotalp, Cliente cliente) {
        this.codigo = codigo;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotalp = valorTotalp;
        this.cliente = cliente;
        listDesarrolador = new Desarrollador[10];
        listServicioAdicional = new ServicioAdicional[10];

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotalp() {
        return valorTotalp;
    }

    public void setValorTotalp(double valorTotalp) {
        this.valorTotalp = valorTotalp;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Desarrollador[] getListDesarrolador() {
        return listDesarrolador;
    }

    public void setListDesarrolador(Desarrollador[] listDesarrolador) {
        this.listDesarrolador = listDesarrolador;
    }

    public ServicioAdicional[] getListServicioAdicional() {
        return listServicioAdicional;
    }

    public void setListServicioAdicional(ServicioAdicional[] listServicioAdicional) {
        this.listServicioAdicional = listServicioAdicional;
    }
}
