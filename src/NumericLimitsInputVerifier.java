
import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * The MIT License
 *
 * Copyright 2017 Nikolas Laskaris.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author Nikolas Laskaris
 */
public class NumericLimitsInputVerifier extends InputVerifier {
    private int min;
    private int max;
    
    public NumericLimitsInputVerifier (int min, int max){
        this.min = min;
        this.max = max;
    }
            
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            int x = Integer.parseInt(text);
            if (x < min || x > max){
                throw new Exception();
            }
        }
        catch (Exception e) {
            input.setBackground(Color.cyan);
            JOptionPane.showMessageDialog(input, "Enter a valid integer (from " + min + " to " + max + ")");
            return false;
        }
        return true;
    }
    
    public boolean shouldYieldFocus(JComponent input) {
        return verify(input);
    }
}
