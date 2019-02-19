package omwg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OMWG {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
        String entrada;
        String[] c;
        int T = Integer.parseInt(in.readLine());
        
        for(int i=0; i < T ; i++){
         entrada = in.readLine();
         c = new String[entrada.length()];
         c = entrada.split(" ");
         int valor1 = Integer.parseInt(c[0]), valor2 = Integer.parseInt(c[1]);
         
         System.out.println((2*valor1*valor2)-valor1-valor2);
        }
        
        
    }
    
}