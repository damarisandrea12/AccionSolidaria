/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static java.awt.SystemColor.window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Institucion;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class InstitucionesDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion ();
    Connection con;
    
    public List listar(){
        List<Institucion>lista = new ArrayList<>();
        String sql = "SELECT instituciones.cod_plantel, instituciones.nombre_institucion, instituciones.contacto,instituciones.nombre_usuario, instituciones.contrasena, usuarios.tipo_usuario, veredas.nombre_vereda FROM ((instituciones INNER JOIN veredas ON instituciones.id_vereda = veredas.id_vereda INNER JOIN usuarios ON instituciones.id_usuario = usuarios.id_usuario))";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Institucion v = new Institucion ();
                v.setPlantel(rs.getInt (1));
                v.setNombreInst(rs.getString (2));
                v.setContact(rs.getString (3));
                v.setNombreUs(rs.getString (4));
                v.setContrasena(rs.getString (5));
                v.setTipo_usuario(rs.getString (6));
                v.setNombre_vereda(rs.getString (7));
                
                
                lista.add(v);
            }
            
            
        }catch (Exception e){
            
        }
        return lista;
    }
    public int agregar(Institucion v){
        int r=0;
        String sql ="insert into Instituciones values(?,?,?,?,?,?,?)";
        try{
            con=c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getPlantel());
            ps.setString(2, v.getNombreInst());
            ps.setString(3, v.getContact());
            ps.setString(4, v.getNombreUs());
            ps.setString(5, v.getContrasena());
            ps.setString(6, v.getTipo_usuario());
            ps.setString(7, v.getNombre_vereda());
            System.out.println("Atesdeguardar1234");
            r=ps.executeUpdate();
            if(r==1){
                r=1;
                System.out.println("despuesdeguardar");
            }else{
                r=0;
                System.out.println("oguardo");
            }
            System.out.println("termibó");
        }catch(Exception e){
            
        }
        return r;
    }
    
    public Institucion listarId(int id){
        String sql="select * from Instituciones where cod_plantel="+id;
        Institucion v =new Institucion();
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                
                v.setPlantel(rs.getInt (1));
                v.setNombreInst(rs.getString (2));
                v.setContact(rs.getString (3));
                v.setNombreUs(rs.getString (4));
                v.setContrasena(rs.getString (5));
                v.setTipo_usuario(rs.getString (6));
                v.setNombre_vereda(rs.getString (7));
                
            }
        }catch (Exception e){
            
        }
        return v;
    }
    
    public int actualizar (Institucion p){
        int r=0;
        String sql ="update instituciones set nombre_institucion=?, contacto=?, nombre_usuario=?,contrasena=?,id_usuario=?,id_vereda=? where cod_plantel=?";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombreInst());
            ps.setString(2, p.getContact());
            ps.setString(3, p.getNombreUs());
            ps.setString(4, p.getContrasena());
            ps.setString(5, p.getTipo_usuario());
            ps.setString(6, p.getNombre_vereda());
            ps.setInt(7, p.getPlantel());
            System.out.println("Antes del Execute");
            r=ps.executeUpdate();
            System.out.println("Despues del Execute");
            if(r==1){
                r=1;
            }else{
                r=0;
            }
            System.out.println(r);
            while (rs.next()){
                p.setPlantel(rs.getInt (1));
                p.setNombreInst(rs.getString (2));
                p.setContact(rs.getString (3));
                p.setNombreUs(rs.getString (4));
                p.setContrasena(rs.getString(5));
                p.setTipo_usuario(rs.getString (6));
                p.setNombre_vereda(rs.getString (7));
            }
        }catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from instituciones where cod_plantel="+id;
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
    public Institucion iniciarsesionInsti(String usuario, String contrasena) {
        String sql = "select nombre_usuario, nombre_institucion, contrasena, contacto, cod_plantel from instituciones where nombre_usuario=? and contrasena=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while (rs.next()) {
                Institucion i = new Institucion();
                i.setNombreUs(rs.getString(1));
                i.setNombreInst(rs.getString(2));
                i.setContrasena(rs.getString(3));
                i.setContact(rs.getString(4));
                i.setPlantel(rs.getInt(5));
                return i;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

