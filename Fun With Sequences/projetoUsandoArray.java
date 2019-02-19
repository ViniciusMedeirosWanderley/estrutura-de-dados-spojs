package com.wanderley;

import java.util.Scanner;

 class projetoUsandoArray{
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
               
        //System.out.println("Digite o tamanho do primeiro array:\r");
        int tamanho1 = sc.nextInt();
        int[] array1 = getArray(tamanho1);
        //System.out.println("Digite o tamanho do segundo array:\r");
        int tamanho2 = sc.nextInt();
        int[] array2 = getArray(tamanho2);
        comparaArray(array1, array2);
        
        
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
}