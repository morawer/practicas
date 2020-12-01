public class Coches {

    private byte[] matricula;
    private byte[] marca;
    private byte[] modelo;
    private byte[] precio;


    @Override
    public String toString() {
        return "Coches [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio
                + "]";
    }

    public Coches() {
    }

    public Coches(byte[] matricula, byte[] marca, byte[] modelo, byte[] precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public byte[] getMatricula() {
        return matricula;
    }

    public void setMatricula(byte[] matricula) {
        this.matricula = matricula;
    }

    public byte[] getMarca() {
        return marca;
    }

    public void setMarca(byte[] marca) {
        this.marca = marca;
    }

    public byte[] getModelo() {
        return modelo;
    }

    public void setModelo(byte[] modelo) {
        this.modelo = modelo;
    }

    public byte[] getPrecio() {
        return precio;
    }

    public void setPrecio(byte[] precio) {
        this.precio = precio;
    }
}