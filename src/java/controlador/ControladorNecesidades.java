/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.NecesidadesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoNecesidad;

/**
 *
 * @author Meli
 */
public class ControladorNecesidades extends HttpServlet {
    
    NecesidadesDAO dao = new NecesidadesDAO();
    TipoNecesidad p = new TipoNecesidad();
    TipoNecesidad p1 = new TipoNecesidad();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorNecesidades</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorNecesidades at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion;
        accion = request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<TipoNecesidad>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("tipoNecesidades.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("addTipoNece.jsp").forward(request, response);
                break;
                
            case "Guardar":
                int id=Integer.parseInt((String)request.getParameter("txtid"));
                String nom=request.getParameter("txtnom");
                p1.setId(id);
                p1.setNombre(nom);  
                System.out.println(p1.toString());
                dao.agregar(p1);
                request.getRequestDispatcher("ControladorNecesidades?accion=Listar").forward(request, response);
                break;

            case "Editar":
                int ide=Integer.parseInt((String)request.getParameter("id"));
                TipoNecesidad pe=dao.listarId(ide);
                request.setAttribute("persona",pe);
                request.getRequestDispatcher("editTipoNece.jsp").forward(request, response);
                break;
            case "Actualizar":
                int id1=Integer.parseInt((String)request.getParameter("txtid"));
                String nom1=request.getParameter("txtnom");
                p.setId(id1);
                p.setNombre(nom1);
                dao.actualizar(p);
                request.getRequestDispatcher("ControladorNecesidades?accion=Listar").forward(request, response);
                break;
            case "Delete":
                int id2=Integer.parseInt((String)request.getParameter("id"));
                dao.delete(id2);
                request.getRequestDispatcher("ControladorNecesidades?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
