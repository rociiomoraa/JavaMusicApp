import java.util.ArrayList;
import java.io.*;

public class Playlist {
    private String nombre;
    private ArrayList<Cancion> canciones;

    //Constructor
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    //Método para agregar una canción a la playlist
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        System.out.println("✅ Canción añadida a la playlist: " + cancion.getTitulo());
    }

    //Método para eliminar una canción de la playlist por título
    public void eliminarCancion(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                canciones.remove(cancion);
                System.out.println("❌ Canción eliminada: " + titulo);
                return;
            }
        }
        System.out.println("⚠ No se encontró la canción: " + titulo);
    }

    //Método para mostrar todas las canciones de la playlist
    public void mostrarPlaylist() {
        System.out.println("\n🎶 Playlist: " + nombre);
        if (canciones.isEmpty()) {
            System.out.println("🚫 La playlist está vacía.");
        } else {
            for (Cancion cancion : canciones) {
                cancion.mostrarInfo();
            }
        }
    }
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public Cancion buscarCancion(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    // Método para guardar la playlist en un archivo
    public void guardarPlaylist(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(nombre + "\n");
            for (Cancion cancion : canciones) {
                writer.write(cancion.getTitulo() + "," + cancion.getArtista() + "," + cancion.getDuracion() + "," + cancion.getGenero() + "\n");
            }
            System.out.println("💾 Playlist guardada en " + archivo);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar la playlist: " + e.getMessage());
        }
    }

    // Método para cargar una playlist desde un archivo
    public static Playlist cargarPlaylist(String archivo) {
        Playlist playlist = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String nombrePlaylist = reader.readLine();
            playlist = new Playlist(nombrePlaylist);

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String titulo = datos[0];
                    String artista = datos[1];
                    double duracion = Double.parseDouble(datos[2]);
                    String genero = datos[3];

                    Cancion cancion = new Cancion(titulo, artista, duracion, genero);
                    playlist.agregarCancion(cancion);
                }
            }
            System.out.println("📂 Playlist cargada desde " + archivo);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar la playlist: " + e.getMessage());
        }
        return playlist;
    }

    public String getNombre() {
        return nombre;
    }
}


