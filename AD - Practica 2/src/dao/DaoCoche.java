package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into personas (NOMBRE,EDAD,PESO) "
				+ " values(?,?,?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setDouble(3, p.getPeso());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
    }

    @Override
    public boolean borrarCoche(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean buscarCoche(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarCoche(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Coche> listarCoche() {
        // TODO Auto-generated method stub
        return null;
    }
    
    

    
}
