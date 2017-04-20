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
public class NormCalculator {
    
    public static double calcNormOne(double[] distanceVector){
        double magnitude = 0;
        for(double d: distanceVector){
            magnitude += d;
        }
        return magnitude;
    }
    
    public static double calcNormTwo(double[] distanceVector){
        double magnitude = 0;
        for(double d: distanceVector){
            magnitude += Math.pow(d, 2);
        }
        magnitude = Math.sqrt(magnitude);
        return magnitude;
    }
    
    public static double calcNormInf(double[] distanceVector){
        double magnitude = 0;
        for(double d: distanceVector){
            magnitude += Math.pow(d, 10);
        }
        magnitude = Math.pow(magnitude, 0.1);
        return magnitude;
    }
}
