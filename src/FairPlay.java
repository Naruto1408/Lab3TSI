import java.awt.*;
import java.util.Scanner;

public class FairPlay {
    public static void playfairB(String message) {
        String[] base = new String[]{"asdfg",
                "cvbnm",
                "yuiop",
                "qwert",
                "hklzx"};
        int size = base.length;
        int mes_len = message.length();
        // додаткові змінні для тимчасового збергівання даних
        int[][] s1 = new int[2][mes_len/2];
        int[][] s2 = new int[2][mes_len/2];
        //встановлення місця в квадраті Полібія символів які потрібно зашифрувати
        for(int k = 0, r=0; k< (mes_len-1);r++, k+=2){
            for (int i = 0; i < size; i++) {
                int ind1 = base[i].indexOf(message.charAt(k));
                if(ind1 >= 0){
                    s1[0][r] = i;
                    s1[1][r] = ind1;
                }
                int ind2 = base[i].indexOf(message.charAt(k+1));
                if(ind2 >= 0){
                    s2[0][r] = i;
                    s2[1][r] = ind2;
                }
            }
        }
//заміна значень відповідно до квадрату; ініціалізація додаткових змінних
        for(int i = 0; i< mes_len/2; i++){
            int st=1;
            if (s1[1][i] == s2[1][i]){
                st = 0;
            }
            if(s1[0][i] == s2[0][i] || s1[1][i] == s2[1][i]){
                s1[st][i] +=1;
                s2[st][i] +=1;
                if(s1[st][i] >4){
                    s1[st][i] = 0;
                }
                if(s2[st][i] >4){
                    s2[st][i] = 0;
                }
            }else{
                int res;
                res = s1[1][i];
                s1[1][i] = s2[1][i];
                s2[1][i] = res;
            }
        }
        //передача зашифрованих даних в фінальний масив
        char[] result = new char[mes_len];
        for(int i = 0, j=0; i<mes_len-1;j++, i+=2){
            result[i] = base[s1[0][j]].charAt(s1[1][j]);
            result[i+1] = base[s2[0][j]].charAt(s2[1][j]);
        }
        System.out.println(result);

        for(int i = 0; i< mes_len/2; i++){
            int st=1;
            if (s1[1][i] == s2[1][i]){
                st = 0;
            }
            if(s1[0][i] == s2[0][i] || s1[1][i] == s2[1][i]){
                s1[st][i] -=1;
                s2[st][i] -=1;
                if(s1[st][i] <0){
                    s1[st][i] = 4;
                }
                if(s2[st][i] <0){
                    s2[st][i] = 4;
                }
            }else{
                int res;
                res = s1[1][i];
                s1[1][i] = s2[1][i];
                s2[1][i] = res;
            }
        }
        //передача розшифрованих даних в фінальний масив
        char[] dec = new char[mes_len];
        for(int i = 0, j=0; i<mes_len-1;j++, i+=2){
            dec[i] = base[s1[0][j]].charAt(s1[1][j]);
            dec[i+1] = base[s2[0][j]].charAt(s2[1][j]);
        }
        System.out.println(dec);
    }

    public static void main(String[] args) {
        playfairB("zasymenkonestor");
    }

}
