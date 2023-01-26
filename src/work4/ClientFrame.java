package work4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ClientFrame extends JFrame {

    private JPanel contentPane;
    private JTextField lengthField;
    private JTextField widthField;
    Socket socket;
    ObjectOutputStream oos;
    DataInputStream dis;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientFrame frame = new ClientFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ClientFrame() {
        setTitle("客户端");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 20, 616, 272);
        contentPane.add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JLabel lblNewLabel = new JLabel("length:");
        lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 323, 58, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("width:");
        lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(284, 323, 58, 15);
        contentPane.add(lblNewLabel_1);

        lengthField = new JTextField();
        lengthField.setBounds(78, 319, 166, 21);
        contentPane.add(lengthField);
        lengthField.setColumns(10);

        widthField = new JTextField();
        widthField.setColumns(10);
        widthField.setBounds(352, 319, 166, 21);
        contentPane.add(widthField);

        System.out.println("客户端端运行...");

        JButton btnNewButton = new JButton("send");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                Rectangle rect = new Rectangle(length, width);
                try {
                    oos.writeObject(rect);
                    oos.flush();
                    System.out.println("发送数据！");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnNewButton.setFont(new

                Font("Consolas", Font.PLAIN, 14));
        btnNewButton.setBounds(529, 318, 97, 23);
        contentPane.add(btnNewButton);

        try {
            socket = new Socket("localhost", 9999);
            oos = new ObjectOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            new Thread() {
                public void run() {
                    try {
                        while (true) {
                            double area = dis.readDouble();
                            System.out.println("客户端端接收...");
                            textArea.setText(textArea.getText() + "length:" + lengthField.getText() + "," + "width:" + widthField.getText() + "的矩形面积是" + area + "\n");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
