public class Cancion {
    private String titulo;
    private String artista;
    private double duracion;
    private String genero;

    public Cancion(String titulo, String artista, double duracion, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.genero = genero;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getArtista(String titulo) {
        return artista;
    }
    public double getDuracion() {
        return duracion;
    }
    public String getGenero() {
        return genero;
    }
    public void mostrarInfo(){
        System.out.println("🎵 " + titulo + " - " + artista + " [" + duracion + " min] (" + genero + ")");
    }
    public String getArtista() {
        return artista;
    }
}
