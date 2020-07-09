package l179_189Colecciones.l179_183HashSet;

public class Libro {
    private String titulo, autor, ISBN;

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }


/* método equals anterior
    public boolean equals(Object obj) {
        if(this.getISBN().equals(((Libro)obj).getISBN())) return true;
        else return false;
    }*/

    // Generando el Hashcode y el equals con IDE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        return ISBN.equals(libro.ISBN);
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }
}
