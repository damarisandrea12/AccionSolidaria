/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.AdministradoresDAO;
import DAO.InstitucionesDAO;
import DAO.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Institucion;
import modelo.TipoUsuario;

/**
 *
 * @author Meli
 */
public class ControladorUsuarios extends HttpServlet {
    UsuariosDAO dao = new UsuariosDAO();
    TipoUsuario p = new TipoUsuario();
    TipoUsuario p1 = new TipoUsuario();
    InstitucionesDAO daoi = new InstitucionesDAO();
    AdministradoresDAO daoa = new AdministradoresDAO();
    int IdInstitucion;
    Institucion i = new Institucion();

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
            out.println("<title>Servlet ControladorUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuarios at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String accion;
        accion = request.getParameter("accion");
        switch (accion) {
            case "cerrarsesion":
                session.invalidate();
                request.getRequestDispatcher("usuario.jsp").forward(request, response);
                break;
        }
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
        HttpSession session = request.getSession();
        String accion;
        accion = request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<TipoUsuario>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("tipoUsuarios.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                request.getRequestDispatcher("addTipoUser.jsp").forward(request, response);
                break;
                
            case "Guardar":
                int id=Integer.parseInt((String)request.getParameter("txtid"));
                String nom=request.getParameter("txtnom");
                p1.setId(id);
                p1.setTipoUs(nom);  
                System.out.println(p1.toString());
                dao.agregar(p1);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;

            case "Editar":
                int ide=Integer.parseInt((String)request.getParameter("id"));
                TipoUsuario pe=dao.listarId(ide);
                request.setAttribute("persona",pe);
                request.getRequestDispatcher("editTipoUser.jsp").forward(request, response);
                break;
            case "Actualizar":
                int id1=Integer.parseInt((String)request.getParameter("txtid"));
                String nom1=request.getParameter("txtnom");
                p.setId(id1);
                p.setTipoUs(nom1);
                dao.actualizar(p);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;
            case "Delete":
                int id2=Integer.parseInt((String)request.getParameter("id"));
                dao.delete(id2);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;
                
            case "Iniciar sesion":
                String usuario;
                usuario = request.getParameter("usuario");
                String Contrasena;
                Contrasena = request.getParameter("Contrasena");
                if (usuario.equals("admin") && Contrasena.equals("123")) {
                    session.setAttribute("admin", "admin");
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } else {
                    i = daoi.iniciarsesionInsti(usuario, Contrasena);
                    if (i != null) {
                        IdInstitucion = i.getPlantel();
                        session.setAttribute("nombre", i.getNombreUs());
                        session.setAttribute("idplantel", i.getNombreInst());
                        request.getRequestDispatcher("institucion.jsp").forward(request, response);
                    } else {
                        if (daoa.iniciarsesionAdmin(usuario, Contrasena)) {
                            session.setAttribute("admin", "admin");
                            request.getRequestDispatcher("admin.jsp").forward(request, response);
                        } else {
                            request.setAttribute("msg", "correo o contraseña incorrecta");
                            request.getRequestDispatcher("usuario.jsp").forward(request, response);
                        }
                    }
                }
                break;
                
            case "misdatos":
                request.setAttribute("i", i);
                request.getRequestDispatcher("Misdatos.jsp").forward(request, response);
                break;

            case "regresar":
                session.setAttribute("nombre", i.getNombreUs());
                session.setAttribute("idplantel", i.getNombreInst());
                request.getRequestDispatcher("institucion.jsp").forward(request, response);
                break;
                
            case "actualizardatos":
                String nomusuario;
                nomusuario = request.getParameter("usuarioe");
                String numcontacto;
                numcontacto = request.getParameter("contactoe");
                String contrasenad;
                contrasenad = request.getParameter("Contrasenae");
                i = dao.actualizardatos(nomusuario, numcontacto, contrasenad, IdInstitucion);
                if (i!=null) {
                    request.setAttribute("msg", "actualizacion correcta");
                }else{
                    request.setAttribute("msg", "error al actualizar");
                }
                request.setAttribute("i", i);
                request.getRequestDispatcher("Misdatos.jsp").forward(request, response);
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
