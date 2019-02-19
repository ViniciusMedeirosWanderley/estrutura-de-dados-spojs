package nicebtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NiceBTree {

   
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
        
        int numberOfTestCases = Integer.parseInt(in.readLine());
        int[] bTeste = new int[numberOfTestCases];
        for(int i=0; i< numberOfTestCases ; i++){
            String testCase = in.readLine();
            
            if(testCase.equalsIgnoreCase("l")){
                bTeste[i] = 0;
                continue;
            }
            
            int a = 0, b = 0;
            boolean[] t = new boolean[testCase.length()];
            t[0] = true;
            for(char c : testCase.toCharArray()){
                if(c == 'n'){
                    a++;
                    t[a] = true;
                }else if(c == 'l'){
                    while(!t[a]){
                        a--;
                    }
                    t[a] = false;
                }
                
                b = Math.max(a, b);
            }
            
           bTeste[i] = b;
        }
        
        for(int i=0 ; i<numberOfTestCases;i++){
            System.out.println(bTeste[i]);
        }
    
    
    
    }
}
