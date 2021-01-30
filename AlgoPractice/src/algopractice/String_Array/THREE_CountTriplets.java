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
public class THREE_CountTriplets {
    
    public static void countTriplets(int[] table , int count){
        int i,j,k,n= table.length;
        int ans =0;
        Arrays.sort(table);
        
        
        for(i=0;i<n-2;i++){
            j=i+1;
            k=n-1;
            while(j<k){
                if(table[i]+table[j]+table[k] >= count ){
                    k--;
                }else{
                    ans += (k-j);
                    j++;
                }
            }
            
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        int[] table = {7,8,5,6,1,3};
        countTriplets(table , 12);
    }
    
}
