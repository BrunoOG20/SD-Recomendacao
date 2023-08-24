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

    public String avaliarFilme(String nomeCliente, String tituloFilme, int nota) {
        int clienteIndex = buscarClientePorNome(nomeCliente);
        int filmeIndex = buscaFilmePorTitulo(tituloFilme);
        String s;

        if (clienteIndex != -1) {
            if (filmeIndex != -1) {
                matriz.get(clienteIndex).set(filmeIndex, nota);
                lstFilmes.get(filmeIndex).setNota(nota);
                s = "Filme avaliado";
            } else {
                s = "Filme nao encontrado";
                System.out.println("Filme nao encontrado");
            }
        } else {
            s = "Usuario nao encontrado";
            System.out.println("Usuario nao encontrado");
        }
        
        return s;
    }

    public String retornaFilmeParaAvaliacao(String nomeCliente) {
        int clienteIndex = buscarClientePorNome(nomeCliente);
        String s = "";
        LinkedList<Filme> fimesNaoAvaliados = new LinkedList();
        
        
        if (clienteIndex != -1){
            LinkedList<Integer> avaliacoesUsuario = matriz.get(clienteIndex);

            for (int i = 0; i < avaliacoesUsuario.size(); i++) {
                if (avaliacoesUsuario.get(i) == 0) {
                    fimesNaoAvaliados.add(lstFilmes.get(i));
                }
            }
            
            if (fimesNaoAvaliados.isEmpty()){
                s = "Todos os filmes ja foram avaliados";
                return s;
            
            } else {
                s = fimesNaoAvaliados.get(0).getTitulo();
                System.out.println(s);
            }
            
        } else {
            System.out.println("Erro ");
        }
        
        return s;
    }

    public int buscarClientePorNome(String nomeCliente) {
        int clienteIndex = -1;
        for (int i = 0; i < lstClientes.size(); i++) {
            if (lstClientes.get(i).getNome().equals(nomeCliente)) {
                clienteIndex = i;
                break;
            }
        }
        return clienteIndex;
    }

    public int buscaFilmePorTitulo(String tituloFilme) {
        int filmeIndex = -1;
        for (int i = 0; i < lstFilmes.size(); i++) {
            if (lstFilmes.get(i).getTitulo().equals(tituloFilme)) {
                filmeIndex = i;
                break;
            }
        }
        return filmeIndex;
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

    public String le() {
        String s = "\n";

        for (int pos = 0; pos < qntFilmes(); pos++) {
            s = s + lstFilmes.get(pos).getTitulo() + " | Nota: " + lstFilmes.get(pos).getNota() + " " + "\n";
        }

        return s;
    }

}
