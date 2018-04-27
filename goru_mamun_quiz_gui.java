import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension.*;

class goru_mamun_quiz_gui{
    static int ca,qn=1;
static   JFrame m=new JFrame("Quizo");
    static  String qname="",qauth="";
static JButton [] ar=new JButton[100];
static int ques_seen=-1,ques_attempted=0,correct=-1,wrong=0,ures=0,cres=0;
static PrintWriter qqq;
static  Font butt,dbutt,fques,dfques,op,dop,sdbutt;    
        
public static void result()
{
JFrame res=new JFrame("Result");
res.setSize(300,500);
res.setLayout(null);
JLabel tu=new JLabel("Seen : "+ques_seen);
tu.setBounds(10,0,300,40);
JLabel tu2=new JLabel("Correct : "+correct);
tu2.setBounds(10,45,300,40);
JLabel tu3=new JLabel("Wrong : "+wrong);
tu3.setBounds(10,90,300,40);
JLabel tu4=new JLabel("Author :positron.piercer");
tu4.setBounds(10,300,300,40);
res.add(tu2);
res.add(tu3);
res.add(tu4);
res.add(tu);
res.setVisible(true);

}
public static void initiate_quiz(String a)throws IOException{
 m.setVisible(false);
 
 JFrame ac=new JFrame(a);
  //ac.setExtendedState(JFrame.MAXIMIZED_BOTH);
 //fullscreen mode
  
 ac.setLayout(null);
 ac.setSize(1000,900);
 ac.setVisible(true);
    JPanel qu=new JPanel();
    qu.setBounds(0,0,1000,900);
    qu.setLayout(null);
    JButton next=new JButton("go->");
    JButton done=new JButton("done");
 next.setFont(dbutt);
    JLabel ques=new JLabel();
    
   
    JLabel top1=new JLabel();
    JLabel top2=new JLabel();
    JLabel top3=new JLabel();
    JLabel top4=new JLabel();
    JRadioButton op1=new JRadioButton();
    JRadioButton op2=new JRadioButton();
    JRadioButton op3=new JRadioButton();
    JRadioButton op4=new JRadioButton();
    JLabel ques_no=new JLabel("Question no. "+qn);
    qu.add(ques_no);
     ques_no.setBounds(310,0,200,40);
        ques.setBounds(50,105,900,200);
        op1.setBounds(50,315,20,20);
        op2.setBounds(50,345,20,20);
        op3.setBounds(50,375,20,20);
        op4.setBounds(50,405,20,20);
ques.setFont(dfques);
ques_no.setFont(dop);
ques_no.setVisible(false);
top1.setFont(dop);
        top2.setFont(dop);
        top3.setFont(dop);
        top4.setFont(dop);

        top1.setBounds(80,310,200,30);
        top2.setBounds(80,340,200,30);
        top3.setBounds(80,370,200,30);
        top4.setBounds(80,400,200,30);

        next.setBounds(350,400,200,90);
        done.setBounds(90,450,70,30);
next.setVisible(true);
        done.setBackground(Color.RED);
        done.setForeground(Color.WHITE);
     op1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setca(1);
                    op2.setSelected(false);
                    op3.setSelected(false);
                    op4.setSelected(false);
                }
            }
        );

        op2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
op1.setSelected(false);
op3.setSelected(false);
op4.setSelected(false);
                    setca(2);
                }
            }
        );

        op3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
op1.setSelected(false);
op2.setSelected(false);
op4.setSelected(false);
                    setca(3);
                }
            }
        );

        op4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
op1.setSelected(false);
op2.setSelected(false);
op3.setSelected(false);
                    setca(4);
                }
            }
        );
ca=0;

 op1.setVisible(false);
          op2.setVisible(false);
            op3.setVisible(false);
              op4.setVisible(false);
              
              
             
                 done.setVisible(false);

BufferedReader br=new BufferedReader(new FileReader(a));
done.setFont(sdbutt);
next.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        try{ques_no.setVisible(true);
            next.setFont(sdbutt);
            next.setBounds(170,450,70,30);
        next.setText("next");
        op1.setVisible(true);
          op2.setVisible(true);
            op3.setVisible(true);
              op4.setVisible(true);
               op1.setSelected(false);
                    op2.setSelected(false);
                    op3.setSelected(false);
                    op4.setSelected(false);
              
              
            
             
                 done.setVisible(true);
        ures=ca;
ques_seen++;
if(cres==ures)
correct++;
else if (ures!=0)
wrong++;
ca=ures=0;
try{
        qn=Integer.parseInt(br.readLine());}
        catch(NumberFormatException ty)
        {
        ac.setVisible(false);
result();}
ques_no.setText("Question no. "+qn);
ques.setText(br.readLine());
//wrap the ques
top1.setText(br.readLine());
top2.setText(br.readLine());
top3.setText(br.readLine());
top4.setText(br.readLine());

cres=Integer.parseInt(br.readLine());




}
catch(Exception ee){}
    }});
      done.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent hgf){
                      ques_seen++;
                      ures=ca;
if(cres==ures)
correct++;
else if (ures!=0)
wrong++;
ca=ures=0;
                      ac.setVisible(false);
                      result();
                    }});
