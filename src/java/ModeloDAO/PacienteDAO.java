package ModeloDAO;

import Config.Conexion;
import Modelo.Paciente;
import java.util.List;
import Interfaces.PacienteInterface;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteDAO implements PacienteInterface{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Paciente pac = new Paciente();

    @Override
    public List listar() {
        ArrayList<Paciente> list = new ArrayList<>();
        String sql = "SELECT * FROM persona WHERE Tipo = 1";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente pa = new Paciente();
                pa.setId(rs.getInt("IdPersona"));
                pa.setTipoPer(rs.getInt("Tipo"));
                pa.setTipoDoc(rs.getInt("TipoDoc"));
                pa.setNroDoc(rs.getString("NroDoc"));
                pa.setNom(rs.getString("Nombres"));
                pa.setApe(rs.getString("Apellidos"));
                pa.setCorreo(rs.getString("Correo"));
                pa.setEdad(rs.getInt("Edad"));
                pa.setUbigeo(rs.getInt("Ubigeo"));
                pa.setCelular(rs.getString("Celular"));

                list.add(pa);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Paciente list(int id) {
        String sql = "SELECT * FROM persona WHERE Tipo = 1 AND IdPersona = " + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pac.setId(rs.getInt("IdPersona"));
                pac.setTipoPer(rs.getInt("Tipo"));
                pac.setTipoDoc(rs.getInt("TipoDoc"));
                pac.setNroDoc(rs.getString("NroDoc"));
                pac.setNom(rs.getString("Nombres"));
                pac.setApe(rs.getString("Apellidos"));
                pac.setCorreo(rs.getString("Correo"));
                pac.setEdad(rs.getInt("Edad"));
                pac.setUbigeo(rs.getInt("Ubigeo"));
                pac.setDireccion(rs.getString("Direccion"));
                pac.setCelular(rs.getString("Celular"));
                pac.setfNac(rs.getString("FecNacimiento"));
                pac.setfEmision(rs.getString("FecEmision"));
                pac.setfCaducidad(rs.getString("FecCaducidad"));
                
            }

        } catch (Exception e) {

        }

        return pac;
    }

    @Override
    public int agregar(Paciente pac) {
        String sql = "INSERT INTO persona(IdPersona, Tipo, TipoDoc, NroDoc, Nombres, Apellidos, Correo, Edad, Ubigeo, Direccion, Celular, FecNacimiento, FecEmision, FecCaducidad, FecRegistro, UserRegistro) VALUES "
                + "('" + pac.getId()+ "', '" + pac.getTipoPer()+ "', '" + pac.getTipoDoc()+ "', '" + pac.getNroDoc()+ "', '" + pac.getNom()+ "', '" + pac.getApe()+ "', '" + pac.getCorreo()+ "', '" + pac.getEdad()+ "', '" + pac.getUbigeo()+ "', '" + pac.getDireccion()+ "', '" + pac.getCelular()+ "', '" + pac.getfNac()+ "', '" + pac.getfEmision()+ "', '" + pac.getfCaducidad()+ "', '" + pac.getFecRegistro()+ "', '" + pac.getCodUserRegistro()+ "')";
        
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
    public int editar(Paciente pac) {
        String sql = "UPDATE persona SET TipoDoc = '" + pac.getTipoDoc()+ "', NroDoc = '" + pac.getNroDoc()+ "', Nombres = '" + pac.getNom()+ "', Apellidos = '" + pac.getApe()+ "', Correo = '" + pac.getCorreo()+ "', Edad = '" + pac.getEdad()+ "' , Ubigeo = '" + pac.getUbigeo()+ "', Direccion = '" + pac.getDireccion()+ "', Celular = '" + pac.getCelular()+ "', FecNacimiento = '" + pac.getfNac()+ "', FecEmision = '" + pac.getfEmision()+ "', FecCaducidad = '" + pac.getfCaducidad()+ "', FecUpdate = '" + pac.getFecUpdate()+ "', UserUpdate = '" + pac.getCodUserUpdate()+ "' WHERE IdPersona = " + pac.getId();
        
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
    public boolean eliminar(int id) {
        String sql = "DELETE FROM persona WHERE Tipo = 1 AND IdPersona = " + id;

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            
        }
        
        return false;
    }
    
    @Override
    public Paciente listBusq(int dni, String fnac, String femi) {
        String sql = "SELECT * FROM persona WHERE Tipo = 1 AND FecNacimiento = '" +fnac+ "' AND FecEmision = '" +femi+ "' AND NroDoc = " + dni;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pac.setId(rs.getInt("IdPersona"));
                pac.setTipoPer(rs.getInt("Tipo"));
                pac.setTipoDoc(rs.getInt("TipoDoc"));
                pac.setNroDoc(rs.getString("NroDoc"));
                pac.setNom(rs.getString("Nombres"));
                pac.setApe(rs.getString("Apellidos"));
                pac.setCorreo(rs.getString("Correo"));
                pac.setEdad(rs.getInt("Edad"));
                pac.setUbigeo(rs.getInt("Ubigeo"));
                pac.setDireccion(rs.getString("Direccion"));
                pac.setCelular(rs.getString("Celular"));
                pac.setfNac(rs.getString("FecNacimiento"));
                pac.setfEmision(rs.getString("FecEmision"));
                pac.setfCaducidad(rs.getString("FecCaducidad"));
                
            }

        } catch (Exception e) {

        }

        return pac;
    }
    
}
