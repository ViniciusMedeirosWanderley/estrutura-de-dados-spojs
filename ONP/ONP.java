package ONP;

import java.io.*;

class ONP {
    
    static class Pilha{
        private int topo = -1;
        private char[] pilha = new char[401];
        
        public void push(char dado){
            pilha[++topo] = dado;
        }
        
        public char pop(){
            char letra = pilha[topo];
            topo--;
            return letra;
        }
    }
    
    public static void main(String[] args) throws IOException{

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
            int quantidade = Integer.parseInt(reader.readLine());
            String[] string = new String[quantidade];
 
            for(int i = 0; i < quantidade; i++){
                string[i] = "";
                String aux = reader.readLine();
                int tamanho = aux.length();
 
                char[] expressão = aux.toCharArray();
                Pilha pilha = new Pilha();
 
                for(int j = 0; j < tamanho; j++){
                    if(Character.isAlphabetic(expressão[j])){
                        string[i] += expressão[j];
 
                    }else if(expressão[j] == '('){
                        pilha.push('(');
 
                    }else if(expressão[j] == ')'){
                        while(pilha.pilha[pilha.topo] != '('){
                            string[i] += pilha.pop();
                        }
 
                        pilha.pop();
 
                    }else if(expressão[j] == '^'){
                        while(pilha.pilha[pilha.topo] == '^'){
                            string[i] += pilha.pop();
                        }
 
                        pilha.push(expressão[j]);
 
                    }else if(expressão[j] == '/' || expressão[j] == '*'){
                        while(pilha.pilha[pilha.topo] == '/' || pilha.pilha[pilha.topo] == '*' ||
                                pilha.pilha[pilha.topo] == '^'){
                            string[i] += pilha.pop();
                        }
 
                        pilha.push(expressão[j]);
 
                    }else if(expressão[j] == '+'|| expressão[j] == '-'){
                        while(pilha.pilha[pilha.topo] != '('){
                            string[i] += pilha.pop();
                        }
 
                        pilha.push(expressão[j]);
                    }
                }
            }
 
 
            for(int i = 0; i < quantidade; i++){
                System.out.println(string[i]);
            }
        }catch(Exception e){
        	System.out.println(e.toString());
        }
    }
}