ques.setVisible(true);
qu.add(ques);
qu.add(op1);
qu.add(op2);
qu.add(op3);
qu.add(op4);
qu.add(top1);
qu.add(top2);
qu.add(top3);
qu.add(top4);
qu.add(next);
qu.add(done);


qu.setVisible(true);
//m.add(ques);

    ac.add(qu);
    ac.setVisible(true);
  // ac.repaint();
}
    public static void setca(int a){
        ca=a;
    }

    public static void main(String[]args)throws IOException
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){
            //lol
        }
     
   
        try{
        
        
         butt=Font.createFont(Font.TRUETYPE_FONT,new File("Pacifico-Regular.ttf"));
         dbutt=butt.deriveFont(50f);
          fques=Font.createFont(Font.TRUETYPE_FONT,new File("Rubik-Bold.ttf"));
         dfques=fques.deriveFont(15f);
          op=Font.createFont(Font.TRUETYPE_FONT,new File("Athiti-Regular"));
         dop=op.deriveFont(18f);
        sdbutt=butt.deriveFont(18f);
        
        }
        catch(Exception hj){}
        
        
        
        
        
        m.setSize(1000,900);

        JPanel make=new JPanel();
        make.setLayout(null);
        make.setBounds(0,0,1000,900);
        JTextField ques=new JTextField();
        JButton next=new JButton("next");
        JButton done=new JButton("done");
JLabel ques_no=new JLabel("Question no. "+qn);
    ;
        JRadioButton op1=new JRadioButton();
        JRadioButton op2=new JRadioButton();
        JRadioButton op3=new JRadioButton();
        JRadioButton op4=new JRadioButton();
        op1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setca(1);
                    op2.setSelected(false);
                    op3.setSelected(false);
                    op4.setSelected(false);
                }
            }
        );

        op2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
op1.setSelected(false);
op3.setSelected(false);
op4.setSelected(false);
                    setca(2);
                }
            }
        );

        op3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
op1.setSelected(false);
op2.setSelected(false);
op4.setSelected(false);
                    setca(3);
                }
            }
        );

        op4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
