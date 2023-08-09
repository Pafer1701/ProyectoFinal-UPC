package examenFinal;

import java.util.ArrayList;
import java.util.List;

public class pruebas {
    public static void main(String[] args) {
        //Bloque de código N

        int c = 1;

        int p = 1;

        while (c<5){

            p += c;

            c++;

        }
        System.out.println(c);
        System.out.println(p);

        int a = 1;

        int b = 1;

        do {

            b += a;

            a++;

        } while (a<5);

        System.out.println(a);
        System.out.println(b);

        for (int i = 1; i <= 5; i++){

            System.out.println("Hola");

            i = i + 1;

        }

        String palabraSize = String.valueOf("5564");
        int digito = 0;
        List<Integer> array = new ArrayList<Integer>();

        for(int i = 0; i <palabraSize.length(); i++) {
            int meterDigito = 5564%10;
            int cocienteNumero = 5564/10;
            array.add(meterDigito);
            array.add(cocienteNumero%10);
            System.out.println(array);
            System.out.println(cocienteNumero);
        }
    }
}
