/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meli
 */
public class Administrador {
    int idAdmin;
    int idUsuario;
    String usuario;
    String nombre;
    String apellido;
    String contrasena;

    public Administrador() {
    }

    public Administrador(int idAdmin, int idUsuario, String usuario, String nombre, String apellido, String contrasena) {
        this.idAdmin = idAdmin;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idAdmin=" + idAdmin + ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", contrasena=" + contrasena + '}';
    }
    
    
    
}
