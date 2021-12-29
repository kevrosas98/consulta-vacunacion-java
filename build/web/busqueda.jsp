<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.Ubigeo"%>
<%@page import="ModeloDAO.MedicoDAO"%>
<%@page import="Modelo.Medico"%>
<%@page import="Modelo.Local"%>
<%@page import="Modelo.Laboratorio"%>
<%@page import="ModeloDAO.OtrosDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Vacuna"%>
<%@page import="java.util.List"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="ModeloDAO.VacunaDAO"%>
<%@page import="Modelo.Paciente"%>
<%@page import="ModeloDAO.PacienteDAO"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consulta - SIS MINSA</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://getbootstrap.com/docs/5.1/examples/heroes/heroes.css" rel="stylesheet">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>

    </head>

    <body class="m-0 vh-100 row justify-content-center align-items-center">

        <main>

            <div class="px-4 py-5 my-5 text-center">
                <img class="d-block mx-auto mb-4" src="https://visualizate.utpxpedition.com/sites/default/files/2020-02/logo-visualizate.png" alt="" height="57">
                <h1 class="display-5 fw-bold">Resultado de tu consulta</h1>
                <%
                    int dni = Integer.parseInt((String) request.getAttribute("pdni"));
                    String femision = (String) request.getAttribute("pemision");
                    String fnacimiento = (String) request.getAttribute("pnacimiento");

                    PacienteDAO dao = new PacienteDAO();
                    Paciente pac = (Paciente) dao.listBusq(dni, fnacimiento, femision);

                    OtrosDAO odao = new OtrosDAO();
                    MedicoDAO meddao = new MedicoDAO();
                %>

                <%            if (pac.getNom() == null) {
                %>
                Usted no existe o ingresó mal sus datos 

                <div class="col-lg-6 mx-auto pt-4">
                    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <a type="button" class="btn btn-primary btn-lg px-4 gap-3" href="javascript:window.print()">Imprimir</a>
                        <a type="button" class="btn btn-outline-secondary btn-lg px-4" href="./">Realizar otra consulta</a>
                    </div>
                </div>

                <%
                } else {
                    
                    

                %>
                <div id="qrcode-container" class="pt-4">
                    <div id="qrcode"></div>
                </div>

                <div class="col-lg-6 mx-auto p-4">
                    <div class="row">
                        <div class="col-6">
                            <p class="lead"><strong>Cuidadano :</strong> <%= pac.getNroDoc() + " - " + pac.getNom() + " " + pac.getApe()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Fecha Nacimiento :</strong> <%= pac.getfNac()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Fecha Emision :</strong> <%= pac.getfEmision()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Fecha Caducidad :</strong> <%= pac.getfCaducidad()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Edad :</strong> <%= pac.getEdad()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Celular :</strong> <%= pac.getCelular()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Direccion :</strong> <%= pac.getDireccion()%></p>
                        </div>
                        <div class="col-6">
                            <p class="lead"><strong>Correo:</strong> <%= pac.getCorreo()%></p>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mx-auto text-lg-start">
                    <div class="row">
                        <div class="col-12">
                            <h3>Vacunas: </h3>
                            <hr />
                        </div>
                    </div>
                </div>

                <%

                    VacunaDAO vdao = new VacunaDAO();
                    List<Vacuna> listarv = vdao.listar(pac.getId());
                    Iterator<Vacuna> iter = listarv.iterator();
                    Vacuna vacl = null;

                    if (listarv.size() == 0) {

                %>

                Usted se encuentra registrado como vacunado aunque sea con una dosis, pero falta actualizar los datos de su vacuna. En breve se estará actualizando.<br><br>
                
                <div class="col-lg-6 mx-auto pt-4">
                    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <a type="button" class="btn btn-primary btn-lg px-4 gap-3" href="javascript:window.print()">Imprimir</a>
                        <a type="button" class="btn btn-outline-secondary btn-lg px-4" href="./">Realizar otra consulta</a>
                    </div>
                </div>
                
                <%        } else {

                    while (iter.hasNext()) {

                        vacl = iter.next();

                        Laboratorio vlab = (Laboratorio) odao.listLab((int) vacl.getIdLab());
                        Local vlocal = (Local) odao.listLocal((int) vacl.getIdLocal());
                        Medico vmedic = (Medico) meddao.list((int) vacl.getIdMedico());
                        Ubigeo ubige = (Ubigeo) odao.listUbigeo(vlocal.getUbigeo());

                %>

                <div class="col-lg-6 mx-auto pt-4">
                    <div class="p-4 p-md-5 border rounded-3 bg-light text-lg-start">
                        <div class="row">
                            <div class="col-6">
                                <p><strong>Dosis:</strong> <%= vacl.getNroDosis()%>°</p>
                            </div>
                            <div class="col-6">
                                <p><strong>Fecha Vacunacion:</strong> <%= vacl.getFechaVacuna()%></p>
                            </div>
                            <div class="col-6">
                                <p><strong>Laboratorio:</strong> <%= vlab.getNombre()%></p>
                            </div>
                            <div class="col-6">
                                <p><strong>Lote:</strong> <%= vacl.getLote()%></p>
                            </div>
                            <div class="col-6">
                                <p><strong>Local:</strong> <%= vlocal.getNombre() + "<br>" + ubige.getNomUbigeo()%></p>
                            </div>
                            <div class="col-6">
                                <p><strong>Medico:</strong> <%= vmedic.getNroDoc() + " - " + vmedic.getNom() + "" + vmedic.getApe()%></p>
                            </div>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>

                <div class="col-lg-6 mx-auto pt-4">
                    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <a type="button" class="btn btn-primary btn-lg px-4 gap-3" href="javascript:window.print()">Imprimir</a>
                        <a type="button" class="btn btn-outline-secondary btn-lg px-4" href="./">Realizar otra consulta</a>
                    </div>
                </div>

                <%
                    }

                %>

                <script src="qrcode.js"></script>

                <script type="text/javascript">
                    let qrcodeContainer = document.getElementById("qrcode");
                    qrcodeContainer.innerHTML = "";
                    let qrcodev = document.getElementById("qr");
                    let uri = window.location.href;
                    new QRCode(qrcodeContainer, uri);
                </script>

                <%            }
                %>

            </div>

        </main>

    </body>
</html>
