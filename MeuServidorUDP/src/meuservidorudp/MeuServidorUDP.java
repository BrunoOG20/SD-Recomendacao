package meuservidorudp;

import java.net.*;
import java.io.*;
import java.util.LinkedList;

public class MeuServidorUDP {
    private static BaseDeDados bd = null;

    public static void main(String[] args) {
        DatagramSocket aSocket = null;
        bd = BaseDeDados.getInstance();
        
        try {
            aSocket = new DatagramSocket(6789);
            bd.cadastrarDados();
            
            while(true) {
                
                byte[] buffer = new byte[600];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                
                LinkedList<Filme> listaFilmes = bd.obterListaFilme();
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(listaFilmes);
                oos.close();
                
                byte[] sendData = baos.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, request.getAddress(), request.getPort());
                aSocket.send(sendPacket);

                String message = new String(request.getData());
                System.out.println("-> " +  message);
                
                String[] dados = message.split(";");
                
                int tipo = Integer.parseInt(dados[0].trim());
                
                switch (tipo){
                    case 1:
                        int nota = Integer.parseInt(dados[3].trim());
                        bd.avaliarFilme(dados[1], dados[2], nota);
                        bd.imprimirMatrizAvaliacoes();
                        break;
                    case 2:
                        System.out.println("OP2");
                        break;    
                    case 3:
                        System.out.println("OP3");
                        break;     
                    case 4:
                        System.out.println("OP4");
                        break;    
                    default:    
                        System.out.println("Err");
                }
            }
        } catch(SocketException e) {
            System.out.println("SERVIDOR - Socket: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("SERVIDOR: Input Output: " + e.getMessage());
        } finally {
            if(aSocket != null) aSocket.close();
        }
    }
}
