package domain;

public class Socio {

    private long idSocio;
    private String nombre;
    private String apellido;
    private String dni;
    private long telefono;
    private String direccion;
    private boolean habilitado = true;
    private int reservasDisponibles = 3;

    public static long UltimoidSocio = 1001;
    public static long contadorSocios = 0;

    //1. No vamos a usar un constructor vacio, porque no queremos que se creen Socios sin los datos completos.
    //   Luego lo complementaremos con validaciones de datos para el ingreso de los campos. 

    public Socio(String nombre, String apellido, String dni, long telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.habilitado = true;
        this.reservasDisponibles = 3;
        inicializarIdSocio();
    }

    public void inicializarIdSocio() {
        idSocio = UltimoidSocio;
        UltimoidSocio++;
        contadorSocios++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
        

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getReservasDisponibles() {
        return reservasDisponibles;
    }

    public void setReservasDisponibles(int reservasDisponibles) {
        this.reservasDisponibles = reservasDisponibles;
    }

    public long getIdSocio() {
        return idSocio;
    }

    public static long getContadorSocios() {
        return contadorSocios;
    }
    
    public void info() {
        System.out.println("Id: " + idSocio);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: " + direccion);
        System.out.println("Reservas Disponibles: " + reservasDisponibles);
        System.out.println("---------------------------");
    }

}
