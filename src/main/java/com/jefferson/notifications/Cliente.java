package com.jefferson.notifications;

public class Cliente {

    private String identificacion;
    private String nombre;
    private String telefono;
    private String correoElectronico;
    private String paisProcedencia;
    private boolean esFrecuente;
    private Proyecto[] listProyecto;


    public Cliente(String identificacion, String nombre, String telefono, String correoElectronico, String paisProcedencia, boolean esFrecuente) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paisProcedencia = paisProcedencia;
        this.esFrecuente = esFrecuente;
        listProyecto = new Proyecto[10];
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public boolean isEsFrecuente() {
        return esFrecuente;
    }

    public void setEsFrecuente(boolean esFrecuente) {
        this.esFrecuente = esFrecuente;
    }

    public Proyecto[] getListProyecto() {
        return listProyecto;
    }

    public void setListProyecto(Proyecto[] listProyecto) {
        this.listProyecto = listProyecto;
    }
}
