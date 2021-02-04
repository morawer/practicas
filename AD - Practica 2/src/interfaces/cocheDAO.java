package interfaces;

import java.util.List;

import entidades.Coche;

public interface cocheDAO {

    public boolean addCoche(Coche c);
    public boolean borrarCoche(int id);
    public boolean buscarCoche(int id);
    public boolean modificarCoche(int id);
    public List <Coche> listarCoche();
}
