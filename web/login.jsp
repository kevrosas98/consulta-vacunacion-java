<%

    HttpSession sesion = request.getSession();
    //Pedir el atributo contadorVisitas a la sesion

    if (sesion.getAttribute("st") != null) {
        out.print("<script>window.location = 'principal.jsp';</script>");
    } else {
    }

%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SIS MINSA</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://getbootstrap.com/docs/5.1/examples/sign-in/signin.css" rel="stylesheet">

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

    <body class="text-center">

        <main class="form-signin">

            <form id="form">

                <img class="mb-4" src="https://visualizate.utpxpedition.com/sites/default/files/2020-02/logo-visualizate.png" height="57">

                <h1 class="h3 mb-3 fw-normal">Iniciar Sesion</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingCorreo" autocomplete="off" name="txtcorreo" placeholder="Ingrese Correo">
                    <label for="floatingCorreo">Correo : </label>
                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" autocomplete="off" name="txtpass" placeholder="Ingrese Contraseña">
                    <label for="floatingPassword">Password : </label>
                </div>

                <input type="button" class="w-100 btn btn-lg btn-primary" name="accion" id="submit" value="Ingresar">

                <div class="mt-3">
                    <label>
                        <a href="index.jsp">Volver al Inicio</a>
                    </label>
                </div>

            </form>

        </main>

        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#submit').click(function () {

                    let txtcorreo = $('#txtcorreo').val();
                    let txtpass = $('#txtpass').val();

                    $.ajax({
                        "url": "UsuarioController?accion=Ingresar",
                        type: 'POST',
                        data: $("#form").serialize()
                    }).done(function (resp) {

                        let d = JSON.parse(JSON.stringify(resp));

                        if (d.success) {

                            Swal.fire({
                                icon: 'success',
                                title: 'Bienvenido al Sistema',
                                text: d.data,
                                confirmButtonText: 'Aceptar',
                                allowOutsideClick: false
                            }).then(function (result) {
                                if (result.value) {
                                    window.location = d.redirect;
                                }
                            });


                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'Usuario o Password Incorrecto',
                                text: d.data,
                                confirmButtonText: 'Aceptar',
                                allowOutsideClick: false
                            });
                        }

                    });

                });
            });
        </script>

    </body>
</html>
