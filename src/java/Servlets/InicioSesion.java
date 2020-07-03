/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.webDao;
import Modelo.webV;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;

/**
 *
 * @author jhone
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        PrintWriter out = response.getWriter();
        
        JSONArray jsonArray = new JSONArray();
        
        
        boolean respuesta = false;
        String mensaje = "";
        System.out.println(request);
        String usuario = request.getParameter("usuario");
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        
        if( usuario.length() > 0 && correo.length() > 0 && pass.length() > 0 ) {
            webDao dao = new webDao();
            webV getSet = new webV(usuario, correo, pass);
            boolean respuestaA = dao.autenticacion(getSet);
            if(respuestaA) {
                HttpSession objSesion = request.getSession(true);
                objSesion.setAttribute("usuario", usuario); // setAttribute con este le decimos que nos guarde un atributo de nuestro objeto. setAttribute nos pide dos claves 1)Como se va a llamar el objeto y la segunda es el valor del objeto
                respuesta = true;
                // response.sendRedirect("menu.jsp"); // Esto es para redireccionar
                System.out.print(getSet);
            } else {
                 respuesta = false;
            }
        }else {
            respuesta = false;
            mensaje = "Debe llenar todos los campos";
        }
        
        jsonArray.put(0, respuesta );
        jsonArray.put(1, mensaje );
        
        out.print(jsonArray);
        
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
