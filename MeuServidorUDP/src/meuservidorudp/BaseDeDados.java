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
        adicionarCliente(new Cliente(1, "KDU"));
        
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

    public String listaDeFilmes(String nomeCliente) {
        String s = "\n";
        int clienteIndex = buscarClientePorNome(nomeCliente);

        Cliente cliente = lstClientes.get(clienteIndex);
        System.out.println("Cliente: " + cliente.getNome());

        LinkedList<Integer> avaliacoesCliente = matriz.get(clienteIndex);
        for (int j = 0; j < lstFilmes.size(); j++) {
            Filme filme = lstFilmes.get(j);
            int nota = avaliacoesCliente.get(j);
            s = s + filme.getTitulo() + " | Nota: " + nota + " " + "\n";
        }
          
        return s;
    }
    
    public double calcularDistancia(LinkedList<LinkedList<Integer>> matriz, int linhaUsuario, int colunaFilme) {
        double distancia = 0;

        for (int i = 0; i < matriz.size(); i++) {
            if (i != linhaUsuario && matriz.get(i).get(colunaFilme) != 0) {
                double diferenca = matriz.get(linhaUsuario).get(colunaFilme) - matriz.get(i).get(colunaFilme);
                distancia += diferenca * diferenca;
            }
        }
        return Math.sqrt(distancia);
    }
    
    public String recomendarFilme(String nome) {
        int linhaUsuario = buscarClientePorNome(nome);
        double menorDistancia = Double.MAX_VALUE;
        LinkedList<Integer> filmesRecomendados = new LinkedList<>();

        for (int coluna = 0; coluna < qntFilmes(); coluna++) {
            if (matriz.get(linhaUsuario).get(coluna) == 0) {
                double distancia = calcularDistancia(matriz, linhaUsuario, coluna);
                System.out.println("Filme: " + lstFilmes.get(coluna).getTitulo() + ", Distância: " + distancia);
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    filmesRecomendados.add(coluna);
                } else if (distancia == menorDistancia) {
                    filmesRecomendados.add(coluna);
                }
            }
        }

        if (!filmesRecomendados.isEmpty()) {
            StringBuilder recomendacoes = new StringBuilder();
            recomendacoes.append("Filme recomendado: \n");
            recomendacoes.append(lstFilmes.get(filmesRecomendados.get(0)).getTitulo());
          
            System.out.println("\n+-------------------------------------------------------------+");
            System.out.println(recomendacoes.toString());
            return recomendacoes.toString();
        } else {
            System.out.println("\n+-------------------------------------------------------------+");
            return "Nao ha filmes para recomendar!";
        }
    }

}
