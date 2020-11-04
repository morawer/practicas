public class Correo {

    // Atributos del correo.
    public static int numId = 1;
    private int id;
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpo;

    // Getters y setters.
    public int getId() {
        return id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public String toString() {
        return "Correo [id=" + id + ", asunto=" + asunto + ", cuerpo=" + cuerpo + ", destinatario=" + destinatario
                + ", remitente=" + remitente + "]";
    }

    // Constructor del correo. El Id no entra como argiumento del contructor. Se
    // sumara uno mas cada vez que se cree uno.
    public Correo(String destinatario, String remitente, String asunto, String cuerpo) {
        id = Correo.numId++;
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }
}
