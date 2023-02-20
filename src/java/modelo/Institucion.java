/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meli
 */
public class Institucion {
    
    int plantel;
    String nombreInst;
    String Contact;
    String nombreUs;
    String contrasena;
    String tipo_usuario;
    String nombre_vereda;

    public Institucion() {
    }

    public Institucion(int plantel, String nombreInst, String Contact, String nombreUs, String contrasena, String tipo_usuario, String nombre_vereda) {
        this.plantel = plantel;
        this.nombreInst = nombreInst;
        this.Contact = Contact;
        this.nombreUs = nombreUs;
        this.contrasena = contrasena;
        this.tipo_usuario = tipo_usuario;
        this.nombre_vereda = nombre_vereda;
    }

    public int getPlantel() {
        return plantel;
    }

    public void setPlantel(int plantel) {
        this.plantel = plantel;
    }

    public String getNombreInst() {
        return nombreInst;
    }

    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre_vereda() {
        return nombre_vereda;
    }

    public void setNombre_vereda(String nombre_vereda) {
        this.nombre_vereda = nombre_vereda;
    }

    @Override
    public String toString() {
        return "Institucion{" + "plantel=" + plantel + ", nombreInst=" + nombreInst + ", Contact=" + Contact + ", nombreUs=" + nombreUs + ", contrasena=" + contrasena + ", tipo_usuario=" + tipo_usuario + ", nombre_vereda=" + nombre_vereda + '}';
    }

    
    
    
}
