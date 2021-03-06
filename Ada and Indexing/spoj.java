package wanderley;

import java.util.Scanner;

 class LSEGen<T> {
	
	class No {
		private T conteudo;
		private No prox;
		
		public No(){
			setProx(null);
		}

		public T getConteudo() {
			return conteudo;
		}

		public void setConteudo(T conteudo) {
			this.conteudo = conteudo;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}
	}
	
	private No cabeca;
	private int tamanho;
	
	public LSEGen(){
		cabeca = null;
		tamanho = 0;
	}
	
	/** Verifica se a Lista está vazia */
	public boolean vazia() {
	    if (tamanho == 0)
	        return true;
	    else
	        return false;
	}

	/**Obtém o tamanho da Lista*/
	public int tamanho() {
	    return tamanho;
	}

	/** Obtém o i-ésimo elemento de uma lista
	    Retorna o valor encontrado. */
	public T elemento (int pos) {
	    No aux = cabeca;
	    int cont = 1;

	    if (vazia()) {
	        return null; // Consulta falhou 
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return null; // Posicao invalida 
	    }

	    // Percorre a lista do 1o elemento até pos 
	    while (cont < pos){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	        cont++;
	    }

	    return aux.getConteudo();
	}

	/**Retorna a posição de um elemento pesquisado.
	    Retorna 0 caso não seja encontrado */
	public int posicao (T dado) {
	    int cont = 1;
	    No aux;

	    /* Lista vazia */
	    if (vazia()) {
	        return -1;
	    }

	    /* Percorre a lista do inicio ao fim até encontrar o elemento*/
	    aux = cabeca;
		while (aux != null) {
	        /* Se encontrar o elemento, retorna sua posicao n;*/
	        if (aux.getConteudo().equals(dado)){
	            return cont;
	        }

	        /* modifica "aux" para apontar para o proximo elemento da lista */
	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}

	/** Insere nó em lista vazia */
	private boolean insereInicioLista(T valor) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setConteudo(valor);
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    tamanho++;
	    return true;
	}

	/** Insere nó no meio da lista */
	private boolean insereMeioLista(int pos, T dado){
	    int cont = 1;

	    // Aloca memoria para novo no
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Localiza a pos. onde será inserido o novo nó
	    No aux = cabeca;
	    while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {  // pos. inválida 
	    		return false;
	    }

	    // Insere novo elemento apos aux
	    novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);

	    tamanho++;
	    return true;
	}

	/** Insere nó no fim da lista */
	private boolean insereFimLista(T dado){
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Procura o final da lista 
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

	    this.tamanho++;
	    return true;
	}

	/**Insere um elemento em uma determinada posição
	    Retorna true se conseguir inserir e 
	    false caso contrario */
	public boolean insere(int pos, T dado) {
		if ((vazia()) && (pos != 1)){
	        return false; /* lista vazia mas posicao inv*/
	    }

	 	/* inserção no início da lista (ou lista vazia)*/
	    if (pos == 1){
	        return insereInicioLista(dado);
	    }
	    /* inserção no fim da lista */
	    else if (pos == tamanho+1){
	        return insereFimLista(dado);
	   }
	   /* inserção no meio da lista */
	   else{
	        return insereMeioLista(pos, dado);
	   }
	}

	/** Remove elemento do início da lista */
	private T removeInicioLista(){
	    No p = cabeca;

	    // Dado recebe o dado removido
	    T dado = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    tamanho--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private T removeNaLista(int pos){
	     No atual = null, antecessor = null;
	     T dado = null;
	     int cont = 1;

	     /* Localiza o nó que será removido*/
	     atual = cabeca;
	     while((cont < pos) && (atual != null)){
	           antecessor = atual;
	           atual = atual.getProx();
	           cont++;
	     }

	     if (atual == null) { /* pos. inválida */
	        return null;
	     }

	    /* retira o elemento da lista */
	    dado = atual.getConteudo();
	    antecessor.setProx(atual.getProx());
	    tamanho--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    atual = null;
	    return dado;
	}

	/**Remove um elemento de uma determinada posição
	    Retorna o valor a ser removido. 
	    null se a posição for inválida ou a lista estiver vazia*/
	public T remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    		return null;
	    }

	    // Remoção do elemento da cabeça da lista 
	    if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remoção em outro lugar da lista
	    else{
	        return removeNaLista(pos);
	    }
	}	
}
 class spoj {
    private static Scanner sc = new Scanner(System.in);    
    public static void main(String[] args){
        LSEGen<String> minhaLista = new LSEGen<String>();
        int i,j;
        LSEGen<String> minhaLista2 = new LSEGen<String>();    
        
        //System.out.print("Digite o numero de palavras da lista:");       
        int tamanhoDaLista;
        tamanhoDaLista = sc.nextInt();
       // System.out.print("Digite as palavras para comparação:");
        int quantidadeDePalavrasParaComparar;
        quantidadeDePalavrasParaComparar = sc.nextInt();
        
        for(i =1 ; i<=(tamanhoDaLista) ; i++){ 
            //System.out.println("Digite a palavra:");
            minhaLista.insere(i, sc.next());
            //System.out.println("o i vale" + i);            
        }
        
        for(i =1 ; i<=(quantidadeDePalavrasParaComparar) ; i++){ 
           // System.out.println("Digite as PalavrasParaComparar:");
            minhaLista2.insere(i, sc.next());
            //System.out.println("o i vale" + i);     
            }      
       
        for (i =1 ; i<=quantidadeDePalavrasParaComparar ; i++){
            int contador = 0;
            for(j=1 ; j<=(tamanhoDaLista ) ; j++){
               if(minhaLista.elemento(j).startsWith(minhaLista2.elemento(i))){
                   contador++;
               }
            }
            System.out.println(contador);// + " QUANTIDADE DE VEZES QUE A PALAVRA COMEÇOU COM " + minhaLista2.elemento(i));
        }
      
    }
    
}
