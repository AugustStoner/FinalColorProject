import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.TitledBorder;




public class ProjectGUI extends JFrame implements ActionListener, ItemListener {

    public Build palette;
    public DrawPalette drawPalette;
    public int activeColor;
    public Map<JRadioButton, Integer> activeButtonsMap;
    JRadioButton color1Active;
    JRadioButton color2Active;
    JRadioButton color3Active;
    JTextField setRed;
    JTextField setGreen;
    JTextField setBlue;
    JTextField changeRed;
    JTextField changeGreen;
    JTextField changeBlue;
    JTextField scaleRed;
    JTextField scaleGreen;
    JTextField scaleBlue;
    JButton calculate;

    public ProjectGUI(){
        this.palette = new Build(3);
        palette.setColor(0, Color.white);
        palette.setColor(1, Color.gray);
        this.drawPalette = new DrawPalette(palette, 20, 120, 50);
        this.activeColor = 0;
        this.activeButtonsMap = new HashMap<>();

        setSize(640, 400);
        setTitle("Color Alchemy Project");
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout threeByOne = new GridLayout(3, 1);

        JPanel colorSelectionPanel = new JPanel();
        colorSelectionPanel.setLayout(new GridLayout(3,1));
        JPanel activeColorPanel = new JPanel();
        color1Active = new JRadioButton("", true);
        color2Active = new JRadioButton();
        color3Active = new JRadioButton();
        ButtonGroup activeButtonGroup = new ButtonGroup();
        activeButtonGroup.add(color1Active);
        activeButtonGroup.add(color2Active);
        activeButtonGroup.add(color3Active);

        activeButtonsMap.put(color1Active, 0);
        activeButtonsMap.put(color2Active, 1);
        activeButtonsMap.put(color3Active, 2);

        color1Active.addItemListener(this);
        color2Active.addItemListener(this);
        color3Active.addItemListener(this);

        activeColorPanel.add(color1Active);
        activeColorPanel.add(color2Active);
        activeColorPanel.add(color3Active);
        activeColorPanel.setBorder(new TitledBorder("Active color"));
        colorSelectionPanel.add(activeColorPanel);
        
        colorSelectionPanel.add(drawPalette);

        calculate = new JButton("Calculate");
        calculate.setBounds(50, 150, 95, 30);
        calculate.addActionListener(this);

        colorSelectionPanel.add(calculate);
        /*
        JPanel selectedColorPanel = new JPanel();
        JCheckBox selectionCheckBox1 = new JCheckBox();
        JCheckBox selectionCheckBox2 = new JCheckBox();
        JCheckBox selectionCheckBox3 = new JCheckBox();
        selectedColorPanel.add(selectionCheckBox1);
        selectedColorPanel.add(selectionCheckBox2);
        selectedColorPanel.add(selectionCheckBox3);
        selectedColorPanel.setBorder(new TitledBorder("Selected color(s)"));
        colorSelectionPanel.add(selectedColorPanel);
        */
        add(colorSelectionPanel);
        


        //JTabbedPane colorProfile = new JTabbedPane();
        //colorProfile.setLayout(new GridLayout(2, 1));
        /* 
        JPanel hsbPanel = new JPanel();
        JPanel rgbPanel = new JPanel();
        hsbPanel.add(new JLabel("Modifiers for Color Mixing"));
        rgbPanel.add(new JLabel("Modifiers for Color Mixing"));
        String[] hsbListItems = new String[] {"Hue", "Saturation", "Brightness"};
        String[] rgbListItems = new String[] {"Red", "Green", "Blue"};
        JList<String> hsbList = new JList<>(hsbListItems);
        JList<String> rgbList = new JList<>(rgbListItems);
        hsbPanel.add(hsbList);
        rgbPanel.add(rgbList);
        colorProfile.addTab("HSB", hsbPanel);
        colorProfile.addTab("RGB", rgbPanel);
        add(colorProfile);
        */

        

        JTabbedPane colorTabbedPane = new JTabbedPane();
        JPanel rgbPane = new JPanel(threeByOne);
        JPanel rgbSetValues = new JPanel(threeByOne);
        rgbSetValues.setBorder(new TitledBorder("Set values ----- (0, 255)"));
        setRed = new JTextField(Integer.toString(palette.getR(activeColor))); 
        setGreen = new JTextField(Integer.toString(palette.getG(activeColor))); 
        setBlue = new JTextField(Integer.toString(palette.getB(activeColor))); 
        rgbSetValues.add(setRed);
        rgbSetValues.add(setGreen);
        rgbSetValues.add(setBlue);
        JPanel rgbChangeValues = new JPanel(threeByOne);
        rgbChangeValues.setBorder(new TitledBorder("Shift values ----- (-255, 255)"));
        changeRed = new JTextField(); 
        changeGreen = new JTextField(); 
        changeBlue = new JTextField(); 
        rgbChangeValues.add(changeRed);
        rgbChangeValues.add(changeGreen);
        rgbChangeValues.add(changeBlue);
        JPanel rgbScaleValues = new JPanel(threeByOne);
        rgbScaleValues.setBorder(new TitledBorder("Scale values"));
        scaleRed = new JTextField(); 
        scaleGreen = new JTextField(); 
        scaleBlue = new JTextField(); 
        rgbScaleValues.add(scaleRed);
        rgbScaleValues.add(scaleGreen);
        rgbScaleValues.add(scaleBlue);

        rgbPane.add(rgbSetValues);
        rgbPane.add(rgbChangeValues);
        rgbPane.add(rgbScaleValues);

        colorTabbedPane.add("Modify Active RGB", rgbPane);
        add(colorTabbedPane);
    
        setVisible(true);

    }

