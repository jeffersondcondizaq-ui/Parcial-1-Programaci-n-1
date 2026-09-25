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

    //Cambia el estado del proyecto
    public void cambiarEstadoProyecto(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    //Agrega un desarrollador a este proyecto
    public boolean agregarDesarrollador(Desarrollador desarrollador) {
        for (int i = 0; i < listDesarrolador.length; i++) {
            if (listDesarrolador[i] == null) {
                listDesarrolador[i] = desarrollador;
                return true;
            }
        }

        return false;
    }

    //Agrega un servicio adicional a este proyecto
    public boolean agregarServicioAdicional(ServicioAdicional servicio) {
        for (int i = 0; i < listServicioAdicional.length; i++) {
            if (listServicioAdicional[i] == null) {
                listServicioAdicional[i] = servicio;
                return true;
            }
        }

        return false;
    }

    //Suma el precio de los servicios adicionales agregados a este proyecto
    public double calcularValorServiciosAdicionales() {
        double valorServicios = 0;

        for (int i = 0; i < listServicioAdicional.length; i++) {
            if (listServicioAdicional[i] != null) {
                valorServicios += listServicioAdicional[i].getPrecio();
            }
        }

        return valorServicios;
    }

    //Convierte una fecha dd/mm/aaaa en un numero para poder restar fechas de forma basica
    static int convertirFechaANumero(String fecha) {
        String[] partesFecha = {"","",""};
        int indice = 0;

        for (int i = 0; i < fecha.length() ; i++) {
            if(fecha.charAt(i) == '/'){
                indice ++;
            }else {
                partesFecha[indice] += fecha.charAt(i);
            }
        }
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);

        return (anio * 360) + (mes * 30) + dia;
    }

    //Valida si este proyecto esta disponible (no se cruza) frente a otro rango de fechas
    public boolean validarDisponibilidad(String otraFechaInicio, String otraFechaEntrega) {
        int inicioEste = convertirFechaANumero(this.fechaInicio);
        int entregaEste = convertirFechaANumero(this.fechaEntrega);
        int inicioOtro = convertirFechaANumero(otraFechaInicio);
        int entregaOtro = convertirFechaANumero(otraFechaEntrega);

        boolean seCruzanLasFechas = inicioOtro <= entregaEste && inicioEste <= entregaOtro;

        return !seCruzanLasFechas;
    }

    //Calcula la cantidad de dias de desarrollo de este proyecto (fechaInicio - fechaEntrega)
    public int calcularCantidadDias() {
        int numeroInicio = convertirFechaANumero(this.fechaInicio);
        int numeroEntrega = convertirFechaANumero(this.fechaEntrega);

        return numeroEntrega - numeroInicio;
    }

    //Calcula la tarifa total de un desarrollador para una cantidad de dias trabajados
    public static double calcularTarifaDesarrolladores(Desarrollador desarrollador, int cantidadDias) {
        return desarrollador.getTarifaDia() * cantidadDias;
    }

    //Calcula el posible descuento de un cliente frecuente sobre un subtotal
    public static double calcularDescuentos(Cliente cliente, double subtotal) {
        double descuento = 0;

        if (cliente.isEsFrecuente()) {
            descuento = subtotal * 0.1;
        }

        return descuento;
    }

    //Calcula el valor total del proyecto teniendo en cuenta tarifa de desarrolladores,
    //dias de desarrollo, servicios adicionales y descuentos de clientes frecuentes
    public double calcularValorTotal(int totalDias, double totalServicios, double descuentos, double tarifaDesarrolladores) {
        double valorTotal = tarifaDesarrolladores + totalServicios - descuentos;

        this.valorTotalp = valorTotal;

        return valorTotal;
    }
}
