package domain;

public class Reserva {

    private long idSocio;
    private long idLibro;
    private long idReserva;

    public static long UltimoidReserva = 101;
    public static long contadorReservas = 0;

    //1. No vamos a usar un constructor vacio, porque no queremos que se creen reservas sin idLibro ni idSocio.
    //   De esta manera, verificaremos que el Socio no tenga mas de 3 reservas realizadas y que el libro este
    //   disponible, antes de generar el idReserva.
    
    public Reserva(long idSocio, long idLibro) {
        this.idSocio = idSocio;
        this.idLibro = idLibro;
        inicializarIdReserva();
    }

    public void inicializarIdReserva() {
        idReserva = UltimoidReserva;
        UltimoidReserva++;
        contadorReservas++;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public long getIdSocio() {
        return idSocio;
    }

    public long getIdLibro() {
        return idLibro;
    }

    public static long getContadorReservas() {
        return contadorReservas;
    }
    
    public void info() {
        System.out.println("Reserva ID: " + idReserva);
        System.out.println("Libro ID: " + idLibro);
        System.out.println("Socio ID: " + idSocio);
        System.out.println("---------------------------");
    }

}