    public int getInt(JTextField text){
        return Integer.parseInt(text.getText());
    }

    public float getFloat(JTextField text){
        return Float.parseFloat(text.getText());
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED) {
            activeColor = activeButtonsMap.get(e.getSource()); // add try/catch block
            setRed.setText(Integer.toString(palette.getR(activeColor)));
            setGreen.setText(Integer.toString(palette.getG(activeColor)));
            setBlue.setText(Integer.toString(palette.getB(activeColor)));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource() == calculate) {
            try {
                // Set RGB
                try {
                    if (setRed.getText() != null) {
                        palette.setR(activeColor, getInt(setRed));
                    }
                } catch (Exception e) {
                }
                try {
                    if (setGreen.getText() != null) {
                        palette.setG(activeColor, getInt(setGreen));
                    }
                } catch (Exception e) {
                }
                try {
                    if (setBlue.getText() != null) {
                        palette.setB(activeColor, getInt(setBlue));
                    }
                } catch (Exception e) {
                }

                // Shift RGB
                try {
                    if (changeRed.getText() != null) {
                        palette.changeR(activeColor, getInt(changeRed));
                        changeRed.setText("");
                    }
                } catch (Exception e) {
                }          
                try {
                    if (changeGreen.getText() != null) {
                        palette.changeG(activeColor, getInt(changeGreen));
                        changeGreen.setText("");
                    }
                } catch (Exception e) {
                }              
                try {
                    if (changeBlue.getText() != null) {
                        palette.changeB(activeColor, getInt(changeBlue));
                        changeBlue.setText("");
                    }
                } catch (Exception e) {
                } 

                // Scale RGB
                try {
                    if (scaleRed.getText() != null) {
                        palette.scaleR(activeColor, getFloat(scaleRed));
                        scaleRed.setText("");
                    }
                } catch (Exception e) {
                }       
                try {
                    if (scaleGreen.getText() != null) {
                        palette.scaleG(activeColor, getFloat(scaleGreen));
                        scaleGreen.setText("");
                    }
                } catch (Exception e) {
                }       
                try {
                    if (scaleBlue.getText() != null) {
                        palette.scaleB(activeColor, getFloat(scaleBlue));
                        scaleBlue.setText("");
                    }
                } catch (Exception e) {
                }
                
                setRed.setText(Integer.toString(palette.getR(activeColor)));
                setGreen.setText(Integer.toString(palette.getG(activeColor)));
                setBlue.setText(Integer.toString(palette.getB(activeColor)));

                drawPalette.repaint();
                palette.printColor(activeColor);
            } catch (Exception E){

            }
        }
    }

    public static void main(String[] args) {
        new ProjectGUI();
    }
}
