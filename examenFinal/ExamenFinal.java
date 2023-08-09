package examenFinal;

import java.util.Arrays;

public class ExamenFinal {
    public static void main(String[] args) {
        int repetidos = contadorRepetidos(456076, 6);
        System.out.println("los numeros se repiten "+ repetidos + " veces");

        int[] arreglo = guardarArreglo(8523413);
        System.out.println("El arreglo es: "+ Arrays.toString(arreglo));

        int numeroIntercambiado = intercambiarArreglo(arreglo);
        System.out.println("El número intercambiado es: "+numeroIntercambiado);
    }

    private static int contadorRepetidos(int numero, int numeroBuscar) {

        // Retornar cuantas veces se repite el número a buscar en el número dado
        String numeroConvertido = String.valueOf(numero);
        int contador = 0;

        for (int i = 0; i < numeroConvertido.length(); i++) {
            char digito = numeroConvertido.charAt(i);
            if (Integer.parseInt(String.valueOf(digito)) == numeroBuscar) {
                contador++;
            }
        }
        return contador;
    }

    private static int[] guardarArreglo(int numero) {

        // Retonar los digitos del numero dado en un arreglo
        String numeroConvertido = String.valueOf(numero);
        int[] arrayNumero = new int[numeroConvertido.length()];

        for (int i = 0; i < numeroConvertido.length(); i++) {
            char digito = numeroConvertido.charAt(i);
            arrayNumero[i] = Integer.parseInt(String.valueOf(digito));
        }
        return arrayNumero;

    }

    private static int intercambiarArreglo( int[] arrayNumero) {

        // Retornar un número intercambiando de posicion de par en par
        int[] newArrayNumero = new int[arrayNumero.length];
        for(int i = 0; i < arrayNumero.length; i+=2) {
            if(i + 1 < arrayNumero.length) {
                int valor1 = arrayNumero[i];
                int valor2 = arrayNumero[i+1];
                newArrayNumero[i] = valor2;
                newArrayNumero[i+1] = valor1;
            }else{
                newArrayNumero[i] = arrayNumero[i];
            }
        }
        String palabra ="";
        for(int i = 0; i < newArrayNumero.length; i++){
            String digito = String.valueOf(newArrayNumero[i]);
            palabra = palabra + digito;
        }

        return Integer.valueOf(palabra);
    }

}
