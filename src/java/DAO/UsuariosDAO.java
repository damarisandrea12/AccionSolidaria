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
import modelo.Conexion;
import modelo.Institucion;
import modelo.TipoUsuario;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class UsuariosDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion ();
    Connection con;
    
    public List listar(){
        List<TipoUsuario>lista = new ArrayList<>();
        String sql = "select * from usuarios";
        try{
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                TipoUsuario v = new TipoUsuario ();
                v.setId(rs.getInt (1));
                v.setTipoUs(rs.getString (2));
                
                lista.add(v);
            }
            
        }catch (Exception e){
            
        }
        return lista;
    }
    public int agregar(TipoUsuario v){
        int r=0;
        String sql ="insert into usuarios(id_usuario, tipo_usuario) values(?,?)";
        try{
            con=c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setString(2, v.getTipoUs());
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
    
    public TipoUsuario listarId(int id){
        String sql="select * from usuarios where id_usuario="+id;
        TipoUsuario v =new TipoUsuario();
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                v.setId(rs.getInt(1));
                v.setTipoUs(rs.getString(2));
                
            }
        }catch (Exception e){
            
        }
        return v;
    }
    
    public int actualizar (TipoUsuario p){
        int r=0;
        String sql ="update usuarios set tipo_usuario=? where id_usuario=?";
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getTipoUs());
            ps.setInt(2, p.getId());
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setTipoUs(rs.getString(2));
            }
        }catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from usuarios where id_usuario="+id;
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            
        }
    }
    public int contarInstituciones(){
        String sql = "select count (*) from instituciones";
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
    
    public int contarAdministradores(){
        String sql = "select count(*) from administradores";
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
    public Institucion actualizardatos(String nomusuario, String numcontacto, String contrasenad, int Id){
        Institucion i= new Institucion();
        try {
            String sql = "UPDATE instituciones SET contacto  = ?, nombre_usuario = ?, contrasena = ? WHERE  cod_plantel = ?";
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, numcontacto);
            ps.setString(2, nomusuario);
            ps.setString(3,contrasenad);
            ps.setInt(4,Id);
            ps.executeUpdate();
            i.setContact(numcontacto);
            i.setNombreUs(nomusuario);
            i.setContrasena(contrasenad);
            i.setPlantel(Id);
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


