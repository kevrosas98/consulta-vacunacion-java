package Controlador;

import Modelo.Laboratorio;
import ModeloDAO.OtrosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LabController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Laboratorio lab = new Laboratorio();
        OtrosDAO ldao = new OtrosDAO();
        
        String action = request.getParameter("accion");

        switch (action) {
            case "eliminarLab":

                int id = Integer.parseInt(request.getParameter("id"));
                lab.setId(id);
                ldao.eliminarLab(id);
                
                response.sendRedirect("Routes?accion=listarLabs");

                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Laboratorio lab = new Laboratorio();
        OtrosDAO ldao = new OtrosDAO();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();

        String action = request.getParameter("accion");
        
        switch (action) {
            case "Agregar":
                
                lab.setNombre(request.getParameter("txtNombre"));
                
                lab.setPais(request.getParameter("txtPais"));
                
                ldao.agregarLab(lab);
                
                out.print(1);
                
                out.flush();
                
                break;

            case "Editar":
                
                int id = Integer.parseInt(request.getParameter("txtId"));
                
                lab.setId(id);
                
                lab.setNombre(request.getParameter("txtNombre"));
                
                lab.setPais(request.getParameter("txtPais"));
                
                ldao.editarLab(lab);
                
                out.print(1);
                
                out.flush();                

                break;
        }
    }

}
