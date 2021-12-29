<%

    HttpSession sesion = request.getSession();
    //Pedir el atributo contadorVisitas a la sesion

    if (sesion.getAttribute("st") == null) {
        out.print("<script>window.location = 'login.jsp';</script>");
    }

%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Atributo"%>
<%@page import="java.util.List"%>
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

        <%            
            OtrosDAO odao = new OtrosDAO();
            List<Atributo> list = odao.listarAtributo(0, 1);
            Iterator<Atributo> iter = list.iterator();
            Atributo atr = null;
        %>

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
                <h1 class="mt-5">Agregar Usuario</h1><hr>

                <div class="col-12 pt-4">

                    <form id="form">

                        <div class="mb-3">
                            <label class="form-label">Tipo Documento:</label>
                            <select name="txtTipoDoc" class="form-control sele">
                                <option value="">Seleccione</option>

                                <%
                                    while (iter.hasNext()) {
                                        atr = iter.next();
                                %>

                                <option value="<%= atr.getValorAtributo()%>"><%= atr.getNombre()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Nro Documento:</label>
                            <input type="text" class="form-control" name="txtDni" value="">
                        </div>    

                        <div class="mb-3">
                            <label class="form-label">Nombres:</label>
                            <input type="text" class="form-control" name="txtNom" value="">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Apellidos:</label>
                            <input type="text" class="form-control" name="txtApe" value="">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Correo:</label>
                            <input type="text" class="form-control" name="txtMail" value="">
                        </div>
                       
                        <div class="mb-3">
                            <input type="button" name="accion" id="submit" class="btn btn-success" value="Agregar">
                            <a type="button" href="Routes?accion=listarUsuarios" class="btn btn-danger"> Volver </a>
                        </div>
                                
                    </form>

                </div>

            </div>
        </main>
                                
        <br><br><br>                         

        <!-- Footer -->
        <footer class="footer fixed-bottom mt-auto py-3 bg-light text-center">
            <div class="container">
                <span class="text-muted">&COPY; 2021 Taller de programaci&oacute;n.</span>
            </div>
        </footer> 

        <script src="https://getbootstrap.com/docs/5.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
            $(document).ready(function () {

                $('#submit').click(function (event) {

                    $.ajax({
                        url: "UsuarioController?accion=Agregar",
                        type: 'POST',
                        data: $("#form").serialize()
                    }).done(function (resp) {

                        Swal.fire("Mensaje de Confirmacion", "Usuario Agregado", "success").then(function (result) {
                            if (result.value) {
                                window.location = "Routes?accion=listarUsuarios";
                            }
                        });

                    });

                });

            });
        </script>

    </body>
</html>
