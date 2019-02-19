package BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class No {
	private int conteudo;
	private No esq;
	private No dir;
	
	public No(){
		esq = null;
		dir = null;
	}
	
	public int getConteudo() {
		return conteudo;
	}
	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}
	
	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	
	public No getDir() {
		return dir;
	}
	
	public void setDir(No dir) {
		this.dir = dir;
	}
    }

class ABP {
    private No raiz;
    private int c;
    public ABP(){
            raiz = null;
            c = 0;
    }

    public int insere(int valor){

            No novoNo = new No();
            novoNo.setConteudo(valor);
            novoNo.setEsq(null);
            novoNo.setDir(null);

            if (raiz == null){ 
                    raiz = novoNo;
                    return c;
            }
            
        No auxiliar = raiz;
        No p = null;
        
        while (auxiliar != null) {
                    p = auxiliar;
                    c++;
                    if (valor < auxiliar.getConteudo()){
                        auxiliar = auxiliar.getEsq(); 
                                
                    }else{
                        auxiliar = auxiliar.getDir();
                        
                    }
        }

            if (valor < p.getConteudo())
                    p.setEsq(novoNo);
            else
                    p.setDir(novoNo);
            return c;
    }
}

class BST {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
        ABP arvore = new ABP();
        int aux =0;
        
        int tamanhoDaSequencia = Integer.parseInt(in.readLine());
        
        for(int i =0; i< tamanhoDaSequencia ;i++){
            aux = arvore.insere(Integer.parseInt(in.readLine()));
            System.out.println(aux);
        }
        
    }
    
}