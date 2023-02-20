/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meli
 */
public class TipoUsuario {
    
    int id;
    String tipoUs;

    public TipoUsuario() {
    }

    public TipoUsuario(int id, String tipoUs) {
        this.id = id;
        this.tipoUs = tipoUs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoUs() {
        return tipoUs;
    }

    public void setTipoUs(String tipoUs) {
        this.tipoUs = tipoUs;
    }
    
    
}
