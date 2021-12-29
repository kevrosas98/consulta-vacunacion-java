
<%

    HttpSession sesion = request.getSession();
    //Pedir el atributo contadorVisitas a la sesion

    if (sesion.getAttribute("st") == null) {
        out.print("<script>window.location = 'login.jsp';</script>");
    }

%>

<%@page import="Modelo.Ubigeo"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Atributo"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.OtrosDAO"%>
<%@page import="Modelo.Paciente"%>
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

        <!-- Contenido -->
        <main class="flex-shrink-0">
            <div class="container">
                <h1 class="mt-5">Editar Paciente</h1><hr>

                <div class="col-12 pt-4">

                    <%  
                        PacienteDAO dao = new PacienteDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idpac"));
                        Paciente pac = (Paciente) dao.list(id);

                        OtrosDAO odao = new OtrosDAO();
                        List<Atributo> listatr = odao.listarAtributo(0, 1);
                        Iterator<Atributo> iteratr = listatr.iterator();
                        Atributo atr = null;
                        String sel = "";

                        List<Ubigeo> listubi = odao.listarUbigeo();
                        Iterator<Ubigeo> iterUbi = listubi.iterator();
                        Ubigeo ubi = null;
                        String selu = "";

                    %>

                    <form id="form">

                        <div class="mb-3">
                            <label class="form-label">Tipo Documento:</label>
                            <select name="txtTipoDoc" class="form-control" style="width: 100%">
                                <option value="">Seleccione</option>

                                <%                    while (iteratr.hasNext()) {
                                        atr = iteratr.next();

                                        if (atr.getValorAtributo() == pac.getTipoDoc()) {
                                            sel = "selected";
                                        } else {
                                            sel = "";
                                        }
                                %>

                                <option value="<%= atr.getValorAtributo()%>" <%=sel%> ><%= atr.getNombre()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Nro Documento:</label>
                            <input type="text" name="txtDni" class="form-control" value="<%= pac.getNroDoc()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Nombres:</label>
                            <input type="text" name="txtNom" class="form-control" value="<%= pac.getNom()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Apellidos:</label>
                            <input type="text" name="txtApe" class="form-control" value="<%= pac.getApe()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Correo:</label>
                            <input type="text" name="txtMail" class="form-control" value="<%= pac.getCorreo()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Edad:</label>
                            <input type="text" name="txtEdad" class="form-control" value="<%= pac.getEdad()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ubigeo:</label>
                            <select name="txtUbigeo"  class="form-control sele" style="width: 100%">
                                <option value="">Seleccione</option>

                                <%
                                    while (iterUbi.hasNext()) {
                                        ubi = iterUbi.next();

                                        if (Integer.parseInt((String) ubi.getIdUbigeo()) == pac.getUbigeo()) {
                                            selu = "selected";
                                        } else {
                                            selu = "";
                                        }
                                %>

                                <option value="<%= ubi.getIdUbigeo()%>" <%=selu%> ><%= ubi.getNomUbigeo()%></option>

                                <%
                                    }
                                %>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Direccion:</label>
                            <input type="text" name="txtDireccion" class="form-control" value="<%= pac.getDireccion()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Celular:</label>
                            <input type="text" name="txtCelular" class="form-control" value="<%= pac.getCelular()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Fecha Nacimiento:</label>
                            <input type="date" name="txtFecNac" class="form-control" value="<%= pac.getfNac()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Fecha Doc Emision:</label>
                            <input type="date" name="txtFecEmi" class="form-control" value="<%= pac.getfEmision()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Fecha Doc Caducidad:</label>
                            <input type="date" name="txtFecCad" class="form-control" value="<%= pac.getfCaducidad()%>">
                        </div>                       

                        <input type="hidden" name="txtId" value="<%= pac.getId()%>">

                        <div class="mb-5">
                            <input type="button" name="accion" id="submit"  class="btn btn-success" value="Actualizar">
                            <a type="button" href="Routes?accion=listarVacunados" class="btn btn-danger">Regresar</a>
                        </div>  
                        
                        <br><br><br>
                                    
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
        <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

        <script>
            $(document).ready(function () {

                $('.sele').select2({
                    minimumInputLength: 4 // only allow terms up to 20 characters long
                });

                $('#submit').click(function () {

                    $.ajax({
                        "url": "PacienteController?accion=Editar",
                        type: 'POST',
                        data: $("#form").serialize()
                    }).done(function (resp) {

                        if (resp == 1) {
                            Swal.fire("Mensaje de Confirmacion", "Paciente Editado", "success").then(function (result) {
                                if (result.value) {
                                    window.location = "Routes?accion=listarVacunados";
                                }
                            });
                        } else {
                            Swal.fire("Mensaje de Error", "No se pudo editar al paciente, Intentelo Nuevamente", "error");
                        }

                    });

                });

            });
        </script>

    </body>
</html>
