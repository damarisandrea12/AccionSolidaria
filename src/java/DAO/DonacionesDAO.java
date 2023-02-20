/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Donacion;
import modelo.Donacion1;


/**
 *
 * @author Meli
 */
public class DonacionesDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion ();
    Connection con;
    
    public List listar(){
        List<Donacion>lista = new ArrayList<>();
        String sql = "SELECT donaciones.id_donacion, estados.nombre_estado, instituciones.nombre_institucion, necesidades.nombre_necesidad, donaciones.descripcion, donaciones.nombre_contacto, donaciones.contacto FROM ((donaciones INNER JOIN necesidades ON  donaciones.id_necesidad = necesidades.id_necesidad INNER JOIN estados  ON donaciones.id_estado = estados.id_estado INNER JOIN instituciones ON donaciones.cod_plantel = instituciones.cod_plantel)) order by id_donacion";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Donacion v = new Donacion ();
                
                v.setId(rs.getInt(1));
                v.setNombre_estado(rs.getString(2));
                v.setNombre_institucion(rs.getString(3));
                v.setNombre_necesidad(rs.getString(4));
                v.setDescripcion(rs.getString(5));
                v.setNombreContacto(rs.getString(6));
                v.setContacto(rs.getString(7));
                
                lista.add(v);
            }
            
        }catch (Exception e){
            
        }
        return lista;
    }
    public List listar1(String nombre){
        List<Donacion>lista = new ArrayList<>();
        String sql = "SELECT donaciones.id_donacion, estados.nombre_estado, instituciones.nombre_institucion, necesidades.nombre_necesidad, donaciones.descripcion, donaciones.nombre_contacto, donaciones.contacto FROM ((donaciones INNER JOIN necesidades ON  donaciones.id_necesidad = necesidades.id_necesidad INNER JOIN estados  ON donaciones.id_estado = estados.id_estado INNER JOIN instituciones ON donaciones.cod_plantel = instituciones.cod_plantel)) where instituciones.nombre_institucion ='" + nombre + "'";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Donacion v = new Donacion ();
                
                v.setId(rs.getInt(1));
                v.setNombre_estado(rs.getString(2));
                v.setNombre_institucion(rs.getString(3));
                v.setNombre_necesidad(rs.getString(4));
                v.setDescripcion(rs.getString(5));
                v.setNombreContacto(rs.getString(6));
                v.setContacto(rs.getString(7));
                
                lista.add(v);
            }
            
        }catch (Exception e){
            
        }
        return lista;
    }
    
    public int agregar(Donacion v){
        int r=0;
        String sql ="insert into Donaciones (id_donacion, id_estado, cod_plantel, id_necesidad, descripcion, nombre_contacto, contacto) values(?,?,?,?,?,?,?)";
        try{
            con=c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setString(2, v.getNombre_estado());
            ps.setString(3, v.getNombre_institucion());
            ps.setString(4, v.getNombre_necesidad());
            ps.setString(5, v.getDescripcion());
            ps.setString(6, v.getNombreContacto());
            ps.setString(7, v.getContacto());
            
            r=ps.executeUpdate();
            
            if(r==1){
                r=1;
            }else{
                r=0;
            }
        }catch(Exception e){
            
        }
        return r;
    }
    
    public Donacion listarId(int id){
        String sql="select * from Donaciones where id_donacion="+id;
        Donacion v =new Donacion();
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                v.setId(rs.getInt(1));
                v.setNombre_estado(rs.getString(2));
                v.setNombre_institucion(rs.getString(3));
                v.setNombre_necesidad(rs.getString(4));
                v.setDescripcion(rs.getString(5));
                v.setNombreContacto(rs.getString(6));
                v.setContacto(rs.getString(7));
                
            }
        }catch (Exception e){
            
        }
        return v;
    }
    
    public int actualizar (Donacion p){
        int r=0;
        String sql ="update Donaciones set id_estado=?, cod_plantel=?, id_necesidad=?, descripcion=?,nombre_contacto=?, contacto=? where id_donacion=?";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombre_estado());
            ps.setString(2, p.getNombre_institucion());
            ps.setString(3, p.getNombre_necesidad());
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getNombreContacto());
            ps.setString(6, p.getContacto());
            ps.setInt(7, p.getId());
         
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre_estado(rs.getString(2));
                p.setNombre_institucion(rs.getString(3));
                p.setNombre_necesidad(rs.getString(4));
                p.setDescripcion(rs.getString(5));
                p.setNombreContacto(rs.getString(6));
                p.setContacto(rs.getString(7));
            }
        }catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from Donaciones where id_donacion="+id;
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
    public int contarActivas(){
        String sql = "select count(*)from donaciones where id_estado=1";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (Exception e){
            
        }
        return 0;
    }
    
    public int contarCanceladas(){
        String sql = "select count(*)from donaciones where id_estado=2";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (Exception e){
            
        }
        return 0;
    }
    
    public int contarExitosas(){
        String sql = "select count(*)from donaciones where id_estado=3";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (Exception e){
            
        }
        return 0;
    }
    
}
   
