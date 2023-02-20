/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meli
 */
public class Donacion1 {

    int id;
    String descripcion;
    String nombreContacto;
    String Contacto;
    String nombre_institucion;
    String nombre_necesidad;
    String nombre_estado;

    public Donacion1() {
    }

    public Donacion1(int id, String descripcion, String nombreContacto, String Contacto, String nombre_institucion, String nombre_necesidad, String nombre_estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombreContacto = nombreContacto;
        this.Contacto = Contacto;
        this.nombre_institucion = nombre_institucion;
        this.nombre_necesidad = nombre_necesidad;
        this.nombre_estado = nombre_estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    public String getNombre_necesidad() {
        return nombre_necesidad;
    }

    public void setNombre_necesidad(String nombre_necesidad) {
        this.nombre_necesidad = nombre_necesidad;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    @Override
    public String toString() {
        return "Donacion{" + "id=" + id + ", descripcion=" + descripcion + ", nombreContacto=" + nombreContacto + ", Contacto=" + Contacto + ", nombre_institucion=" + nombre_institucion + ", nombre_necesidad=" + nombre_necesidad + ", nombre_estado=" + nombre_estado + '}';
    }

    
}
