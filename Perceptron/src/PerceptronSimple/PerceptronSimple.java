/* 
 * Copyright (C) 2016 Stelliox.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package PerceptronSimple;

 
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stelliox.com
 */
public class PerceptronSimple {
    double[] W;
    
    double θ = -0.4;
    final double E = 0.6;
    
    int count = 0;
    
    public PerceptronSimple(Integer[][] input, Integer[]output) {
        W = new double[input[0].length];
        System.out.println("*********************"); 
        for (int i = 0; i < W.length; i++) {
            W[i] =  new Random().nextDouble() / 2.5;
            System.out.println("* W"+i+" "+W[i]);
        }
        
        System.out.println("* θ: " + θ);
        System.out.println("*********************");
        
        System.out.println("Trainig success: "+trainig(input, output));
    }
    
    public boolean trainig(Integer[][] input, Integer[]output) {
        int i = 0;
        double y;
        int limit = 1000;
        while (i < input.length && count<limit) {     
            y = getY(input[i]);
            System.out.print("Input: "+Arrays.asList(input[i]));
            System.out.println(" Expected Value: "+Arrays.asList(output[i]));
            System.out.println("Output: "+y);
            System.out.println();
            if(y == output[i])
                i++;
            else {
                i = adjustment(input[i], output[i]);                
                count++;
            } 
        }
        
        return (count < limit);
    } 
    
    private int adjustment(Integer[] input, Integer output) {
        for (int i = 0; i < input.length; i++)
            W[i] = W[i]+ 2*E * input[i] * output;
        
        θ = θ + 2*E * output * (-1);
        
        System.out.println("*********************"); 
        System.out.println("*  Adjustment ("+count+")"); 
        for (int i = 0; i < W.length; i++) { 
            System.out.println("* W"+i+" "+W[i]);
        }
        
        System.out.println("* θ: " + θ);
        System.out.println("*********************");
        return 0;
    }
    
    private double getY(Integer[] input) {
        double wx, y;
        wx = 0;
        
        for (int i = 0; i < input.length; i++) { 
            wx +=  input[i]*W[i];
        }
        
        wx += (-1 * θ); 
        y = Math.tanh(wx);         
        y = (y >= 0) ? 1 : -1;
        
        return y;
    }
    
    public void test(Integer[][] input) {
        System.out.println("*********  TEST  *********");
        for (Integer[] r : input) {
           System.out.print("Input: "+Arrays.asList(r));
           System.out.println(" Output: "+getY(r));
        }
        System.out.println("**************************");
        
    }
}
