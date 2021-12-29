<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Ubigeo"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Local"%>
<%@page import="ModeloDAO.OtrosDAO"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIS MINSA - Vacunacion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
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
                <h1 class="mt-5">Editar Local</h1><hr>

                <div class="col-12 pt-4">

                    <%

                        OtrosDAO dao = new OtrosDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idloc"));
                        Local loc = (Local) dao.listLocal(id);

                        List<Ubigeo> list = dao.listarUbigeo();
                        Iterator<Ubigeo> iter = list.iterator();
                        Ubigeo ubi = null;

                    %>

                    <form id="form">

                        <div class="mb-3">
                            <label class="form-label">Nombre:</label>
                            <input type="text" name="txtNombre" class="form-control" value="<%= loc.getNombre()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Direccion:</label>
                            <input type="text" name="txtDireccion" class="form-control" value="<%= loc.getDireccion()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ubigeo:</label>
                            <select name="txtUbigeo" class="form-control sele" style="width: 100%">
                                <option value="">Seleccione</option>

                                <%
                                    String sel = "";

                                    while (iter.hasNext()) {
                                        ubi = iter.next();

                                        if (Integer.parseInt((String) ubi.getIdUbigeo()) == loc.getUbigeo()) {
                                            sel = "selected";
                                        } else {
                                            sel = "";
                                        }
                                %>

                                <option value="<%= ubi.getIdUbigeo()%>" <%=sel%> ><%= ubi.getNomUbigeo()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>

                        <div class="mb-3">
                            <input type="hidden" name="txtId" value="<%= loc.getId()%>">
                            <input type="button" name="accion" class="btn btn-success" id="submit" value="Actualizar">
                            <a type="button" href="Routes?accion=listarLocales" class="btn btn-danger">Regresar</a>
                        </div>

                    </form>

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
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

        <script>
            $(document).ready(function () {

                $('select').select2({
                    minimumInputLength: 4 // only allow terms up to 20 characters long
                });

                $('#submit').click(function () {

                    $.ajax({
                        "url": "LocalController?accion=Editar",
                        type: 'POST',
                        data: $("#form").serialize()
                    }).done(function () {

                        Swal.fire("Mensaje de Confirmacion", "Local Actualizado", "success").then(function (result) {
                            if (result.value) {
                                window.location = "Routes?accion=listarLocales";
                            }
                        });

                    });

                });

            });
        </script>

    </body>
</html>
