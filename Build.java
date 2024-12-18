import java.awt.Color;
import java.util.ArrayList;


public class Build {
    
    private final ArrayList<Color> palette;
    private final int maxSize;

    public Build(int size) {
        this.maxSize = size;
        this.palette = new ArrayList<>(size);
        for (int i = 0; i < this.maxSize; i++) {
            this.palette.add(Color.black);
        }
    }

    /****************/
    /*   Setters    */
    /****************/

    public void setColor(int i, int r, int g, int b){
        Color newColor = new Color(r, g, b);
        palette.set(i, newColor);
    }

    public void setColor(int i, Color newColor){
        palette.set(i, newColor);
    }

    public void setR(int i, int r){
        setColor(i, r, getG(i), getB(i));
    }

    public void setG(int i, int g){
        setColor(i, getR(i), g, getB(i));
    }

    public void setB(int i, int b){
        setColor(i, getR(i), getG(i), b);
    }

    // hue float in range 0.0 to 1.0
    public void setHue(int i, float hue){
        if ((hue < 0.0) || (hue > 1.0)) { hue = 0.0f; }
        Color newColor = Color.getHSBColor(hue, getSaturation(i), getBrightness(i));
        setColor(i, newColor);
    }

    // saturation float in range 0.0 to 1.0
    public void setSaturation(int i, float saturation){
        if (saturation < 0.0) { saturation = 0.0f; }
        if (saturation > 1.0) { saturation = 1.0f; }
        Color newColor = Color.getHSBColor(getHue(i), saturation, getBrightness(i));
        setColor(i, newColor);
    }

    // value float in range 0.0 to 1.0
    public void setBrightness(int i, float value){
        if (value < 0.0) { value = 0.0f; }
        if (value > 1.0) { value = 1.0f; }
        Color newColor = Color.getHSBColor(getHue(i), getSaturation(i), value);
        setColor(i, newColor);
    }

    /*****************/
    /*   Modifiers   */
    /*****************/

    public void changeR(int i, int xr){
        int r = getR(i);
        if (((r + xr) <= 255) && ((r + xr) > 0)) { r += xr; }
        else if ((r + xr) <= 0) { r = 0; }
        else { r = 255; }
        
        setR(i, r);
    }

    public void changeG(int i, int xg){
        int g = getG(i);
        if (((g + xg) <= 255) && ((g + xg) > 0)) { g += xg; }
        else if ((g + xg) <= 0) { g = 0; }
        else { g = 255; }
        
        setG(i, g);
    }

    public void changeB(int i, int xb){
        int b = getB(i);
        if (((b + xb) <= 255) && ((b + xb) > 0)) { b += xb; }
        else if ((b + xb) <= 0) { b = 0; }
        else { b = 255; }
        setB(i, b);
    }
    
    public void scaleR(int i, float k){
        int r = getR(i);
        if ((Math.round(r*k) <= 255) && (Math.round(r*k) > 0)) { r = Math.round(r*k); }
        else if (Math.round(r*k) <= 0) { r = 0; }
        else { r = 255; }
        setR(i, r);
    }

    public void scaleG(int i, float k){
        int g = getG(i);
        if ((Math.round(g*k) <= 255) && (Math.round(g*k) > 0)) { g = Math.round(g*k); }
        else if (Math.round(g*k) <= 0) { g = 0; }
        else { g = 255; }
        setG(i, g);
    }

    public void scaleB(int i, float k){
        int b = getB(i);
        if ((Math.round(b*k) <= 255) && (Math.round(b*k) > 0)) { b = Math.round(b*k); }
        else if (Math.round(b*k) <= 0) { b = 0; }
        else { b = 255; }
        setB(i, b);
    }

    public void scaleSaturation(int i, float k){
        float sat = getSaturation(i)*k;
        setSaturation(i, sat);
    }

    public void scaleBrightness(int i, float k){
        float value = getBrightness(i)*k;
        setBrightness(i, value);
    }

    public void scaleValue(int i, float k){
        scaleR(i, k);
        scaleG(i, k);
        scaleB(i, k);
    }

    public void changeHue(int i, float x){
        float hue = getHue(i) + x;
        setHue(i, hue);
    }

    public void changeSaturation(int i, float x){
        float sat = getSaturation(i) + x;
        setSaturation(i, sat);
    }

    public void changeBrightness(int i, float x){
        float value = getBrightness(i);
        setBrightness(i, value);
    }

    public void changeValue(int i, int x){
        changeR(i, x);
        changeG(i, x);
        changeB(i, x);
    }
    
    public void changeWarmth(int i, int x){
        changeR(i, x);  // pos x increases warmth, negative decreases warmth
        changeB(i, -x);
    }

    /****************/
    /*   Getters    */
    /****************/

    public Color getColor(int i){
        return palette.get(i);
    }

    public int getR(int i){
        return palette.get(i).getRed();
    }

    public int getG(int i){
        return palette.get(i).getGreen();
    }

    public int getB(int i){
        return palette.get(i).getBlue();
    }

    public float[] getHSB(int i){
        return Color.RGBtoHSB(getR(i), getG(i), getB(i), null);
    }

    public float getHue(int i){
        float[] hsb = getHSB(i);
        return hsb[0];  
    }

    public float getSaturation(int i){
        float[] hsb = getHSB(i);
        return hsb[1];  
    }

    public float getBrightness(int i){
        float[] hsb = getHSB(i);
        return hsb[2];  
    }

    public int getSize(){ 
        return palette.size();
    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public void printColor(int i){
        System.out.println("(r:" + getR(i) + ", g:" + getG(i) + ", b:" + getB(i) + ")");
    }


    public static void main(String[] args) {

        Build newPalette = new Build(5);
        newPalette.setColor(0, 125, 120, 70);
        newPalette.setColor(1, 240,10,10);
        newPalette.setColor(2, 10, 60, 180);
        newPalette.setColor(3, 128, 128, 128);
        newPalette.printColor(0);
        Color orange = Color.orange;
        newPalette.setColor(4, orange);
        newPalette.printColor(4);
            
    }

}
