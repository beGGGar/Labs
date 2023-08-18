package outdated;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 * Создание окна для вывода пользователей с помощью библиотеки swing
 * @author Разноглазов Никита ПИН-24
 *
 */
public class TestSwing {
    private static final Logger LOG = Logger.getLogger(TestSwing.class.getName());

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PanelCommon pc = new PanelCommon();
            frame.add(pc);
            pc.AddSmth("aaaaaa");
            


            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);

        });
    }
}

/**
 * Панель с текстовым полем
 * @author Разноглазов Никита ПИН-24
 *
 */
class PanelTextField extends JPanel {

    private JTextField textField;
    private JButton buttonRemove;
    private JPanel panelParent;

    public PanelTextField(JPanel panelParent, String str) {
        setLayout(new BorderLayout());
        this.panelParent = panelParent;
        
        textField = new JTextField(str);
        textField.setEditable(false);
        buttonRemove = new JButton("X");
        buttonRemove.addActionListener(e -> {
                PanelTextField.this.panelParent.remove(PanelTextField.this);
                PanelTextField.this.panelParent.revalidate();
                PanelTextField.this.panelParent.repaint();
            });

        add(textField, BorderLayout.CENTER);
        add(buttonRemove, BorderLayout.EAST);
    }

    public String getText() {
        return textField.getText();
    }
}
/**
 * Панель для списка
 * @author Разноглазов Никита ПИН-24
 *
 */
class PanelCommon extends JPanel {

    private JLabel label;

    private List<PanelTextField> panelTextFieldList = new ArrayList();

    private JPanel panelContainer;


    public PanelCommon() {
        setLayout(new BorderLayout());
        label = new JLabel("Тестовый заголовок");
        add(label, BorderLayout.NORTH);

        panelContainer = new JPanel() {
            @Override
            public void remove(Component comp) {
                panelTextFieldList.remove(comp);
                super.remove(comp);
            }
        };
         
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        add(new JScrollPane(panelContainer), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
    }
    
    /**
     * Добавление элемента в список
     * @param a
     */
    public void AddSmth(String a) {
    	SwingUtilities.invokeLater(() -> {
            PanelTextField panelTextField = new PanelTextField(panelContainer,a);
            panelTextFieldList.add(panelTextField);
            panelContainer.add(panelTextField);
            panelContainer.revalidate();
            PanelCommon.this.revalidate();
        });
    }
    
    
}