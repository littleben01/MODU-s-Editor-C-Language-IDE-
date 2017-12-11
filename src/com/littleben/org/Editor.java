package com.littleben.org;

import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;


 
class Editor extends JFrame
{
	
	
    //�����̳� ��ü ������ �����ϰ�, null�� ����   
    Container myContainer = null;
   
    //MyEditor Ŭ������ �����ڸ� ����
    public Editor(String title) {
       
        //�θ� Ŭ����(JFrame)�� �����ڸ� �ҷ�����.
        super(title);
 
        //���ø����̼� Ÿ��Ʋ�� ������ ����
        final String myTitle = title;
 
        //���� �̸��� Ÿ��Ʋ�� ����
        this.setTitle(title + " - ����.txt");
 
        //�������� ����Ʈ������ �� �����̳� ��ü�� ����
        myContainer = this.getContentPane();
        getContentPane().setLayout(null);
 
        //�Է¿� �ؽ�Ʈ ������ �ۼ�
        final JTextArea Textbox = new JTextArea();
        Textbox.setText("#include <stdio.h> \r\n\r\nint main(){\r\n\tprintf(\"Hello World\");\r\n}");
 
        //��ٲٱ⸦ ����; �ڵ� �ٹٲٱ�
        Textbox.setLineWrap(true) ;
 
        //��ũ�������� �����Ͽ� �ؽ�Ʈ ������ ����
        JScrollPane myScroll = new JScrollPane(Textbox);
        myScroll.setBounds(0, 0, 785, 433);
 
        //ContentPane�� ScrollPane�� ����
        myContainer.add(myScroll);
        
        JLabel StatusLabel = new JLabel("\uB300\uAE30\uC911");
        StatusLabel.setBounds(12, 442, 109, 15);
        getContentPane().add(StatusLabel);
        
        JButton btnRun = new JButton("RUN");
        
        btnRun.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		JFileChooser fileChooser=new JFileChooser();
                if (fileChooser.showSaveDialog(Editor.this) != JFileChooser.APPROVE_OPTION)
                            return;
                        File file = fileChooser.getSelectedFile();
                        try {
                            FileWriter out = new FileWriter(file);
                            Textbox.write(out);
                            out.close();

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        String filepath = file.getPath();
                        String filepath2 = filepath.substring(0, filepath.lastIndexOf(File.separator));
                        System.out.println(filepath);
                        System.out.println(filepath2);
                        String name = file.getName();


                        String name2 = file.getName().substring(0, file.getName().lastIndexOf("."));
                         String folder = filepath2+"\\";
        	        String exe = folder+name2+".exe";
                         System.out.println(exe);
                  
                        ProcessBuilder pb=new ProcessBuilder();
                          try {
                            
                        	  int val = 0;
    
                              pb = new ProcessBuilder("cmd", "/C", "gcc " + "\"" + filepath2 + "\\" + name + "\"" + " -o \"" + name2+"\"");
                            
                           
                              pb = new ProcessBuilder("cmd", "/C", "g++ " + "\"" + filepath2 + "\\" + name + "\"" + " -o \"" + name2+"\"");

                            
                              StatusLabel.setText("������ ��");
                              
                            pb.directory(new File(filepath2));
                            Process p = pb.start();
                            p.waitFor();
                            int x = p.exitValue();
                            int z=p.exitValue();
                         
                            if (x == 0) {
                                
                                Runtime rt = Runtime.getRuntime();
                                try {
                                    String username = System.getProperty("user.name");
                                    String c = "@echo off\n" + "\"" +
                                            filepath2 + "\\" + name2 + ".exe\"\n" + "echo.\n" + "echo.\n" + "echo Process Terminated\n" +
                                            "pause\n" +
                                            "exit";


                                    File dir = new File("C:\\Users\\" + username + "\\CodeEditor");
                                    dir.mkdir();

                                    try {
                                        File file2 = new File("C:\\Users\\" + username + "\\CodeEditor" + "\\run.bat");
                                        file2.createNewFile();
                                        PrintWriter writer = new PrintWriter(file2);
                                        writer.println(c);
                                        writer.close();


                                        Process p2 = Runtime.getRuntime().exec("cmd /c start run.bat", null, new File("C:\\Users\\" + username + "\\CodeEditor"));
                                        StatusLabel.setText("������ �Ϸ�");
                                    } catch (Exception ex) {

                                    }


                                } catch (Exception ex) {

                                }

                            } else {
                                

                                JOptionPane.showMessageDialog(Editor.this, "Compilation Error", "Error", JOptionPane.ERROR_MESSAGE);
                                StatusLabel.setText("������ ����");

                            }


                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
        	}
        });
        btnRun.setBounds(676, 438, 97, 23);
        getContentPane().add(btnRun);
       
 
 
