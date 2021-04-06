package prompt.easy;

public class CaesarCipherEncryptor {
    
    public static String caesarCypherEncryptor(String str, int key) {
        String encrypted = "";

        for (char c : str.toCharArray()) {
            encrypted += getNextChar(c, key);
        }
        
        return encrypted;
    }

    public static char getNextChar(char c, int key) {
        int currASCII = (int) c;
        int newASCII = (currASCII + key - 'a') % 26;
        return (char) (newASCII + 'a');
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
        System.out.println(caesarCypherEncryptor("xyz", 2).equals("zab"));
    }
}
