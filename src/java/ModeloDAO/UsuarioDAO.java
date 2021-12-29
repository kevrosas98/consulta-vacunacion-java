package ModeloDAO;

import Config.Conexion;
import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.UsuarioInterface;

public class UsuarioDAO implements UsuarioInterface {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usu = new Usuario();

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario usu LEFT JOIN persona pe ON pe.IdPersona = usu.IdPersona";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId(rs.getInt("IdPersona"));
                us.setIdUsuario(rs.getInt("IdUsuario"));
                us.setTipoDoc(rs.getInt("TipoDoc"));
                us.setNroDoc(rs.getString("NroDoc"));
                us.setNom(rs.getString("Nombres"));
                us.setApe(rs.getString("Apellidos"));
                us.setCorreo(rs.getString("Correo"));

                list.add(us);
            }
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public Usuario list(int id) {
        String sql = "SELECT * FROM usuario usu LEFT JOIN persona pe ON pe.IdPersona = usu.IdPersona where pe.IdPersona=" + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                usu.setId(rs.getInt("IdPersona"));
                usu.setIdUsuario(rs.getInt("IdUsuario"));
                usu.setTipoDoc(rs.getInt("TipoDoc"));
                usu.setNroDoc(rs.getString("NroDoc"));
                usu.setNom(rs.getString("Nombres"));
                usu.setApe(rs.getString("Apellidos"));
                usu.setCorreo(rs.getString("Correo"));
            }

        } catch (Exception e) {

        }

        return usu;
    }

    @Override
    public boolean agregar(Usuario usu) {
        String sql = "INSERT INTO `persona`(`IdPersona`, `Tipo`, `TipoDoc`, `NroDoc`, `Nombres`, `Apellidos`, `Correo`, `FecRegistro`, `UserRegistro`) VALUES "
                + "('" + usu.getId() + "', '" + usu.getTipoPer() + "','" + usu.getTipoDoc() + "','" + usu.getNroDoc() + "','" + usu.getNom() + "','" + usu.getApe() + "','" + usu.getCorreo() + "','" + usu.getFecRegistro() + "','" + usu.getCodUserRegistro() + "')";
        String sql2 = "INSERT INTO `usuario`(`IdPersona`, `Password`, `Intentos`) VALUES ('" + usu.getId() + "','" + usu.getPass() + "','0')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean editar(Usuario usu) {
        String sql = "UPDATE persona SET TipoDoc = '" + usu.getTipoDoc() + "' , NroDoc = '" + usu.getNroDoc() + "', Nombres = '" + usu.getNom() + "', Apellidos = '" + usu.getApe() + "', Correo = '" + usu.getCorreo() + "' where IdPersona = " + usu.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean resetPass(Usuario usu) {
        String sql = "UPDATE usuario SET Password = '" + usu.getPass() + "' where IdUsuario = '" + usu.getIdUsuario() + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            return false;

        }
    }

    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE FROM usuario where IdPersona =" + id;
        String sql2 = "DELETE FROM persona where IdPersona =" + id;

        try {

            con = cn.getConnection();

            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            ps = con.prepareStatement(sql2);
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public int maxId() {

        int max = 0;
        String sql = "SELECT MAX(IdPersona)+1 AS max FROM persona";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                max = rs.getInt("max");
            }

            return max;

        } catch (Exception e) {

            return 0;

        }
    }

    @Override
    public int validar(Usuario usu) {
        int r = 0;
        
        String sql = "SELECT pe.*, usu.* FROM usuario usu INNER JOIN persona pe ON pe.IdPersona = usu.IdPersona WHERE pe.Tipo = 3 AND pe.Correo = '" + usu.getCorreo() +"' AND usu.Password = '" + usu.getPass() + "'";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = r + 1;
                usu.setId(rs.getInt("IdUsuario"));
                usu.setNom(rs.getString("Nombres"));
                usu.setApe(rs.getString("Apellidos"));
                usu.setCorreo(rs.getString("Correo"));
            }

            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 2;
        }
    }

////    public static void main(String[] args) {
////        Persona p = new Persona();
////        p.setNom("Hans");
////        p.setCorreo("hrosas@mail.com");
////
////        PersonaDAO dao = new PersonaDAO();
////        int r = dao.validar(p);
////        
////        System.out.println("Validar = " + r);
////    }
    
}
