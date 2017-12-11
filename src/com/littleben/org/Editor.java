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
	
	
    //컨테이너 객체 변수를 선언하고, null을 대입   
    Container myContainer = null;
   
    //MyEditor 클래스의 생성자를 정의
    public Editor(String title) {
       
        //부모 클래스(JFrame)의 생성자를 불러낸다.
        super(title);
 
        //애플리케이션 타이틀을 변수에 수납
        final String myTitle = title;
 
        //파일 이름을 타이틀에 설정
        this.setTitle(title + " - 무제.txt");
 
        //프레임의 컨텐트페인을 얻어서 컨테이너 객체에 대입
        myContainer = this.getContentPane();
        getContentPane().setLayout(null);
 
        //입력용 텍스트 영역을 작성
        final JTextArea Textbox = new JTextArea();
        Textbox.setText("#include <stdio.h> \r\n\r\nint main(){\r\n\tprintf(\"Hello World\");\r\n}");
 
        //행바꾸기를 지원; 자동 줄바꾸기
        Textbox.setLineWrap(true) ;
 
        //스크롤페인을 생성하여 텍스트 영역을 설정
        JScrollPane myScroll = new JScrollPane(Textbox);
        myScroll.setBounds(0, 0, 785, 433);
 
        //ContentPane에 ScrollPane을 설정
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

                            
                              StatusLabel.setText("컴파일 중");
                              
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
                                        StatusLabel.setText("컴파일 완료");
                                    } catch (Exception ex) {

                                    }


                                } catch (Exception ex) {

                                }

                            } else {
                                

                                JOptionPane.showMessageDialog(Editor.this, "Compilation Error", "Error", JOptionPane.ERROR_MESSAGE);
                                StatusLabel.setText("컴파일 에러");

                            }


                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
        	}
        });
        btnRun.setBounds(676, 438, 97, 23);
        getContentPane().add(btnRun);
       
 
 
        //FileChooser 인스턴스 생성
        final JFileChooser myFileChooser = new JFileChooser();
 
        //메뉴바 작성 ----------------------------------------
       
        //MenuBar/Menu/MenuItem 변수 선언
        JMenuBar MenuBar ;
        JMenu MB_File;
       
        JMenuItem File_new ; //New
        JMenuItem File_Open ; //Open
        JMenuItem File_Save ; //Save
        JMenuItem File_Exit ;
 
        //MenuBar를 작성하여 프레임에 설정
        MenuBar = new JMenuBar();
        MenuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setJMenuBar(MenuBar);  //프레임이름.setJMenubar(메뉴바이름)
                                                //프레임에 메뉴바 삽입
 
        //File Menu의 작성과 구성------------------------------
        MB_File = new JMenu("File");
 
        //니모닉 키를 설정
        MB_File.setMnemonic('F');
 
        //MenuItem의 작성과 구성
       
 
        /*
            New : 현재 편집중인 문서를 파기하고 새로운 문서를 작성한다.
            Open : 대화상자를 표시하여 임의의 파일을 연다.
            Save : 대화상자를 표시하여 편집중인 문서에 이름을 붙여서 저장한다.           
            Exit : My Editor 를 끝낸다
        */
 
        //New 메뉴아이템
        File_new = new JMenuItem("New", new ImageIcon("new.gif"));
        

        //New메뉴아이템을 File메뉴에 추가
        MB_File.add(File_new);
       
        //New 메뉴 이벤트 처리를 정의
        File_new.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                Textbox.setText("");
                Editor.this.setTitle(myTitle + " - 무제.txt") ;
            }
        });
 
        //Open 메뉴아이템
        File_Open = new JMenuItem("Open", new ImageIcon("open.gif"));
        MB_File.add(File_Open);
 
        //Open 메뉴 이벤트 처리를 정의
        //FileChooser를 표시하여 지정한 파일을 연다
        File_Open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               
                //[열기] 대화상자를 오픈한다.
                int intRet = myFileChooser.showOpenDialog(Editor.this);
               
                /* 반환값 :
                   
                    JFileChooser.CANCEL_OPTION   : 대화상자에서 취소(Cancel)버튼이 눌린경우
                    JFileChooser.APPROVE_OPTION  : 대화상자에서 응당(yes,ok등) 버튼이 눌린경우
                    JFileChooser.ERROR_OPTION : 어떤 에러가 발생해 대화상자가 취소된경우
                */
 
 
                //yse 혹은 ok버튼이 눌린 경우
                if(intRet == JFileChooser.APPROVE_OPTION){
                    //파일을 여는 처리를 수행한다.
                    try{
                        //읽어들이기용 String 객체
                        String strLine;
                        //FileChooser로 선택된 파일을 File객체에 대입
                        File myFile = myFileChooser.getSelectedFile();
                       
                        //프레임 타이틀에 불러온 파일명 기재
                        Editor.this.setTitle(myTitle + " - " + myFile.getName()) ;
 
                        //선택된 파일의 절대결로를 지정하여 BufferedReader 객체를 작성
                        BufferedReader myReader = new BufferedReader(
                            new FileReader(myFile.getAbsolutePath()));
 
                        //TextArea에 처음에 1행을 대입
                        Textbox.setText(myReader.readLine());
                        //2행 이후는 행바꾸기 코드를 넣어 어펜드
                        while((strLine = myReader.readLine()) != null){
                            Textbox.append("\n"+strLine);
 
                        }
 
                        //BufferedReader 객체를 클로즈
                        myReader.close();
 
                    }catch(IOException ie){
                        System.out.println(ie+ "==> 입출력오류 발생");
                    }
 
                }
 
            }
        });
 
        //Save 메뉴아이템
        File_Save = new JMenuItem("Save", new ImageIcon("save.gif"));
        MB_File.add(File_Save);
 
        //Save 메뉴 이벤트 처리를 정의
        File_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                //[저장] 대화 상자를 오픈한다.
                int intRet = myFileChooser.showSaveDialog(Editor.this);
 
                //yes혹은 ok버튼이 눌린 경우
                if (intRet == JFileChooser.APPROVE_OPTION)
                {
                    //파일을 저장하는 처리를 수행한다.
                    try{
                        File myFile = myFileChooser.getSelectedFile();
                       
                               
                        //프레임 타이틀에 불러온 파일명 기재
                        Editor.this.setTitle(myTitle + " - " + myFile.getName()) ;
 
                        PrintWriter myWriter = new PrintWriter(
                            new BufferedWriter(new FileWriter(myFile.getAbsolutePath())));
                        myWriter.write(Textbox.getText());
                        myWriter.close();
 
                    }catch(IOException ie){
                        System.out.println(ie+ "==> 입출력 오류 발생");
                    }
                }
            }
        });
       
        //세퍼레이터 추가 ; 구분짓는선
        MB_File.addSeparator();
 
        //Exit 메뉴아이템
        File_Exit = new JMenuItem("Exit",new ImageIcon("exit.gif"));
        MB_File.add(File_Exit);
       
        //Exit 메뉴 이벤트 처리를 정의
        File_Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });
 
        //FileMenu를 MenuBar에 편성
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
 
        //메뉴바 작성 끝 --------------------------------------
        
       
        //프레임(윈도우)이 닫힐때의 처리를 정의
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        //Look & Feel 설정
 
        try{
 
            //테마 적용
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        	//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //설정을 반영
            SwingUtilities.updateComponentTreeUI(this);
 
        }catch(Exception e){
        	 e.printStackTrace();
        }
 
        //프레임의 크기를 정의 하여 표시
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
        //MyEditor 클래스의 새로운 인스턴스 생성
        Editor myApp = new Editor("MODU Editor");
   
    }
}

