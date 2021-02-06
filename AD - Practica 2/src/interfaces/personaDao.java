package interfaces;

import java.util.List;

import entidades.Persona;

public interface personaDao {

    public boolean addPersona(Persona p);
    public boolean borrarPersona(int id);
    public Persona buscarPersona(int id);
    public List <Persona> listarPersona();
    public boolean addPersonaCoche (int idPersona, int idCoche);
    public boolean borrarPersonaCoche (int idPersona, int idCoche);
    public List <Persona> listarPersonaCoche(int idCoche);

}
