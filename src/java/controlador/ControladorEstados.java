/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.EstadosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estados;
import modelo.Veredas;

/**
 *
 * @author Meli
 */
public class ControladorEstados extends HttpServlet {
    EstadosDAO dao = new EstadosDAO();
    Estados p = new Estados();
    Estados p1 = new Estados();

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
            out.println("<title>Servlet ControladorEstados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEstados at " + request.getContextPath() + "</h1>");
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
                List<Estados>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("estado.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("addEstados.jsp").forward(request, response);
                break;
                
            case "Guardar":
                int id=Integer.parseInt((String)request.getParameter("txtid"));
                String nom=request.getParameter("txtnom");
                p1.setId(id);
                p1.setNombre(nom);  
                System.out.println(p1.toString());
                dao.agregar(p1);
                request.getRequestDispatcher("ControladorEstados?accion=Listar").forward(request, response);
                break;

            case "Editar":
                int ide=Integer.parseInt((String)request.getParameter("id"));
                Estados pe=dao.listarId(ide);
                request.setAttribute("persona",pe);
                request.getRequestDispatcher("editEstado.jsp").forward(request, response);
                break;
            case "Actualizar":
                int id1=Integer.parseInt((String)request.getParameter("txtid"));
                String nom1=request.getParameter("txtnom");
                p.setId(id1);
                p.setNombre(nom1);
                dao.actualizar(p);
                request.getRequestDispatcher("ControladorEstados?accion=Listar").forward(request, response);
                break;
            case "Delete":
                int id2=Integer.parseInt((String)request.getParameter("id"));
                dao.delete(id2);
                request.getRequestDispatcher("ControladorEstados?accion=Listar").forward(request, response);
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
