/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algopractice.String_Array;

/**
 *
 * @author User
 */
public class AlgoPractice {

    public static void reverse(char str[]){
        int beg = 0, end, size;
        char tem;
        size = str.length;
        end = size-1;
        
        while(end>beg){
            if(!Character.isAlphabetic(str[beg])){
                beg++;
            }else{
            if(!Character.isAlphabetic(str[end])){
                end--;
            }
            else{
            tem = str[beg];
            str[beg]=str[end];
            str[end]=tem;
            end--;
            beg++;
            }
        }
        
    }System.out.println(str);
    }
    public static void main(String[] args) {
        String ss = "asdf$ETer5$";
        char s[]= ss.toCharArray();
        reverse(s);
    }
    
}
