package com.example.proyectin.modelo;

public class Cliente {
    private String cliente_id;
    private String nombre;
    private String Apellido;
    private String cedula;
    private String telefono;
    private String direccion;

    public Cliente(String cliente_id, String nombre, String apellido, String cedula, String telefono, String direccion) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        Apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {

    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
