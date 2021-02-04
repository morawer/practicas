package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Coche;
import interfaces.cocheDAO;

public class DaoCoche implements cocheDAO {

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
    public boolean addCoche(Coche c) {

        if (!abrirConexion()) {
            return false;
        }
        boolean alta = true;

        String query = "INSERT INTO COCHES (MATRICULA,MARCA,MODELO,COLOR) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, c.getMatricula());
            ps.setString(2, c.getMarca());
            ps.setString(3, c.getModelo());
            ps.setString(4, c.getColor());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0)
                alta = false;
        } catch (SQLException e) {
            System.out.println("alta -> Error al insertar: " + c);
            alta = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return alta;
    }

    @Override
    public boolean borrarCoche(int id) {

        if (!abrirConexion()) {
            return false;
        }

        boolean borrado = true;
        String query = "DELETE FROM COCHES WHERE ID = ?";
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
    public Coche buscarCoche(int id) {

        if (!abrirConexion()) {
            return null;
        }
        Coche coche = null;

        String query = "select ID,MATRICULA,MARCA,MODELO,COLOR FROM COCHES WHERE ID = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                coche = new Coche();
                coche.setId(rs.getInt(1));
                coche.setMatricula(rs.getString(2));
                coche.setMarca(rs.getString(3));
                coche.setModelo(rs.getString(4));
                coche.setColor(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("buscar -> error al buscar el " + "coche con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return coche;
    }

    @Override
    public boolean modificarCoche(int id, String matricula, String marca, String modelo, String color) {

        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE COCHES SET MATRICULA = ?, MARCA = ?, MODELO = ?, COLOR = ? WHERE ID = ?";
        try {
            
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setString(1, matricula);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, color);
            ps.setInt(5, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0)
                modificado = false;
        } catch (SQLException e) {
            modificado = false;
            System.out.println("Modificar -> No se ha podido modificar el coche con el ID: " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return modificado;

    }

    @Override
    public List<Coche> listarCoche() {
        if (!abrirConexion()) {
            return null;
        }
        List<Coche> listaCoches = new ArrayList<>();

        Coche coche = null;

        String query = "SELECT ID,MATRICULA,MARCA,MODELO,COLOR FROM COCHES";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                coche = new Coche();
                coche.setId(rs.getInt(1));
                coche.setMatricula(rs.getString(2));
                coche.setMarca(rs.getString(3));
                coche.setModelo(rs.getString(4));
                coche.setColor(rs.getString(5));

                listaCoches.add(coche);
            }
        } catch (SQLException e) {
            System.out.println("listar -> error al obtener los " + "coches");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaCoches;
    }

}
