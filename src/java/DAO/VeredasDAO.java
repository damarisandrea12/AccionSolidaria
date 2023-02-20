/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class VeredasDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion ();
    Connection con;
    
    public List listar(){
        List<Veredas>lista = new ArrayList<>();
        String sql = "select * from veredas";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Veredas v = new Veredas ();
                v.setId(rs.getInt (1));
                v.setNombre(rs.getString (2));
                
                lista.add(v);
            }
            
        }catch (Exception e){
            
        }
        return lista;
    }
    public int agregar(Veredas v){
        int r=0;
        String sql ="insert into veredas(id_vereda,nombre_vereda) values(?,?)";
        try{
            con=c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setString(2, v.getNombre());
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
    
    public Veredas listarId(int id){
        String sql="select * from veredas where id_vereda="+id;
        Veredas v =new Veredas();
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                
            }
        }catch (Exception e){
            
        }
        return v;
    }
    
    public int actualizar (Veredas p){
        int r=0;
        String sql ="update veredas set nombre_vereda=? where id_vereda=?";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getId());
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
            }
        }catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from veredas where id_vereda="+id;
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
    
}
