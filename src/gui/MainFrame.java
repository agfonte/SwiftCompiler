package gui;

//import com.bulenkov.darcula.DarculaLookAndFeelInfo;

import com.bulenkov.darcula.DarculaLookAndFeelInfo;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import parser.swiftLexer;
import parser.swiftParser;
import traductor.BCELVisitor;
import traductor.MethodAnalizer;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JButton openButton;
    private JButton button1;
    private JButton compilarButton;
    private JButton button3;
    private JTextArea numberArea;
    private JTextPane codeArea;
    private JTextArea consoleArea;
    private JSplitPane splitPane;
    private StyledDocument styledDocument;
    private Style orangeStyle;
    private Style yellowStyle;
    private Style defaultStyle;
    private Style purpleStyle;
    private Style greenStyle;
    private Style blueStyle;

    private Process process;


    public MainFrame(String title) throws HeadlessException {
        super(title);
        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        styledDocument = codeArea.getStyledDocument();
        defaultStyle = styledDocument.addStyle("normal", styledDocument.getStyle(StyleContext.DEFAULT_STYLE));
        orangeStyle = styledDocument.addStyle("orange", defaultStyle);
        StyleConstants.setForeground(orangeStyle, new Color(0xCB7730));
        yellowStyle = styledDocument.addStyle("yellow", defaultStyle);
        StyleConstants.setForeground(yellowStyle, new Color(0xFFC66D));
        purpleStyle = styledDocument.addStyle("purple", defaultStyle);
        StyleConstants.setForeground(purpleStyle, new Color(0x9876AA));
        greenStyle = styledDocument.addStyle("green", defaultStyle);
        StyleConstants.setForeground(greenStyle, new Color(0x5F864A));
        blueStyle = styledDocument.addStyle("blue", defaultStyle);
        StyleConstants.setForeground(blueStyle, new Color(0x5595BB));
        updateModel(countChars(codeArea.getText(), '\n'), numberArea);
        codeArea.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                //When you type \n or when you paste something remove \r characters
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_V) {
                    int position = codeArea.getCaretPosition();
                    codeArea.setText(codeArea.getText().replaceAll("\r", ""));
                    codeArea.setCaretPosition(position);
                }
                updateModel(countChars(codeArea.getText(), '\n'), numberArea);
                highlight(codeArea.getText());
            }
        });
        compilarButton.addActionListener(e -> compile(codeArea.getText()));
    }

    public static void main(String[] argv) {
        try {
            UIManager.setLookAndFeel(DarculaLookAndFeelInfo.CLASS_NAME);
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame("Swift to Java Compiler");
            mainFrame.pack();
            mainFrame.setVisible(true);
        });
    }

    private int countChars(String text, char ch) {
        if (text.equals("")) {
            return 0;
        }
        int i = 1;
        for (int c = 0; c < text.length(); c++) {
            if (text.charAt(c) == ch) {
                i++;
            }
        }
        return i;
    }

    private void highlight(String text) {
        ANTLRInputStream input = new ANTLRInputStream(text);
        // create a lexer that feeds off of input CharStream
        swiftLexer lexer = new swiftLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        swiftParser parser = new swiftParser(tokens);
        ParseTree tree = parser.top_level(); // begin parsing at init rule
        HighlightVisitor highlightVisitor = new HighlightVisitor(codeArea.getText(), styledDocument, orangeStyle,
                greenStyle, purpleStyle, yellowStyle, defaultStyle, blueStyle);
        highlightVisitor.visit(tree);
    }

    private void compile(String text) {
        if (process != null && process.isAlive()) {
            process.destroy();
            return;
        }
        ANTLRInputStream input = new ANTLRInputStream(text);
        // create a lexer that feeds off of input CharStream
        swiftLexer lexer = new swiftLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        swiftParser parser = new swiftParser(tokens);
        ParseTree tree = parser.top_level(); // begin parsing at init rule
        MethodAnalizer methodAnalizer = new MethodAnalizer("Swift");
        methodAnalizer.visit(tree);
        BCELVisitor visitor = new BCELVisitor("Swift", methodAnalizer.declaredMethods);
        try {
            visitor.visit(tree);
            JavaClass javaClass = visitor.getJavaClass();
            for (Method method : javaClass.getMethods()) {
                System.out.println(method.getName() + "\n" + method.getCode().toString());
            }
            try {
                javaClass.dump("Swift.class");
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                try {
                    process = Runtime.getRuntime().exec("java -classpath . Swift",
                            null, new File("").getAbsoluteFile());
                    long time = System.currentTimeMillis();
                    compilarButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/stop_white.png")));
                    consoleArea.setText("");
                    consoleArea.setText("Program running...\n");
                    Scanner scanner = new Scanner(process.getInputStream());
                    Scanner error = new Scanner(process.getErrorStream());
                    while (process.isAlive()) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            consoleArea.append(line + "\n");
                            consoleArea.setCaretPosition(consoleArea.getText().length());
                        }
                        while (error.hasNextLine()) {
                            String line = error.nextLine();
                            consoleArea.append(line + "\n");
                            consoleArea.setCaretPosition(consoleArea.getText().length());
                        }
                    }
                    time = System.currentTimeMillis() - time;
                    compilarButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/run_white.png")));
                    if (process.exitValue() == 0) {
                        consoleArea.append("\nProgram Finished Successfully!!\n");
                    } else {
                        consoleArea.append("\nProgram exited with value " + process.exitValue() + "\n");
                    }
                    consoleArea.append(timeToString(time) + "\n");
                    consoleArea.setCaretPosition(consoleArea.getText().length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (RuntimeException e) {
            consoleArea.setText(e.getMessage());
            e.printStackTrace();
        }
    }

    private String timeToString(long time) {
        long min = time / (1000 * 60);
        long secs = time / 1000 - min * 60;
        return min + " MIN " + ((secs < 10) ? "0" : "") + secs + " SEC";
    }

    private void updateModel(Integer line, JTextArea model) {
        while (model.getLineCount() - 1 < line) {
            model.append(model.getLineCount() + "\n");
        }
        if (model.getLineCount() - 1 > line) {
            try {
                model.replaceRange("", model.getLineEndOffset(line - 1), model.getLineEndOffset(model.getLineCount() - 1));
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}
