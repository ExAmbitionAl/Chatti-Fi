import javax.swing.*;
import java.awt.event.*;

public class ChatInterface 
{
  
  private static void frameSettings(JFrame f, int x,int y )
  {
    f.setSize(x,y);
    f.setLayout(null);
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  
  public static void main(String args[])
  {
    JFrame f = new JFrame();
    JTextArea prepiska = new JTextArea();

    frameSettings(f,800,600+5);
    
    JButton bConnect = new JButton("Connect");
    bConnect.setBounds(0,f.getHeight()-100,100,50);
    bConnect.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
  {
    String s = prepiska.getText();
    s = s + "Proba Buray\n";
    prepiska.setText(s);
  }
    });
    f.add(bConnect);
    
    
    prepiska.setEditable(false);
    prepiska.setBounds(f.getWidth()/2,0,400,500);
        JScrollPane scroll = new JScrollPane(prepiska);
        scroll.setBounds(f.getWidth()/2,0,400,500);
    f.add(scroll);
    
    
    JTextField tfPoruka = new JTextField();
    tfPoruka.setVisible(true);
    tfPoruka.setBounds(scroll.getWidth(),scroll.getHeight()+5,400,50);
    f.add(tfPoruka);
   
    JLabel lHost = new JLabel("Host");
    lHost.setBounds(5,5,50,25);
    f.add(lHost);
    
    JLabel lPort = new JLabel("Port");
    lPort.setBounds(5,60,50,25);
    f.add(lPort);
    
    JTextField tfHost = new JTextField();
    tfHost.setBounds(60,5,150,25);
    f.add(tfHost);
    
    JTextField tfPort = new JTextField();
    tfPort.setBounds(60,60,150,25);
    f.add(tfPort);
    
    /*JLabel lPrepiska = new JLabel();
    //lPrepiska.setBounds(scroll.getWidth()-60,5,50,25);
    f.add(lPrepiska);
    
    JLabel lPoruka = new JLabel();
    //lPoruka.setBounds(scroll.getWidth()-60,scroll.getHeight(),50,25);
    lPoruka.setBounds(320,500,50,25);
    f.add(lPoruka);*/
    f.setVisible(true);
  }
}