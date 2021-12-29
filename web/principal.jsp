<%

    HttpSession sesion = request.getSession();
    //Pedir el atributo contadorVisitas a la sesion

    if (sesion.getAttribute("st") == null) {
        out.print("<script>window.location = 'login.jsp';</script>");
    }

%>

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
                <h1 class="mt-5">Bienvenido a SIS MINSA! ${nom}</h1><hr>

                <div class="row">
                    <div class="col-sm-6 p-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Usuarios</h5>
                                <p class="card-text">Gestiona los usuarios del SIS MINSA.</p>
                                <a href="Routes?accion=listarUsuarios" class="btn btn-primary" >Listar Usuarios</a><br>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 p-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Pacientes</h5>
                                <p class="card-text">Gestiona a los vacunados de la pandemia.</p>
                                <a href="Routes?accion=listarVacunados" class="btn btn-primary" >Listar Vacunados</a><br>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 p-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Medicos</h5>
                                <p class="card-text">Gestiona a los medicos vacunadores.</p>
                                <a href="Routes?accion=listarMedicos" class="btn btn-primary">Listar Medicos</a><br>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 p-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Locales de Vacunaci&oacute;n</h5>
                                <p class="card-text">Gestiona los locales que se llevan a cabos las campa&ntilde;as de vacunaci&oacute;n.</p>
                                <a href="Routes?accion=listarLocales" class="btn btn-primary">Listar Locales</a><br>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 p-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Laboratorios</h5>
                                <p class="card-text">Gestiona a las marcas de vacunas que se llevan aplicando en las campañas.</p>
                                <a href="Routes?accion=listarLabs" class="btn btn-primary">Listar Laboratorios</a><br>
                            </div>
                        </div>
                    </div>
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
    </body>
</html>