op1.setSelected(false);
op2.setSelected(false);
op3.setSelected(false);
                    setca(4);
                }
            }
        );

        JTextField top1=new JTextField();
        JTextField top2=new JTextField();
        JTextField top3=new JTextField();
        JTextField top4=new JTextField();
        top1.setFont(dop);
        top2.setFont(dop);
        top3.setFont(dop);
        top4.setFont(dop);
        ques.setFont(dfques);
        done.setFont(sdbutt);
        next.setFont(sdbutt);
        ques_no.setFont(dbutt);
        next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{  
                       
                    
                        
                        qqq.println(qn++);
                            ques_no.setText("Question no. "+qn);
                        qqq.println(ques.getText());
                        qqq.println(top1.getText());
                        qqq.println(top2.getText());
                        qqq.println(top3.getText());
                        qqq.println(top4.getText());
                        qqq.println(ca);
                        
                    }
                    catch(Exception ef)
                    {}
                    op1.setSelected(false);
                    op2.setSelected(false);
                    op3.setSelected(false);
                    op4.setSelected(false);
                    ques.setText("");
                    top1.setText("");
                    top2.setText("");
                    top3.setText("");
                    top4.setText("");
                }});

        done.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{  
                        
                        qqq.println(qn);
                        qqq.println(ques.getText());
                        qqq.println(top1.getText());
                        qqq.println(top2.getText());
                        qqq.println(top3.getText());
                        qqq.println(top4.getText());
                        qqq.println(ca);
                        qqq.println("END OF QUIZ");
                        qqq.close();
                        qqq.close();
                        qqq.close();
                    }
                    catch(Exception ef)
                    {
                    }
                    make.setVisible(false);
                }});
        ques_no.setBounds(310,0,320,90);
        ques.setBounds(50,105,900,200);
        op1.setBounds(50,315,20,20);
        op2.setBounds(50,345,20,20);
        op3.setBounds(50,375,20,20);
        op4.setBounds(50,405,20,20);

         top1.setBounds(80,310,200,30);
        top2.setBounds(80,340,200,30);
        top3.setBounds(80,370,200,30);
        top4.setBounds(80,400,200,30);

        next.setBounds(170,450,70,30);
         done.setBounds(90,450,70,30);

        done.setBackground(Color.RED);
        done.setForeground(Color.WHITE);

        make.add(ques);
        make.add(ques_no);
        make.add(op1);
        make.add(op2);
        make.add(op3);
        make.add(op4);
        make.add(top1);
        make.add(top2);
        make.add(top3);
        make.add(top4);
        make.add(done);
        make.add(next);
        make.setVisible(false);

        
        
        //--------------------------------------------
        
        JPanel cattempt=new JPanel();
        cattempt.setLayout(null);
        cattempt.setPreferredSize(new Dimension(1000,900));
        JScrollPane sattempt=new JScrollPane(cattempt,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sattempt.setBounds(0,200,1000,700);
        JLabel avail_choice =new JLabel("Available Quizes");
        avail_choice.setFont(dbutt);
        avail_choice.setBounds(300,50,500,90);
        try{
        FileReader fr=new FileReader("quiz_list.txt");
        BufferedReader br=new BufferedReader(fr);
        int i=0;
        String ch="";
        while((ch=br.readLine())!=null){
        ar[i]=new JButton(ch);
        ar[i].setFont(dop);
        ar[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                     avail_choice.setVisible(false);
        cattempt.setVisible(false);
        sattempt.setVisible(false);
            initiate_quiz(((JButton)e.getSource()).getText());
        }
        catch(Exception er){}
            
        }});
        
        ar[i].setBounds(320,60+(10+30*i),200,30);
        if((10+30*i)>600)
        cattempt.setPreferredSize(new Dimension(500,100+(10+30*i)));
        cattempt.add(ar[i]);
        i++;
        cattempt.repaint();
        sattempt.repaint();
        }
        }
        catch(Exception hih){}
        m.add(avail_choice);
        avail_choice.setVisible(false);
        cattempt.setVisible(false);
        sattempt.setVisible(false);
        
        
        
        
//---------------------------------------------------------------------
        
        
        JPanel name=new JPanel();
        name.setLayout(null);
        name.setBounds(0,0,1000,900);
        JLabel lname=new JLabel("Quiz Name : ");
        JLabel lauth=new JLabel("Auth Name : ");
        lname.setFont(dfques);
        lauth.setFont(dfques);
        JTextField tname=new JTextField();
        JTextField tauth=new JTextField();
        tname.setFont(dop);
        tauth.setFont(dop);
        JButton ndone=new JButton("next>>");
        
       

    
        ndone.setFont(dbutt);
        ndone.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    qname=tname.getText();
                    qauth=tauth.getText();
                    name.setVisible(false);
                    make.setVisible(true);
                    try{
                        FileWriter fw=new FileWriter("quiz_list.txt",true);
                        BufferedWriter bw=new BufferedWriter(fw);
                        PrintWriter pw=new PrintWriter(bw);
                        pw.println(qname+" by "+qauth);
                        pw.close();
                        bw.close();
                        fw.close();
                        qqq=new PrintWriter(new BufferedWriter(new FileWriter(qname+" by "+qauth)));

                    }
                    catch(Exception ef){
                        //lol
                    }
                }});

        lname.setBounds(300,300,150,40);
        tname.setBounds(450,300,200,40);
        lauth.setBounds(300,350,150,40);
        tauth.setBounds(450,350,200,40);
        ndone.setBounds(350,400,200,70);
        
        name.add(lname);
        name.add(tname);
        name.add(lauth);
        name.add(tauth);
        name.add(ndone);
        name.setVisible(false);

        //--------------------------------
        JPanel choice=new JPanel();
        choice.setLayout(null);
        choice.setBounds(0,0,1000,900);
        JButton mk=new JButton("Make");
        JButton at=new JButton("Attempt");
        mk.setFont(dbutt);
        at.setFont(dbutt);
        at.setBackground(Color.BLACK);
        at.setForeground(Color.WHITE);
        mk.setBounds(350,300,300,90);
        at.setBounds(350,400,300,90);
        mk.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    choice.setVisible(false);

                    name.setVisible(true);
                }});
                
                at.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    choice.setVisible(false);

                    cattempt.setVisible(true);
                    sattempt.setVisible(true);
                    avail_choice.setVisible(true);
                }});
        choice.add(at);
        choice.add(mk);

            
        //---------------------------------------------
        m.add(sattempt);
        m.add(make);
        m.add(choice);
        m.add(name);
        m.setVisible(true);

            
            
    }
} 
