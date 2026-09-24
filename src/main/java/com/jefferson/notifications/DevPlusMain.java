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
