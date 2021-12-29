package ModeloDAO;

import Config.Conexion;
import Interfaces.OtrosInterface;
import Modelo.Atributo;
import Modelo.Laboratorio;
import Modelo.Local;
import Modelo.Ubigeo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OtrosDAO implements OtrosInterface {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /* Local */
    Local loc = new Local();

    @Override
    public List listarLocal() {
        ArrayList<Local> list = new ArrayList<>();
        String sql = "SELECT * FROM local";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Local lo = new Local();
                lo.setId(rs.getInt("IdLocal"));
                lo.setNombre(rs.getString("Nombre"));
                lo.setDireccion(rs.getString("Direccion"));
                lo.setUbigeo(rs.getInt("Ubigeo"));

                list.add(lo);
            }
        } catch (Exception e) {

        }

        return list;
    }

    @Override
    public Local listLocal(int id) {
        String sql = "SELECT * FROM local where IdLocal = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                loc.setId(rs.getInt("IdLocal"));
                loc.setNombre(rs.getString("Nombre"));
                loc.setDireccion(rs.getString("Direccion"));
                loc.setUbigeo(rs.getInt("Ubigeo"));
            }

        } catch (Exception e) {

        }

        return loc;
    }

    @Override
    public boolean agregarLocal(Local loc) {
        String sql = "INSERT INTO local (Nombre, Direccion, Ubigeo) VALUES ('" + loc.getNombre() + "', '" + loc.getDireccion() + "', '" + loc.getUbigeo() + "')";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean editarLocal(Local loc) {
        String sql = "UPDATE local SET Nombre = '" + loc.getNombre() + "', Direccion = '" + loc.getDireccion() + "', Ubigeo = '" + loc.getUbigeo() + "' WHERE IdLocal = " + loc.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminarLocal(int id) {
        String sql = "DELETE FROM local WHERE IdLocal = " + id;

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }

    /* Laboratorio */
    Laboratorio lab = new Laboratorio();

    @Override
    public List listarLab() {
        ArrayList<Laboratorio> list = new ArrayList<>();
        String sql = "SELECT * FROM laboratorio";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Laboratorio la = new Laboratorio();

                la.setId(rs.getInt("IdLab"));
                la.setNombre(rs.getString("Nombre"));
                la.setPais(rs.getString("Pais"));

                list.add(la);
            }

        } catch (Exception e) {

        }

        return list;
    }

    @Override
    public Laboratorio listLab(int id) {
        String sql = "SELECT * FROM laboratorio where IdLab = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lab.setId(rs.getInt("IdLab"));
                lab.setNombre(rs.getString("Nombre"));
                lab.setPais(rs.getString("Pais"));
            }

        } catch (Exception e) {

        }

        return lab;
    }

    @Override
    public boolean agregarLab(Laboratorio lab) {
        String sql = "INSERT INTO laboratorio(Nombre, Pais) VALUES ('" + lab.getNombre() + "' , '" + lab.getPais() + "')";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean editarLab(Laboratorio lab) {
        String sql = "UPDATE laboratorio SET Nombre = '" + lab.getNombre() + "' , Pais = '" + lab.getPais() + "' WHERE IdLab = " + lab.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminarLab(int id) {
        String sql = "DELETE FROM laboratorio WHERE IdLab = " + id;

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }

    /* Ubigeo */
    Ubigeo ub = new Ubigeo();

    @Override
    public List listarUbigeo() {
        ArrayList<Ubigeo> listUbi = new ArrayList<>();
        String sql = "SELECT * FROM ubigeo";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Ubigeo ubi = new Ubigeo();

                ubi.setIdUbigeo(rs.getString("IdUbigeo"));
                ubi.setNomUbigeo(rs.getString("NombreUbigeo"));

                listUbi.add(ubi);
            }
        } catch (Exception e) {

        }

        return listUbi;
    }

    @Override
    public Ubigeo listUbigeo(int id) {
        String sql = "SELECT * FROM ubigeo where IdUbigeo = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ub.setIdUbigeo(rs.getString("IdUbigeo"));
                ub.setNomUbigeo(rs.getString("NombreUbigeo"));
            }

        } catch (Exception e) {

        }

        return ub;
    }
    
    /* Atributo */
    
    Atributo at = new Atributo();

    @Override
    public List listarAtributo(int tipo, int grupo) {

        ArrayList<Atributo> listaA = new ArrayList<>();
        String sql = "SELECT * FROM atributo WHERE GroupAtributo = " + grupo + " AND TipoAtributo = " + tipo;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Atributo atr = new Atributo();
                atr.setIdAtributo(rs.getInt("IdAtributo"));
                atr.setGroupAtributo(rs.getInt("GroupAtributo"));
                atr.setValorAtributo(rs.getInt("ValorAtributo"));
                atr.setNombre(rs.getString("Nombre"));
                atr.setTipoAtributo(rs.getInt("TipoAtributo"));
                listaA.add(atr);
            }
        } catch (Exception e) {

        }

        return listaA;
    }

    @Override
    public Atributo listAtributo(int tipo, int valor, int grupo) {
        String sql = "SELECT * FROM atributo where ValorAtributo = " + valor + " AND GroupAtributo = " + grupo + " AND TipoAtributo = " + tipo;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                at.setIdAtributo(rs.getInt("IdAtributo"));
                at.setGroupAtributo(rs.getInt("GroupAtributo"));
                at.setValorAtributo(rs.getInt("ValorAtributo"));
                at.setNombre(rs.getString("Nombre"));
                at.setTipoAtributo(rs.getInt("TipoAtributo"));
            }

        } catch (Exception e) {

        }

        return at;
    }

}
