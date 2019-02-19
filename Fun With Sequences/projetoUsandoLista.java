package com.wanderley;

import java.util.Scanner;

class projetoUsandoLista {
    
    private static final Scanner sc = new Scanner(System.in);
    
    private int dados[];
    private int tamAtual;
    private int tamMax;
    
    public static void main(String[] args) {
        projetoUsandoLista lista1 = new projetoUsandoLista(sc.nextInt());
        lista1.dados = getArray(lista1.tamMax);
        projetoUsandoLista lista2 = new projetoUsandoLista(sc.nextInt());
        lista2.dados = getArray(lista2.tamMax);
        comparaArray(lista1.dados,lista2.dados);
        
    }
    public projetoUsandoLista(int tamMax) {
        this.tamMax = tamMax;
        tamAtual = 0;
        dados = new int[tamMax];

    }
    
    public static int[] getArray(int tamanho){
        int[] array = new int[tamanho];
        //System.out.println("Digite " + tamanho + " valores inteiros");  
        
        for(int i = 0 ; i <array.length ; i++ ){
            array[i] = sc.nextInt();
        }
        
        return array;
    }
    
    public static void comparaArray(int[] array1 , int[] array2){
        int temp1 = 0;
        int aux1 = 0;
        boolean flag = true;
            while(flag){                        
                for(int i = 0 ; i<array1.length ; i++){
                    for(int j=0;j<array2.length ; j++){
                        if(array1[i] != array2[j] ){
                           temp1++;
                        }
                        if (temp1 == array2.length){
                            System.out.print(array1[i] + " ");
                        }
                    } 
                    temp1 = 0;
                }
                flag = false;
            }    
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int[] getDados() {
        return dados;
    }

    public void setDados(int[] dados) {
        this.dados = dados;
    }

    public int getTamAtual() {
        return tamAtual;
    }

    public void setTamAtual(int tamAtual) {
        this.tamAtual = tamAtual;
    }

    public void setTamMax(int tamMax) {
        this.tamMax = tamMax;
    }

   
}
