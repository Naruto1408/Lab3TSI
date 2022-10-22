public class Verman {
    public static void verman(String message) {
        String gamma_shifr = "qwertyuiopasdfghjklzxcvbnm";
        int mas_len = message.length();
        char[] result = new char[mas_len];
        int[] res_len = new int[mas_len];
        for (int i = 0; i < mas_len; i++) {
            res_len[i] = message.charAt(i) ^ gamma_shifr.charAt(i);
            result[i] = (char) res_len[i];
        }
        for (int i = 0; i < mas_len; i++)
            System.out.print(res_len[i]+ " ");
        System.out.println();
        char[] dec = new char[mas_len];
        for (int i = 0; i < mas_len; i++)
            dec[i] = (char) (result[i] ^ gamma_shifr.charAt(i));
        System.out.println(dec);
    }

    public static void main(String[] args) {
        verman("zasymenkonestor");
    }
}
