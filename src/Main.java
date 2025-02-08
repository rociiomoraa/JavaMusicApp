import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist miPlaylist = new Playlist("Mis Favoritas de Bad Bunny");
        playlists.add(miPlaylist);
        Reproductor reproductor = new Reproductor(miPlaylist);

        System.out.println("🎵 Bienvenidx a JavaMusicApp 🎵");
        System.out.println("📀 Tu gestor de música en Java");
        System.out.println("🎧 Puedes crear playlists, agregar canciones y guardarlas.");
        System.out.println("\nPresiona ENTER para continuar...");
        scanner.nextLine();

        while (true) {
            System.out.println("\n🎶 MENU INTERACTIVO:");
            System.out.println("1. Crear nueva playlist 📂");
            System.out.println("2. Seleccionar una playlist 🎼");
            System.out.println("3. Agregar canción 🎵");
            System.out.println("4. Mostrar playlists disponibles 📜");
            System.out.println("5. Mostrar canciones de la playlist actual 🎶");
            System.out.println("6. Guardar playlist 💾");
            System.out.println("7. Cargar playlist 📂");
            System.out.println("8. Reproducir música 🎧");
            System.out.println("9. Eliminar playlist ❌");
            System.out.println("10. Salir 🚪");
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
                    System.out.print("📂 Ingresa el nombre de la nueva playlist: ");
                    String nombrePlaylist = scanner.nextLine();
                    Playlist nuevaPlaylist = new Playlist(nombrePlaylist);
                    playlists.add(nuevaPlaylist);
                    System.out.println("✅ Nueva playlist creada: " + nombrePlaylist);
                    break;

                case 2:
                    if (playlists.isEmpty()) {
                        System.out.println("🚫 No hay playlists disponibles.");
                        break;
                    }
                    System.out.println("📜 Playlists disponibles:");
                    for (int i = 0; i < playlists.size(); i++) {
                        System.out.println((i + 1) + ". " + playlists.get(i).getNombre());
                    }
                    System.out.print("Selecciona una playlist: ");
                    try {
                        int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
                        if (seleccion >= 0 && seleccion < playlists.size()) {
                            miPlaylist = playlists.get(seleccion);
                            reproductor = new Reproductor(miPlaylist);
                            System.out.println("🎶 Playlist activa: " + miPlaylist.getNombre());
                        } else {
                            System.out.println("⚠ Número fuera de rango.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ Ingresa un número válido.");
                    }
                    break;

                case 3:
                    if (playlists.isEmpty()) {
                        System.out.println("🚫 No hay playlists disponibles. Crea una primero.");
                        break;
                    }

                    System.out.println("📜 Selecciona una playlist para agregar la canción:");
                    for (int i = 0; i < playlists.size(); i++) {
                        System.out.println((i + 1) + ". " + playlists.get(i).getNombre());
                    }

                    System.out.print("Número de la playlist: ");
                    int seleccionPlaylist;
                    try {
                        seleccionPlaylist = Integer.parseInt(scanner.nextLine()) - 1;
                        if (seleccionPlaylist < 0 || seleccionPlaylist >= playlists.size()) {
                            System.out.println("⚠ Número fuera de rango.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ Ingresa un número válido.");
                        break;
                    }

                    Playlist playlistSeleccionada = playlists.get(seleccionPlaylist);

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duración (min): ");

                    double duracion;
                    try {
                        duracion = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ Duración no válida. Ingresa un número.");
                        break;
                    }

                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    playlistSeleccionada.agregarCancion(new Cancion(titulo, artista, duracion, genero));

                    System.out.println("✅ Canción añadida a la playlist: " + playlistSeleccionada.getNombre());
                    break;

                case 4:
                    if (playlists.isEmpty()) {
                        System.out.println("🚫 No hay playlists creadas.");
                    } else {
                        System.out.println("📜 Listado de playlists:");
                        for (Playlist p : playlists) {
                            System.out.println("🎼 " + p.getNombre() + " (" + p.getCanciones().size() + " canciones)");
                        }
                    }
                    break;

                case 5:
                    miPlaylist.mostrarPlaylist();
                    break;

                case 6:
                    System.out.print("Ingresa el nombre del archivo para guardar: ");
                    String archivoGuardar = scanner.nextLine();
                    miPlaylist.guardarPlaylist(archivoGuardar + ".txt");
                    break;

                case 7:
                    System.out.print("Ingresa el nombre del archivo para cargar: ");
                    String archivoCargar = scanner.nextLine();
                    Playlist cargada = Playlist.cargarPlaylist(archivoCargar + ".txt");
                    if (cargada != null) {
                        playlists.add(cargada);
                        System.out.println("📂 Playlist cargada: " + cargada.getNombre());
                    }
                    break;

                case 8:
                    reproductor.simularReproduccion(scanner);
                    break;

                case 9:
                    if (playlists.isEmpty()) {
                        System.out.println("🚫 No hay playlists para eliminar.");
                        break;
                    }
                    System.out.println("📜 Playlists disponibles:");
                    for (int i = 0; i < playlists.size(); i++) {
                        System.out.println((i + 1) + ". " + playlists.get(i).getNombre());
                    }
                    System.out.print("Selecciona la playlist a eliminar: ");
                    try {
                        int seleccionEliminar = Integer.parseInt(scanner.nextLine()) - 1;
                        if (seleccionEliminar >= 0 && seleccionEliminar < playlists.size()) {
                            Playlist eliminada = playlists.remove(seleccionEliminar);
                            System.out.println("❌ Playlist eliminada: " + eliminada.getNombre());
                            if (eliminada == miPlaylist && !playlists.isEmpty()) {
                                miPlaylist = playlists.get(0);
                                reproductor = new Reproductor(miPlaylist);
                                System.out.println("🎵 Nueva playlist activa: " + miPlaylist.getNombre());
                            }
                        } else {
                            System.out.println("⚠ Número fuera de rango.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ Ingresa un número válido.");
                    }
                    break;

                case 10:
                    System.out.println("👋 Gracias por usar JavaMusicApp. ¡Hasta pronto!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠ Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
