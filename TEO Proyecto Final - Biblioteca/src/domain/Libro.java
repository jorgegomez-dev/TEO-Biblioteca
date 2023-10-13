package domain;

public class Libro {
    private long idLibro;
    private String titulo;
    private String genero;
    private String editorial;
    private int anio;
    private String autorNombre;
    private String autorApellido;
    
    private String estado;
      
    public static long UltimoidLibro = 100001;
    public static long contadorLibros = 0;

    public Libro() {
        inicializarIdLibro();
    }

    public Libro(String titulo, String genero, String editorial, int anio, String autorNombre, String autorApellido, String estado) {
        this.titulo = titulo;
        this.genero = genero;
        this.editorial = editorial;
        this.anio = anio;
        this.autorNombre = autorNombre;
        this.autorApellido = autorApellido;
        this.estado = estado;
        inicializarIdLibro();
    }
    
    public void inicializarIdLibro(){
        idLibro = UltimoidLibro;
        UltimoidLibro++;
        contadorLibros++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }


    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getAutorApellido() {
        return autorApellido;
    }

    public void setAutorApellido(String autorApellido) {
        this.autorApellido = autorApellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getIdLibro() {
        return idLibro;
    }

    public static long getContadorLibros() {
        return contadorLibros;
    }  
    
    public void info(){
        System.out.println("Id: " + idLibro);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autorApellido + ", " + autorNombre);
        System.out.println("Año: " + anio);
        System.out.println("Genero: " + genero);
        System.out.println("Editorial: " + editorial);
        System.out.println("Estado: " + estado);
        System.out.println("---------------------------");
    }
    
}
