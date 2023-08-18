package meuservidorudp;

import java.util.LinkedList;

public class BaseDeDados {

    private LinkedList<Filme> lstFilmes;
    private LinkedList<Cliente> lstClientes;
    private LinkedList<LinkedList<Integer>> matriz = null;
    private static BaseDeDados instance = null;

    public static BaseDeDados getInstance() {
        if (instance == null) {
            instance = new BaseDeDados();
        }
        return instance;
    }

    public BaseDeDados() {
        lstFilmes = new LinkedList<>();
        lstClientes = new LinkedList<>();
        matriz = new LinkedList<>();
    }

    public void cadastrarDados() {
        adicionarCliente(new Cliente(1, "BRUNO"));
        adicionarCliente(new Cliente(2, "ANDRE"));
        
        adicionarFilme(new Filme("300 ESPARTA"));
        adicionarFilme(new Filme("AGENTE STONE"));
        adicionarFilme(new Filme("INTERESTELAR"));
        adicionarFilme(new Filme("OPPENHEIMER"));
        adicionarFilme(new Filme("SE7EN"));
    }

    
    public void adicionarCliente(Cliente cliente) {
        lstClientes.add(cliente);
        LinkedList<Integer> avaliacoes = new LinkedList<>();
        for (int i = 0; i < lstFilmes.size(); i++) {
            avaliacoes.add(0); // Inicializa com nota 0 para todos os filmes
        }
        matriz.add(avaliacoes);
    }

    public void adicionarFilme(Filme filme) {
        lstFilmes.add(filme);
        for (LinkedList<Integer> avaliacoes : matriz) {
            avaliacoes.add(0);
        }
    }
    
    public void imprimirMatrizAvaliacoes() {
        for (int i = 0; i < lstClientes.size(); i++) {
            Cliente cliente = lstClientes.get(i);
            System.out.println("Cliente: " + cliente.getNome());

            LinkedList<Integer> avaliacoesCliente = matriz.get(i);
            for (int j = 0; j < lstFilmes.size(); j++) {
                Filme filme = lstFilmes.get(j);
                int nota = avaliacoesCliente.get(j);
                System.out.println("    Filme: " + filme.getTitulo() + " | Nota: " + nota);
            }
            System.out.println();
        }
    }
       
    
    public void avaliarFilme(String nomeCliente, String tituloFilme, int nota) {
        int clienteIndex = -1;
        for (int i = 0; i < lstClientes.size(); i++) {
            if (lstClientes.get(i).getNome().equals(nomeCliente)) {
                clienteIndex = i;
                break;
            }
        }

        int filmeIndex = -1;
        for (int i = 0; i < lstFilmes.size(); i++) {
            if (lstFilmes.get(i).getTitulo().equals(tituloFilme)) {
                filmeIndex = i;
                break;
            }
        }

        if (clienteIndex != -1) {
            if (filmeIndex != -1){
                matriz.get(clienteIndex).set(filmeIndex, nota);
                lstFilmes.get(filmeIndex).setNota(nota);
            } else {
                System.out.println("Filme nao encontrado");
            }
            
        } else {
            System.out.println("Usuario nao encontrado");
        }
    }
       
    public LinkedList<Cliente> obterListaCliente() {
        return lstClientes;
    }
    
     public LinkedList<Filme> obterListaFilme() {
        return lstFilmes;
    }

    public int qntClientes() {
        return lstClientes.size();
    }

    public int qntFilmes() {
        return lstFilmes.size();
    }

    public void listarClientes() {
        for (int i = 0; i < qntClientes(); i++) {
            System.out.println(lstClientes.get(i).toString());
        }
    }

}
