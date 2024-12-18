RGB values for colors can fall between 0 and 255.

Setting values for r,g,b will function with any integer, the program will automatically restrict out-of-range input.
Entering a value between 0 and 255 will replace the r,g, or b values for the active color(1-3).

Changing values will allow positive and negative integers, and the program will restrict out-of-range input.
 (if the change would cause the r,g, or b value to go below 0 or above 255, it will snap to either 0 or 255 as appropriate.)
Entering a value between -255 and 255 will combine that value with the r,g, or b value for the active color, and set that color as the new active color.

Scaling values functions best with floats or integers above 0, and will restrict input. 
The current r,g, or b value will be multiplied by the input float, and the result will be set as the new active color value. 


HSB values for colors can fall between 0.0 and 1.0

HSB values can be set individually with float values between 0.0 and 1.0, otherwise the input will be snapped to 0 or 1 as appropriate. 

Changing HSB values will add or subtract the input from the current active color's h,s, or b values. 
Floats between -1.0 and 1.0 work best.
Input will snap to 0.0 and 1.0 as appropriate if the change results in an out-of-range value.

Scaling saturation and brightness values will multiply the s or b values by the input, and set the active color's s or b values to the new color.
Scaling works best with floats or integers above 0. 
Input will snap to 0.0 and 1.0 as appropriate if the scaling causes an out-of-value range. 