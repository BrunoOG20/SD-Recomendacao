package meuservidorudp;

public class Filme {
    private String titulo;
    private int nota;

    public Filme(String titulo) {
        this.titulo = titulo;
        this.nota = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
