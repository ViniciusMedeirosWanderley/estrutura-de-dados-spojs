package TREEORD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

class Arvore{
    class No{
        private int conteúdo;
        private No filhoEsquerda;
        private No filhoDireita;
        
        public int getConteúdo(){
            return conteúdo;
        }
        
        public void setConteúdo(int c){
            conteúdo = c;
        }
        
        public No getFilhoEsquerda(){
            return filhoEsquerda;
        }
        
        public void setFilhoEsquerda(No n){
            filhoEsquerda = n;
        }
        
        public No getFilhoDireita(){
            return filhoDireita;
        }
        
        public void setFilhoDireita(No n){
            filhoDireita = n;
        }
        
    }    
    private No root; 
    private int tamanho;
    private int[] inOrder;
    private int[] postOrder;
    private int[] preOrder;
    private int preIndex;
    private int posIndex;
    
    public Arvore(int[] pre, int[] pos, int[] in, int s){
        preOrder = pre;
        inOrder = in;
        postOrder = pos;
        preIndex = 0;
        posIndex = 0;
        tamanho = s;
        
        root = construirArvore(0, tamanho);
    }
    
    //Use the inOrder and preOrder transversal to recreate the tree 
    private No construirArvore(int começo, int fim){
        if (começo > fim){
            return null;
        }
       
        No novoNo = new No();
        novoNo.setConteúdo(preOrder[preIndex++]);
  
        
        if (começo == fim){
            return novoNo;
        }
        
        int inIndex = buscaInOrder(começo, fim, novoNo.getConteúdo());
  
        novoNo.setFilhoEsquerda(construirArvore(começo, inIndex - 1)) ;
        novoNo.setFilhoDireita(construirArvore(inIndex + 1, fim)) ;
  
        return novoNo;
        
    }
    
    //Return the position of a certain valor in the inOrder traversal
    public int buscaInOrder(int começo, int fim, int valor) {
        int i;
        for (i = começo; i <= fim; i++) {
            if (inOrder[i] == valor){
                return i;
            }
        }
       
       return i;
    }
    
    //Return true if postOrder traveral of the tree created is the same as the one given by the user
    public boolean comparaPosOrder(){
        try{
           comparePostOrder(root);
           return true; 
        }catch (Exception e){
            return false;
        }
    }
    
    private void comparePostOrder(No n) throws Exception{
        if (n == null) 
            return;
        
        comparePostOrder(n.getFilhoEsquerda());
        comparePostOrder(n.getFilhoDireita());
        
        if(postOrder[posIndex++] != n.getConteúdo()){
            throw new Exception ("Exceção");
        }
    }
    
    
}

public class TREEORD {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        int[][]transversal = new int[3][n];
        int i; 
        
        String aux[]; 
                
        aux = in.readLine().split(" ");
        for(i = 0; i < n; i++){
            transversal[0][i] = Integer.parseInt(aux[i]);
        }
        
        aux = in.readLine().split(" ");
        for(i = 0; i < n; i++){
            transversal[1][i] = Integer.parseInt(aux[i]);
        }
        
        aux = in.readLine().split(" ");
        for(i = 0; i < n; i++){
            transversal[2][i] = Integer.parseInt(aux[i]);
        }
                
        Arvore arvoreBinária = new Arvore(transversal[0], transversal[1], transversal[2], n - 1);      
        
        if(arvoreBinária.comparaPosOrder()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
      
    }
}