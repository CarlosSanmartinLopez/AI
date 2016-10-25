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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stelliox.com
 */
public class Test {
    public static void AND() {
        Integer[][] input = new Integer[][] {
            {1,1,1},  
            {1,1,-1},  
            {1,-1,1},  
            {-1,-1,-1},  
            {-1,1,1},  
            {-1,1,-1},  
        };
        
        Integer[] output = new Integer[] {
             1,
            -1,
            -1,
            -1,
            -1,
            -1,
        };
        
        PerceptronSimple p = new PerceptronSimple(input, output);   
        p.test(input);
    }
    
    public static void OR() {
        Integer[][] input = new Integer[][] {
            {1,1}, 
            {1,-1},
            {-1,1},
            {-1,-1}
        };
        
        Integer[] output = new Integer[] {
            1,
            1,
            1,
            -1
        };
        
        PerceptronSimple p = new PerceptronSimple(input, output);   
        p.test(input);
    }
    
    public static void main(String[] args) {         
        AND(); 
        //OR(); 
    }
}
