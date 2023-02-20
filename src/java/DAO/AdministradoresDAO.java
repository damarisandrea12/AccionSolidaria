/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Administrador;
import modelo.Conexion;

/**
 *
 * @author Meli
 */
public class AdministradoresDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List listar() {
        List<Administrador> lista = new ArrayList<>();
        String sql = "select * from administradores";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Administrador v = new Administrador();
                v.setIdAdmin(rs.getInt(1));
                v.setUsuario(rs.getString(2));
                v.setNombre(rs.getString(3));
                v.setApellido(rs.getString(4));
                v.setContrasena(rs.getString(5));
                v.setIdUsuario(rs.getInt(6));
                lista.add(v);
            }
        } catch (SQLException e) {

        }
        
        return lista;
    }

    public int agregar(Administrador v) {
        int r = 0;
        String sql = "insert into administradores(id_admin, usuario, nombre,apellido, contrasena, id_usuario) values(?,?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdAdmin());
            ps.setString(2, v.getUsuario());
            ps.setString(3, v.getNombre());
            ps.setString(4, v.getApellido());
            ps.setString(5, v.getContrasena());
            ps.setInt(6, v.getIdUsuario());
            System.out.print(v.toString());
            System.out.print("antes");
            r = ps.executeUpdate();
            System.out.print("despues");
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            System.out.print(r);
        } catch (SQLException e) {

        }
        return r;
    }

    public Administrador listarId(String id)  {
        String sql = "select * from administradores where id_admin=" + id;
        Administrador v = new Administrador();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                v.setIdAdmin(rs.getInt(1));
                v.setUsuario(rs.getString(2));
                v.setNombre(rs.getString(3));
                v.setApellido(rs.getString(4));
                v.setContrasena(rs.getString(5));
                v.setIdUsuario(rs.getInt(6));

            }
        } catch (SQLException e) {

        }
        return v;
    }

    public int actualizar(Administrador p){
        int r = 0;
        String sql = "update administradores set usuario=?, nombre=?, apellido=?, contrasena=?, id_usuario=? where id_admin=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getUsuario());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getContrasena());
            ps.setInt(5, p.getIdUsuario());
            ps.setInt(6, p.getIdAdmin());

            System.out.println(p.getContrasena());
            System.out.println(p.getIdAdmin());

            r = ps.executeUpdate();
            System.out.println("después");
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            while (rs.next()) {
                p.setIdAdmin(rs.getInt(1));
                p.setUsuario(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setApellido(rs.getString(4));
                p.setContrasena(rs.getString(5));
                p.setIdUsuario(rs.getInt(6));
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public void delete(String id) {
        String sql = "delete from administradores where id_admin=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public boolean iniciarsesionAdmin(String usuario, String contrasena)  {
        String sql = "select * from administradores where usuario=? and contrasena=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
