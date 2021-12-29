<%@page import="Modelo.Ubigeo"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Local"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.OtrosDAO"%>
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
                <h1 class="mt-5">Listar Locales</h1><hr>
                <a href="Routes?accion=agregarLocales" class="btn btn-success">Agregar Nuevo</a>

                <div class="col-12 pt-4">

                    <div class="table-responsive">
                        
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Direccion</th>
                                    <th>Ubigeo</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%
                                    OtrosDAO dao = new OtrosDAO();
                                    List<Local> list = dao.listarLocal();
                                    Iterator<Local> iter = list.iterator();
                                    Local loc = null;

                                    while (iter.hasNext()) {
                                        loc = iter.next();
                                        Ubigeo ubige = (Ubigeo) dao.listUbigeo(loc.getUbigeo());

                                %>
                                <tr>
                                    <td><%= loc.getNombre()%></td>
                                    <td><%= loc.getDireccion()%></td>
                                    <td><%= ubige.getNomUbigeo()%></td>
                                    <td class="text-center">
                                        <a href="Routes?accion=editLocales&id=<%= loc.getId()%>" class="btn btn-sm btn-success">Editar</a>
                                        <a href="LocalController?accion=eliminarLocal&id=<%= loc.getId()%>" class="btn btn-sm btn-danger">Eliminar</a>
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
