package Controlador;

import Modelo.Medico;
import ModeloDAO.MedicoDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MedicoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Medico med = new Medico();
        MedicoDAO mdao = new MedicoDAO();
        
        String action = request.getParameter("accion");

        switch (action) {
            case "eliminarMedico":

                int id = Integer.parseInt(request.getParameter("id"));
                med.setId(id);
                mdao.eliminar(id);
                
                response.sendRedirect("Routes?accion=listarMedicos");

                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Medico med = new Medico();
        MedicoDAO mdao = new MedicoDAO();
        
        UsuarioDAO udao = new UsuarioDAO();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("accion");
        
        switch (action) {
            case "Agregar":
                               
                int mx = udao.maxId();

                LocalDate medFecReg = LocalDate.now();              

                med.setId(mx);
                med.setTipoPer(2);
                med.setTipoDoc(Integer.parseInt((String) request.getParameter("txtTipoDoc")));
                med.setNroDoc(request.getParameter("txtDni"));
                med.setNom(request.getParameter("txtNom"));
                med.setApe(request.getParameter("txtApe"));
                med.setCorreo(request.getParameter("txtMail"));
                med.setTipMedico(Integer.parseInt((String) request.getParameter("txtTipMedico")));
                med.setLicencia(request.getParameter("txtLicencia"));
                med.setFecRegistro(medFecReg);
                med.setCodUserRegistro(1);

                mdao.agregar(med);

                out.print(1);
                out.flush();

                break;

            case "Editar":
                
                LocalDate medFecUpdate = LocalDate.now();
                
                med.setId(Integer.parseInt(request.getParameter("txtId")));
                
                med.setTipoDoc(Integer.parseInt((String) request.getParameter("txtTipoDoc")));
                med.setNroDoc(request.getParameter("txtDni"));
                med.setNom(request.getParameter("txtNom"));
                med.setApe(request.getParameter("txtApe"));
                med.setCorreo(request.getParameter("txtMail"));
                med.setTipMedico(Integer.parseInt((String) request.getParameter("txtTipMedico")));
                med.setLicencia(request.getParameter("txtLicencia"));
                med.setFecUpdate(medFecUpdate);
                med.setCodUserUpdate(1);               

                mdao.editar(med);

                out.print(1);
                out.flush();

                break;
        }
        
    }
    
}
