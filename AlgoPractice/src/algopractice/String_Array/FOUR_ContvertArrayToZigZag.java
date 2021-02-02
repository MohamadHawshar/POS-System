/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algopractice.String_Array;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class FOUR_ContvertArrayToZigZag {
    
    public static void zig(int[] table){
        int swtch = 0;
        int temp;
        
        for(int i=0;i<table.length-1;i++){
            if(swtch == 0){
                swtch=1;
                if(table[i] > table[i+1]){
                 temp = table[i];
                 table[i]=table[i+1];
                 table[i+1]=temp;
                }
            }else{
                swtch=0;
                if(table[i] < table[i+1]){
                 temp = table[i];
                 table[i]=table[i+1];
                 table[i+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(table));
        
    }
    
    public static void main(String[] args) {
        int[] table = {1, 4, 3, 2};
        zig(table);
    
    }
    
}
