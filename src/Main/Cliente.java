
package Main;

import Interface.Inicial;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.Random;


/**
 *
 * @author Wz
 */
public class Cliente {
    private int id, porta, sucessorIdProcurado, idSuc, idAnt;
    private byte ip[], ipSuc[] = new byte[4], ipAnt[] = new byte[4], sucessorIpProcurado[] = new byte[4];
    private String ipServidor;      
    Inicial tela;
    
    public Cliente(Inicial tela) {
        geraID();
        setarIP();
        idSuc = idAnt = id;
        porta = 12345;
        this.tela = tela;
    }
    
    private void geraID() {
        id = Math.abs(new Random().nextInt());
    }

    private byte[] retornaIPLocal(){//Função para devolver o IP do usuário
        int a = 0;
        byte i[] = {0,0,0,0};
        InetAddress ip = null;
        String ipAddress = null;       
        Enumeration<NetworkInterface> net = null;
        try {
            net = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        while(net.hasMoreElements()){
            if (a == 1) break;//'a' limita a ocorrência do Loop
            NetworkInterface element = net.nextElement();
            Enumeration<InetAddress> addresses = element.getInetAddresses();
            while (addresses.hasMoreElements()){
                ip = addresses.nextElement();
                if (ip instanceof Inet4Address){//Verifica se é IPv4
                    i = ip.getAddress();
                    if (i[0] != (byte) 127){//Verifica se o IP adquirido é o IP local (127.0.0.1), se for atribuímos 1 para 'a', para "mostrar" ao loop que chegamos ao IP desejado

                        a = 1;
                        break;
                    }
                }
            }
        }

        return i;
    }
    
    private void setarIP() {
        
        try {
            ip = retornaIPLocal();
            ipSuc = retornaIPLocal();
            ipAnt = retornaIPLocal();
        } catch(Exception e) {
            
            tela.setjLAvisos("IP não encontrado!");
        }
        
    }     
     
    public static byte[] intToBytes(int i) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(i);
        return bb.array();
    }
    public static int bytesToInt(byte[] b) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (b[i] & 0x000000FF) << shift;
        }
        return value;
    }

    public void lookup(int idProcurado) {
        try {
            
            ByteBuffer mensagem = ByteBuffer.allocate(13);
            byte codigo[] = {(byte) 2};
            mensagem.put(codigo);
            mensagem.put(intToBytes(id));
            mensagem.put(ip);
            mensagem.put(intToBytes(idProcurado));           
                       
           
            Socket TCPSocket = new Socket(ipServidor, porta);                       
            DataOutputStream out = new DataOutputStream(TCPSocket.getOutputStream());
            out.writeInt(mensagem.array().length);
            out.write(mensagem.array());
            
        } catch (UnknownHostException e) {            
            tela.setjLAvisos("Endereço IP inválido, digite novamente!");
            
        } catch (IOException e) {
	             
            tela.setjLAvisos("Endereço IP inválido, digite novamente!");
            
        }
    }    
    
    public void join() {
        try {
            //montar mensagem
            ByteBuffer mensagem = ByteBuffer.allocate(5);
            byte codigo[] = {0};//codigo da mensagem: 0 - join
            mensagem.put(codigo);
            mensagem.put(intToBytes(id));           
                      
            Socket TCPSocket = new Socket(ipServidor, porta);
            DataOutputStream out = new DataOutputStream(TCPSocket.getOutputStream());
            out.writeInt(mensagem.array().length); // write length of the message
            out.write(mensagem.array());
        } catch (UnknownHostException e) {
                      tela.setjLAvisos("Servidor desconhecido. Digite um ip válido.");
        } catch (IOException e) {   
            tela.setjLAvisos("Endereço IP inválido, digite novamente!");
       }
    }
    
    public void update() {
        try {
            //monta mensagem
            ByteBuffer mensagem = ByteBuffer.allocate(13);
            byte codigo[] = {(byte) 3};//codigo da mensagem: 3 - update
            mensagem.put(codigo);
            mensagem.put(intToBytes(id));//id de origem da mensagem
            mensagem.put(intToBytes(id));// id do novo sucessor
            mensagem.put(ip);//ip do novo sucessor
            
            //atualiza ipServidor para antecessor que será atualizado
            setIPServidor(getIpAntString());
            
            //ip do destino da mensagem
         
            
            Socket TCPSocket = new Socket(ipServidor, porta);
            
            
            //Envia mensagem
         
            DataOutputStream out = new DataOutputStream(TCPSocket.getOutputStream());
            out.writeInt(mensagem.array().length);//Escreve tamanho da mensagem
            out.write(mensagem.array());
            
            
            
        } catch (UnknownHostException e) {
            tela.setjLAvisos("Servidor desconhecido. Digite um ip válido.");
        } catch (IOException e) {
	    //Exibe mensagem de erro
            
            tela.setjLAvisos(e.getMessage());
        }
    }
    
    public void leave() {
       try {
            ByteBuffer mensagem = ByteBuffer.allocate(21);
            byte codigo[] = {1};
            mensagem.put(codigo);
            mensagem.put(intToBytes(id));
            mensagem.put(intToBytes(idSuc));
            mensagem.put(ipSuc);
            mensagem.put(intToBytes(idAnt));
            mensagem.put(ipAnt);       

            setIPServidor(getIpSucString());
            
            Socket TCPSocket = new Socket(ipServidor, porta);            
            DataOutputStream out = new DataOutputStream(TCPSocket.getOutputStream());
            out.writeInt(mensagem.array().length);
            out.write(mensagem.array());
            
            setIPServidor(getIpAntString());
            Socket TCPSocket2 = new Socket(ipServidor, porta);
            DataOutputStream out2 = new DataOutputStream(TCPSocket2.getOutputStream());
            out2.writeInt(mensagem.array().length);
            out2.write(mensagem.array());          

        } catch (UnknownHostException e) {
            
            tela.setjLAvisos("Endereço IP inválido, digite novamente!");
        } catch (IOException e) {           
            tela.setjLAvisos("Endereço IP inválido, digite novamente!");
        }
    }    

    public void setIPServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }
    public String getIPServidor() {
        return this.ipServidor;
    }
    
    public int getIdSuc() {
        return idSuc;
    }
    public void setIdSuc(int idSuc) {
        this.idSuc = idSuc;
    }
    
    public String getIpSucString() {
        int i;
        int aux;
        String resposta = "";
        for(i = 0; i < 4; i++) {
            aux = ipSuc[i];
            if(aux < 0) aux += 256;
            resposta += aux + "";
            if(i < 3) resposta += ".";
        }
        return resposta;
    }
    public byte[] getIpSuc() {
        return ipSuc;
    }
    public void setIpSuc(byte[] ipSuc) {
        this.ipSuc = ipSuc;
    }
    
    public String getSucIpProcuradoString() {
        int i;
        int aux;
        String resposta = "";
        for(i = 0; i < 4; i++) {
            aux = sucessorIpProcurado[i];
            if(aux < 0) aux += 256;
            resposta += aux + "";
            if(i < 3) resposta += ".";
        }
        return resposta;
    }
    public byte[] getSucessosrIpProcurado() {
        return sucessorIpProcurado;
    }
    
    public void setSucIpProcurado(byte[] sucessorIpProcurado) {
        this.sucessorIpProcurado = sucessorIpProcurado;
    }    
    public int getSucIdProcurado() {
        return sucessorIdProcurado;
    }
    
    public void setSucIdProcurado(int sucessorIdProcurado) {
        this.sucessorIdProcurado = sucessorIdProcurado;
    }
  
    public int getIdAnt() {
        return idAnt;
    }    
    public void setIdAnt(int idAnt) {
        this.idAnt = idAnt;
    }
    
    public String getIpAntString() {
        int i;
        int aux;
        String resposta = "";
        for(i = 0; i < 4; i++) {
            aux = ipAnt[i];
            if(aux < 0) aux += 256;
            resposta += aux + "";
            if(i < 3) resposta += ".";
        }
        return resposta;
    }
    public byte[] getIpAnt() {
        return ipAnt;
    }    
    public void setIpAnt(byte[] ipAnt) {
        this.ipAnt = ipAnt;
    }
    
    public int getId() {
        return id;
    }
    
    public String getIPString() {
        int i;
        int aux;
        String resposta = "";
        for(i = 0; i < 4; i++) {
            aux = ip[i];
            if(aux < 0) aux += 256;
            resposta += aux + "";
            if(i < 3) resposta += ".";
        }
        return resposta;
    }
    public byte[] getIp() {
        return ip;
    }
    public void setIp(byte ip[]) {
        this.ip = ip;
    }
    
    public int getPortaServidor() {
        return this.porta;
    }
    public void setPortaServidor(int porta) {
        this.porta = porta;
    }
}

