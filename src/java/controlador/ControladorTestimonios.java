/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.TestimoniosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Testimonio;

/**
 *
 * @author Meli
 */
public class ControladorTestimonios extends HttpServlet {
    
    TestimoniosDAO dao = new TestimoniosDAO();
    Testimonio p = new Testimonio();
    Testimonio p1 = new Testimonio();

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
            out.println("<title>Servlet ControladorTestimonios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorTestimonios at " + request.getContextPath() + "</h1>");
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
                List<Testimonio>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("tablaTesti.jsp").forward(request, response);
                break;
                
            case "Listar1":
                String codplantel = request.getParameter("idplantel");
                List<Testimonio> datos1 = dao.listar1(codplantel);
                request.setAttribute("datos1", datos1);
                request.getRequestDispatcher("tablaTesti1.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("addTestimonio.jsp").forward(request, response);
                break;
            case "Nuevo1":
                request.getRequestDispatcher("addTestimonio1.jsp").forward(request, response);
                break;
                
            case "Guardar":
                int id=Integer.parseInt((String)request.getParameter("txtid"));
                String nom=request.getParameter("txtnom");
                String desc=request.getParameter("txtdesc");
                String don=request.getParameter("txtdon");
                String Inst=request.getParameter("txtins");
                
                p1.setId(id);
                p1.setNombre(nom);  
                p1.setDescripcion(desc); 
                p1.setDonante(don); 
                p1.setnombre_institucion(Inst);
                dao.agregar(p1);
                request.getRequestDispatcher("ControladorTestimonios?accion=Listar").forward(request, response);
                break;
                
            case "Guardar1":
                int id5=Integer.parseInt((String)request.getParameter("txtid"));
                String nom5=request.getParameter("txtnom");
                String desc5=request.getParameter("txtdesc");
                String don5=request.getParameter("txtdon");
                String Inst5=request.getParameter("txtins");
                
                p1.setId(id5);
                p1.setNombre(nom5);  
                p1.setDescripcion(desc5); 
                p1.setDonante(don5); 
                p1.setnombre_institucion(Inst5);
                dao.agregar(p1);
                request.getRequestDispatcher("ControladorTestimonios?accion=Listar1").forward(request, response);
                break;

            case "Editar":
                int ide=Integer.parseInt((String)request.getParameter("id"));
                Testimonio pe=dao.listarId(ide);
                request.setAttribute("persona",pe);
                request.getRequestDispatcher("editTestimonio.jsp").forward(request, response);
                break;
            case "Editar1":
                int ide1=Integer.parseInt((String)request.getParameter("id"));
                Testimonio pe1=dao.listarId(ide1);
                request.setAttribute("persona",pe1);
                request.getRequestDispatcher("editTestimonio1.jsp").forward(request, response);
                break;    
                
            case "Actualizar":
                int id1=Integer.parseInt((String)request.getParameter("txtid"));
                String nom1=request.getParameter("txtnom");
                String desc1=request.getParameter("txtdesc");
                String don1=request.getParameter("txtdon");
                String Inst1=request.getParameter("txtins");
                
                p1.setId(id1);
                p1.setNombre(nom1);  
                p1.setDescripcion(desc1); 
                p1.setDonante(don1); 
                p1.setnombre_institucion(Inst1);
                dao.actualizar(p1);
                
                request.getRequestDispatcher("ControladorTestimonios?accion=Listar").forward(request, response);
                break;
            case "Actualizar1":
                int id9=Integer.parseInt((String)request.getParameter("txtid"));
                String nom9=request.getParameter("txtnom");
                String desc9=request.getParameter("txtdesc");
                String don9=request.getParameter("txtdon");
                String Inst9=request.getParameter("txtins");
                
                p1.setId(id9);
                p1.setNombre(nom9);  
                p1.setDescripcion(desc9); 
                p1.setDonante(don9); 
                p1.setnombre_institucion(Inst9);
                dao.actualizar(p1);
                
                request.getRequestDispatcher("ControladorTestimonios?accion=Listar1").forward(request, response);
                break;    
                
            case "Delete":
                int id2=Integer.parseInt((String)request.getParameter("id"));
                dao.delete(id2);
                request.getRequestDispatcher("ControladorTestimonios?accion=Listar").forward(request, response);
                break;
                
            case "Delete1":
                int id6=Integer.parseInt((String)request.getParameter("id"));
                dao.delete1(id6);
                request.getRequestDispatcher("ControladorTestimonios?accion=Listar1").forward(request, response);
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
