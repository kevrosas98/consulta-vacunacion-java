package Controlador;

import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Routes extends HttpServlet {

    /* Principal */
    String home = "./";
    String login = "login.jsp";

    /* Usuarios */
    String listarUsuarios = "vistas/usuarios/listar.jsp";
    String agregarUsuarios = "vistas/usuarios/agregar.jsp";
    String editUsuarios = "vistas/usuarios/editar.jsp";
    String resetUsuarios = "vistas/usuarios/reset.jsp";
    /* Vacunados */
    String listarVacunados = "vistas/vacunados/listar.jsp";
    String agregarVacunados = "vistas/vacunados/agregar.jsp";
    String editVacunados = "vistas/vacunados/editar.jsp";
    /* Medicos */
    String listarMedicos = "vistas/medicos/listar.jsp";
    String agregarMedicos = "vistas/medicos/agregar.jsp";
    String editMedicos = "vistas/medicos/editar.jsp";
    /* Locales */
    String listarLocales = "vistas/locales/listar.jsp";
    String agregarLocales = "vistas/locales/agregar.jsp";
    String editLocales = "vistas/locales/editar.jsp";
    /* Labs */
    String listarLabs = "vistas/labs/listar.jsp";
    String agregarLabs = "vistas/labs/agregar.jsp";
    String editLabs = "vistas/labs/editar.jsp";
    /* Vacuna */
    String listarVacuna = "vistas/vacunados/listarVac.jsp";
    String agregarVacuna = "vistas/vacunados/agregarVac.jsp";
    String editVacuna = "vistas/vacunados/editarVac.jsp";
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redirecciona = "";
        String action = request.getParameter("accion");

        switch (action) {
            case "listarUsuarios":
                redirecciona = listarUsuarios;
                break;
            case "agregarUsuarios":
                redirecciona = agregarUsuarios;
                break;
            case "editUsuarios":
                request.setAttribute("idusu", request.getParameter("id"));
                redirecciona = editUsuarios;
                break;
            case "resetUsuarios":
                request.setAttribute("idusu", request.getParameter("id"));
                redirecciona = resetUsuarios;
                break;
            case "listarVacunados":
                redirecciona = listarVacunados;
                break;
            case "agregarVacunados":
                redirecciona = agregarVacunados;
                break;
            case "editVacunados":
                request.setAttribute("idpac", request.getParameter("id"));
                redirecciona = editVacunados;
                break;
            case "listarMedicos":
                redirecciona = listarMedicos;
                break;
            case "agregarMedicos":
                redirecciona = agregarMedicos;
                break;
            case "editMedicos":
                request.setAttribute("idmed", request.getParameter("id"));
                redirecciona = editMedicos;
                break;
            case "listarLocales":
                redirecciona = listarLocales;
                break;
            case "agregarLocales":
                redirecciona = agregarLocales;
                break;
            case "editLocales":
                request.setAttribute("idloc", request.getParameter("id"));
                redirecciona = editLocales;
                break;
            case "listarLabs":
                redirecciona = listarLabs;
                break;
            case "agregarLabs":
                redirecciona = agregarLabs;
                break;
            case "editLabs":
                request.setAttribute("idlab", request.getParameter("id"));
                redirecciona = editLabs;
                break;
            case "listarVacuna":
                request.setAttribute("idvacp", request.getParameter("idp"));
                redirecciona = listarVacuna;
                break;
            case "agregarVacuna":
                request.setAttribute("idvacp", request.getParameter("idp"));
                redirecciona = agregarVacuna;
                break;
            case "editVacuna":
                request.setAttribute("idvac", request.getParameter("idv"));
                request.setAttribute("idvacp", request.getParameter("idp"));
                redirecciona = editVacuna;
                break;
            case "cerrar":
                request.getSession().invalidate();
                redirecciona = login;
                break;
        }

        RequestDispatcher vista = request.getRequestDispatcher(redirecciona);
        vista.forward(request, response);

    }

}
