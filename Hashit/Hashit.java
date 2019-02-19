/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashit;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{

    String hash[];
    int tamanhoHash=0;
    
    int hash(String chave){
        int i, h = 0;
        int n = chave.length();
        for(i=0 ; i<n ; i++){
            h+=(((int)chave.charAt(i))*(i+1));
        }

        return 19*h;
    }

    int Hash(String chave){
        return hash(chave)%101;
    }

    int find(String chave){
        int r = -1;
        for(int i=0;i<101;i++){
            if(hash[i]!=null && hash[i].equals(chave)){
                r = i;
                break;
            }
        }
        return r;
    }

    void insert(String chave){
        int r = find(chave);
        int j , key_hash = Hash(chave);
        if(r == -1){
            for(j=0 ; j<20 ; j++){
                
                r = (key_hash+j*(j+23)) % 101;
                if(hash[r] == null){
                    hash[r] = chave;
                    tamanhoHash++;
                    break;
                }
            }
        }
    }

    void delete(String chave){
        int r = find(chave);
        if( r != -1){
            hash[r]=null;
            tamanhoHash--;
        }
    }

    public static void main(String []args) throws IOException{
        new Main().run();
    }

    public void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tamanho = Integer.parseInt(br.readLine().trim());
        int n;
        String line, key, op, p[];
        
        while(tamanho-->0){
            hash=new String[101];
            tamanhoHash=0;
            n=Integer.parseInt(br.readLine().trim());
            while(n-->0){
                line=br.readLine().trim();
                p=line.split(":");
                if(p[0].equals("ADD")){
                    insert(p[1]);
                }else{
                    delete(p[1]);
                }
            }
            System.out.println(tamanhoHash);
            for(int i=0;i<101;i++){
                if(hash[i]!=null){
                    System.out.println(i+":"+hash[i]);
                }
            }
        }
    }
}
