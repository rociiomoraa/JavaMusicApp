# 🎧 JavaMusicApp - Gestor de Música en Java 

¡Bienvenido/a a **JavaMusicApp**! 🎵🚀 Este es un programa en **Java** que permite gestionar múltiples playlists de manera eficiente desde la terminal. Puedes **crear playlists, agregar canciones, guardar y cargar playlists en archivos, y simular la reproducción de música** con controles básicos.

---

## 📜 Características
✅ **Crear múltiples playlists** y gestionarlas de forma independiente.  
✅ **Seleccionar la playlist activa** para reproducir canciones de ella.  
✅ **Agregar canciones** con título, artista, duración y género a una playlist específica.  
✅ **Ver la lista de playlists disponibles** y su contenido.  
✅ **Eliminar playlists** cuando ya no sean necesarias.  
✅ **Guardar y cargar playlists** desde archivos de texto.  
✅ **Simular la reproducción de canciones** con opciones de **siguiente y anterior**.  

---

## 🔧 Requisitos
- Tener **Java 8** o superior instalado.  
- Un editor de código como **IntelliJ IDEA** o **VS Code**.  

---

## 🚀 Instalación y Uso
### 1️⃣ Clonar el Repositorio:
```bash
git clone https://github.com/TU_USUARIO/JavaMusicApp.git
cd JavaMusicApp
```
### 2️⃣ Compilar el Proyecto:
```bash
javac -d bin src/Main.java
```
### 3️⃣ Ejecutar el Programa:
```bash
java -cp bin Main
```

---

## 🖥 Cómo Usarlo
Al ejecutar el programa, verás un **menú interactivo** como este:
```plaintext
--- JavaMusicApp ---
1. Crear nueva playlist 📂
2. Seleccionar playlist activa 🎼
3. Agregar canción 🎵
4. Mostrar playlists disponibles 📜
5. Mostrar canciones de la playlist actual 🎶
6. Guardar playlist 💾
7. Cargar playlist 📂
8. Reproducir música 🎧
9. Eliminar playlist ❌
10. Salir 🚪
Elige una opción:
```

---

## 📂 Estructura del Proyecto
```plaintext
/JavaMusicApp
│── src/Main.java                # Código fuente principal
│── src/Cancion.java             # Clase para manejar canciones
│── src/Playlist.java            # Clase para gestionar playlists
│── src/Reproductor.java         # Simulación de un reproductor de música
│── playlists/                   # Carpeta para archivos de playlists guardadas
│── README.md                    # Este archivo con información del proyecto
```

---

## 📝 Ejemplo de Uso
```plaintext
Elige una opción: 1
📂 Ingresa el nombre de la nueva playlist: Rock Clásico
✅ Nueva playlist creada: Rock Clásico

Elige una opción: 3
📜 Selecciona una playlist para agregar la canción:
1. Rock Clásico
2. Mis Favoritas de Bad Bunny
Número de la playlist: 1

Título: Bohemian Rhapsody
Artista: Queen
Duración (min): 5.55
Género: Rock
✅ Canción añadida a la playlist: Rock Clásico

Elige una opción: 8
🎵 Reproduciendo: Bohemian Rhapsody - Queen
▶ 1. Siguiente   ⏮ 2. Anterior   ⏸ 3. Pausar   ⏹ 4. Salir
```

---

## 🔗 Contribuciones
¡Las contribuciones son bienvenidas! 🎉 Si quieres mejorar el proyecto:
- Haz un **fork** del repositorio.
- Crea una **rama** con tus cambios.
- Haz un **pull request** explicando las mejoras.

---

## 🏆 Autor
👤 **Rocío Mora García**  
📧 **rocio.mora.garcia02@gmail.com**  
🌐 **[Mi Perfil de GitHub](https://github.com/rociiomoraa)**  

---

¡Gracias por usar **JavaMusicApp**! 🚀😊


