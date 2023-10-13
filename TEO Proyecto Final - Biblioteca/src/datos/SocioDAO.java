package datos;

import domain.Socio;
import java.util.*;

/* 1. Usamos SocioDAO para separar la capa de datos de la capa de logica de negocio
      Aqui colocaremos todos los servicios que nos brinda la clase Socio y aqui crearemos un Array dinamico para
      el almacenamiento de los Socios que tiene la biblioteca (ya que no trabajaremos con bases
      de datos).
      Si trabajasemos con bases de datos, creariamos una Interface SocioDAO y luego la implementariamos en SocioDAOImpl
 */
public class SocioDAO {

    //1. List que usaremos como base de datos para el sistema de Gestion y para el acceso a la data para este ejercicio
    List<Socio> socios = new ArrayList();

    //2. Constructor vacio por defecto
    public SocioDAO() {
    }

    //3. Metodo Getter para obtener la lista de Socios de la biblioteca por orden de id
    public List<Socio> getSocios() {
        return socios;
    }

    //4. Metodo que permite Agregar un Socio de Biblioteca
    public void agregarSocioBiblioteca(Socio socio) {
        socios.add(socio);
        System.out.println("Socio agregado Exitosamente!");
        System.out.println("---------------------------");
    }

    //5. Metodo que permite buscar por coincidencia de cadenas un Apellido de Socio (Ignorando mayusculas y minusculas).
    public void busquedaPorApellidoSocio(String apellido) {
        boolean band = false;
        for (Socio socio : socios) {
            if (socio.getApellido().equalsIgnoreCase(apellido)) {
                socio.info();
                System.out.println("Socio Encontrado con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el Socio. Verifique Apellido");
        }
        System.out.println("---------------------------");
    }

    //6. Metodo que permite buscar un Socio por ID
    public int busquedaSocioID(long id) {
        int resu = 0;
        boolean band = false;
        for (int i = 0; i < socios.size(); i++) {
            Socio socio = socios.get(i);
            if (socio.getIdSocio() == id) {
                socio.info();
                System.out.println("Socio Encontrado con Exito!");
                resu = 1;
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el Socio. Verifique ID");
        }
        System.out.println("---------------------------");
        return resu;
    }

    //7. Metodo que permite buscar un Socio por DNI
    public void busquedaPorDNI(String dni) {
        boolean band = false;
        for (Socio socio : socios) {
            if (socio.getDni().equalsIgnoreCase(dni)) {
                socio.info();
                System.out.println("Socio Encontrado con Exito!");
                band = true;
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el Socio. Verifique DNI");
        }
        System.out.println("---------------------------");
    }

    //8. Metodo que Verifica que al cargarse un Socio no se encuentre repetido
    public int verificarExistencia(String nombre, String apellido, String dni) {
        int select = 0;
        boolean band = false;
        for (Socio socio : socios) {
            if (socio.getApellido().equalsIgnoreCase(apellido)) {
                if (socio.getNombre().equalsIgnoreCase(nombre)) {
                    if (socio.getDni().equalsIgnoreCase(dni)) {
                        socio.info();
                        System.out.println("El Socio ya se encuentra Registrado en base de Datos.");
                        System.out.println("Actualice los Datos del Socio desde el Menu.");
                        band = true;
                        select = 1;
                    }
                }
            }
        }

        if (band != true) {
            System.out.println("Socio ingresado correctamente!");
        }
        System.out.println("---------------------------");
        return select;
    }

    //9. Metodo que permite Actualizar un Socio Existente
    public void actualizarSocio(long id, String nombre, String apellido, String dni, long telefono, String dire) {

        boolean band = false;
        for (int i = 0; i < socios.size(); i++) {
            Socio socio = socios.get(i);
            if (socio.getIdSocio() == id) {
                if (socio.getNombre().equalsIgnoreCase(nombre) || nombre.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar el Nombre.");
                } else {
                    socio.setNombre(nombre);
                    System.out.println("Se ha actualizado el Nombre");
                }

                if (socio.getApellido().equalsIgnoreCase(apellido) || apellido.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar el Apellido");
                } else {
                    socio.setApellido(apellido);
                    System.out.println("Se ha actualizado el Apellido");
                }

                if (socio.getDni().equalsIgnoreCase(dni) || dni.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar la Editorial");
                } else {
                    socio.setDni(dni);
                    System.out.println("Se ha actualizado el DNI");
                }

                if (socio.getTelefono() == telefono || telefono == 0) {
                    System.out.println("No se ha podido actualizar el Telefono");
                } else {
                    socio.setTelefono(telefono);
                    System.out.println("Se ha actualizado el Telefono");
                }

                if (socio.getDireccion().equalsIgnoreCase(dire) || dire.equalsIgnoreCase("")) {
                    System.out.println("No se ha podido actualizar la Direccion");
                } else {
                    socio.setDireccion(dire);
                    System.out.println("Se ha actualizado la Direccion");
                }
                socio.info();
                System.out.println("Socio Actualizado con Exito!");
                band = true;
            }
        }

        if (band != true) {
            System.out.println("No se encuentra el Socio. Verifique ID");
        }
    }

    //10. Metodo que permite Eliminar un Socio
    public void eliminarSocio(long id) {
        boolean band = false;
        for (int i = 0; i < socios.size(); i++) {
            Socio socio = socios.get(i);
            if (socio.getIdSocio() == id) {
                System.out.println("Socio encontrado con Exito!");
                band = true;
                if (socio.getReservasDisponibles() < 3) {
                    System.out.println("El Socio " + socio.getApellido() + ", " + socio.getNombre()
                            + " iD(" + socio.getIdSocio() + ") "
                            + "NO puede eliminarse porque tiene reservas de libros activas.");
                    System.out.println("Para darse de baja, debe devolver los libros.");
                } else {
                    socio.info();
                    socios.remove(i);
                    System.out.println("Socio eliminado con Exito!");
                }
            }
        }
        if (band != true) {
            System.out.println("No se encuentra el Socio. Verifique ID");
        }

    }

    //11. Metodo que muestra por pantalla la cantidad de Socios Historicos y Activos que tiene la Biblioteca
    public void estadisticasSocios() {
        System.out.println("Cantidad de Socios Historicos: " + Socio.getContadorSocios());
        System.out.println("Socios Activos Actualmente: " + socios.size());
        System.out.println("------------------------------------------");
    }

    //14. Metodo que muestra la informacion pertinente a cada socio que este ingresado en la biblioteca
    public void info(List<Socio> socios) {
        for (int i = 0; i < socios.size(); i++) {
            System.out.println("id: " + socios.get(i).getIdSocio());
            System.out.println("Nombre: " + socios.get(i).getNombre());
            System.out.println("Apellido: " + socios.get(i).getApellido());
            System.out.println("DNI: " + socios.get(i).getDni());
            System.out.println("Telefono: " + socios.get(i).getTelefono());
            System.out.println("Direccion: " + socios.get(i).getDireccion());
            System.out.println("Reservas Disponibles: " + socios.get(i).getReservasDisponibles());
            System.out.println("---------------------------");
        }
    }

}
