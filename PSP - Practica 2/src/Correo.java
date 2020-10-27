public class Correo {

    public static int numId = 1;
    private int id;
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpo;

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
        return "Correo [id=" + id + ", asunto=" + asunto + ", cuerpo=" + cuerpo + 
        ", destinatario=" + destinatario +  ", remitente=" + remitente + "]";
    }

    public Correo(String destinatario, String remitente, String asunto, String cuerpo) {
        id = Correo.numId++; 
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }
}
