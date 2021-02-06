package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Persona;
import interfaces.personaDao;

public class DaoPersona implements personaDao {

    private Connection conexion;

    public boolean abrirConexion() {
        String url = "jdbc:mysql://localhost:3306/bbdd_practica_2";
        String usuario = "root";
        String password = "";
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addPersona(Persona p) {
        
        if (!abrirConexion()) {
            return false;
        }
        boolean alta = true;

        String query = "INSERT INTO PERSONAS (NOMBRE,EDAD,PESO) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEdad());
            ps.setDouble(3, p.getPeso());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0)
                alta = false;
        } catch (SQLException e) {
            System.out.println("alta -> Error al insertar: " + p);
            alta = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return alta;
    }

    @Override
    public boolean borrarPersona(int id) {

        if (!abrirConexion()) {
            return false;
        }

        boolean borrado = true;
        String query = "DELETE FROM PERSONAS WHERE ID = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0)
                borrado = false;
        } catch (SQLException e) {
            borrado = false;
            System.out.println("baja -> No se ha podido dar de baja" + " el id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return borrado;
    }

    @Override
    public Persona buscarPersona(int id) {

        if (!abrirConexion()) {
            return null;
        }
        Persona persona = null;

        String query = "SELECT ID,NOMBRE,EDAD,PESO,IDCOCHE FROM PERSONAS WHERE ID = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setEdad(rs.getInt(3));
                persona.setPeso(rs.getDouble(4));
                persona.setIdCoche(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("buscar -> error al buscar la persona con el ID: " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return persona;
    }

    @Override
    public List<Persona> listarPersona() {
        if (!abrirConexion()) {
            return null;
        }
        List<Persona> listaPersonas = new ArrayList<>();

        Persona persona = null;

        String query = "SELECT ID,NOMBRE,EDAD,PESO,IDCOCHE FROM PERSONAS";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setEdad(rs.getInt(3));
                persona.setPeso(rs.getDouble(4));
                persona.setIdCoche(rs.getInt(5));

                listaPersonas.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("listar -> error al obtener los " + "coches");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaPersonas;
    }

    @Override
    public boolean addPersonaCoche(int idPersona, int idCoche) {

        if (!abrirConexion()) {
            return false;
        }

        boolean cocheAsignado = true;
        String query = "UPDATE PERSONAS SET IDCOCHE = ? WHERE ID = ?";
        try {
            
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idCoche);
            ps.setInt(2, idPersona);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0)
                cocheAsignado = false;
        } catch (SQLException e) {
            cocheAsignado = false;
            System.out.println("No se ha podido modificar la persona con el ID: " + idPersona);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return cocheAsignado;

    }

    @Override
    public boolean borrarPersonaCoche(int idPersona) {

        if (!abrirConexion()) {
            return false;
        }

        boolean personaNoAsignada = true;
        String query = "UPDATE PERSONAS SET IDCOCHE = 0 WHERE ID = ?";
        try {
            
            PreparedStatement ps = conexion.prepareStatement(query);
            
            ps.setInt(1, idPersona);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0)
                personaNoAsignada = false;
        } catch (SQLException e) {
            personaNoAsignada = false;
            System.out.println("No se ha podido modificar la asignacion del vehiculo a la persona con ID: " + idPersona);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return personaNoAsignada;

    }

    @Override
    public List<Persona> listarPersonaCoche(int idCoche) {

        if (!abrirConexion()) {
            return null;
        }

        List<Persona> listaPersonas = new ArrayList<>();

        Persona persona = null;

        String query = "SELECT ID,NOMBRE,EDAD,PESO,IDCOCHE FROM PERSONAS WHERE IDCOCHE = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idCoche);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setEdad(rs.getInt(3));
                persona.setPeso(rs.getDouble(4));
                persona.setIdCoche(rs.getInt(5));

                listaPersonas.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("listar -> error al obtener la lista de personas asignadas al coche con ID: " + idCoche);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaPersonas;
    }
}
