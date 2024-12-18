import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class ProjectGUI extends JFrame implements ActionListener, ItemListener {

    public Build palette;
    public DrawPalette drawPalette;
    public int activeColor;
    public Map<JRadioButton, Integer> activeButtonsMap;
    JPanel colorSelectionPanel;
    JPanel colorPalettePanel;
    JPanel colorPalette;
    JRadioButton color1Active;
    JRadioButton color2Active;
    JRadioButton color3Active;
    JCheckBox color1Select;
    JCheckBox color2Select;
    JCheckBox color3Select;
    JTextField setRed;
    JTextField setGreen;
    JTextField setBlue;
    JTextField changeRed;
    JTextField changeGreen;
    JTextField changeBlue;
    JTextField scaleRed;
    JTextField scaleGreen;
    JTextField scaleBlue;
    JButton calculateRGB;
    JTextField setHue;
    JTextField setSaturation;
    JTextField setBrightness;
    JTextField changeHue;
    JTextField changeSaturation;
    JTextField changeBrightness;
    JTextField scaleSaturation;
    JTextField scaleBrightness;
    JButton calculateHSB;

    public ProjectGUI(){
        this.palette = new Build(3);
        palette.setColor(0, Color.white);
        palette.setColor(1, Color.gray);
        this.drawPalette = new DrawPalette(palette, 20, 0, 0);
        this.activeColor = 0;
        this.activeButtonsMap = new HashMap<>();

        setSize(640, 420);
        setTitle("Color Alchemy Project");
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout threeByOne = new GridLayout(3, 1);
        Dimension inputRGBDimension = new Dimension(50,20);
        Dimension inputHSBDimension = new Dimension(80, 20);

        colorSelectionPanel = new JPanel();
        colorSelectionPanel.setLayout(new BoxLayout(colorSelectionPanel, BoxLayout.Y_AXIS));
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

        //GridBagLayout paletteLayout = new GridBagLayout();
        //paletteLayout.setConstraints(this, constraints);
        colorPalettePanel = new JPanel(new GridLayout(2,1));
        colorPalettePanel.add(new JLabel("Current Palette"));
        colorPalettePanel.setPreferredSize(new Dimension(320, 100));
        colorPalettePanel.setBorder(new LineBorder(Color.blue));
        colorPalette = new JPanel(new FlowLayout());
        //colorPalette.add(drawPalette);
        //drawPalette.setPreferredSize(new Dimension(200, 24));
        //colorPalettePanel.add(colorPalette);
        //colorSelectionPanel.add(colorPalettePanel);
        
        //draw();
        /* 
        colorPalettePanel.add(colorPalette);
        colorSelectionPanel.add(colorPalettePanel);
        
        */
        add(colorSelectionPanel);
        /* 
        JPanel selectedColorPanel = new JPanel();
        color1Select = new JCheckBox();
        color2Select = new JCheckBox();
        color3Select = new JCheckBox();
        selectedColorPanel.add(color1Select);
        selectedColorPanel.add(color2Select);
        selectedColorPanel.add(color3Select);
        selectedColorPanel.setBorder(new TitledBorder("Selected color(s)"));
        
        colorSelectionPanel.add(selectedColorPanel);
        */

        calculateRGB = new JButton("Calculate");
        //calculateRGB.setBounds(50, 150, 95, 30);
        calculateRGB.addActionListener(this);

        calculateHSB = new JButton("Calculate");
        //calculateHSB.setBounds()
        calculateHSB.addActionListener(this);

        //colorSelectionPanel.add(calculateRGB);
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
        JPanel rgbPane = new JPanel(new GridLayout(4,1));

        JPanel rgbSetValues = new JPanel(threeByOne);
        rgbSetValues.setBorder(new TitledBorder("Set values ----- (0, 255)"));
        setRed = new JTextField(Integer.toString(palette.getR(activeColor))); 
        setGreen = new JTextField(Integer.toString(palette.getG(activeColor))); 
        setBlue = new JTextField(Integer.toString(palette.getB(activeColor))); 
        JPanel setRedPanel = new JPanel();
        JPanel setGreenPanel = new JPanel();
        JPanel setBluePanel = new JPanel();
        setRedPanel.add(new JLabel("R:"));
        setRedPanel.add(setRed);
        setGreenPanel.add(new JLabel("G:"));
        setGreenPanel.add(setGreen);
        setBluePanel.add(new JLabel("B:"));
        setBluePanel.add(setBlue);
        rgbSetValues.add(setRedPanel);
        rgbSetValues.add(setGreenPanel);
        rgbSetValues.add(setBluePanel);
        /*
        rgbSetValues.add(new JLabel("R:"));
        rgbSetValues.add(setRed);
        rgbSetValues.add(new JLabel("G:"));
        rgbSetValues.add(setGreen);
        rgbSetValues.add(new JLabel("B:"));
        rgbSetValues.add(setBlue);
        */
        setRed.setPreferredSize(inputRGBDimension);
        setGreen.setPreferredSize(inputRGBDimension);
        setBlue.setPreferredSize(inputRGBDimension);
        //rgbSetValues.setPreferredSize(new Dimension(250, 50));

        JPanel rgbChangeValues = new JPanel(threeByOne);
        rgbChangeValues.setBorder(new TitledBorder("Shift values ----- (-255, 255)"));
        changeRed = new JTextField(); 
        changeGreen = new JTextField(); 
        changeBlue = new JTextField(); 
        JPanel changeRedPanel = new JPanel();
        JPanel changeGreenPanel = new JPanel();
        JPanel changeBluePanel = new JPanel();
        changeRedPanel.add(new JLabel("R:"));
        changeRedPanel.add(changeRed);
        changeGreenPanel.add(new JLabel("G:"));
        changeGreenPanel.add(changeGreen);
        changeBluePanel.add(new JLabel("B:"));
        changeBluePanel.add(changeBlue);
        rgbChangeValues.add(changeRedPanel);
        rgbChangeValues.add(changeGreenPanel);
        rgbChangeValues.add(changeBluePanel);
        changeRed.setPreferredSize(inputRGBDimension);
        changeGreen.setPreferredSize(inputRGBDimension);
        changeBlue.setPreferredSize(inputRGBDimension);


        JPanel rgbScaleValues = new JPanel(threeByOne);
        rgbScaleValues.setBorder(new TitledBorder("Scale values"));
        scaleRed = new JTextField(); 
        scaleGreen = new JTextField(); 
        scaleBlue = new JTextField(); 
        JPanel scaleRedPanel = new JPanel();
        JPanel scaleGreenPanel = new JPanel();
        JPanel scaleBluePanel = new JPanel();
        scaleRedPanel.add(new JLabel("R:"));
        scaleRedPanel.add(scaleRed);
        scaleGreenPanel.add(new JLabel("G:"));
        scaleGreenPanel.add(scaleGreen);
        scaleBluePanel.add(new JLabel("B:"));
        scaleBluePanel.add(scaleBlue);
        rgbScaleValues.add(scaleRedPanel);
        rgbScaleValues.add(scaleGreenPanel);
        rgbScaleValues.add(scaleBluePanel);
        scaleRed.setPreferredSize(inputRGBDimension);
        scaleGreen.setPreferredSize(inputRGBDimension);
        scaleBlue.setPreferredSize(inputRGBDimension);

        rgbPane.add(rgbSetValues);
        rgbPane.add(rgbChangeValues);
        rgbPane.add(rgbScaleValues);

        rgbPane.add(calculateRGB);

        colorTabbedPane.add("Modify Active RGB", rgbPane);

        JPanel hsbPane = new JPanel(new GridLayout(4,1));
        JPanel hsbSetValues = new JPanel(threeByOne);
        hsbSetValues.setBorder(new TitledBorder("Set Hue, Saturation, Brightness ----- (0.0, 1.0)"));
        setHue = new JTextField(Float.toString(palette.getHue(activeColor)));
        setSaturation = new JTextField(Float.toString(palette.getSaturation(activeColor)));
        setBrightness = new JTextField(Float.toString(palette.getBrightness(activeColor)));
        JPanel setHuePanel = new JPanel();
        JPanel setSaturationPanel = new JPanel();
        JPanel setBrightnessPanel = new JPanel();
        setHuePanel.add(new JLabel("H:"));
        setHuePanel.add(setHue);
        setSaturationPanel.add(new JLabel("S:"));
        setSaturationPanel.add(setSaturation);
        setBrightnessPanel.add(new JLabel("B:"));
        setBrightnessPanel.add(setBrightness);
        setHue.setPreferredSize(inputHSBDimension);
        setSaturation.setPreferredSize(inputHSBDimension);
        setBrightness.setPreferredSize(inputHSBDimension);
        hsbSetValues.add(setHuePanel);
        hsbSetValues.add(setSaturationPanel);
        hsbSetValues.add(setBrightnessPanel);


        JPanel hsbChangeValues = new JPanel(threeByOne);
        hsbChangeValues.setBorder(new TitledBorder("Shift values ----- (-1.0, 1.0)"));
        changeHue = new JTextField(); 
        changeSaturation = new JTextField(); 
        changeBrightness = new JTextField(); 
        changeHue.setPreferredSize(inputHSBDimension);
        changeSaturation.setPreferredSize(inputHSBDimension);
        changeBrightness.setPreferredSize(inputHSBDimension);
        JPanel changeHuePanel = new JPanel();
        JPanel changeSaturationPanel = new JPanel();
        JPanel changeBrightnessPanel = new JPanel();
        changeHuePanel.add(new JLabel("H:"));
        changeHuePanel.add(changeHue);
        changeSaturationPanel.add(new JLabel("S:"));
        changeSaturationPanel.add(changeSaturation);
        changeBrightnessPanel.add(new JLabel("B:"));
        changeBrightnessPanel.add(changeBrightness);
        hsbChangeValues.add(changeHuePanel);
        hsbChangeValues.add(changeSaturationPanel);
        hsbChangeValues.add(changeBrightnessPanel);

        JPanel hsbScaleValues = new JPanel(new GridLayout(2,1));
        scaleSaturation = new JTextField();
        scaleBrightness = new JTextField();
        scaleSaturation.setPreferredSize(inputHSBDimension);
        scaleBrightness.setPreferredSize(inputHSBDimension);
        JPanel scaleSaturationPanel = new JPanel();
        JPanel scaleBrightnessPanel = new JPanel();
        scaleSaturationPanel.add(new JLabel("S:"));
        scaleSaturationPanel.add(scaleSaturation);
        scaleBrightnessPanel.add(new JLabel("B:"));
        scaleBrightnessPanel.add(scaleBrightness);
        hsbScaleValues.add(scaleSaturationPanel);
        hsbScaleValues.add(scaleBrightnessPanel);
        hsbScaleValues.setBorder(new TitledBorder("Scale Saturation, Brightness values"));


        hsbPane.add(hsbSetValues);
        hsbPane.add(hsbChangeValues);
        hsbPane.add(hsbScaleValues);
        hsbPane.add(calculateHSB);

        colorTabbedPane.add("Modify Active HSB", hsbPane);
        add(colorTabbedPane);
        
    
        setVisible(true);

    }

    public void clearPalette(){
        colorPalette.removeAll();
    }

    public void draw(){
        for (int i = 0; i < palette.getSize(); i++) {
            DrawSquare square = new DrawSquare(palette.getColor(i), 0, 0, 100);
            square.setPreferredSize(new Dimension(24, 24));
            square.setBorder(new LineBorder(Color.green));
            colorPalette.add(square);
        }
        colorPalettePanel.add(colorPalette);
        colorSelectionPanel.add(colorPalettePanel);
        add(colorSelectionPanel);

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
            setHue.setText(Float.toString(palette.getHue(activeColor)));
            setSaturation.setText(Float.toString(palette.getSaturation(activeColor)));
            setBrightness.setText(Float.toString(palette.getBrightness(activeColor)));

        }
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        if (evt.getSource() == calculateRGB) {
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
                
                //colorPalette.repaint();
                //clearPalette();
                //draw();
                palette.printColor(activeColor);
            } catch (Exception E){

            }
        }
        if (evt.getSource() == calculateHSB) {
            try {
                // Set HSB
                try {
                    if (setHue.getText() != null) {
                        palette.setHue(activeColor, getFloat(setHue));
                    }
                } catch (Exception e) {
                }
                try {
                    if (setSaturation.getText() != null) {
                        palette.setSaturation(activeColor, getFloat(setSaturation));
                    }
                } catch (Exception e) {
                }
                try {
                    if (setBrightness.getText() != null) {
                        palette.setBrightness(activeColor, getFloat(setBrightness));
                    }
                } catch (Exception e) {
                }

                // Shift HSB
                try {
                    if (changeHue.getText() != null) {
                        palette.changeHue(activeColor, getFloat(changeHue));
                        changeHue.setText("");
                    }
                } catch (Exception e) {
                }          
                try {
                    if (changeSaturation.getText() != null) {
                        palette.changeSaturation(activeColor, getFloat(changeSaturation));
                        changeSaturation.setText("");
                    }
                } catch (Exception e) {
                }              
                try {
                    if (changeBrightness.getText() != null) {
                        palette.changeBrightness(activeColor, getFloat(changeBrightness));
                        changeBrightness.setText("");
                    }
                } catch (Exception e) {
                } 

                // Scale Saturation Brightness
                try {
                    if (scaleSaturation.getText() != null) {
                        palette.scaleSaturation(activeColor, getFloat(scaleSaturation));
                        scaleSaturation.setText("");
                    }
                } catch (Exception e) {
                }       
                try {
                    if (scaleBrightness.getText() != null) {
                        palette.scaleBrightness(activeColor, getFloat(scaleBrightness));
                        scaleBrightness.setText("");
                    }
                } catch (Exception e) {
                }       
                
                setHue.setText(Float.toString(palette.getHue(activeColor)));
                setSaturation.setText(Float.toString(palette.getSaturation(activeColor)));
                setBrightness.setText(Float.toString(palette.getBrightness(activeColor)));

                drawPalette.repaint();
                //colorPalette.repaint();
                //clearPalette();
                //draw();
                palette.printColor(activeColor);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        new ProjectGUI();
    }
}
