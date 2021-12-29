<%@page import="Modelo.Laboratorio"%>
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
                <h1 class="mt-5">Editar Laboratorio</h1><hr>

                <div class="col-12 pt-4">


                    <%

                        OtrosDAO dao = new OtrosDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idlab"));
                        Laboratorio lab = (Laboratorio) dao.listLab(id);

                    %>

                    <form id="form">

                        <div class="mb-3">
                            <label class="form-label">Laboratorio:</label>
                            <input type="text" name="txtNombre" class="form-control" value="<%= lab.getNombre()%>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Pais:</label>
                            <input type="text" name="txtPais" class="form-control" value="<%= lab.getPais()%>">
                        </div>
                        
                        <div class="mb-3">
                            <input type="hidden" name="txtId" value="<%= lab.getId()%>">
                            <input type="button"  class="btn btn-success"   name="accion" id="submit" value="Actualizar">
                            <a type="button" class="btn btn-danger" href="Routes?accion=listarLabs">Regresar</a>
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

        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
            $(document).ready(function () {

                $('#submit').click(function () {

                    $.ajax({
                        "url": "LabController?accion=Editar",
                        type: 'POST',
                        data: $("#form").serialize()
                    }).done(function () {

                        Swal.fire("Mensaje de Confirmacion", "Laboratorio Actualizado", "success").then(function (result) {
                            if (result.value) {
                                window.location = "Routes?accion=listarLabs";
                            }
                        });

                    });

                });

            });
        </script>

    </body>
</html>