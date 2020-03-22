package Main;


import Interface.Inicial;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

/**
 *
 * @author Wz
 */
public class Servidor extends Thread {
   
    ServerSocket ss;
    Socket TCPSocket;
    Cliente cliente;
    Inicial tela;
    ByteBuffer mensagem;
    Integer porta = 12345;
    public Servidor(Inicial tela, Cliente cliente) {
        this.tela = tela;        
        this.cliente = cliente;
    }    
    
    public void run() {
        try {

            ss = new ServerSocket(porta);  
            byte mensagemRecebida[] = new byte[256];              
            
            int codigoOperacao;            
            while (true) {
                TCPSocket = ss.accept();
                DataInputStream dis = new DataInputStream(TCPSocket.getInputStream());
                mensagem = ByteBuffer.allocate(256);
                
                int len = dis.readInt();                
                byte[] data = new byte[len];
                if (len > 0) {
                dis.readFully(data);
                }
                ByteArrayInputStream bin = new ByteArrayInputStream(data);
                bin.read(mensagemRecebida);
                mensagem.put(mensagemRecebida);
                mensagem.position(0);
                
                
                codigoOperacao = mensagem.get();
                if(codigoOperacao < 0) codigoOperacao += 256;
                                                             
                switch(codigoOperacao) {
                    case 0:
                        recebeJoin();
                        break;
                    case 1:
                        recebeLeave();
                        break;
                    case 2:
                        recebeLookup();
                        break;
                    case 3:
                        recebeUpdate();
                        break;
                    case 128:
                        recebeRespostaJoin();
                        break;
                    case 129:
                        recebeRespostaLeave();
                        break;
                    case 130:
                        recebeRespostaLookup();
                        break;
                    case 131:
                        recebeRespostaUpdate();
                        break;
                    default:
                        try {
                            throw new Exception("Operação incorreta.");
                        } catch (Exception e) {

                            
                            tela.setjLAvisos(e.getMessage());
                            
                        }
                }
            }
        } catch (IOException e) {	               
            tela.setjLAvisos(e.getMessage());
        }
    }
    
    public void recebeLookup() throws IOException {
        int idOrigemProcura = mensagem.getInt();
        byte ipOrigemProcura[] = new byte[4];
        mensagem = mensagem.get(ipOrigemProcura, 0, 4);
        int idProcurado = mensagem.getInt();        
        
        if(cliente.getId() >= idProcurado && cliente.getIdAnt() < idProcurado) {

            ByteBuffer resposta = ByteBuffer.allocate(13);
            resposta.put((byte)130);
            resposta.putInt(idProcurado);
            resposta.putInt(cliente.getId());
            resposta.put(cliente.getIp());            
           
            enviarTCP(resposta, ipOrigemProcura);
        }
        else if(cliente.getId() == cliente.getIdAnt()) {
            
            ByteBuffer resposta = ByteBuffer.allocate(13);
            resposta.put((byte)130);
            resposta.putInt(idProcurado);
            resposta.putInt(cliente.getId());
            resposta.put(cliente.getIp());            
                   
            enviarTCP(resposta, ipOrigemProcura);
            
        }
        else if(cliente.getId() >= idProcurado && cliente.getId() < cliente.getIdAnt()&& cliente.getId() < cliente.getIdSuc()) {
            
            ByteBuffer resposta = ByteBuffer.allocate(13);
            resposta.put((byte)130);
            resposta.putInt(idProcurado);
            resposta.putInt(cliente.getId());
            resposta.put(cliente.getIp());            
                    
            enviarTCP(resposta, ipOrigemProcura);
        }
        else if(cliente.getIdAnt() < idProcurado && cliente.getId() < cliente.getIdSuc() && cliente.getId() < cliente.getIdAnt()) {
            
            
            ByteBuffer resposta = ByteBuffer.allocate(13);
            resposta.put((byte)130);
            resposta.putInt(idProcurado);
            resposta.putInt(cliente.getId());
            resposta.put(cliente.getIp());            
            
            enviarTCP(resposta, ipOrigemProcura);
        }
        else {            
            
            ByteBuffer resposta = ByteBuffer.allocate(13);
            resposta.put((byte)2);
            resposta.putInt(idOrigemProcura);
            resposta.put(ipOrigemProcura);
            resposta.putInt(idProcurado);            
                      
            enviarTCP(resposta, cliente.getIpSuc());
        }
        
        
        tela.setjLAvisos("O Id " + idOrigemProcura + " buscou por " + idProcurado + ".");
    }
    public void recebeJoin() throws IOException {
        try {
            
            int idNovoNo = mensagem.getInt();            
            if(idNovoNo == cliente.getId()) throw new Exception("Id ja existe");           
            ByteBuffer resposta = ByteBuffer.allocate(17);
            resposta.put((byte)128);

            resposta.putInt(cliente.getId());
            resposta.put(cliente.getIp());
            resposta.putInt(cliente.getIdAnt());
            resposta.put(cliente.getIpAnt());
            
                     
            Socket enviar =  new Socket(TCPSocket.getInetAddress(), porta);
            DataOutputStream out = new DataOutputStream(enviar.getOutputStream());
            out.writeInt(resposta.array().length); 
            out.write(resposta.array());
            
            cliente.setIdAnt(idNovoNo);
            cliente.setIpAnt(TCPSocket.getInetAddress().getAddress());
            
            tela.Att();
            tela.setjLAvisos("O Id " + idNovoNo + " entrou na rede.");
            
        } catch (Exception e) {          
            tela.setjLAvisos("A tentativa de conexão falhou!");
          }
    }
    public void recebeUpdate() throws IOException {
        try {
            
            mensagem.getInt();
            cliente.setIdSuc(mensagem.getInt());
            byte aux[] = new byte[4];
            mensagem = mensagem.get(aux, 0, 4);
            cliente.setIpSuc(aux);
            
            tela.Att();            
            tela.setjBSair(true);

            ByteBuffer resposta = ByteBuffer.allocate(5);
            resposta.put((byte)131);// codigo resposta
            resposta.put(Cliente.intToBytes(cliente.getId()));

            Socket enviar = new Socket(TCPSocket.getInetAddress(), porta);            
            DataOutputStream out = new DataOutputStream(enviar.getOutputStream());
            out.writeInt(resposta.array().length);
            out.write(resposta.array());
            
        } catch (IOException e) {
            tela.setjLAvisos("A atualização dos nós falhou!");
            
        }
    }
    public void recebeLeave() throws IOException {
        int idNoSaindo = mensagem.getInt();
 
        byte aux[] = new byte[4];
        
        if(cliente.getIdAnt() == idNoSaindo) {            
            mensagem.getInt();
            mensagem.getInt();
            cliente.setIdAnt(mensagem.getInt());
            mensagem = mensagem.get(aux, 0, 4);
            cliente.setIpAnt(aux);
        }
        else {           
            cliente.setIdSuc(mensagem.getInt());
            mensagem = mensagem.get(aux, 0, 4);
            cliente.setIpSuc(aux);
            mensagem.getInt();
            mensagem.getInt();
        }
        
        tela.Att();
                
        if(cliente.getIPString().compareTo(cliente.getIpAntString()) == 0)
            tela.setjBSair(false);

       
        ByteBuffer resposta = ByteBuffer.allocate(5);
        resposta.put((byte)129);
        resposta.putInt(cliente.getId());
        
              
        Socket enviar =  new Socket(TCPSocket.getInetAddress(), porta);
        DataOutputStream out = new DataOutputStream(enviar.getOutputStream());
        out.writeInt(resposta.array().length); // Escreve o tamanho da mensagemRecebida
        out.write(resposta.array());
        
        
        tela.setjLAvisos("O Id " + idNoSaindo + " saiu da rede.");
        
    }
    

