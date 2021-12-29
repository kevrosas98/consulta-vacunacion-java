package ModeloDAO;

import Config.Conexion;
import Interfaces.VacunaInterface;
import Modelo.Vacuna;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacunaDAO implements VacunaInterface {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vacuna vac = new Vacuna();

    @Override
    public List listar(int id) {
        ArrayList<Vacuna> list = new ArrayList<>();
        String sql = "SELECT * FROM vacuna WHERE IdPersona = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Vacuna vacu = new Vacuna();
                vacu.setIdPaciente(rs.getInt("IdPersona"));
                vacu.setIdVacuna(rs.getInt("IdVacuna"));
                vacu.setNroDosis(rs.getInt("NroDosis"));
                vacu.setIdLab(rs.getInt("IdLab"));
                vacu.setLote(rs.getString("Lote"));
                vacu.setFechaVacuna(rs.getString("FechaVacuna"));
                vacu.setIdLocal(rs.getInt("IdLocal"));
                vacu.setIdMedico(rs.getInt("IdMedico"));

                list.add(vacu);
            }
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public Vacuna listVacuna(int id) {
        String sql = "SELECT * FROM vacuna WHERE IdVacuna = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                vac.setIdPaciente(rs.getInt("IdPersona"));
                vac.setIdVacuna(rs.getInt("IdVacuna"));
                vac.setNroDosis(rs.getInt("NroDosis"));
                vac.setIdLab(rs.getInt("IdLab"));
                vac.setIdMedico(rs.getInt("IdMedico"));
                vac.setLote(rs.getString("Lote"));
                vac.setIdLocal(rs.getInt("IdLocal"));
                vac.setFechaVacuna(rs.getString("FechaVacuna"));
            }

        } catch (Exception e) {

        }

        return vac;
    }
    
    @Override
    public int agregar(Vacuna vac) {
        String sql = "INSERT INTO vacuna(IdPersona, NroDosis, IdLab, Lote, IdLocal, IdMedico, FechaVacuna, FechaReg, IdUserReg) VALUES "
                + "('" + vac.getIdPaciente()+ "', '" + vac.getNroDosis() + "', '" + vac.getIdLab()+ "', '" + vac.getLote()+ "', '" + vac.getIdLocal() + "', '" + vac.getIdMedico()+ "', '" + vac.getFechaVacuna() + "', '" + vac.getFecRegistro()+ "', '" + vac.getCodUserReg()+ "')";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            int st = ps.executeUpdate();

            return st;

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int editar(Vacuna vac) {
        String sql = "UPDATE vacuna SET "
                + "NroDosis = '" + vac.getNroDosis() + "', "
                + "IdLab = '" + vac.getIdLab()+ "', "
                + "Lote = '" + vac.getLote()+ "', "
                + "IdLocal = '" + vac.getIdLocal() + "', "
                + "IdMedico = '" + vac.getIdMedico()+ "', "
                + "FechaVacuna = '" + vac.getFechaVacuna() + "', "
                + "FechaUpdate = '" + vac.getFecUpdate() + "', "
                + "IdUserUpdate = '" + vac.getCodUserUpdate() + "' "
                + " WHERE IdVacuna = '" + vac.getIdVacuna()+ "' AND IdPersona = '" + vac.getIdPaciente() + "'";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            int st = ps.executeUpdate();

            return st;

        } catch (Exception e) {

            return 0;

        }
    }

    @Override
    public boolean eliminar(int id, int idp) {
        String sql = "DELETE FROM vacuna WHERE IdVacuna = " + id + " AND IdPersona = " + idp;

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }
    
}
