package datos;

import domain.Libro;
import domain.Reserva;
import domain.Socio;
import java.util.*;

/* 1. Usamos ReservaDAO para separar la capa de datos de la capa de logica de negocio
      Aqui colocaremos todos los servicios que nos brinda la clase Reserva.
      Si trabajasemos con bases de datos, creariamos una Interface ReservaDAO y luego la implementariamos en ReservDAOImpl 
 */
public class ReservaDAO {

    //1. List que usaremos como base de datos para el sistema de Gestion y para el acceso a la data para este ejercicio
    List<Reserva> reservas = new ArrayList();

    //2. Constructor vacio por defecto
    public ReservaDAO() {
    }

    //3. Metodo Getter para obtener la lista de Reservas de la biblioteca por orden de id
    public List<Reserva> getReservas() {
        return reservas;
    }

    //4. Metodo para generar una nueva reserva
    public void generarReserva(List<Socio> socios, List<Libro> libros, long idLibro, long idSocio) {
        boolean bandLibro = false;
        boolean bandSocioExist = false;
        boolean bandSocioHab = false;

        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getIdLibro() == idLibro) {
                System.out.println("Libro encontrado!");
                if (libro.getEstado().equalsIgnoreCase("Disponible")) {
                    System.out.println("Libro disponible para reserva!");
                    bandLibro = true;
                }
            }
        }

        for (int i = 0; i < socios.size(); i++) {
            Socio socio = socios.get(i);
            if (socio.getIdSocio() == idSocio) {
                System.out.println("Socio encontrado!");
                bandSocioExist = true;
                if (socio.getReservasDisponibles() > 0 && socio.getReservasDisponibles() <= 3) {
                    System.out.println("Socio habilitado para Reservar!");
                    bandSocioHab = true;
                }
            }
        }

        if (bandSocioExist == false) {
            System.out.println("Socio NO Encontrado. Verifique ID o Registrese.");
        }
        if (bandSocioHab == false) {
            System.out.println("Socio NO esta habilitado para Reservar! Ya tiene 3 reservas activas.");
        }

        if (bandLibro == false) {
            System.out.println("El libro NO esta disponible en este momento.");
        }

        if (bandLibro == true && bandSocioHab == true) {
            Reserva reserva = new Reserva(idSocio, idLibro);

            for (int i = 0; i < libros.size(); i++) {
                Libro libro = libros.get(i);
                if (libro.getIdLibro() == idLibro) {
                    libro.setEstado("Reservado");
                }
            }

            for (int i = 0; i < socios.size(); i++) {
                Socio socio = socios.get(i);
                if (socio.getIdSocio() == idSocio) {
                    int num = socio.getReservasDisponibles();
                    socio.setReservasDisponibles(num - 1);
                }
            }
            reservas.add(reserva);
            System.out.println("---------------------------");
            reserva.info();
            System.out.println("Reservado con Exito!");
        }
        System.out.println("---------------------------");

    }

    //5. Metodo para buscar una reserva por id
    public void busquedaReservaID(long id) {
        boolean band = false;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getIdReserva() == id) {
                reserva.info();
                System.out.println("Reserva Encontrada con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra la Reserva. Verifique ID o si ya se ha devuelto el libro.");
        }
        System.out.println("---------------------------");
    }

    //6. Metodo para buscar una reserva por id del Socio
    public void busquedaReservaIDSocio(long id) {
        boolean band = false;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getIdSocio() == id) {
                reserva.info();
                System.out.println("Reserva Encontrada con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra la Reserva. Verifique ID Socio o si ya se ha devuelto el libro.");
        }
        System.out.println("---------------------------");
    }

    //7. Metodo para buscar una reserva por id del Libro
    public void busquedaReservaIDLibro(long id) {
        boolean band = false;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getIdLibro() == id) {
                reserva.info();
                System.out.println("Reserva Encontrada con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra la Reserva. Verifique ID Libro o si ya se ha devuelto el libro.");
        }
        System.out.println("---------------------------");
    }

    //8. Metodo para eliminar Reserva y actualizar el estado del Socio y del Libro
    public void eliminarReserva(List<Socio> socios, List<Libro> libros, long idReserva, long idSocio, long idLibro) {
        //int select = 0;
        boolean band = false;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getIdReserva() == idReserva) {
                if (reserva.getIdSocio() == idSocio) {
                    if (reserva.getIdLibro() == idLibro) {
                        reservas.remove(i);
                        band = true;
                        //select = 1;
                    }
                }
            }
        }

        if (band != true) {
            System.out.println("La reserva no pudo ser Eliminada. Verifique IDs.");
        } else {
            System.out.println("Reserva eliminada con Exito!");
            for (int i = 0; i < libros.size(); i++) {
                Libro libro = libros.get(i);
                if (libro.getIdLibro() == idLibro) {
                    if (libro.getEstado().equalsIgnoreCase("Reservado")) {
                        System.out.println("Libro devuelto a la biblioteca!");
                    }
                }
            }

            for (int i = 0; i < socios.size(); i++) {
                Socio socio = socios.get(i);
                if (socio.getIdSocio() == idSocio) {
                    System.out.println("Reservas de Socio actualizadas!");
                    socio.setReservasDisponibles(socio.getReservasDisponibles() + 1);
                }
            }
        }

        System.out.println("---------------------------");
        //return select;
    }

    //9. Metodo que muestra por pantalla la cantidad de Reservas Historicas y la cantidad de Reservas activas
    public void estadisticasReservas() {
        System.out.println("Cantidad de Reservas Historicas: " + Reserva.getContadorReservas());
        System.out.println("Reservas Activas Actualmente: " + reservas.size());
        System.out.println("------------------------------------------");
    }

    //10. Metodo que muestra la informacion pertinente a cada reserva que este ingresado en la biblioteca
    public void info(List<Reserva> reservas) {
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println("Reserva ID: " + reservas.get(i).getIdReserva());
            System.out.println("Socio ID: " + reservas.get(i).getIdSocio());
            System.out.println("Libro ID: " + reservas.get(i).getIdLibro());
            System.out.println("---------------------------");
        }
    }
}
