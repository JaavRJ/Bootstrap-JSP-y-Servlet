<%-- 
    Document   : jsp3
    Created on : 16 mar 2023, 13:04:14
    Author     : alumno
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.corcho.Datos"%>
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
        <%
            
            
            String nombre = null;
            String calif = null;
            String guardar = null;
            String apelliP = null;
            String apelliM = null;
            String genero = null;
            String carrera = null;
            String semes = null;
            String id = null;
            String editar = null;
            String accion = "guardar";
            String actualizar = "guardar";
            Datos datos = null;
            Integer idx = null;
            List<Datos>lista = null;
            
            session = request.getSession( true );
            if( session != null )
            {
                if( session.getAttribute("lista") == null )
                {
                    session.setAttribute("lista", new ArrayList<Datos>());
                }
                lista = (List)session.getAttribute("lista");
            }
            nombre = request.getParameter( "nombre" );
            calif = request.getParameter( "calif" );
            apelliP = request.getParameter( "apelliP" );
            apelliM = request.getParameter( "apelliM" );
            genero = request.getParameter( "genero" );
            carrera = request.getParameter( "carrera" );
            semes = request.getParameter( "semes" );
            guardar = request.getParameter( "guardar" );
            id = request.getParameter( "id" );
            editar = request.getParameter( "editar" );
            actualizar = request.getParameter( "actualizar" );
            
            if( "Submit".equals( editar ) )
            {
                idx = Integer.parseInt( id );
                if( idx < lista.size() )
                {
                    datos = lista.get( idx );
                }
                accion = "actualizar";
            }
            
            if( "Submit".equals( guardar ) || "Submit".equals( actualizar ) )
            {
                if( "Submit".equals( guardar ) )
                {
                    datos = new Datos( );
                }
                else
                {
                    datos = lista.get(Integer.parseInt( id ) );
                }
                datos.setNombre(nombre);
                datos.setCalf( Float.parseFloat( calif ) ); 
                datos.setApelliM(apelliM);
                datos.setApelliP(apelliP);
                datos.setCarrera(carrera);
                datos.setGenero(genero);
                datos.setSemes(semes);
                if( "Submit".equals( guardar ) )
                {
                    lista.add( datos );
                }
        %>
                <h1>EXITO!</h1>
                <script>
                    console.log("Exito");
                </script>
                <a href="jsp2.jsp">Ir a jsp2 </a>
        <%
            }
            if( datos == null )
            {
                datos = new Datos( );
                datos.setNombre( "" );
                datos.setCalf( 0f );
                datos.setApelliM("");
                datos.setApelliP("");
                datos.setCarrera("");
                datos.setGenero("" );
                datos.setSemes("" );

            }
            if( !"Submit".equals( guardar ) && !"Submit".equals( actualizar ) )
            {
        %>  
        <form id="form1">
            <table class="table">
                <tr>
                    <td>Nombre</td>
                    <td><input id="nombre" name="nombre" value="<%=datos.getNombre()%>" type="text"/></td>

                </tr>
                <tr>
                    <tD>ApellidoP</tD>
                    <td><input id="apelliP" name="apelliP" value="<%=datos.getApelliP()%>" type="text"/></td>
                </tr>
                <tr>
                    <tD>ApellidoM</tD>
                    <td><input id="apelliM" name="apelliM" value="<%=datos.getApelliM()%>" type="text"/></td>
                </tr>
                <tr>
                    <tD>Carrera</tD>
                    <td><input id="carrera" name="carrera" value="<%=datos.getCarrera()%>" type="text"/></td>
                </tr>
                <tr>
                    <tD>Genero</tD>
                    <td><input id="genero" name="genero" value="<%=datos.getGenero()%>" type="text"/></td>
                </tr>
                <tr>
                    <tD>Semes</tD>
                    <td><input id="semes" name="semes" value="<%=datos.getSemes()%>" type="text"/></td>
                </tr>
                <tr >
                    <td>Calificación</td>
                    <td WIDTH="30%" alig><select width="80%" class="form-select form-select-sm" aria-label=".form-select-sm example" id="calif" name="calif" value="<%=datos.getCalf()%>" type="number"/>
                            <option selected>Open this select menu</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                            <option value="4">Four</option>
                            <option value="5">Five</option>
                            <option value="6">Six</option>
                            <option value="7">Seven</option>
                            <option value="8">Eight</option>
                            <option value="9">Nine</option>
                            <option value="10">Ten</option>
                            
                      
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="submit" id="Guardar" name="<%=accion%>" value="Submit"/>
                    </td>
                </tr>
            </table>
        </form>
        <%
            }
        %>
    </body>
</html>