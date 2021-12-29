<%

    HttpSession sesion = request.getSession();
    //Pedir el atributo contadorVisitas a la sesion

    if (sesion.getAttribute("st") == null) {
        out.print("<script>window.location = 'login.jsp';</script>");
    }

%>

<%@page import="Modelo.Ubigeo"%>
<%@page import="Modelo.Atributo"%>
<%@page import="ModeloDAO.OtrosDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PacienteDAO"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIS MINSA - Vacunacion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <style>
            main > .container {
                padding: 60px 15px 0;
            }

        </style>

    </head>

    <body class="d-flex flex-column h-100">

        <header>
            <!-- Nav -->
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="principal.jsp">SIS MINSA</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="principal.jsp">Home</a>
                            </li>
                        </ul>
                        <form class="d-flex">
                            <a href="Routes?accion=cerrar" class="btn btn-danger" type="submit">Cerrar Sesion</a>
                        </form>
                    </div>
                </div>
            </nav>
        </header>

        <!-- Contenido -->
        <main class="flex-shrink-0">
            <div class="container">
                <h1 class="mt-5">Listar Pacientes</h1><hr>
                <a href="Routes?accion=agregarVacunados" class="btn btn-success">Agregar Nuevo</a>

                <div class="col-12 pt-4">

                    <div class="table-responsive">

                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Tipo Documento</th>
                                    <th>Nro Documento</th>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Edad</th>
                                    <th>Celular</th>
                                    <th>Correo</th>
                                    <th>Ubigeo</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%
                                    PacienteDAO dao = new PacienteDAO();
                                    OtrosDAO odao = new OtrosDAO();
                                    List<Paciente> list = dao.listar();
                                    Iterator<Paciente> iter = list.iterator();
                                    Paciente pac = null;

                                    while (iter.hasNext()) {
                                        pac = iter.next();
                                        Atributo atrv = (Atributo) odao.listAtributo(0, pac.getTipoDoc(), 1);
                                        Ubigeo ubige = (Ubigeo) odao.listUbigeo(pac.getUbigeo());

                                %>
                                <tr>
                                    <td><%= atrv.getNombre()%></td>
                                    <td><%= pac.getNroDoc()%></td>
                                    <td><%= pac.getNom()%></td>
                                    <td><%= pac.getApe()%></td>
                                    <td><%= pac.getEdad()%></td>
                                    <td><%= pac.getCelular()%></td>
                                    <td><%= pac.getCorreo()%></td>
                                    <td><%= ubige.getNomUbigeo()%></td>
                                    <td class="text-center">
                                        <a href="Routes?accion=editVacunados&id=<%= pac.getId()%>" class="btn btn-sm btn-success">Editar</a>
                                        <a href="Routes?accion=listarVacuna&idp=<%= pac.getId()%>" class="btn btn-sm btn-primary">Ver Vacunas</a>
                                        <a href="PacienteController?accion=eliminarPaciente&id=<%= pac.getId()%>" class="btn btn-sm btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>

                    </div>

                </div>

            </div>
        </main>

        <!-- Footer -->
        <footer class="footer fixed-bottom mt-auto py-3 bg-light text-center">
            <div class="container">
                <span class="text-muted">&COPY; 2021 Taller de programaci&oacute;n.</span>
            </div>
        </footer> 

<script src="https://getbootstrap.com/docs/5.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>