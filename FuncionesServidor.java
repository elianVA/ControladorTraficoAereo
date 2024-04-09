import java.io.*;
import java.util.Scanner;
import java.net.*;
import javax.swing.JOptionPane;

public class FuncionesServidor {
    private static final String HOST = "locathost";
    private static final int PUERTO = 5000;
    
    private ServerSocket servidor;
    private Socket cliente;
    
    private DataOutputStream salida;
    private DataInputStream entrada;
    
    private String mensajeRecibido = "";
    
    public void iniciarServidor()
    {       
        Scanner lectura = new Scanner(System.in);
        
        try
        {
            servidor = new ServerSocket(PUERTO);
            cliente = new Socket();
            
            System.out.println("Esperando conexion...");
            
            cliente = servidor.accept();
            
            System.out.println("Se conecto un cliente");
            
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            
            String mensajeAEnviar = "";
            
            while (!mensajeAEnviar.equals("SALIR") )
            {
                mensajeRecibido = entrada.readUTF();
                if(vocabularioInadecuado(mensajeRecibido))
                {
                    mensajeAEnviar = "Por favor no utilice lenguaje inapropiado";
                    salida.writeUTF(mensajeAEnviar);
                }
                System.out.println("Mensaje del cliente: " + mensajeRecibido);
                System.out.println("");
                if (mensajeRecibido.equals("Hola"))
                {
                    mensajeAEnviar = "Hola";
                    salida.writeUTF(mensajeAEnviar);
                }
                else
                {
                    System.out.println("Digite una respuesta para el cliente: ");
                    mensajeAEnviar = lectura.nextLine();
                    salida.writeUTF(mensajeAEnviar);
                }
            }
            
        }
        catch(IOException error)
        {
            JOptionPane.showMessageDialog(null, "Se produjo un error" + error.getMessage());
        }
    }
    
    private boolean vocabularioInadecuado(String mensajeCliente)
    {
        if(mensajeCliente.contains("tonto"))
        {
            return true;
        }else
        {
            return false;
        }
        
    }  
}
