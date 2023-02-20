/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meli
 */
public class Testimonio {
    
    int id;
    String nombre;
    String descripcion;
    String donante;
    String nombre_institucion;

    public Testimonio() {
    }

    public Testimonio(int id, String nombre, String descripcion, String donante, String nombre_institucion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.donante = donante;
        this.nombre_institucion = nombre_institucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    public String getnombre_institucion() {
        return nombre_institucion;
    }

    public void setnombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    @Override
    public String toString() {
        return "Testimonio{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", donante=" + donante + ", nombre_institucion=" + nombre_institucion + '}';
    }
    
    
}
