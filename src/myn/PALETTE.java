package myn;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class PALETTE {

	private JFrame frame;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PALETTE window = new PALETTE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public static JProgressBar progressBar ;
	public static TextArea textArea;
	public static JLabel num;
	public PALETTE() {
		initialize();
		
		this.frame.setSize(2048, 1134);  
	        //设置位置  
		this.frame. setLocation(50, 50); 
		//背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）  
        String path = "./image/background.jpg";  
        // 背景图片  
        ImageIcon background = new ImageIcon(path);  
        // 把背景图片显示在一个标签里面  
        JLabel label = new JLabel(background);  
        // 把标签的大小位置设置为图片刚好填充整个面板  
        label.setBounds(0, 0, this.frame.getWidth(), this.frame.getHeight());  
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.frame.getContentPane();  
        frame.getContentPane().setLayout(null);
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setBounds(863, 306, 666, 402);
        frame.getContentPane().add(fileChooser);
        fileChooser.setVisible(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
        
        JLabel lblNewLabel = new JLabel("\u91CD\u590D\u6587\u4EF6\u67E5\u91CD\u5668(by:mayining)");
        lblNewLabel.setForeground(new Color(255, 250, 240));
        lblNewLabel.setFont(new Font("方正静蕾简体加粗版", Font.BOLD, 72));
        lblNewLabel.setBounds(491, 77, 1181, 98);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u8981\u68C0\u67E5\u7684\u6587\u4EF6\u5939");
        lblNewLabel_1.setForeground(new Color(100, 149, 237));
        lblNewLabel_1.setFont(new Font("Aunt-沉魅体", Font.BOLD, 50));
        lblNewLabel_1.setBounds(139, 208, 550, 74);
        frame.getContentPane().add(lblNewLabel_1);
        
        textArea = new TextArea();
        textArea.setEditable(true);
       
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 32));
        textArea.setText("\u8BF7\u9009\u62E9\u8DEF\u5F84\u540E\u70B9\u51FB\u5F00\u59CB\u6309\u94AE\u3002");
        textArea.setBounds(10, -12, 1684, 552);
        frame.getContentPane().add(textArea);
       

        JScrollPane jsp = new JScrollPane(  textArea);
        jsp.setBounds(246, 395, 1684, 552);    //设置 JScrollPane 宽100,高200  
        frame.getContentPane().add(jsp);
        
        JLabel label_1 = new JLabel("\u5904\u7406\u5982\u4E0B\uFF1A");
        label_1.setForeground(new Color(100, 149, 237));
        label_1.setFont(new Font("Aunt-沉魅体", Font.BOLD, 50));
        label_1.setBounds(139, 306, 255, 74);
        frame.getContentPane().add(label_1);
        
        textArea_1 = new JTextArea();
        textArea_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        
        	}
        });
        textArea_1.setBackground(UIManager.getColor("TextField.caretForeground"));
        textArea_1.setForeground(new Color(255, 255, 255));
        textArea_1.setFont(new Font("方正静蕾简体加粗版", Font.PLAIN, 40));
        textArea_1.setText("\u8BF7\u70B9\u51FB\u8FD9\u91CC\u8F93\u5165\u6216\u8005\u70B9\u51FB\u53F3\u4FA7\u6309\u94AE\u9009\u62E9");
        textArea_1.setBounds(718, 226, 858, 63);
        frame.getContentPane().add(textArea_1);
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //设置可见  
        frame.setVisible(true);  
        //点关闭按钮时退出  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setResizable(false);
        JButton btnNewButton = new JButton("\u9009\u62E9");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		fileChooser.setVisible(true);
        		int returnVal =  fileChooser.showOpenDialog( fileChooser);
        		if( returnVal==fileChooser.CANCEL_OPTION){
        			
        		}
        		else if( returnVal==fileChooser.APPROVE_OPTION){
        			File file = fileChooser.getSelectedFile();
        			textArea_1.setText(file.getAbsolutePath());
        		}
        	}
        });
        btnNewButton.setToolTipText("");
        btnNewButton.setForeground(new Color(250, 250, 210));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("海派腔调禅大黑简2.0", Font.PLAIN, 44));
        btnNewButton.setBounds(1607, 226, 162, 57);
        frame.getContentPane().add(btnNewButton);
        
        progressBar = new JProgressBar();
        progressBar.setBounds(430, 323, 1146, 39);
        frame.getContentPane().add(progressBar);
        progressBar.setVisible(false);
        
        JButton btnStart = new JButton("\u5F00\u59CB");
        btnStart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(num.getText().contains("完成")||num.getText().contains("..."))
        		progressBar.setVisible(true);
        		Thread my=new Thread(new Runnable(){
        			public void run(){
        				DuplicateFile temp = new DuplicateFile();
                		File o=new File(textArea_1.getText());
                		PALETTE.textArea.setText("");
                			temp.run(o);
        			}
        		});
        		if(num.getText().contains("完成")||num.getText().contains("...")){
        			System.out.println("run!");
        			my.start();
        		}
        		
        	}
        });
        btnStart.setToolTipText("");
        btnStart.setForeground(new Color(250, 250, 210));
        btnStart.setFont(new Font("海派腔调禅大黑简2.0", Font.PLAIN, 44));
        btnStart.setBackground(Color.BLACK);
        btnStart.setBounds(1802, 225, 162, 57);
        frame.getContentPane().add(btnStart);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(1933, 747, -336, -349);
        frame.getContentPane().add(scrollPane);
        
        num = new JLabel("...");
        num.setForeground(UIManager.getColor("TextArea.background"));
        num.setFont(new Font("方正静蕾简体加粗版", Font.PLAIN, 50));
        num.setBounds(1607, 306, 393, 57);
        frame.getContentPane().add(num);
        
      
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setAutoRequestFocus(false);
		
	}
}
