<%

    HttpSession sesion = request.getSession();
    //Pedir el atributo contadorVisitas a la sesion

    if (sesion.getAttribute("st") == null) {
        out.print("<script>window.location = 'login.jsp';</script>");
    }

%>

<%@page import="Modelo.Ubigeo"%>
<%@page import="Modelo.Medico"%>
<%@page import="Modelo.Local"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Laboratorio"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Paciente"%>
<%@page import="ModeloDAO.MedicoDAO"%>
<%@page import="ModeloDAO.OtrosDAO"%>
<%@page import="ModeloDAO.PacienteDAO"%>
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

        <%                    int id = Integer.parseInt((String) request.getAttribute("idvacp"));

            PacienteDAO pdao = new PacienteDAO();
            OtrosDAO odao = new OtrosDAO();
            MedicoDAO mdco = new MedicoDAO();

            Paciente pac = (Paciente) pdao.list(id);

            List<Laboratorio> listalab = odao.listarLab();
            Iterator<Laboratorio> iteratr = listalab.iterator();
            Laboratorio lval = null;

            List<Local> listaloc = odao.listarLocal();
            Iterator<Local> iteraloc = listaloc.iterator();
            Local lloc = null;

            List<Medico> listamed = mdco.listar();
            Iterator<Medico> iteramdc = listamed.iterator();
            Medico mdc = null;


        %>

        <!-- Contenido -->
        <main class="flex-shrink-0">
            <div class="container">
                <h1 class="mt-5">Agregar Vacuna</h1><hr>

                <div class="col-12 pt-4">

                    <form id="form">


                        <div class="mb-3">
                            <label class="form-label">Paciente:</label>
                            <input type="text" readonly="" class="form-control" value="<%= pac.getNroDoc() + " - " + pac.getNom() + " " + pac.getApe()%>">
                            <input type="hidden" name="txtIdPaciente" value="<%=id%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Nro Dosis:</label>
                            <input type="text" name="txtNroDosis" class="form-control" value="">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Laboratorio:</label>
                            <select name="txtIdLab" class="form-control sele" style="width: 100%">
                                <option value="">Seleccione</option>

                                <%
                                    while (iteratr.hasNext()) {
                                        lval = iteratr.next();
                                %>

                                <option value="<%= lval.getId()%>"><%= lval.getNombre()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Lote:</label>
                            <input type="text" name="txtLote" class="form-control" value="">
                        </div>   

                        <div class="mb-3">
                            <label class="form-label">Local:</label>
                            <select name="txtIdLocal" class="form-control sele" style="width: 100%">
                                <option value="">Seleccione</option>

                                <%
                                    while (iteraloc.hasNext()) {
                                        lloc = iteraloc.next();
                                        Ubigeo ubige = (Ubigeo) odao.listUbigeo(lloc.getUbigeo());
                                %>

                                <option value="<%= lloc.getId()%>"><%= lloc.getNombre() + " - " + ubige.getNomUbigeo()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Medico:</label>
                            <select name="txtIdMedico" class="form-control sele" style="width: 100%">
                                <option value="">Seleccione</option>

                                <%
                                    while (iteramdc.hasNext()) {
                                        mdc = iteramdc.next();
                                %>

                                <option value="<%= mdc.getId()%>"><%= mdc.getNroDoc() + " - " + mdc.getNom() + " " + mdc.getApe()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div> 

                        <div class="mb-3">
                            <label class="form-label">Fecha Vacunacion:</label>
                            <input type="date" name="txtFechaVacuna" class="form-control" value="">
                        </div> 

                        <div class="mb-3">
                            <input type="button" name="accion" id="submit" class="btn btn-sm btn-success" value="Agregar">
                            <a type="button" href="Routes?accion=listarVacuna&idp=<%=id%>" class="btn btn-sm btn-danger"> Volver </a><br>
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
                        url: "PacienteController?accion=AgregarVacuna",
                        type: 'POST',
                        data: $("#form").serialize()
                    }).done(function (resp) {

                        if (resp == 1) {
                            Swal.fire("Mensaje de Confirmacion", "Vacuna Registrada", "success").then(function (result) {
                                if (result.value) {
                                    window.location = "Routes?accion=listarVacuna&idp=<%=id%>";
                                }
                            });
                        } else {
                            Swal.fire("Mensaje de Error", "No se pudo registrar al paciente, Intentelo Nuevamente", "error");
                        }

                    });

                });

            });
        </script>

    </body>
</html>

