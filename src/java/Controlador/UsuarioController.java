package Controlador;

import Modelo.Usuario;
import Modelo.Util;
import ModeloDAO.UsuarioDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.ws.rs.client.Entity.json;


public class UsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usu = new Usuario();
        UsuarioDAO udao = new UsuarioDAO();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("accion");
        String json = "";
        
        int rpta = 0;

        switch (action) {
            case "Agregar":

                int mx = udao.maxId();

                int usuTipo = 3;
                int usuTipoDoc = Integer.parseInt((String) request.getParameter("txtTipoDoc"));
                String usuNroDoc = request.getParameter("txtDni");
                String usuNom = request.getParameter("txtNom");
                String usuApe = request.getParameter("txtApe");
                String usuMail = request.getParameter("txtMail");
                LocalDate usuFecReg = LocalDate.now();
                int usuReg = 1;

                usu.setTipoPer(usuTipo);
                usu.setTipoDoc(usuTipoDoc);
                usu.setNroDoc(usuNroDoc);
                usu.setNom(usuNom);
                usu.setApe(usuApe);
                usu.setCorreo(usuMail);
                usu.setFecRegistro(usuFecReg);
                usu.setCodUserRegistro(usuReg);

                usu.setId(mx);
                usu.setPass("123456");

                udao.agregar(usu);

                out.print(1);
                out.flush();

                break;

            case "Editar":

                usu.setId(Integer.parseInt(request.getParameter("txtId")));

                usu.setTipoDoc(Integer.parseInt((String) request.getParameter("txtTipoDoc")));
                usu.setNroDoc(request.getParameter("txtDni"));
                usu.setNom(request.getParameter("txtNom"));
                usu.setApe(request.getParameter("txtApe"));
                usu.setCorreo(request.getParameter("txtMail"));
//                usu.setFecUpdate(LocalDate.now());
//                usu.setCodUserUpdate(1);               

                udao.editar(usu);

                out.print(1);
                out.flush();

                break;

            case "Reset":

                usu.setIdUsuario(Integer.parseInt(request.getParameter("txtId")));

                usu.setPass("123abc");

                boolean st = udao.resetPass(usu);

                if (st) {
                    out.print(1);
                } else {
                    out.print(0);
                }

                out.flush();

                break;

            case "Ingresar":

                String correo = request.getParameter("txtcorreo");
                String contra = request.getParameter("txtpass");

                usu.setCorreo(correo);
                usu.setPass(contra);
                
                rpta = udao.validar(usu);

                Gson gson = new Gson();

                if (rpta == 1) {

                    request.getSession().setAttribute("st", 1);
                    request.getSession().setAttribute("nom", correo);
                    request.getSession().setAttribute("correo", contra);

                    Util jsonv = new Util(true, "Acepte para ingresar!", "principal.jsp");
                    json = gson.toJson(jsonv);
                    
                } else {
                    Util jsonv = new Util(false, "Vuelva a intentarlo", "");
                    json = gson.toJson(jsonv);
                }

                out.println(json);
                out.flush();

                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usu = new Usuario();
        UsuarioDAO udao = new UsuarioDAO();

        String action = request.getParameter("accion");

        switch (action) {
            case "eliminarUsuario":

                int id = Integer.parseInt(request.getParameter("id"));
                usu.setId(id);
                udao.eliminar(id);

                response.sendRedirect("Routes?accion=listarUsuarios");

                break;
        }
    }

}
