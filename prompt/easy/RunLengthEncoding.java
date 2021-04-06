package prompt.easy;

public class RunLengthEncoding {
    
    public static String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder();
        int runningLength = 1;

        for (int i = 1; i < string.length(); i++) {
            char currChar = string.charAt(i);
            char prevChar = string.charAt(i - 1);

            if (currChar != prevChar || runningLength == 9) {
                sb.append(String.valueOf(runningLength));
                sb.append(String.valueOf(prevChar));
                runningLength = 0;
            } 

            runningLength++;
        }
        
        sb.append(String.valueOf(runningLength));
        sb.append(String.valueOf(string.charAt(string.length() - 1)));
        return sb.toString();
    }

    public static void main(String[] args) {
        var input = "AAAAAAAAAAAAABBCCCCDD";
        var expected = "9A4A2B4C2D";
        var actual = runLengthEncoding(input);
        System.out.println(actual);
        System.out.println(expected.equals(actual));
    }
}
