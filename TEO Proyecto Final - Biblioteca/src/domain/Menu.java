package domain;


/* 1. Usamos la clase Menu, para generar los metodos de Menu que luego llamaremos desde el main
*/

public class Menu {

    public Menu() {
    }

    public void msjElijaOpcion() {
        System.out.println("");
        System.out.println("Elija una opcion del menu para continuar...");
    }

    public void menuPrincipal() {
        System.out.println("");
        System.out.println("************* MENU PRINCIPAL *************");
        System.out.println("");
        System.out.println("1. GESTION de LIBROS");
        System.out.println("2. GESTION de SOCIOS");
        System.out.println("3. GESTION de RESERVAS");
        System.out.println("4. ESTADISTICAS");
        System.out.println("0. Salir");
        System.out.println("------------------------------------------");
    }

    public void menuLibros() {
        System.out.println("");
        System.out.println("*********** GESTION de LIBROS ***********");
        System.out.println("");
        System.out.println("1. Ver Lista Completa de Libros Ordenada por ID");
        System.out.println("2. Ver Lista Completa de Libros Ordenada por Titulo");
        System.out.println("3. Ver Lista Completa de Libros Ordenada por Genero");
        System.out.println("4. BUSCAR un libro por ID");
        System.out.println("5. BUSCAR un libro por Titulo");
        System.out.println("6. BUSCAR un libro por Autor (Apellido)");
        System.out.println("7. BUSCAR todos los libros de un Genero");
        System.out.println("8. Cargar nuevo Libro en la Base de Datos");
        System.out.println("9. Actualizar Libro (ID Requerido) en la Base de Datos");
        System.out.println("10. Eliminar un libro (ID Requerido) de la base de datos.");
        System.out.println("0. Volver al MENU PRINCIPAL");
        System.out.println("------------------------------------------");
    }

    public void menuSocios() {
        System.out.println("");
        System.out.println("*********** GESTION de SOCIOS ***********");
        System.out.println("");
        System.out.println("1. Ver Lista Completa de Socios ordenada por ID");
        System.out.println("2. BUSCAR un Socio por ID");
        System.out.println("3. BUSCAR un Socio por Apellido");
        System.out.println("4. BUSCAR un Socio por DNI");
        System.out.println("5. Cargar nuevo Socio en la Base de Datos");
        System.out.println("6. Actualizar un Socio (ID Requerido) en la Base de Datos");
        System.out.println("7. Eliminar un Socio (ID Requerido) de la base de datos.");
        System.out.println("0. Volver al MENU PRINCIPAL");
        System.out.println("------------------------------------------");
    }

    public void menuReservas() {
        System.out.println("");
        System.out.println("*********** GESTION de RESERVAS ***********");
        System.out.println("");
        System.out.println("1. Generar nueva Reserva");
        System.out.println("2. BUSCAR una Reserva por ID de Reserva");
        System.out.println("3. BUSCAR una Reserva por ID de Socio");
        System.out.println("4. BUSCAR una Reserva por ID de Libro");
        System.out.println("5. Eliminar Reserva");
        System.out.println("6. Ver Lista de Reservas Activas");
        System.out.println("0. Volver al MENU PRINCIPAL");
        System.out.println("------------------------------------------");
    }

}
