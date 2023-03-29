/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.corcho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BD1
 */
@WebServlet(name = "CambiaCliente", urlPatterns = {"/CambiaCliente"})
public class Cambios extends HttpServlet {
    private String nomb;
    private int idx;
            Cliente cliente = new Cliente();

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
        
        HttpSession session = null;
        List<Cliente> clientes = null;
        session = request.getSession( );
        clientes = (List<Cliente>) session.getAttribute("clientes" );
        
        idx=Integer.parseInt(request.getParameter("id"));
        cliente = clientes.get(idx);

        
        
        
        response.setContentType("text/html;charset=UTF-8");
        String accion = null;
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregaCliente</title>");            
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body>");
            accion = request.getParameter("guardar" );
            if(accion != null && "Guardar".equals(accion) )
            {
                guardaCliente( request );
            }
            else
            {
                imprimirFormulario( out );
            }
            out.println("<a href=\"ClienteList\">Lista de clientes</a>");
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

    public void imprimirFormulario( PrintWriter out )
    {

         out.println("<form id=\"form2\">");
        out.println("<table class=\"table table-striped\">");
        out.println("<tr>");
        out.println("<td>Nombre</td><td>");
        out.println(("<input id=\"nombre\" value=")+ cliente.getNombre() +(" name=\"nombre\" type=\"text\" />"));
        out.println("</td>");
        
        out.println("<tr>");
        out.println("<td>Apellido Paterno</td><td>");
        out.println(("<input id=\"apellidoP\" value=")+cliente.getApellidoP() +(" name=\"apellidoP\" type=\"text\" />"));
        out.println("</td>");
        
        out.println("<tr>");
        out.println("<td>Apellido Materno</td><td>");
        out.println(("<input id=\"apellidoM\" value=")+cliente.getApellidoM()+(" name=\"apellidoM\" type=\"text\" />"));
        out.println("</td>");
        
        
        out.println("<tr>");
        out.println("<td>Carrera</td><td>");
        out.println(("<select width=\"80%\" class=\"form-select form-select-sm\" aria-label=\".form-select-sm example\" value=")+cliente.getCarrera()+("id=\"carrera\" name=\"carrera\" type=\"text\"/>"));
        out.println("<option selected>"+cliente.getCarrera()+"</option>");        
        out.println("<option value=\"Progra\">Progra</option>");        
        out.println("<option value=\"Maquinas\">Maquinas</option>");        
        out.println("<option value=\"Sistemas\">Sistemas</option>");        
        out.println("<option value=\"Meca\">Meca</option>");    
        
        out.println("<tr>");
        out.println("<td>Semestre</td><td>");
        out.println(("<select width=\"80%\" value=")+ cliente.getSemes()+ ("class=\"form-select form-select-sm\" aria-label=\".form-select-sm example\" id=\"semes\" name=\"semes\" type=\"text\"/>"));
        out.println("<option selected>"+ cliente.getSemes()+"</option>");        
        out.println("<option value=\"Primero\">Primero</option>");        
        out.println("<option value=\"Segundo\">Segundo</option>");        
        out.println("<option value=\"Tercer\">Tercero</option>");        
        out.println("<option value=\"Cuarto\">Cuarto</option>");        
        out.println("<option value=\"Quinto\">Quinto</option>");        
        out.println("<option value=\"Sexto\">Sexto</option>");        
        
        out.println("<tr>");
        out.println("<td>Genero</td><td>");
        out.println(("<select width=\"60%\" value=")+ cliente.getGenero() + ("class=\"form-select form-select-sm\" aria-label=\".form-select-sm example\" id=\"genero\" name=\"genero\" value=\"<%=datos.getGenero()%>\" type=\"text\"/>"));
        out.println("<option selected>"+ cliente.getGenero() +"</option>");        
        out.println("<option value=\"Masculino\">Masculino</option>");         
        out.println("<option value=\"Femenino\">Femenino</option>");         
        
        out.println("<tr>");
        out.println("<td>Calif</td><td>");
        out.println(("<select width=\"80%\" value=")+ cliente.getCalif() + ("class=\"form-select form-select-sm\" aria-label=\".form-select-sm example\" id=\"calif\" name=\"calif\" type=\"float\"/>"));
        out.println("<option selected>"+ cliente.getCalif() +"</option>");        
        out.println("<option value=\"1\">Uno</option>");        
        out.println("<option value=\"2\">Dos</option>");        
        out.println("<option value=\"3\">Tres</option>");        
        out.println("<option value=\"4\">Cuatro</option>");        
        out.println("<option value=\"5\">Cinco</option>");        
        out.println("<option value=\"6\">Seis</option>");  
        out.println("<option value=\"7\">Siete</option>");  
        out.println("<option value=\"8\">Ocho</option>");  
        out.println("<option value=\"9\">Nueve</option>");  
        out.println("<option value=\"10\">Diez</option>");
        
        out.println("<tr>");
        out.println("<td>Edad</td><td>");
        out.println(("<input id=\"edad\" name=\"edad\" type=\"number\" value=")+cliente.getEdad()+("/>"));
        out.println("</td>");
        
        
        out.println("<tr>");
        out.println("<td colspan=\"2\"><input id=\"guardar\" name=\"guardar\" value=\"Guardar\"  type=\"submit\" /></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");         
    }

    private void guardaCliente(HttpServletRequest request) 
    {
        Cliente cliente = new Cliente( );
        List<Cliente>list = null;
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApellidoP(request.getParameter("apellidoP"));
        cliente.setApellidoM(request.getParameter("apellidoM"));
        cliente.setEdad( getCampoInteger( request.getParameter("edad") ) );
        cliente.setCalif(getCampoInteger(request.getParameter("calif")));
        cliente.setCarrera(request.getParameter("carrera"));
        cliente.setGenero(request.getParameter("genero"));
        cliente.setSemes(request.getParameter("semes"));
        
        if( cliente.getApellidoM() == null || cliente.getApellidoP() == null ||
            cliente.getNombre() == null || cliente.getEdad() == null 
                || cliente.getCarrera() == null || cliente.getGenero() == null || cliente.getSemes() == null )
        {
            return;
        }
        list = (List<Cliente>) request.getSession().getAttribute("clientes");
        if( list == null )
        {
            list = new ArrayList<>();
            request.getSession().setAttribute("clientes", list);
        }
        list.add(cliente);
        
        
    }
    
    private void cambiarCliente(HttpServletRequest request){
        
    }
    
    
    
    private Integer getCampoInteger( String parametro )
    {
        try
        {
            return Integer.valueOf(parametro);
        }
        catch(NumberFormatException ex)
        {
            return  null;
        }
    }
}