import javax.swing.*;
import java.awt.*;

public class mwindow {

    public class SwingDemo {
        private void createGUI() {
            //创建一个窗口，创建一个窗口
            myFrame frame = new myFrame("软件体系结构教学系统");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //设置窗口大小
            frame.setSize(600, 400);
            //设置窗口位置
            frame.setLocation(650,300);
            //显示窗口
            frame.setVisible(true);
        }
    }

    public class myFrame extends JFrame{
        String str1 = "*******软件体系结构教学系统*******";
        String str2 = " 请选择您想展示的软件体系结构风格";
        String str3 = "1.主程序-子程序软件体系结构    2.面向对象软件体系结构";
        String str4 = "3.事件系统软件体系结构        4.管道-过滤软件体系结构";
        String[] str = new String[]{"1.主程序-子程序软件体系结构","2.面向对象软件体系结构","3.事件系统软件体系结构","4.管道-过滤软件体系结构"};
        String msg = "<html><body>" + str1 + "<br>" + str2 + "<br>"+str3+"<br>"+str4+"<br>" + "</body></html>";
        JLabel label = new JLabel(msg);
        JTextField textField = new JTextField(50);
        JButton button = new JButton("确定");

        //构造函数
        public myFrame(String title)
        {
            //继承父类，
            super(title);

            //内容面板
            Container contentPane = getContentPane();
            contentPane.setLayout(new FlowLayout());
            textField.setHorizontalAlignment(JTextField.CENTER);
            //添加控件
            contentPane.add(label);
            contentPane.add(textField);
            contentPane.add(button);

            //按钮点击处理 lambda表达式
            button.addActionListener((e) -> {
                onButtonOk();
            });
        }

        //事件处理
        private void onButtonOk()
        {
            String sstr = textField.getText();//获取输入内容
            //判断是否输入了
            if(sstr.equals(""))
            {
                Object[] options = { "OK ", "CANCEL " };
                JOptionPane.showOptionDialog(null, "您还没有输入 ", "提示", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,null, options, options[0]);
            }
            else {
                int x = 0;
                try {
                    x = Integer.parseInt(sstr);
                }catch (Exception e){
                    Object[] options = { "OK ", "CANCEL " };
                    JOptionPane.showOptionDialog(null, "请输入数字 ", "提示", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE,null, options, options[0]);
                }
                if(x<1||x>4){
                    Object[] options = { "OK ", "CANCEL " };
                    JOptionPane.showOptionDialog(null, "超出选择范围 ", "提示", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE,null, options, options[0]);
                }
                else {
                    JOptionPane.showMessageDialog(this, "您选择了：" + str[x-1]);
                    show_picture s = new show_picture();
                    s.foo(x);
                }
            }

        }

    }
    public void foo() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingDemo s = new SwingDemo();
                s.createGUI();
            }
        });
    }

}
