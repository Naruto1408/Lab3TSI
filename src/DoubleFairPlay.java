public class DoubleFairPlay {
    public static void doubleB(String message){
        String[] base1 = new String[]{
                "pedna",
                "ifxgs",
                "clkyq",
                "mbwtu",
                "rohzv"};
        String[] base2 = new String[]{
                "clkyq",
                "sefnt",
                "udhgr",
                "pxoav",
                "mbwzi"};
        int size = base1.length;
        int mes_len = message.length();
        int[][] s1 = new int[2][mes_len/2];
        int[][] s2 = new int[2][mes_len/2];

        for(int k = 0, r=0; k< (mes_len-1);r++, k+=2){
            for (int i = 0; i < size; i++) {
                int ind = base1[i].indexOf(message.charAt(k));
                if(ind >= 0){
                    s1[0][r] = i;
                    s1[1][r] = ind;
                }
                int ind1 = base2[i].indexOf(message.charAt(k+1));
                if(ind1 >= 0){
                    s2[0][r] = i;
                    s2[1][r] = ind1;
                }
            }
        }

        for(int i =  0; i < mes_len/2; i++){
            if(s1[0][i] == s2[0][i]){
                int change = s1[1][i];
                s1[1][i] = s2[1][i];
                s2[1][i] = change;
            }else{
                int change = s1[0][i];
                s1[0][i] = s2[0][i];
                s2[0][i] = change;
            }
        }

        char[] result = new char[mes_len];
        for(int i = 0, j=0; i<mes_len-1;j++, i+=2){
            if(s1[0][j] == s2[0][j]){
                result[i+1] = base1[s1[0][j]].charAt(s1[1][j]);
                result[i] = base2[s2[0][j]].charAt(s2[1][j]);
            }else{
                result[i]  = base2[s2[0][j]].charAt(s2[1][j]);
                result[i+1] = base1[s1[0][j]].charAt(s1[1][j]);
            }
        }

        System.out.println(result);

        char[] dec = new char[mes_len];
        for(int i =  0; i < mes_len/2; i++){
            if(s1[0][i] == s2[0][i]){
                int change = s1[1][i];
                s1[1][i] = s2[1][i];
                s2[1][i] = change;
            }else{
                int change = s1[0][i];
                s1[0][i] = s2[0][i];
                s2[0][i] = change;
            }
        }
        for(int i = 0, j=0; i<mes_len-1;j++, i+=2) {
            dec[i] = base1[s1[0][j]].charAt(s1[1][j]);
            dec[i + 1] = base2[s2[0][j]].charAt(s2[1][j]);
        }
        System.out.println(dec);
    }

    public static void main(String[] args) {
        doubleB("zasymenkonestor");

    }
}
