import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Reproductor {
    private Playlist playlist;
    private int cancionActual;
    private boolean enReproduccion;
    private boolean repetirCancion;
    private boolean modoAleatorio;
    private ArrayList<Cancion> ordenAleatorio;

    // Constructor
    public Reproductor(Playlist playlist) {
        this.playlist = playlist;
        this.cancionActual = 0;
        this.enReproduccion = false;
        this.repetirCancion = false;
        this.modoAleatorio = false;
        this.ordenAleatorio = new ArrayList<>(playlist.getCanciones());
    }

    public String obtenerCancionActual() {
        if (playlist.getCanciones().isEmpty()) {
            return "🚫 No hay canciones en la playlist.";
        }
        Cancion cancion = playlist.getCanciones().get(cancionActual);
        return cancion.getTitulo() + " - " + cancion.getArtista();
    }

    public void siguiente() {
        if (playlist.getCanciones().isEmpty()) {
            System.out.println("🚫 No hay canciones en la playlist.");
            return;
        }
        if (repetirCancion) {
            System.out.println("🔄 Repitiendo: " + obtenerCancionActual());
        } else if (modoAleatorio) {
            Collections.shuffle(ordenAleatorio);
            Cancion cancion = ordenAleatorio.get(0);
            System.out.println("🔀 Reproduciendo aleatoriamente: " + cancion.getTitulo() + " - " + cancion.getArtista());
        } else {
            cancionActual = (cancionActual + 1) % playlist.getCanciones().size();
            System.out.println("▶ Reproduciendo: " + obtenerCancionActual());
        }
    }

    public void anterior() {
        if (playlist.getCanciones().isEmpty()) {
            System.out.println("🚫 No hay canciones en la playlist.");
            return;
        }
        cancionActual = (cancionActual - 1 + playlist.getCanciones().size()) % playlist.getCanciones().size();
        System.out.println("⏮ Reproduciendo: " + obtenerCancionActual());
    }

    public void pausar() {
        if (enReproduccion) {
            enReproduccion = false;
            System.out.println("⏸ Música pausada.");
        } else {
            System.out.println("⚠ No hay música en reproducción.");
        }
    }

    public void activarRepetir() {
        repetirCancion = !repetirCancion;
        System.out.println(repetirCancion ? "🔄 Repetición activada." : "🔁 Repetición desactivada.");
    }

    public void activarModoAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println(modoAleatorio ? "🔀 Modo aleatorio activado." : "📀 Modo aleatorio desactivado.");
        if (modoAleatorio) {
            Collections.shuffle(ordenAleatorio);
        }
    }

    // Método para simular la reproducción dentro de `Reproductor.java`
    public void simularReproduccion(Scanner scanner) {
        while (true) {
            System.out.println("\n🎵 Reproduciendo: " + obtenerCancionActual());
            System.out.println("▶ 1. Siguiente   ⏮ 2. Anterior   ⏸ 3. Pausar   ⏹ 4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Opción no válida. Ingresa un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    siguiente();
                    break;
                case 2:
                    anterior();
                    break;
                case 3:
                    pausar();
                    break;
                case 4:
                    System.out.println("⏹ Deteniendo la reproducción...");
                    return;
            }
        }
    }
}
