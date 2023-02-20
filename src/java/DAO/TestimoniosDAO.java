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
import modelo.Testimonio;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class TestimoniosDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion ();
    Connection con;
    
    public List listar(){
        List<Testimonio>lista = new ArrayList<>();
        String sql = "SELECT testimonios.id_testimonio, instituciones.nombre_institucion, testimonios.nombre_testimonio, testimonios.descripcion_testimonio, testimonios.donante FROM ((testimonios INNER JOIN instituciones ON testimonios.cod_plantel = instituciones.cod_plantel))";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Testimonio v = new Testimonio ();
                v.setId(rs.getInt(1));
                v.setnombre_institucion(rs.getString(2));
                v.setNombre(rs.getString(3));
                v.setDescripcion(rs.getString(4));
                v.setDonante(rs.getString(5));
                
                lista.add(v);
            }
            
        }catch (Exception e){
            
        }
        return lista;
    }
    
    public List listar1(String nombre){
        List<Testimonio>lista = new ArrayList<>();
        String sql = "SELECT testimonios.id_testimonio, instituciones.nombre_institucion, testimonios.nombre_testimonio, testimonios.descripcion_testimonio, testimonios.donante FROM ((testimonios INNER JOIN instituciones ON testimonios.cod_plantel = instituciones.cod_plantel))where instituciones.nombre_institucion ='" + nombre + "'";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Testimonio v = new Testimonio ();
                v.setId(rs.getInt(1));
                v.setnombre_institucion(rs.getString(2));
                v.setNombre(rs.getString(3));
                v.setDescripcion(rs.getString(4));
                v.setDonante(rs.getString(5));
                
                lista.add(v);
            }
            
        }catch (Exception e){
            
        }
        return lista;
    }
    public int agregar(Testimonio v){
        int r=0;
        String sql ="insert into testimonios (id_testimonio, cod_plantel, nombre_testimonio, descripcion_testimonio, donante) values(?,?,?,?,?)";
        try{
            con=c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setString(2, v.getnombre_institucion());
            ps.setString(3, v.getNombre());
            ps.setString(4, v.getDescripcion());
            ps.setString(5, v.getDonante());
            
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
    
    public Testimonio listarId(int id){
        String sql="select * from Testimonios where id_testimonio="+id;
        Testimonio v =new Testimonio();
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                v.setId(rs.getInt(1));
                v.setnombre_institucion(rs.getString(2));
                v.setNombre(rs.getString(3));
                v.setDescripcion(rs.getString(4));
                v.setDonante(rs.getString(5));
                
            }
        }catch (Exception e){
            
        }
        return v;
    }
    
    public int actualizar (Testimonio p){
        int r=0;
        String sql ="update testimonios set cod_plantel=?, nombre_testimonio=?, descripcion_testimonio=?, donante=? where id_testimonio=?";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getnombre_institucion());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getDescripcion());
            ps.setString(4, p.getDonante());
            ps.setInt(5, p.getId());
            System.out.println(p.getId());
            
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setDonante(rs.getString(4));
                p.setnombre_institucion(rs.getString(5));
            }
        }catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from testimonios where id_testimonio="+id;
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
    
    public void delete1(int id){
        String sql = "delete from testimonios where id_testimonio="+id;
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
    
}
