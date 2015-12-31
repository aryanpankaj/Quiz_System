/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_system;

/**
 *
 * @author Pankaj jangid
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class  Quiz_System extends JFrame implements ActionListener{
            JPanel panel;
            JPanel panelresult;
            JRadioButton choice1;
            JRadioButton choice2;
            JRadioButton choice3;
            JRadioButton choice4;
            ButtonGroup bg;
            JLabel lblmess;
            JButton btnext;
            String[][] ar_q;
            String[][] ar_qa;
            int qaid;
            HashMap<Integer, String> map;

            Quiz_System(){
                      initializedata();
                     setTitle("Quiz Program");
                      setDefaultCloseOperation(EXIT_ON_CLOSE);
                      setSize(430,350);
                     setLocation(300,100);
                     setResizable(false);
                     Container cont=getContentPane();
                     cont.setLayout(null);          
                      cont.setBackground(Color.GRAY);
                    bg=new ButtonGroup();     
                    choice1=new JRadioButton("Choice1",true);
                    choice2=new JRadioButton("Choice2",false);
                    choice3=new JRadioButton("Choice3",false);
                    choice4=new JRadioButton("Choice4",false);
                    bg.add(choice1);
                    bg.add(choice2);
                    bg.add(choice3);
                    bg.add(choice4);
                    lblmess=new JLabel("Choose a correct anwswer");
                    lblmess.setForeground(Color.BLUE);
                    lblmess.setFont(new Font("Arial", Font.BOLD, 11));
                   btnext=new JButton("Next");
                    btnext.setForeground(Color.GREEN);                
                    btnext.addActionListener(this);
                    panel=new JPanel();
                   panel.setBackground(Color.LIGHT_GRAY);
                   panel.setLocation(10,10);
                  panel.setSize(400,300);
                   panel.setLayout(new GridLayout(6,2));
                   panel.add(lblmess);
                  panel.add(choice1);
                    panel.add(choice2);
                 panel.add(choice3);
                  panel.add(choice4);
                  panel.add(btnext);
                   cont.add(panel);
                  setVisible(true);
                  qaid=0;
                    readqa(qaid);
           
            }
           
       public void actionPerformed(ActionEvent e){
           
                        if(btnext.getText().equals("Next")){
                                    if(qaid<9){
                                               
                                                map.put(qaid,getSelection());
                                                qaid++;
                                                readqa(qaid);
                                                }
                                    else {
                                                map.put(qaid,getSelection());
                                                btnext.setText("Show answers");
                                               
                                             }
                                    }
                        else if(btnext.getText().equals("Show answers"))
                                    new Report();
                       
                       
            }
           

           
       public void initializedata(){
                        //ar_q stores pairs of question and its possible answers
                        ar_q=new String[10][5];

                        ar_q[0][0]="How to run Java program on the command prompt?";
                        ar_q[0][1]="javac JavaProgram";
                        ar_q[0][2]="java JavaProgram";
                        ar_q[0][3]="javac JavaProgram.java";
                        ar_q[0][4]="No one";

                        ar_q[1][0]="What is the use of the println method?";
                        ar_q[1][1]="It is used to print text on the screen.";
                        ar_q[1][2]="It is used to print text on the screen with the line break.";
                        ar_q[1][3]="It is used to read text from keyboard.";
                        ar_q[1][4]="It is used to read text from a file.";
                       
                        ar_q[2][0]="How to read a character from the keyboard?";
                        ar_q[2][1]="char c=System.read()";
                        ar_q[2][2]="char c=System.in.read()";
                        ar_q[2][3]="char c=(char)System.read()";
                        ar_q[2][4]="char c=(char)System.in.read()";

                        ar_q[3][0]="Which one is a single-line comment?";
                        ar_q[3][1]="/...";
                        ar_q[3][2]="//...";
                        ar_q[3][3]="/*...";
                        ar_q[3][4]="/*...*/";

                        ar_q[4][0]="How do you declare an integer variable x?";
                        ar_q[4][1]="int x";
                        ar_q[4][2]="x as Integer";
                        ar_q[4][3]="Int[] x";
                        ar_q[4][4]="No one is correct.";

                        ar_q[5][0]="How do you convert a string of number to a number?";
                        ar_q[5][1]="int num=Integer.parseInt(str_num)";
                        ar_q[5][2]="int num=str_num.toInteger()";
                        ar_q[5][3]="int num=(int)str_num";
                        ar_q[5][4]="int num=(Integer)str_num";

                        ar_q[6][0]="What is the value of x? int x=3>>2";
                        ar_q[6][1]="1";
                        ar_q[6][2]="0";
                        ar_q[6][3]="3";
                        ar_q[6][4]="-3";

                        ar_q[7][0]="How to do exit a loop?";
                        ar_q[7][1]="Using exit";
                        ar_q[7][2]="Using break";
                        ar_q[7][3]="Using continue";
                        ar_q[7][4]="Using terminate";

                        ar_q[8][0]="What is the correct way to allocate one-dimensional array?";
                        ar_q[8][1]="int[size] arr=new int[]";
                        ar_q[8][2]="int arr[size]=new int[]";
                        ar_q[8][3]="int[size] arr=new int[size]";
                        ar_q[8][4]="int[] arr=new int[size]";

                        ar_q[9][0]="What is the correct way to allocate two-dimensional array?";
                        ar_q[9][1]="int[size][] arr=new int[][]";
                        ar_q[9][2]="int arr=new int[rows][cols]";
                        ar_q[9][3]="int arr[rows][]=new int[rows][cols]";
                        ar_q[9][4]="int[][] arr=new int[rows][cols]";

                       
                        //ar_qa stores pairs of question and its correct answer
                        ar_qa=new String[10][2];
                       
                        ar_qa[0][0]="How to run Java program on the command prompt?";
                        ar_qa[0][1]="java JavaProgram";

                        ar_qa[1][0]="What is the use of the println method?";
                        ar_qa[1][1]="It is used to print text on the screen with the line break.";

                        ar_qa[2][0]="How to read a character from the keyboard?";
                        ar_qa[2][1]="char c=(char)System.in.read()";

                        ar_qa[3][0]="Which one is a single-line comment?";
                        ar_qa[3][1]="//...";


                        ar_qa[4][0]="How do you declare an integer variable x?";
                        ar_qa[4][1]="int x";

                        ar_qa[5][0]="How do you convert a string of number to a number?";
                        ar_qa[5][1]="int num=Integer.parseInt(str_num)";

                        ar_qa[6][0]="What is the value of x? int x=3>>2";
                        ar_qa[6][1]="0";
                       
                        ar_qa[7][0]="How to do exit a loop?";
                        ar_qa[7][1]="Using break";
                       
                        ar_qa[8][0]="What is the correct way to allocate one-dimensional array?";
                        ar_qa[8][1]="int[] arr=new int[size]";

                        ar_qa[9][0]="What is the correct way to allocate two-dimensional array?";
                        ar_qa[9][1]="int[][] arr=new int[rows][cols]";
                       
                       
                        //create a map object to store pairs of question and selected answer
                        map=new HashMap<Integer, String>();
                       
                        }
       public String getSelection(){
                        String selectedChoice=null;
                        Enumeration<AbstractButton> buttons=bg.getElements(); 
                        while(buttons.hasMoreElements()) 
                        { 
                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                        if(temp.isSelected()) 
                                    { 
                                                selectedChoice=temp.getText();
                                    } 
                         }  
                        return(selectedChoice);
            }


      public void readqa(int qid){
                        lblmess.setText("  "+ar_q[qid][0]);
                        choice1.setText(ar_q[qid][1]);
                        choice2.setText(ar_q[qid][2]);
                        choice3.setText(ar_q[qid][3]);
                        choice4.setText(ar_q[qid][4]);
                        choice1.setSelected(true);
            }
       public void reset(){
                        qaid=0;
                        map.clear();
                        readqa(qaid);
                        btnext.setText("Next");
                        }
       public int calCorrectAnswer(){
                        int qnum=10;
                        int count=0;
                        for(int qid=0;qid<qnum;qid++)
                                    if(ar_qa[qid][1].equals(map.get(qid))) count++;
                        return count;
            }

       public class Report extends JFrame{
                        Report(){
                                    setTitle("Answers");
                                    setSize(850,550);
                                    setBackground(Color.WHITE);
                                    addWindowListener(new WindowAdapter(){
                                                            public void windowClosing(WindowEvent e){
                                                                        dispose();
                                                                        reset();
                                                            }
                                                });
                                    Draw d=new Draw();                                  
                                    add(d);
                                    setVisible(true);
                                    }
                       
                       
                  class Draw extends Canvas{
                                    public void paint(Graphics g){
                                                int qnum=10;
                                                int x=10;
                                                int y=20;
                                                for(int i=0;i<qnum;i++){
                                                            //print the 1st column
                                                            g.setFont(new Font("Arial",Font.BOLD,12));                                         
                                                            g.drawString(i+1+". "+ar_qa[i][0], x,y);
                                                            y+=30;           
                                                            g.setFont(new Font("Arial",Font.PLAIN,12));                             
                                                            g.drawString("      Correct answer:"+ar_qa[i][1], x,y);
                                                            y+=30;
                                                            g.drawString("      Your answer:"+map.get(i), x,y);
                                                            y+=30;
                                                            //print the 2nd column
                                                            if(y>400)
                                                            {y=20;
                                                              x=450;
                                                            }
                                                           
                                                }
                                                //Show number of correct answers
                                                int numc=calCorrectAnswer();
                                                g.setColor(Color.BLUE);
                                                g.setFont(new Font("Arial",Font.BOLD,14));
                                                g.drawString("Number of correct answers:"+numc,300,500);
                       
                                               
                                    }
                        }
                                   
            }
           

           

}


 public class QuizProgram{
 
            public static void main(String args[]){
                         new Quiz_System();
  
            }


}

