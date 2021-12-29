package ModeloDAO;

import Config.Conexion;
import Modelo.Medico;
import java.util.List;
import Interfaces.MedicoInterface;
import java.sql.*;
import java.util.ArrayList;

public class MedicoDAO implements MedicoInterface{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Medico med = new Medico();

    @Override
    public List listar() {
        ArrayList<Medico> list = new ArrayList<>();
        String sql = "SELECT * FROM persona WHERE Tipo = 2";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Medico md = new Medico();
                md.setId(rs.getInt("IdPersona"));
                md.setTipoPer(rs.getInt("Tipo"));
                md.setTipoDoc(rs.getInt("TipoDoc"));
                md.setNroDoc(rs.getString("NroDoc"));
                md.setNom(rs.getString("Nombres"));
                md.setApe(rs.getString("Apellidos"));
                md.setCorreo(rs.getString("Correo"));
                md.setTipMedico(rs.getInt("TipoMed"));

                list.add(md);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Medico list(int id) {
        String sql = "SELECT * FROM persona WHERE Tipo = 2 AND IdPersona = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                med.setId(rs.getInt("IdPersona"));
                med.setTipoPer(rs.getInt("Tipo"));
                med.setTipoDoc(rs.getInt("TipoDoc"));
                med.setNroDoc(rs.getString("NroDoc"));
                med.setNom(rs.getString("Nombres"));
                med.setApe(rs.getString("Apellidos"));
                med.setCorreo(rs.getString("Correo"));
                med.setTipMedico(rs.getInt("TipoMed"));
                med.setLicencia(rs.getString("Licencia"));
            }

        } catch (Exception e) {

        }

        return med;
    }

    @Override
    public boolean agregar(Medico med) {
        String sql = "INSERT INTO persona(IdPersona, Tipo, TipoDoc, NroDoc, Nombres, Apellidos, Correo, TipoMed, Licencia, FecRegistro, UserRegistro) VALUES "
                + "('" + med.getId() + "', '" + med.getTipoPer()+ "', '" + med.getTipoDoc()+ "', '" + med.getNroDoc()+ "', '" + med.getNom()+ "', '" + med.getApe()+ "', '" + med.getCorreo()+ "', '" + med.getTipMedico()+ "', '" + med.getLicencia()+ "', '" + med.getFecRegistro()+ "' , '" + med.getCodUserRegistro()+ "')";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean editar(Medico med) {
        String sql = "UPDATE persona SET TipoDoc = '" + med.getTipoDoc() + "', NroDoc = '" + med.getNroDoc() + "', Nombres = '" + med.getNom()+ "', Apellidos = '" + med.getApe()+ "', Correo = '" + med.getCorreo()+ "', TipoMed = '" + med.getTipMedico()+ "', Licencia = '" + med.getLicencia()+ "', FecUpdate = '" + med.getFecUpdate()+ "', UserUpdate = '" + med.getCodUserUpdate()+ "' WHERE IdPersona = " + med.getId();
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM persona WHERE Tipo = 2 AND IdPersona = " + id;

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            
        }
        
        return false;
    }
    
}
