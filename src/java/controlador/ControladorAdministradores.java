/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.AdministradoresDAO;
import DAO.VeredasDAO;
import DAO.DonacionesDAO;
import DAO.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Administrador;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class ControladorAdministradores extends HttpServlet {

    AdministradoresDAO dao = new AdministradoresDAO();
    Administrador p = new Administrador();
    Administrador p1 = new Administrador();
    DonacionesDAO r = new DonacionesDAO();
    UsuariosDAO u = new UsuariosDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAdministradores</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAdministradores at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accion;
        accion = request.getParameter("accion");
        switch (accion){
            case "cerrarsesion":
                session.invalidate();
                request.getRequestDispatcher("usuario.jsp").forward(request,response);
                break;
            case "admin login":
                session.setAttribute("admin", "admin");
                request.getRequestDispatcher("admin.jsp").forward(request,response);
                break;
        }
    }
        
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion;
        accion = request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<Administrador>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("tablaAdmins.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("addAdmin.jsp").forward(request, response);
                break;
                
            case "Guardar":
                int idAdmin= Integer.parseInt((String)request.getParameter("txtid"));
                String user =request.getParameter("txtuser");
                String nom=request.getParameter("txtnom");
                String ape=request.getParameter("txtape");
                String pass=request.getParameter("txtpass");
                int id= Integer.parseInt((String)request.getParameter("txttipo"));
                
                p1.setIdAdmin(idAdmin);
                p1.setUsuario(user);
                p1.setNombre(nom); 
                p1.setApellido(ape);
                p1.setContrasena(pass); 
                p1.setIdUsuario(id); 
                
                System.out.println(p1.toString());
                dao.agregar(p1);
                request.getRequestDispatcher("ControladorAdministradores?accion=Listar").forward(request, response);
                break;
            
            case "Editar":
                String ide=request.getParameter("id");
                System.out.println(ide);
                Administrador pe = dao.listarId(ide);
                request.setAttribute("persona",pe);
                request.getRequestDispatcher("editAdmin.jsp").forward(request, response);
                break;
                
            case "Actualizar":
                int idAdmin1= Integer.parseInt((String)request.getParameter("txtid"));
                String user1 =request.getParameter("txtuser");
                String nom1=request.getParameter("txtnom");
                String ape1=request.getParameter("txtape");
                String pass1=request.getParameter("txtpass");
                int id1= Integer.parseInt((String)request.getParameter("txttipo"));
                
                p.setIdAdmin(idAdmin1);
                p.setUsuario(user1);
                p.setNombre(nom1); 
                p.setApellido(ape1);
                p.setContrasena(pass1); 
                p.setIdUsuario(id1); 
                
                dao.actualizar(p);
                request.getRequestDispatcher("ControladorAdministradores?accion=Listar").forward(request, response);
                break;
                
            
            case "Delete":
                String id3=request.getParameter("id");
                dao.delete(id3);
                request.getRequestDispatcher("ControladorAdministradores?accion=Listar").forward(request, response);
                break;  
                
            case "irreportes":
                request.setAttribute("activas",r.contarActivas() );
                request.setAttribute("canceladas",r.contarCanceladas());
                request.setAttribute("exitosas",r.contarExitosas());
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
                break;
                
            case "irreportes2":
                request.setAttribute("admi",u.contarAdministradores());
                request.setAttribute("insti",u.contarInstituciones());
                request.getRequestDispatcher("reportesUsuarios.jsp").forward(request, response);
                break;    
            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
