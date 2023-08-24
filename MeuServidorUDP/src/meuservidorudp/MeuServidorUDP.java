package meuservidorudp;

import java.net.*;
import java.io.*;

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
             
                String message = new String(request.getData());
                System.out.println("-> " +  message);
                
                String[] dados = message.split(";");
                
                int tipo = Integer.parseInt(dados[0].trim());
                
                String resposta = "";
                
                switch (tipo){
                    case 1:
                        resposta = bd.retornaFilmeParaAvaliacao(dados[1].trim());
                        break;
                    case 2:
                        //int nota = Integer.parseInt(dados[3].trim());
                        resposta = bd.avaliarFilme(dados[1].trim(), dados[2].trim(), 2);
                        break;    
                    case 3:
                        System.out.println("OP3");
                        break;     
                    case 4:
                        System.out.println("OP4");
                        resposta = bd.le();
                        break;    
                    default:    
                        System.out.println("Err");
                }
                
                
                byte[] todasMsg = resposta.getBytes();
                DatagramPacket reply = new DatagramPacket(todasMsg, todasMsg.length, request.getAddress(), request.getPort());

                aSocket.send(reply);
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
