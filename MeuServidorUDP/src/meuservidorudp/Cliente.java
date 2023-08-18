package meuservidorudp;

import java.util.LinkedList;

public class Cliente {
    private int id;
    private String nome;
    private LinkedList<Filme> lstFilme;
    
    public Cliente(int id, String nome ) {
        this.nome = nome;
        this.id = id;
        this.lstFilme = new LinkedList<Filme>();
    }

    public String getNome() {
        return nome;
    }
    
     public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinkedList<Filme> getLstFilme() {
        return lstFilme;
    }

    public void setLstFilme(LinkedList<Filme> lstFilme) {
        this.lstFilme = lstFilme;
    }
    
    public int qntFilme(){
        return lstFilme.size();
    }
    
    public void adicionarFilme(Filme filme) {
        lstFilme.add(filme);
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
