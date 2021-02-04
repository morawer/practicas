package interfaces;

import java.util.List;

import entidades.Coche;

public interface cocheDAO {

    public boolean addCoche(Coche c);
    public boolean borrarCoche(int id);
    public Coche buscarCoche(int id);
    public boolean modificarCoche(int id , String matricula, String marca, String modelo, String color);
    public List <Coche> listarCoche();
}
