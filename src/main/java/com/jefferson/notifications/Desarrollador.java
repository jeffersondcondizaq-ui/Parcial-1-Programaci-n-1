package com.jefferson.notifications;

public class Desarrollador {

    private String codigo;
    private String equipoTrabajo;
    private String nivel;
    private int maxProyectosSimultaneos;
    private double tarifaDia;
    private String estado;

    private Proyecto[] listProyecto;

    public Desarrollador(String codigo, String equipoTrabajo, String nivel, int maxProyectosSimultaneos, double tarifaDia, String estado) {
        this.codigo = codigo;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.maxProyectosSimultaneos = maxProyectosSimultaneos;
        this.tarifaDia = tarifaDia;
        this.estado = estado;
        listProyecto = new Proyecto[10];
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getMaxProyectosSimultaneos() {
        return maxProyectosSimultaneos;
    }

    public void setMaxProyectosSimultaneos(int maxProyectosSimultaneos) {
        this.maxProyectosSimultaneos = maxProyectosSimultaneos;
    }

    public double getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Cambia el estado del desarrollador y devuelve un mensaje de confirmacion
    public String cambiarEstadoDesarrollador(String nuevoEstado) {
        this.estado = nuevoEstado;
        return "El desarrollador " + this.codigo + " fue asiganado a un proyecto.";
    }

    public Proyecto[] getListProyecto() {
        return listProyecto;
    }

    public void setListProyecto(Proyecto[] listProyecto) {
        this.listProyecto = listProyecto;
    }

    //Agrega un proyecto a la lista de proyectos de este desarrollador
    public boolean agregarProyecto(Proyecto proyecto) {
        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] == null) {
                listProyecto[i] = proyecto;
                return true;
            }
        }

        return false;
    }

    //Cuenta en cuantos proyectos esta actualmente asignado este desarrollador
    public int contarProyectosAsignados() {
        int contador = 0;

        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    //Arma el texto con los proyectos en los que esta asignado este desarrollador
    public String listarProyectosAsignados() {
        String mensaje = "";
        boolean tieneProyectos = false;

        for (int i = 0; i < listProyecto.length; i++) {
            if (listProyecto[i] != null) {
                mensaje += "\n  - " + listProyecto[i].getCodigo() + " (" + listProyecto[i].getEstado() + ")";
                tieneProyectos = true;
            }
        }

        if (!tieneProyectos) {
            mensaje = "\n  Sin proyectos asignados.";
        }

        return mensaje;
    }
}