import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;  
import java.awt.Font;

public class TextFieldExample implements ActionListener{  
    JTextField tf1;  
    JButton b2,b1,b3,b4,b5,b6,c;  
    JTextPane text;
    JTextArea area;
    TextFieldExample(){  
        JFrame f= new JFrame();  
        Font fe = new Font("Verdana",Font.BOLD,30);
        tf1=new JTextField();  
        tf1.setBounds(50,30,450,100);          
        tf1.setBackground(Color.BLACK);
        tf1.setForeground(Color.WHITE);
        tf1.setFont(fe);
        area=new JTextArea("ENTER YOUR VALUE FROM KEYBOARD");  
        area.setBounds(50,0, 450,30);  
        area.setEditable(false);
        b2=new JButton("DEC->BINARY");  
        b2.setBounds(50,130,150,50);  
        b1=new JButton("DEC->OCTAL");  
        b1.setBounds(50,180,150,50);  
        b3=new JButton("DEC->HEXA");  
        b3.setBounds(50,230,150,50);  
        c=new JButton("ALL CLEAR");  
        c.setBounds(370,130,120,50); 
        b4=new JButton("BINARY->DEC");  
        b4.setBounds(210,130,150,50);  
        b4.setBackground(Color.ORANGE);
        b4.setForeground(Color.BLACK);
        b5=new JButton("OCTAL->DEC");  
        b5.setBounds(210,180,150,50);
        b5.setBackground(Color.RED);  
        b5.setForeground(Color.BLACK);
        b6=new JButton("HEXA->DEC");  
        b6.setBounds(210,230,150,50);  
        b6.setBackground(Color.ORANGE);
        b6.setForeground(Color.BLACK);
        c.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        f.add(tf1);f.add(c);f.add(b2);f.add(b3);f.add(b1);f.add(b4);f.add(b5);f.add(b6);f.add(area);
        f.setSize(550,330);  
        f.setBackground(Color.BLUE);
        f.setLayout(null);  
        f.setVisible(true); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }    
    public static String toHex(int decimal){    
        int rem;  
        String hex="";   
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
       while(decimal>0){  
          rem=decimal%16;   
          hex=hexchars[rem]+hex;   
          decimal=decimal/16;  
        }  
       return hex;  
    }   
    public static String toOct(int decimal){    
        int rem;  
        String oct="";   
       while(decimal>0){  
          rem=decimal%8;   
          oct=rem + oct;   
          decimal=decimal/8;  
        }  
       return oct;  
    }   
    public static String tobinary(int decimal){
        int rem;
        String binary="";
        if(decimal < 99999){
        while(decimal>0){
            rem = decimal%2;
            binary = rem + binary;
            decimal = decimal/2;}}
        else{binary = "max input 10^5";} 
        return binary;
    }    
    public static int HextoDec(String hexVal){  
        int len = hexVal.length();
        int base = 1;
        int dec_val = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (hexVal.charAt(i) >= '0'
                && hexVal.charAt(i) <= '9') {
                dec_val += (hexVal.charAt(i) - 48) * base;
                base = base * 16;
            }
            else if (hexVal.charAt(i) >= 'A'
                     && hexVal.charAt(i) <= 'F') {
                dec_val += (hexVal.charAt(i) - 55) * base;
                base = base * 16;
            }
        }
        return dec_val;
    }  
   public static int octalToDec(int n){
        int dec_value = 0;
        int base = 1;
        int temp = n;
        while (temp > 0) {
            int last_digit = temp % 10;
            temp = temp / 10;
            dec_value += last_digit * base;
            base = base * 8;
        }
        return dec_value;
    }
    public static int binaryToDec(int n){
        int dec_value = 0;
        int base = 1;
        int temp = n;
        while (temp > 0) {
            int last_digit = temp % 10;
            temp = temp / 10;
            dec_value += last_digit * base;
            base = base * 2;
        }
        return dec_value;
}
    public static int maxvalue(int a){
        int b=0,c=0;
        while(a > 0){
            b = a%10;
            if(b > c){c=b;}
            a = a/10;
        };
    return c;
    }
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==c){  
            tf1.setText(""); }   
        String s1=tf1.getText();    
        if(e.getSource()==b4){  
            int a=Integer.parseInt(s1);
            if(maxvalue(a)>1){tf1.setText("invalid");}
            else{
            String result = Integer.toString(binaryToDec(a)); 
            tf1.setText(result);}}
        if(e.getSource()==b5){  
            int a=Integer.parseInt(s1);
            if(maxvalue(a)>7){tf1.setText("invalid");}
            else{
            String result = Integer.toString(octalToDec(a)); 
            tf1.setText(result);} } 
        if(e.getSource()==b6){  
            String result = Integer.toString(HextoDec(s1)); 
            tf1.setText(result);}   
        if(e.getSource()==b3){  
            int a=Integer.parseInt(s1);
            String result = toHex(a); 
            tf1.setText(result);} 
        if(e.getSource()==b2){  
            int a=Integer.parseInt(s1);
            String result = tobinary(a); 
            tf1.setText(result);} 
        if(e.getSource()==b1){ 
            int a=Integer.parseInt(s1); 
            String result = toOct(a); 
            tf1.setText(result); }
 }  
public static void main(String[] args) {  
    new TextFieldExample();  
} }  