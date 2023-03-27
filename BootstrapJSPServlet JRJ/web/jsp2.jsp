    <%-- 
    Document   : jsp2
    Created on : 14 mar 2023, 13:12:32
    Author     : corcho
--%>

<%@page import="java.util.List"%>
<%@page import="org.corcho.Datos"%>
<%@page import="org.corcho.Negocio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>mi jsp2!</h1>
        <%
            int i = 0;
            List<Datos> lista = null;
            String id = null;
            String borrar = null;
            session = request.getSession( true );
            
            if( session != null )
            {
                if( session.getAttribute("lista") != null )
                {
                    lista = (List)session.getAttribute( "lista" );
                }
            }
            id = request.getParameter( "id" );
            borrar = request.getParameter( "borrar" );
            if( "Submit".equals( borrar ) )
            {
                lista.remove( Integer.parseInt(id) );
            }
        %>
        <a href="jsp1.jsp">Regresar a jsp1 v1</a>
        <a href="jsp3.jsp">ir a jsp3</a>
        <table class="table table-hover">
            <tr>
                <td>#</td>
                <td>Id</td>
                <td>Nombre</td>
                <td>ApelliP</td>
                <td>ApelliM</td>
                <td>Smestre</td>
                <td>Genero</td>
                <td>Carrera</td>
                <td>Cal</td>
                <td>Acciones</td>
            </tr>
            <%
              if( lista != null && !lista.isEmpty() )
              {
                for( Datos datos : lista)
                {
            %>
            <tr>
                <td><%=i + 1%></td>
                <td><%=i%></td>
                <td><%=datos.getNombre( )%></td>
                <td><%=datos.getApelliP()%></td>
                <td><%=datos.getApelliM()%></td>
                <td><%=datos.getSemes()%></td>
                <td><%=datos.getGenero()%></td>
                <td><%=datos.getCarrera()%></td>
                <td><%=datos.getCalf()%></td>
                <td>
                    <a href="jsp2.jsp?id=<%=i%>&borrar=Submit">Borrar</a> 
                    <a href="jsp3.jsp?id=<%=i++%>&editar=Submit">Editar</a> 
                </td>
            </tr>
            <%
                }
              }
            %>
        </table>
    </body>
</html>
