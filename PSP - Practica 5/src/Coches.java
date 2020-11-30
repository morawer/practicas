public class Coches {

    private String matricula;
    private String marca;
    private String modelo;
    private String precio;

    public Coches(String matricula, String marca, String modelo, String precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Coches() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio + " €.";
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coches [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio
                + "]";
    }
    
    
}