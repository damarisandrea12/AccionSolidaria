/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.DonacionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Donacion;
import modelo.Testimonio;

/**
 *
 * @author Meli
 */
public class ControladorDonaciones extends HttpServlet {

    DonacionesDAO dao = new DonacionesDAO();
    Donacion p = new Donacion();
    Donacion p1 = new Donacion();

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
            out.println("<title>Servlet ControladorDonaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDonaciones at " + request.getContextPath() + "</h1>");
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
        switch (accion) {
            case "Listar":
                List<Donacion> datos = dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("donaciones.jsp").forward(request, response);
                break;

            case "Listar1":
                String codplantel = request.getParameter("idplantel");
                List<Donacion> datos1 = dao.listar1(codplantel);
                request.setAttribute("datos1", datos1);
                request.getRequestDispatcher("donaciones1.jsp").forward(request, response);
                break;

            case "Nuevo":
                request.getRequestDispatcher("addDonacion.jsp").forward(request, response);
                break;
            case "Nuevo1":
                request.getRequestDispatcher("addDonacion1.jsp").forward(request, response);
                break;

            case "Guardar":
                int id = Integer.parseInt((String) request.getParameter("txtid"));
                String est = request.getParameter("txtest");
                String ins = request.getParameter("txtins");
                String nec = request.getParameter("txtnec");
                String nom = request.getParameter("txtdes");
                String des = request.getParameter("txtcon");
                String tel = request.getParameter("txttel");

                p.setId(id);
                p.setNombre_estado(est);
                p.setNombre_institucion(ins);
                p.setNombre_necesidad(nec);
                p.setDescripcion(nom);
                p.setNombreContacto(des);
                p.setContacto(tel);

                System.out.println(p.toString());
                dao.agregar(p);
                request.getRequestDispatcher("ControladorDonaciones?accion=Listar").forward(request, response);
                break;

            case "Guardar1":
                int id7 = Integer.parseInt((String) request.getParameter("txtid"));
                String est7 = request.getParameter("txtest");
                String ins7 = request.getParameter("txtins");
                String nec7 = request.getParameter("txtnec");
                String nom7 = request.getParameter("txtdes");
                String des7 = request.getParameter("txtcon");
                String tel7 = request.getParameter("txttel");

                p.setId(id7);
                p.setNombre_estado(est7);
                p.setNombre_institucion(ins7);
                p.setNombre_necesidad(nec7);
                p.setDescripcion(nom7);
                p.setNombreContacto(des7);
                p.setContacto(tel7);

                System.out.println(p.toString());
                dao.agregar(p);
                request.getRequestDispatcher("ControladorDonaciones?accion=Listar1").forward(request, response);
                break;

            case "Editar":
                int ide = Integer.parseInt((String) request.getParameter("id"));
                Donacion pe = dao.listarId(ide);
                request.setAttribute("persona", pe);
                request.getRequestDispatcher("editDonacion.jsp").forward(request, response);
                break;
            case "Editar1":
                int ide4 = Integer.parseInt((String) request.getParameter("id"));
                Donacion pe1 = dao.listarId(ide4);
                request.setAttribute("persona", pe1);
                request.getRequestDispatcher("editDonacion1.jsp").forward(request, response);
                break;
            case "Actualizar":
                int id1 = Integer.parseInt((String) request.getParameter("txtid"));
                String est1 = request.getParameter("txtest");
                String ins1 = request.getParameter("txtins");
                String nec1 = request.getParameter("txtnec");
                String nom1 = request.getParameter("txtdes");
                String des1 = request.getParameter("txtcon");
                String tel1 = request.getParameter("txttel");
                p.setId(id1);
                p.setNombre_estado(est1);
                p.setNombre_institucion(ins1);
                p.setNombre_necesidad(nec1);
                p.setDescripcion(nom1);
                p.setNombreContacto(des1);
                p.setContacto(tel1);

                dao.actualizar(p);

                request.getRequestDispatcher("ControladorDonaciones?accion=Listar").forward(request, response);
                break;
            case "Actualizar1":
                int id9 = Integer.parseInt((String) request.getParameter("txtid"));
                String est9 = request.getParameter("txtest");
                String ins9 = request.getParameter("txtins");
                String nec9 = request.getParameter("txtnec");
                String nom9 = request.getParameter("txtdes");
                String des9 = request.getParameter("txtcon");
                String tel9 = request.getParameter("txttel");
                p.setId(id9);
                p.setNombre_estado(est9);
                p.setNombre_institucion(ins9);
                p.setNombre_necesidad(nec9);
                p.setDescripcion(nom9);
                p.setNombreContacto(des9);
                p.setContacto(tel9);

                dao.actualizar(p);

                request.getRequestDispatcher("ControladorDonaciones?accion=Listar1").forward(request, response);
                break;
            case "Delete":
                int id3 = Integer.parseInt((String) request.getParameter("id"));
                dao.delete(id3);
                request.getRequestDispatcher("ControladorDonaciones?accion=Listar").forward(request, response);
                break;
            case "Delete1":
                int id8 = Integer.parseInt((String) request.getParameter("id"));
                dao.delete(id8);
                request.getRequestDispatcher("ControladorDonaciones?accion=Listar1").forward(request, response);
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
