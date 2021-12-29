package Controlador;

import Modelo.Local;
import ModeloDAO.OtrosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Local loc = new Local();
        OtrosDAO lodao = new OtrosDAO();

        String action = request.getParameter("accion");

        switch (action) {
            case "eliminarLocal":

                int id = Integer.parseInt(request.getParameter("id"));
                loc.setId(id);
                lodao.eliminarLocal(id);

                response.sendRedirect("Routes?accion=listarLocales");

                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Local loc = new Local();
        OtrosDAO lodao = new OtrosDAO();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("accion");

        switch (action) {
            case "Agregar":
                
                loc.setNombre(request.getParameter("txtNombre"));
                loc.setDireccion(request.getParameter("txtDireccion"));
                loc.setUbigeo(Integer.parseInt(request.getParameter("txtUbigeo")));
                
                lodao.agregarLocal(loc);
                
                out.print(1);
                
                out.flush();
                
                break;

            case "Editar":
                
                int id = Integer.parseInt(request.getParameter("txtId"));
                
                loc.setId(id);
                loc.setNombre(request.getParameter("txtNombre"));
                loc.setDireccion(request.getParameter("txtDireccion"));
                loc.setUbigeo(Integer.parseInt(request.getParameter("txtUbigeo")));
                
                lodao.editarLocal(loc);
                
                out.print(1);
                
                out.flush();

                break;
        }

    }

}
