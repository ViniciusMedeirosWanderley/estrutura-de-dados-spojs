package AdaQueue;
import java.io.*;

class Main {
    
    static class No{
        private int conteudo;
	private No prox;
        private No ant;

	public No(){
            prox=null;
            ant=null;
	}

	public int getConteudo() {
            return conteudo;
	}

	public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
	}

	public No getProx() {
            return prox;
	}

	public void setProx(No prox) {
            this.prox = prox;
	}
        
        public No getAnt() {
            return ant;
        }

        public void setAnt(No ant) {
            this.ant = ant;
        }
    }
    
    static class Fila{
        protected No start;
        protected No end;
        protected int nElementos;
        protected boolean flagReverse = false;
        
        public Fila() {
            start = null; 
            end = null;
            nElementos = 0;
	}
        
        public void command(String s){
            String[] parts = s.split(" ");
            
            if(parts[0].equals("back")){
                removeBack();
            }
            if(parts[0].equals("front")){
                removeFront();
            }
            if(parts[0].equals("reverse")){
                reverse();
            }
            if(parts[0].equals("push_back")){
                pushBack(parts[1]);
            }
            if(parts[0].equals("toFront")){
                pushFront(parts[1]);
            }            
            
        }
        
        public void pushFront(String s){
            int number = Integer.parseInt(s);
            No newNo = new No();
            newNo.setConteudo(number);
            
            if(flagReverse){
                reverse();
                pushBack(s);
                reverse();
            }else{
                if(nElementos == 0){
                    start = newNo;
                    end = newNo;
                }else{
                    start.setAnt(newNo);
                    newNo.setProx(start);
                    start = newNo;
                }            
                nElementos++;
            }
        }
        
        public void pushBack(String s){
            int number = Integer.parseInt(s);
            No newNo = new No();
            newNo.setConteudo(number);
            
            if(flagReverse){
                reverse();
                pushFront(s);
                reverse();
            }else{
                if(nElementos == 0){
                    start = newNo;
                }else{
                    newNo.setAnt(end);
                    end.setProx(newNo);
                }

                end = newNo;
                nElementos++;
            }
        }
        
        public void removeFront(){
            
            if(flagReverse){
                reverse();
                removeBack();
                reverse();
            }else{
            
                if(nElementos == 0){
                    System.out.println("No job for Ada?");
                }else{
                    int aux = start.getConteudo();
                    No p = start;

                    if(start == end){
                        start = null;
                        end = null;
                    }else{
                        start = p.getProx();
                        p.setProx(null);
                        start.setAnt(null);
                    }

                    p = null;
                    nElementos--;
                    System.out.println(aux);
                }
            }
        }
            
        public void removeBack(){
            
            if(flagReverse){
                reverse();
                removeFront();
                reverse();
            }else{
            
                if(nElementos == 0){
                    System.out.println("No job for Ada?");
                }else{
                    int aux = end.getConteudo();
                    No p = end;

                    if(start == end){
                        start = null;
                        end = null;
                    }else{
                        end = p.getAnt();
                        end.setProx(null);
                    }

                    p = null;
                    nElementos--;
                    System.out.println(aux);
                }
            }
        }
        
        public void reverse(){
           if(nElementos == 0) return;
           
           No aux = start;
           start = end;
           end = aux;
           flagReverse =  !flagReverse;
           
        }
    }
    
    public static void main(String[] args) throws IOException{
        try{
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Fila queue = new Fila();
            int length = Integer.parseInt(reader.readLine());
            
            for(int i = 0; i < length; i++){
                String a = reader.readLine();
                queue.command(a);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}