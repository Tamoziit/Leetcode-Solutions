import java.util.Scanner;

class kthCharacter_StringGame {
    public char kthCharacter(int k) {
        int itr = (int) Math.ceil(Math.log(k) / Math.log(2));
        int i, j;
        String w = "a";
        String next = "";
        for (i = 0; i < itr; i++) {
            for (j = 0; j < w.length(); j++) {
                char ch = (char) (w.charAt(j) + 1);
                if (ch > 'z') {
                    ch = 'a';
                }
                next += ch;
            }
            w += next;
            next = "";
            System.out.println(w);
        }

        return w.charAt(k - 1);
    }

    public static void main(String args[]) {
        kthCharacter_StringGame ob = new kthCharacter_StringGame();
        Scanner sc = new Scanner(System.in);
        int k;
        System.out.println("Enter a no.");
        k = sc.nextInt();

        System.out.println("Res = " + ob.kthCharacter(k));
        sc.close();
    }
}