    public void recebeRespostaLookup() {
        try{
            byte aux[] = new byte[4];
            int idProcurado = mensagem.getInt();//descarta id procurado
            cliente.setSucIdProcurado(mensagem.getInt());//atualiza id do sucessor do procurado
            mensagem = mensagem.get(aux, 0, 4);
            cliente.setSucIpProcurado(aux);//atualiza ip do sucessor do procurado
            
            if(idProcurado == cliente.getId() && cliente.getId() == cliente.getIdAnt())
                tela.setjBConectar(true);
            else
                tela.setjBConectar(false);       
            
            tela.setjLAvisos("Encontrado! IP: " + cliente.getSucIpProcuradoString() + " Id: " + cliente.getSucIdProcurado());
        }catch(Exception e){

            
            tela.setjLAvisos(e.getMessage());
            
        }
    }
    public void recebeRespostaJoin() {
        try {

            byte aux[] = new byte[4];
            byte aux2[] = new byte[4];

            cliente.setIdSuc(mensagem.getInt());
            mensagem = mensagem.get(aux, 0, 4);
            cliente.setIpSuc(aux);
            cliente.setIdAnt(mensagem.getInt());
            mensagem = mensagem.get(aux2, 0, 4);
            cliente.setIpAnt(aux2);            
            tela.Att();

            tela.setjBIdentificar(false);
            tela.setjBConectar(false);
            tela.setjLAvisos("Conectado a rede!");
        } catch(Exception e) {
            
            tela.setjLAvisos(e.getMessage());
            
        }
    }
    public void recebeRespostaUpdate() {
        try {
            int idOrigem = mensagem.getInt();            
            tela.setjBIdentificar(true);
            tela.setjBSair(true);            
            
            tela.setjLAvisos("Atualização dos nós concluída!");
        } catch(Exception e) {            
            tela.setjLAvisos("Erro na atualização dos nós");
            
        }
    }
    public void recebeRespostaLeave() {
        mensagem.getInt();
        
        cliente.setIdSuc(cliente.getId());
        cliente.setIdAnt(cliente.getId());
        cliente.setIpSuc(cliente.getIp());
        cliente.setIpAnt(cliente.getIp());
        
        //atualiza campos da interface
        tela.Att();
        tela.setjLAvisos("Você saiu da rede!");
        
        //atualiza botões da interface
        tela.setjBIdentificar(true);
        tela.setjBSair(false);  

    }
    
    public int getPortaServidor() {
        return this.porta;
    }
    public void setPortaServidor(int porta) {
        this.porta = porta;
    }
    
    public void enviarTCP(ByteBuffer resposta, byte[] IP) throws IOException{
        Socket enviar =  new Socket(InetAddress.getByAddress(IP), porta);
          DataOutputStream out = new DataOutputStream(enviar.getOutputStream());
          out.writeInt(resposta.array().length); 
          out.write(resposta.array());
    }

}
