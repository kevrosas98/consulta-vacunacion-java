package Controlador;

import Modelo.Paciente;
import Modelo.Vacuna;
import ModeloDAO.PacienteDAO;
import ModeloDAO.UsuarioDAO;
import ModeloDAO.VacunaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PacienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente pac = new Paciente();
        PacienteDAO pdao = new PacienteDAO();

        Vacuna vac = new Vacuna();
        VacunaDAO vdao = new VacunaDAO();

        String action = request.getParameter("accion");

        switch (action) {
            case "eliminarPaciente":

                int id = Integer.parseInt(request.getParameter("id"));
                pac.setId(id);
                pdao.eliminar(id);

                response.sendRedirect("Routes?accion=listarVacunados");

                break;

            case "eliminarVacuna":

                int idv = Integer.parseInt(request.getParameter("idv"));
                int idPaciente = Integer.parseInt(request.getParameter("idp"));
                
                vac.setIdVacuna(idv);
                vac.setIdPaciente(idPaciente);
                
                vdao.eliminar(idv, idPaciente);

                response.sendRedirect("Routes?accion=listarVacuna&idp="+idPaciente);

                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Paciente pac = new Paciente();
        PacienteDAO pdao = new PacienteDAO();

        Vacuna vac = new Vacuna();
        VacunaDAO vdao = new VacunaDAO();

        UsuarioDAO udao = new UsuarioDAO();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("accion");

        switch (action) {
            case "Agregar":

                int mx = udao.maxId();

                LocalDate pacFecReg = LocalDate.now();

                pac.setId(mx);
                pac.setTipoPer(1);
                pac.setTipoDoc(Integer.parseInt((String) request.getParameter("txtTipoDoc")));
                pac.setNroDoc(request.getParameter("txtDni"));
                pac.setNom(request.getParameter("txtNom"));
                pac.setApe(request.getParameter("txtApe"));
                pac.setCorreo(request.getParameter("txtMail"));
                pac.setEdad(Integer.parseInt((String) request.getParameter("txtEdad")));
                pac.setUbigeo(Integer.parseInt((String) request.getParameter("txtUbigeo")));
                pac.setDireccion(request.getParameter("txtDireccion"));
                pac.setCelular(request.getParameter("txtCelular"));
                pac.setfNac(request.getParameter("txtFecNac"));
                pac.setfEmision(request.getParameter("txtFecEmi"));
                pac.setfCaducidad(request.getParameter("txtFecCad"));
                pac.setFecRegistro(pacFecReg);
                pac.setCodUserRegistro(1);

                int st = pdao.agregar(pac);

                out.print(st);

                out.flush();

                break;

            case "Editar":

                LocalDate pacFecUpdate = LocalDate.now();

                pac.setId(Integer.parseInt(request.getParameter("txtId")));

                pac.setTipoDoc(Integer.parseInt((String) request.getParameter("txtTipoDoc")));
                pac.setNroDoc(request.getParameter("txtDni"));
                pac.setNom(request.getParameter("txtNom"));
                pac.setApe(request.getParameter("txtApe"));
                pac.setCorreo(request.getParameter("txtMail"));
                pac.setEdad(Integer.parseInt((String) request.getParameter("txtEdad")));
                pac.setUbigeo(Integer.parseInt((String) request.getParameter("txtUbigeo")));
                pac.setDireccion(request.getParameter("txtDireccion"));
                pac.setCelular(request.getParameter("txtCelular"));
                pac.setfNac(request.getParameter("txtFecNac"));
                pac.setfEmision(request.getParameter("txtFecEmi"));
                pac.setfCaducidad(request.getParameter("txtFecCad"));
                pac.setFecUpdate(pacFecUpdate);
                pac.setCodUserUpdate(1);

                int ste = pdao.editar(pac);

                out.print(ste);

                out.flush();

                break;

            case "AgregarVacuna":

                LocalDate vacFecReg = LocalDate.now();
                
                vac.setIdPaciente(Integer.parseInt((String) request.getParameter("txtIdPaciente")));
                vac.setNroDosis(Integer.parseInt((String) request.getParameter("txtNroDosis")));
                vac.setIdLab(Integer.parseInt((String) request.getParameter("txtIdLab")));
                vac.setLote(request.getParameter("txtLote"));
                vac.setIdLocal(Integer.parseInt((String) request.getParameter("txtIdLocal")));
                vac.setIdMedico(Integer.parseInt((String) request.getParameter("txtIdMedico")));
                vac.setFechaVacuna(request.getParameter("txtFechaVacuna"));
                vac.setFecRegistro(vacFecReg);
                vac.setCodUserReg(1);

                int stv = vdao.agregar(vac);

                out.print(stv);

                out.flush();

                break;
                
            case "EditarVacuna" :
                                
                LocalDate vacFecUpdt = LocalDate.now();
                
                vac.setIdVacuna(Integer.parseInt(request.getParameter("txtIdVacuna")));
                vac.setIdPaciente(Integer.parseInt(request.getParameter("txtIdPaciente")));
                
                vac.setNroDosis(Integer.parseInt((String) request.getParameter("txtNroDosis")));
                vac.setIdLab(Integer.parseInt((String) request.getParameter("txtIdLab")));
                vac.setLote(request.getParameter("txtLote"));
                vac.setIdLocal(Integer.parseInt((String) request.getParameter("txtIdLocal")));
                vac.setIdMedico(Integer.parseInt((String) request.getParameter("txtIdMedico")));
                vac.setFechaVacuna(request.getParameter("txtFechaVacuna"));
                vac.setFecUpdate(vacFecUpdt);
                vac.setCodUserUpdate(1);

                int stvu = vdao.editar(vac);

                out.print(stvu);

                out.flush();
                
                break;
                
            default:
                                
                break;
                
        }

    }

}
