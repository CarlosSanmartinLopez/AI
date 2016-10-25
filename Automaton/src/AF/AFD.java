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
package AF;

/**
 *
 * @author Stelliox.com
 */
//Autómata Finito Determinista
public class AFD 
{
    private int[] input;
    private int count;
    private int actual;
    private int state;
    private int terminate;
	
    public AFD()
    {
        terminate = 1;
    }
    
    public void setInput(int[] input)
    {
        this.input = input;
    }
    
    public int getState()
    {
        state = process();
       
        if (state == 1) 
            System.out.println("Success");
        else
           System.out.println("Fail");
        
        return state;
    }
    
    private int process()
    {
        actual = 1;
        count = 0;
        while (true) 
        {
            if (count > input.length-1)
                break;
            
            switch(actual)
            {
                case 1:
                        switch(input[count])
                        {
                            case 0:
                                actual = 2;
                                break;
                            case 1:
                                actual = 1;
                                break;
                        }
                    break;
                case 2:
                        switch(input[count])
                        {
                            case 0:
                                actual = 1;
                                break;
                            case 1:
                                actual = 2;
                                break;
                        }
                    break;
            }
            count++;
        }
        return actual;
    }
    
    public static void main(String[] args) 
    {
        AFD a = new AFD();
        
        int[] inputA = new int[]{1,0,0,1};
            a.setInput(inputA);
        
        // success
        System.out.println(a.getState());
        
        int[] inputB = new int[]{1,0,0,1,0,1};
            a.setInput(inputB);
        // fail
        System.out.println(a.getState());
    }
}
