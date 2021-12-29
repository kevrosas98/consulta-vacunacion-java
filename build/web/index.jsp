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

            <div class="container col-xl-10 col-xxl-8 px-4 py-5">
                <div class="row align-items-center g-lg-5 py-5">
                    <div class="col-lg-7 text-center text-lg-start">
                        <img class="d-block mb-4" src="https://visualizate.utpxpedition.com/sites/default/files/2020-02/logo-visualizate.png" alt="" height="80">
                        <h1 class="display-4 fw-bold lh-1 mb-3">Consulta tu Vacunaci&oacute;n</h1>
                        <p class="col-lg-10 fs-4">Recuerda que debes presentar tu carnet de vacunaci&oacute;n en lugares cerrados. Consulta aqui e imprime tu carnet. </p>
                    </div>
                    <div class="col-md-10 mx-auto col-lg-5">

                        <form class="p-4 p-md-5 border rounded-3 bg-light" action="CarnetBusqueda">

                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" autocomplete="off" name="txtDni" placeholder="Ingrese No. Documento" required>
                                <label>No. Documento :</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="date" class="form-control" name="txtNacimiento" required>
                                <label >Fecha de Nacimiento :</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="date" class="form-control" name="txtEmision" required>
                                <label >Fecha de Emision :</label>
                            </div>

                            <input type="submit" class="w-100 btn btn-lg btn-primary" name="accion" value="Buscar" >

                            <hr class="my-4">

                            <small class="text-muted"><a href="login.jsp">Usuario MINSA</a></small>
                        </form>

                    </div>
                </div>
            </div>

        </main>

    </body>


</html>