        //FileChooser �ν��Ͻ� ����
        final JFileChooser myFileChooser = new JFileChooser();
 
        //�޴��� �ۼ� ----------------------------------------
       
        //MenuBar/Menu/MenuItem ���� ����
        JMenuBar MenuBar ;
        JMenu MB_File;
       
        JMenuItem File_new ; //New
        JMenuItem File_Open ; //Open
        JMenuItem File_Save ; //Save
        JMenuItem File_Exit ;
 
        //MenuBar�� �ۼ��Ͽ� �����ӿ� ����
        MenuBar = new JMenuBar();
        MenuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setJMenuBar(MenuBar);  //�������̸�.setJMenubar(�޴����̸�)
                                                //�����ӿ� �޴��� ����
 
        //File Menu�� �ۼ��� ����------------------------------
        MB_File = new JMenu("File");
 
        //�ϸ�� Ű�� ����
        MB_File.setMnemonic('F');
 
        //MenuItem�� �ۼ��� ����
       
 
        /*
            New : ���� �������� ������ �ı��ϰ� ���ο� ������ �ۼ��Ѵ�.
            Open : ��ȭ���ڸ� ǥ���Ͽ� ������ ������ ����.
            Save : ��ȭ���ڸ� ǥ���Ͽ� �������� ������ �̸��� �ٿ��� �����Ѵ�.           
            Exit : My Editor �� ������
        */
 
        //New �޴�������
        File_new = new JMenuItem("New", new ImageIcon("new.gif"));
        

        //New�޴��������� File�޴��� �߰�
        MB_File.add(File_new);
       
