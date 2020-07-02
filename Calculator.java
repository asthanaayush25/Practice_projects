import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


class Calculator extends JFrame
{


String s1="";
JButton num[];
JButton op[];
JButton sym[];
JTextField display;
JButton ans;
Calculator(String frametext)
{
super(frametext);

setSize(280,400);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
}
void setComp()
{
int x;
int y=300;
int k=0;
sym=new JButton[3];
x=15;
String s="<.0";
for(int i=0;i<3;i++)
{
sym[i]=new JButton(s.charAt(i)+"");
add(sym[i]);
sym[i].setBounds(x,y,50,50);
x+=60;
}
sym[2].addActionListener(new Handler());
sym[1].addActionListener(new Handler());
sym[0].addActionListener(new change());
y=240;
s="789456123";
num=new JButton[9];
for (int i=0;i<3;i++)
{
x=15;
for(int j=0;j<3;j++)
{
num[i]=new JButton(s.charAt(k)+"");
k++;
num[i].setBounds(x,y,50,50);
add(num[i]);
num[i].addActionListener(new Handler());
x+=60;
}
y-=60;
}
s="/*+%";
op=new JButton[4];
y=300;
for(int i=0;i<4;i++)
{
op[i]=new JButton(s.charAt(i)+"");
add(op[i]);
op[i].setBounds(x,y,50,50);
op[i].addActionListener(new Handler());
y-=60;
}
ans=new JButton("Answer");
add(ans);
ans.setBounds(15,y,230,50);
ans.addActionListener(new solve());
display=new JTextField();
display.setBounds(15,y-50,230,40);
add(display);

}
public static void main(String args[])
{
Calculator c=new Calculator("Calculator");
c.setComp();
}
class solve implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
      try{
      ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
      ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
      Object ob= scriptEngine.eval(s1);
      s1=""+ob;
      display.setText(s1);
       
      s1="";
      }
      catch(Exception e2)
{
display.setText("NaN");
s1="";
}


}
}
class change implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
s1=s1.substring(0,s1.length()-1);
display.setText(s1);
}
}
class Handler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
s1+=((JButton) e.getSource()).getText();
display.setText(s1);
}
}
}
 