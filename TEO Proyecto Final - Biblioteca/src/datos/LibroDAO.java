package datos;

import domain.Libro;
import java.util.*;
import java.util.stream.Collectors;

/* 1. Usamos LibroDAO para separar la capa de datos de la capa de logica de negocio
      Aqui colocaremos todos los servicios que nos brinda la clase Libro y aqui crearemos un Array dinamico para
      el almacenamiento de los libros que tiene la biblioteca (ya que no trabajaremos con bases
      de datos). 
      Si trabajasemos con bases de datos, creariamos una Interface LibroDAO y luego la implementariamos en LibroDAOImpl
 */
public class LibroDAO {

    //1. List que usaremos como base de datos para el sistema de Gestion y para el acceso a la data para este ejercicio
    List<Libro> libros = new ArrayList();

    //2. Constructor vacio por defecto
    public LibroDAO() {
    }

    //3. Metodo Getter para obtener la lista de libros de la biblioteca por orden de id
    public List<Libro> getLibros() {
        return libros;
    }

    //4. Metodo para agregar un libro ya existente en la biblioteca y que este disponible para la reserva
    public void agregarLibroBiblioteca(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado Exitosamente!");
        System.out.println("---------------------------");
    }

    //5. Metodo que permite ordenar alfabeticamente por Titulo a todos los libros y hacer una busqueda tipo Scroll
    public void busquedaAlfaPorTitulo(List<Libro> libros) {

        Comparator<Libro> comparador = Comparator.comparing(Libro::getTitulo);
        List<Libro> librosOrdenadosPorTitulo = libros.stream().sorted(comparador).collect(Collectors.toList());

        info(librosOrdenadosPorTitulo);
    }

    //6. Metodo que permite ordenar alfabeticamente por Genero a todos los libros y hacer una busqueda tipo Scroll
    public void busquedaAlfaPorGenero(List<Libro> libros) {
        Comparator<Libro> comparador = Comparator.comparing(Libro::getGenero);
        List<Libro> librosOrdenadosGenero = libros.stream().sorted(comparador).collect(Collectors.toList());

        info(librosOrdenadosGenero);
    }

    //7. Metodo que permite buscar por coincidencia de cadenas un Titulo (Ignorando mayusculas y minusculas).
    public void busquedaPorTitulo(List<Libro> libros, String titulo) {
        boolean band = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.info();
                System.out.println("Libro Encontrado con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el Libro. Verifique Titulo");
        }
        System.out.println("---------------------------");

    }

    //8. Metodo que permite buscar por coincidencia de cadenas un Genero (Ignorando mayusculas y minusculas).
    public void busquedaPorGenero(List<Libro> libros, String genero) {
        boolean band = false;
        int cont = 0;
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                libro.info();
                cont++;
                band = true;
            }
        }
        if (band == true) {
            System.out.println("La busqueda '" + genero + "' arrojó " + cont + " resultados.");
        }
        if (band != true) {
            System.out.println("No hay libros de este genero. Verifique Genero");
        }
    }

    //9. Metodo que permite buscar por coincidencia de cadenas un Apellido de Autor (Ignorando mayusculas y minusculas).
    public void busquedaPorApellidoAutor(List<Libro> libros, String apellido) {
        boolean band = false;
        int cont = 0;
        for (Libro libro : libros) {
            if (libro.getAutorApellido().equalsIgnoreCase(apellido)) {
                libro.info();
                cont++;
                band = true;
            }
        }
        if (band == true) {
            System.out.println("La busqueda '" + apellido + "' arrojó " + cont + " resultados.");
            System.out.println("Libro Encontrado con Exito!");
        }
        if (band != true) {
            System.out.println("No se encuentra el Libro. Verifique Titulo");
        }
        System.out.println("---------------------------");
    }
    
    //10. Metodo que permite buscar un libro por ID
    public int busquedaLibroID(long id) {
        int resu = 0;
        boolean band = false;
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getIdLibro() == id) {
                libro.info();
                System.out.println("Libro Encontrado con Exito!");
                resu = 1;
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el libro. Verifique ID");
        }
        System.out.println("---------------------------");
        return resu;
    }

    //11. Metodo que permite Eliminar un libro
    public void eliminarLibro(long id) {
        boolean band = false;
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getIdLibro() == id) {
                libros.remove(i);
                System.out.println("Libro eliminado con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el libro. Verifique ID");
        }

    }

    //12. Metodo que permite Actualizar un libro existente
    public void actualizarLibro(long id, String titulo, String genero, String editorial, int anio, String autorNombre, String autorApellido, String estado) {

        boolean band = false;
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getIdLibro() == id) {
                if (libro.getTitulo().equalsIgnoreCase(titulo) || titulo.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar el Titulo.");
                } else {
                    libro.setTitulo(titulo);
                    System.out.println("Se ha actualizado el Titulo");
                }

                if (libro.getGenero().equalsIgnoreCase(genero) || genero.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar el Genero");
                } else {
                    libro.setGenero(genero);
                    System.out.println("Se ha actualizado el Genero");
                }

                if (libro.getEditorial().equalsIgnoreCase(editorial) || editorial.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar la Editorial");
                } else {
                    libro.setEditorial(editorial);
                    System.out.println("Se ha actualizado la Editorial");
                }

                if (libro.getAnio() == anio || anio == 0) {
                    System.out.println("No se ha podido actualizar el Año");
                } else {
                    libro.setAnio(anio);
                    System.out.println("Se ha actualizado el Año");
                }

                if (libro.getAutorNombre().equalsIgnoreCase(autorNombre) || autorNombre.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar el Nombre del Autor");
                } else {
                    libro.setAutorNombre(autorNombre);
                    System.out.println("Se ha actualizado el Nombre del Autor");
                }

                if (libro.getAutorApellido().equalsIgnoreCase(autorApellido) || autorApellido.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar el Apellido del Autor");
                } else {
                    libro.setAutorApellido(autorApellido);
                    System.out.println("Se ha actualizado el Apellido del Autor");
                }
                System.out.println("---------------------------");
                libro.info();
                System.out.println("Libro Actualizado con Exito!");
                band = true;
            }
        }

        if (band != true) {
            System.out.println("No se encuentra el libro. Verifique ID");
        }

        System.out.println("---------------------------");
    }



    //13. Metodo que muestra por pantalla la cantidad de Libros que tiene la Biblioteca
    public void estadisticasLibros() {
        System.out.println("Stock de libros Actualmente: " + libros.size());
        System.out.println("------------------------------------------");
    }

    //14. Metodo que muestra la informacion pertinente a cada libro que este ingresado en la biblioteca
    public void info(List<Libro> libros) {
        for (int i = 0; i < libros.size(); i++) {
            System.out.println("id: " + libros.get(i).getIdLibro());
            System.out.println("Titulo: " + libros.get(i).getTitulo());
            System.out.println("Genero: " + libros.get(i).getGenero());
            System.out.println("Autor: " + libros.get(i).getAutorApellido() + ", " + libros.get(i).getAutorNombre());
            System.out.println("Año: " + libros.get(i).getAnio());
            System.out.println("Editorial: " + libros.get(i).getEditorial());
            System.out.println("Estado: " + libros.get(i).getEstado());
            System.out.println("---------------------------");
        }
    }

}
