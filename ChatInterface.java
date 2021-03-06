import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatInterface 
{
  static String serName  ="localhost";
  static int port = 9000;
  
  private static JFrame f;
  private static JTextArea prepiska;
  private static JButton bConnect, bSend;
  private static JTextField tfPoruka, tfHost, tfPort;
  
  static Socket sock;
  static DataOutputStream ostream;
  static DataInputStream istream;
  
  static boolean isConnected;
  /////////////////////////////////////////////////////////////////
  private static void frameSettings(JFrame f, int x,int y )
  {
    f = new JFrame("Chat Client");
    prepiska = new JTextArea();
    
    f.setSize(x,y);
    f.setLayout(null);
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    bConnect = new JButton("Connect");
    bConnect.setBounds(0,f.getHeight()-100,100,50);
    bConnect.addActionListener(taskConnector);
    
    
    bSend = new JButton("Send");
    bSend.setBounds(290,f.getHeight()-100, 100,50);
    bSend.addActionListener(taskPerformer);
    
    prepiska.setEditable(false);
    prepiska.setBounds(f.getWidth()/2,0,400,500);
        JScrollPane scroll = new JScrollPane(prepiska);
        scroll.setBounds(f.getWidth()/2,0,400,500);
    f.add(scroll);
    
    tfPoruka = new JTextField();
    tfPoruka.setVisible(true);
    tfPoruka.setBounds(scroll.getWidth(),scroll.getHeight()+5,400,50);
    
    JLabel lHost = new JLabel("Host");
    lHost.setBounds(5,5,50,25);
    JLabel lPort = new JLabel("Port");
    lPort.setBounds(5,60,50,25);
    
    tfHost = new JTextField();
    tfHost.setBounds(60,5,150,25);
    tfHost.setText("localhost");
    tfPort = new JTextField();
    tfPort.setBounds(60,60,150,25);
    tfPort.setText("9000");
    
    f.add(bConnect);
    f.add(bSend);
    f.add(tfPoruka);    
    f.add(lHost);  
    f.add(lPort);
    f.add(tfHost);   
    f.add(tfPort);
    
    f.setVisible(true);
  }
  /////////////////////////////////////////////////////////////////////////////////////
  
  public static ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        String msgout="";
        try {
            msgout=tfPoruka.getText().trim();
            prepiska.append("\n Client: " + msgout);
            ostream.writeUTF("Client: "+msgout);
            tfPoruka.setText("");
        } catch (Exception e) {
        }             
        }
    };
  
  
  public static ActionListener taskConnector = new ActionListener() {
        public void actionPerformed(ActionEvent ev)
        {
            isConnected = true;
        }
        
    };
  
  
  public static void main(String args[]) throws Exception
  {
    
   /* Socket sock;
    sock = new Socket("127.0.0.1",3030);
       
    ostream = sock.getOutputStream(); 
    pwrite = new PrintWriter(ostream, true);
     
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
    
    String receiveMessage, sendMessage;*/
    String msgin ="";
    
        frameSettings(f,800,600+5);    
        try{
    /*sock=new Socket("localhost", 9000);
    istream=new DataInputStream(sock.getInputStream());
    ostream=new DataOutputStream(sock.getOutputStream());*/
          
            while(!msgin.equals("exit")){
            if(isConnected){
              sock=new Socket("localhost", 9000);
              istream=new DataInputStream(sock.getInputStream());
              ostream=new DataOutputStream(sock.getOutputStream());
              msgin=istream.readUTF();
              prepiska.setText(prepiska.getText().trim()+"\n"+msgin);
            }
          }
    
        }
        catch(Exception e){}
   
    
   

  }
}
