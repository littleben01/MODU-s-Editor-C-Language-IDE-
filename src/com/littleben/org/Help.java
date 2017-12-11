package com.littleben.org;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Help extends JFrame{
 
 public Help(){
  createTabbedPane();
  setTitle("About");
  setSize(800, 450);
    
  setVisible(true);
 }
 
 
 void createTabbedPane(){
  JTabbedPane tPane = new JTabbedPane();
  getContentPane().add(tPane);
  JPanel mainPanel = new JPanel();
  tPane.addTab("소개", mainPanel);
  mainPanel.setLayout(null);
  
  JLabel lblNewLabel = new JLabel("\uC18C\uAC1C");
  lblNewLabel.setBounds(371, 10, 29, 27);
  mainPanel.add(lblNewLabel);
  
  JLabel lblCc = new JLabel("\uC774 \uD504\uB85C\uADF8\uB7A8\uC740 \uC790\uBC14\uB85C \uB9CC\uB4E4\uC5B4\uC9C4 C/C++ IDE\uC785\uB2C8\uB2E4.");
  lblCc.setVerticalAlignment(SwingConstants.TOP);
  lblCc.setBounds(12, 130, 486, 27);
  mainPanel.add(lblCc);
  
  JLabel lblGcc = new JLabel("\uCEF4\uD30C\uC77C\uB7EC\uB294 gcc\uB97C \uC0AC\uC6A9\uD558\uBA70, \uD658\uACBD \uBCC0\uC218\uC5D0 gcc\uAC00 \uB4F1\uB85D\uB418\uC5B4\uC788\uC5B4\uC57C \uD569\uB2C8\uB2E4. ");
  lblGcc.setVerticalAlignment(SwingConstants.TOP);
  lblGcc.setBounds(12, 153, 486, 27);
  mainPanel.add(lblGcc);
  
  JLabel label_2 = new JLabel("\uC774 \uD398\uC774\uC9C0 \uC911 \uBB38\uC758 \uD0ED\uC758 \uB0B4\uC6A9\uC744 \uD3EC\uD568\uD558\uC5EC, \uC8FC\uC11D\uC744 \uC218\uC815\uD558\uC9C0 \uC54A\uACE0 \uCD9C\uCC98\uB97C \uBD84\uBA85\uD788 \uBA85\uC2DC\uD558\uB294 \uC870\uAC74\uC73C\uB85C \uC790\uC720\uB86D\uAC8C \uC218\uC815/\uBCA0\uD3EC \uAC00\uB2A5\uD569\uB2C8\uB2E4.");
  label_2.setVerticalAlignment(SwingConstants.TOP);
  label_2.setBounds(12, 178, 735, 27);
  mainPanel.add(label_2);
  
  JLabel label_6 = new JLabel("\uC774 \uD504\uB85C\uADF8\uB7A8\uC740 \uD559\uC2B5\uC744 \uBAA9\uC801\uC73C\uB85C \uB9CC\uB4E4\uC5C8\uC2B5\uB2C8\uB2E4. \uD68C\uC6D0\uAC00\uC785 \uC2DC \uD3C9\uC18C\uC5D0 \uC0AC\uC6A9\uD558\uC9C0 \uC54A\uB294 ID\uC640 \uBE44\uBC00\uBC88\uD638 \uC0AC\uC6A9\uC744 \uAD8C\uC7A5\uB4DC\uB9BD\uB2C8\uB2E4.");
  label_6.setVerticalAlignment(SwingConstants.TOP);
  label_6.setBounds(12, 202, 735, 27);
  mainPanel.add(label_6);
  
  JLabel lblThisProgramIs = new JLabel("This program is C/C++ IDE made with java.");
  lblThisProgramIs.setVerticalAlignment(SwingConstants.TOP);
  lblThisProgramIs.setBounds(12, 249, 486, 27);
  mainPanel.add(lblThisProgramIs);
  
  JLabel lblProgramUsesGcc = new JLabel("Program uses gcc for compile code, so gcc must be registered on environment variable.");
  lblProgramUsesGcc.setVerticalAlignment(SwingConstants.TOP);
  lblProgramUsesGcc.setBounds(12, 272, 555, 27);
  mainPanel.add(lblProgramUsesGcc);
  
  JLabel lblInclude = new JLabel(" if you don't change comment and specify origin, you are free to edit/share this program.(include Inquire tab in this window)");
  lblInclude.setVerticalAlignment(SwingConstants.TOP);
  lblInclude.setBounds(12, 297, 735, 27);
  mainPanel.add(lblInclude);
  
  JLabel lblThisProgramMade = new JLabel("This program made for java study. Don't use ID/PW usually you use.");
  lblThisProgramMade.setVerticalAlignment(SwingConstants.TOP);
  lblThisProgramMade.setBounds(12, 321, 735, 27);
  mainPanel.add(lblThisProgramMade);
  
  
  JLabel schedulerLabel = new JLabel("기능&설명", SwingConstants.CENTER);
  schedulerLabel.setBounds(361, 5, 56, 15);
  JPanel schedulerPanel = new JPanel();
  schedulerPanel.setLayout(null);
  schedulerPanel.add(schedulerLabel);
  tPane.addTab("기능", schedulerPanel);
  
  JLabel label = new JLabel("\uBAA8\uB450\uC758 \uC5D0\uB514\uD130\uB294 \uB300\uD45C\uC801\uC73C\uB85C \uC544\uB798\uC640 \uAC19\uC740 \uAE30\uB2A5\uC774 \uC788\uC2B5\uB2C8\uB2E4.");
  label.setVerticalAlignment(SwingConstants.TOP);
  label.setBounds(12, 64, 486, 27);
  schedulerPanel.add(label);
  
  JLabel lblCc_1 = new JLabel("- C/C++\uC744 \uD3B8\uC9D1\uD558\uACE0, \uC800\uC7A5\uD558\uACE0, \uC2E4\uD589\uD560 \uC218 \uC788\uB2E4.");
  lblCc_1.setVerticalAlignment(SwingConstants.TOP);
  lblCc_1.setBounds(12, 87, 486, 27);
  schedulerPanel.add(lblCc_1);
  
  JLabel label_3 = new JLabel("- \uB370\uC774\uD130\uBCA0\uC774\uC2A4\uC5D0 \uCF54\uB4DC\uB97C \uC5C5\uB85C\uB4DC \uD574\uC11C, \uC6D0\uD560\uB54C \uB2E4\uC6B4\uB85C\uB4DC\uBC1B\uC544 \uC0AC\uC6A9\uD560 \uC218 \uC788\uB2E4.");
  label_3.setVerticalAlignment(SwingConstants.TOP);
  label_3.setBounds(12, 112, 735, 27);
  schedulerPanel.add(label_3);
  
  JLabel label_1 = new JLabel("\u203B\uD68C\uC6D0\uAC00\uC785\uC744 \uD574\uC57C \uCF54\uB4DC\uB97C \uC5C5\uB85C\uB4DC\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
  label_1.setVerticalAlignment(SwingConstants.TOP);
  label_1.setBounds(32, 136, 735, 27);
  schedulerPanel.add(label_1);
  
  JLabel label_5 = new JLabel("- \uC704 \uAE30\uB2A5\uC758 \uC5F0\uC7A5\uC120\uC73C\uB85C, \uD2B9\uC815\uD55C REPO Key \uB9CC \uAC00\uC9C0\uACE0 \uC788\uC73C\uBA74 \uB204\uAD6C\uB098 \uC18C\uC2A4\uB97C \uACF5\uC720\uD560 \uC218 \uC788\uB2E4.");
  label_5.setVerticalAlignment(SwingConstants.TOP);
  label_5.setBounds(12, 160, 735, 27);
  schedulerPanel.add(label_5);
  
  JLabel lblModuEditorHas = new JLabel("MODU Editor has functions as follows.");
  lblModuEditorHas.setVerticalAlignment(SwingConstants.TOP);
  lblModuEditorHas.setBounds(12, 215, 486, 27);
  schedulerPanel.add(lblModuEditorHas);
  
  JLabel lblEditCc = new JLabel("- Edit C/C++ Codes, Save and Run them.");
  lblEditCc.setVerticalAlignment(SwingConstants.TOP);
  lblEditCc.setBounds(12, 238, 486, 27);
  schedulerPanel.add(lblEditCc);
  
  JLabel lblYouCan = new JLabel("- You can upload codes on Database, so you can download it anytime, anywhere.");
  lblYouCan.setVerticalAlignment(SwingConstants.TOP);
  lblYouCan.setBounds(12, 263, 735, 27);
  schedulerPanel.add(lblYouCan);
  
  JLabel lblIfYou = new JLabel("\u203B If you want to upload code on DB, you have to register on this program.");
  lblIfYou.setVerticalAlignment(SwingConstants.TOP);
  lblIfYou.setBounds(32, 287, 735, 27);
  schedulerPanel.add(lblIfYou);
  
  JLabel lblAnExtension = new JLabel("- An extension to that function, every");
  lblAnExtension.setVerticalAlignment(SwingConstants.TOP);
  lblAnExtension.setBounds(12, 311, 735, 27);
  schedulerPanel.add(lblAnExtension);
  
  
  JLabel reportLabel = new JLabel("제작자&문의", SwingConstants.CENTER);
  reportLabel.setBounds(355, 5, 68, 15);
  JPanel reportPanel = new JPanel();
  reportPanel.setLayout(null);
  reportPanel.add(reportLabel);
  tPane.addTab("문의", reportPanel);
  
  JLabel label_4 = new JLabel("\uC81C\uC791\uC790 : \uD5C8\uCC2C\uC601");
  label_4.setVerticalAlignment(SwingConstants.TOP);
  label_4.setBounds(12, 133, 735, 27);
  reportPanel.add(label_4);
  
  JLabel lblLittlebenioicloudcom = new JLabel("\uC804\uC790\uC6B0\uD3B8 : littleben.io@icloud.com");
  lblLittlebenioicloudcom.setVerticalAlignment(SwingConstants.TOP);
  lblLittlebenioicloudcom.setBounds(12, 178, 735, 27);
  reportPanel.add(lblLittlebenioicloudcom);
  
  JLabel lblHttpsgithubcomlittleben = new JLabel("\uAE43\uD5C8\uBE0C : https://github.com/littleben01");
  lblHttpsgithubcomlittleben.setVerticalAlignment(SwingConstants.TOP);
  lblHttpsgithubcomlittleben.setBounds(12, 154, 735, 27);
  reportPanel.add(lblHttpsgithubcomlittleben);
  
  JLabel lblEmailLittlebenioicloudcom = new JLabel("Email : littleben.io@icloud.com");
  lblEmailLittlebenioicloudcom.setVerticalAlignment(SwingConstants.TOP);
  lblEmailLittlebenioicloudcom.setBounds(12, 297, 735, 27);
  reportPanel.add(lblEmailLittlebenioicloudcom);
  
  JLabel lblGithubHttpsgithubcomlittleben = new JLabel("Github : https://github.com/littleben01");
  lblGithubHttpsgithubcomlittleben.setVerticalAlignment(SwingConstants.TOP);
  lblGithubHttpsgithubcomlittleben.setBounds(12, 276, 735, 27);
  reportPanel.add(lblGithubHttpsgithubcomlittleben);
  
  JLabel lblProducerBryce = new JLabel("Producer : Aaron Hur");
  lblProducerBryce.setVerticalAlignment(SwingConstants.TOP);
  lblProducerBryce.setBounds(12, 252, 735, 27);
  reportPanel.add(lblProducerBryce);
  
  JLabel label_8 = new JLabel("\uD504\uB85C\uADF8\uB7A8\uC5D0 \uB300\uD574 \uAD81\uAE08\uD55C \uC810\uC774 \uC788\uAC70\uB098 \uBB38\uC758\uD560 \uC810\uC774 \uC788\uC73C\uBA74 \uC774\uBA54\uC77C\uC744 \uD1B5\uD574 \uC5F0\uB77D\uD574 \uC8FC\uC2ED\uC2DC\uC624.");
  label_8.setVerticalAlignment(SwingConstants.TOP);
  label_8.setBounds(22, 201, 735, 27);
  reportPanel.add(label_8);
  
  JLabel lblIfYouHave = new JLabel("If you have a question or inquiry, please contact me by email.");
  lblIfYouHave.setVerticalAlignment(SwingConstants.TOP);
  lblIfYouHave.setBounds(22, 321, 735, 27);
  reportPanel.add(lblIfYouHave);
  
 
 }

 public static void main(String[] ar){
  //new Help ();
 }
}