        //New �޴� �̺�Ʈ ó���� ����
        File_new.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                Textbox.setText("");
                Editor.this.setTitle(myTitle + " - ����.txt") ;
            }
        });
 
        //Open �޴�������
        File_Open = new JMenuItem("Open", new ImageIcon("open.gif"));
        MB_File.add(File_Open);
 
        //Open �޴� �̺�Ʈ ó���� ����
        //FileChooser�� ǥ���Ͽ� ������ ������ ����
        File_Open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               
                //[����] ��ȭ���ڸ� �����Ѵ�.
                int intRet = myFileChooser.showOpenDialog(Editor.this);
               
                /* ��ȯ�� :
                   
                    JFileChooser.CANCEL_OPTION   : ��ȭ���ڿ��� ���(Cancel)��ư�� �������
                    JFileChooser.APPROVE_OPTION  : ��ȭ���ڿ��� ����(yes,ok��) ��ư�� �������
                    JFileChooser.ERROR_OPTION : � ������ �߻��� ��ȭ���ڰ� ��ҵȰ��
                */
 
 
                //yse Ȥ�� ok��ư�� ���� ���
                if(intRet == JFileChooser.APPROVE_OPTION){
                    //������ ���� ó���� �����Ѵ�.
                    try{
                        //�о���̱�� String ��ü
                        String strLine;
                        //FileChooser�� ���õ� ������ File��ü�� ����
                        File myFile = myFileChooser.getSelectedFile();
                       
                        //������ Ÿ��Ʋ�� �ҷ��� ���ϸ� ����
                        Editor.this.setTitle(myTitle + " - " + myFile.getName()) ;
 
                        //���õ� ������ �����θ� �����Ͽ� BufferedReader ��ü�� �ۼ�
                        BufferedReader myReader = new BufferedReader(
                            new FileReader(myFile.getAbsolutePath()));
 
                        //TextArea�� ó���� 1���� ����
                        Textbox.setText(myReader.readLine());
                        //2�� ���Ĵ� ��ٲٱ� �ڵ带 �־� �����
                        while((strLine = myReader.readLine()) != null){
                            Textbox.append("\n"+strLine);
 
                        }
 
                        //BufferedReader ��ü�� Ŭ����
                        myReader.close();
 
                    }catch(IOException ie){
                        System.out.println(ie+ "==> ����¿��� �߻�");
                    }
 
                }
 
            }
        });
 
        //Save �޴�������
        File_Save = new JMenuItem("Save", new ImageIcon("save.gif"));
        MB_File.add(File_Save);
 
        //Save �޴� �̺�Ʈ ó���� ����
        File_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                //[����] ��ȭ ���ڸ� �����Ѵ�.
                int intRet = myFileChooser.showSaveDialog(Editor.this);
 
                //yesȤ�� ok��ư�� ���� ���
                if (intRet == JFileChooser.APPROVE_OPTION)
                {
                    //������ �����ϴ� ó���� �����Ѵ�.
                    try{
                        File myFile = myFileChooser.getSelectedFile();
                       
                               
                        //������ Ÿ��Ʋ�� �ҷ��� ���ϸ� ����
                        Editor.this.setTitle(myTitle + " - " + myFile.getName()) ;
 
                        PrintWriter myWriter = new PrintWriter(
                            new BufferedWriter(new FileWriter(myFile.getAbsolutePath())));
                        myWriter.write(Textbox.getText());
                        myWriter.close();
 
                    }catch(IOException ie){
                        System.out.println(ie+ "==> ����� ���� �߻�");
                    }
                }
            }
        });
       
        //���۷����� �߰� ; �������¼�
        MB_File.addSeparator();
 
        //Exit �޴�������
        File_Exit = new JMenuItem("Exit",new ImageIcon("exit.gif"));
        MB_File.add(File_Exit);
       
        //Exit �޴� �̺�Ʈ ó���� ����
        File_Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });
 
        //FileMenu�� MenuBar�� ��
        MenuBar.add(MB_File);
        
        JMenu mnCode = new JMenu("Code");
        MenuBar.add(mnCode);
        
        JMenuItem mntmUpload = new JMenuItem("Upload");
        mnCode.add(mntmUpload);
        
        
        
        mntmUpload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	String code=Textbox.getText();
            	new Upload(code).main(new String[] {""});
            }
        });
        
        JMenuItem mntmDownload = new JMenuItem("Download");
        mnCode.add(mntmDownload);
        
        mntmDownload.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
            	String code=Textbox.getText();
            	new Download().main(new String[] {""});
            }
        });
        
        JMenu MB_Help = new JMenu("Help");
        MenuBar.add(MB_Help);
        
        JMenuItem mntmAbout = new JMenuItem("About");
        MB_Help.add(mntmAbout);
        
        JMenuItem mntmSendToProducer = new JMenuItem("Send to Producer");
        MB_Help.add(mntmSendToProducer);
        
        mntmSendToProducer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
            	String code=Textbox.getText();
            	new ToProducer().main(new String[] {""});
            }
        });
 
        mntmAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
            	String code=Textbox.getText();
            	new Help().main(new String[] {""});
            }
        });
 
        //�޴��� �ۼ� �� --------------------------------------
        
       
        //������(������)�� �������� ó���� ����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        //Look & Feel ����
 
        try{
 
            //�׸� ����
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        	//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //������ �ݿ�
            SwingUtilities.updateComponentTreeUI(this);
 
        }catch(Exception e){
        	 e.printStackTrace();
        }
 
        //�������� ũ�⸦ ���� �Ͽ� ǥ��
        this.setSize(801,530);
        this.setVisible(true);
        File_new.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
        File_Open.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
        File_Save.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
        mntmUpload.setAccelerator(KeyStroke.getKeyStroke('U', Event.CTRL_MASK));
        mntmDownload.setAccelerator(KeyStroke.getKeyStroke('D',Event.CTRL_MASK));
        
        
        
    }
    
    
    public static void main(String[] args)
    {
        //MyEditor Ŭ������ ���ο� �ν��Ͻ� ����
        Editor myApp = new Editor("MODU Editor");
   
    }
}

