/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.InstitucionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;
import modelo.Institucion;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class ControladorInstituciones extends HttpServlet {
    InstitucionesDAO dao = new InstitucionesDAO();
    Institucion p = new Institucion();
    Institucion p1 = new Institucion();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInstituciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInstituciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion;
        accion = request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<Institucion>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("tablaInsti.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("addInsti.jsp").forward(request, response);
                break;
                
            case "Guardar":
                int id=Integer.parseInt((String)request.getParameter("txtid"));
                String nom=request.getParameter("txtnom");
                String tel=request.getParameter("txttel");
                String user=request.getParameter("txtus");
                String con=request.getParameter("txtcon");
                String Us=request.getParameter("txttip");
                String Ve=request.getParameter("txtver");
                
                p.setPlantel(id);
                p.setNombreInst(nom);
                p.setContact(tel);
                p.setNombreUs(user);
                p.setContrasena(con);
                p.setTipo_usuario(Us);
                p.setNombre_vereda(Ve);
                dao.agregar(p);
                
                request.getRequestDispatcher("usuario.jsp").forward(request, response);
                break;
                
            case "Guardar1":
                int id3=Integer.parseInt((String)request.getParameter("txtid"));
                String nom3=request.getParameter("txtnom");
                String tel3=request.getParameter("txttel");
                String user3=request.getParameter("txtus");
                String con3=request.getParameter("txtcon");
                String Us3=request.getParameter("txttip");
                String Ve3=request.getParameter("txtver");
                
                p.setPlantel(id3);
                p.setNombreInst(nom3);
                p.setContact(tel3);
                p.setNombreUs(user3);
                p.setContrasena(con3);
                p.setTipo_usuario(Us3);
                p.setNombre_vereda(Ve3);
                dao.agregar(p);
                
                request.getRequestDispatcher("tablaAdmins.jsp").forward(request, response);
                break;

            case "Editar":
                int ide=Integer.parseInt((String)request.getParameter("id"));
                Institucion pe=dao.listarId(ide);
                request.setAttribute("persona",pe);
                request.getRequestDispatcher("editInsti.jsp").forward(request, response);
                break;
            case "Actualizar":
                int id1=Integer.parseInt((String)request.getParameter("txtid"));
                String nom1=request.getParameter("txtnom");
                String tel1=request.getParameter("txttel");
                String user1=request.getParameter("txtus");
                String con1=request.getParameter("txtcon");
                String Us1=request.getParameter("txttip");
                String Ve1=request.getParameter("txtver");
                
                System.out.println("después del set");
                p.setPlantel(id1);
                p.setNombreInst(nom1);
                p.setContact(tel1);
                p.setNombreUs(user1);
                p.setContrasena(con1);
                p.setTipo_usuario(Us1);
                p.setNombre_vereda(Ve1);
                
                System.out.println(p.toString());
                System.out.println("después del set");
                dao.actualizar(p);
                request.getRequestDispatcher("ControladorInstituciones?accion=Listar").forward(request, response);
                break;
            case "Delete":
                int id2=Integer.parseInt((String)request.getParameter("id"));
                dao.delete(id2);
                request.getRequestDispatcher("ControladorInstituciones?accion=Listar").forward(request, response);
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
