import java.util.ArrayList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    //Constructor
    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    //Método para agregar una canción al álbum
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        System.out.println("✅ Canción añadida: " + cancion.getTitulo() + " al álbum " + nombre);
    }

    //Método para mostrar todas las canciones del álbum
    public void mostrarCanciones() {
        System.out.println("\n📀 Álbum: " + nombre + " - " + artista);
        for (Cancion cancion : canciones) {
            cancion.mostrarInfo();
        }
    }
}
