package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarnetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String result = "/busqueda.jsp";

        String redirecciona = "";
        String buscar = request.getParameter("accion");

        switch (buscar) {
            case "Buscar":
                request.setAttribute("pdni", request.getParameter("txtDni"));
                request.setAttribute("pemision", request.getParameter("txtEmision"));
                request.setAttribute("pnacimiento", request.getParameter("txtNacimiento"));
                redirecciona = result;

                break;

        }

        RequestDispatcher vista = request.getRequestDispatcher(redirecciona);
        vista.forward(request, response);
    }

}
