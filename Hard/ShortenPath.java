package Hard;

import java.util.*;
import java.util.stream.Collectors;

class Program {

    public static String shortenPath(String path) {

        // Time:  O(n)
        // Space: O(n)

        String[] strArr = path.split("/");
        List<String> stack = new ArrayList<>();
        List<String> tokensList = Arrays.asList(strArr);
        List<String> filteredTokensList =
                tokensList.stream().filter(token -> isImportantToken(token)).collect(Collectors.toList());

        boolean isAbsolutePath = (path.charAt(0) == '/') ? true : false;
        if (isAbsolutePath) {
            stack.add("");
        }
        for (String str : filteredTokensList) {
            if (str.equals("..")) {
                if (stack.size() == 0 || stack.get(stack.size() - 1).equals("..")) {
                    stack.add(str);
                } else if (!stack.get(stack.size() - 1).equals("")) {
                    stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(str);
            }
        }

        if (stack.size() == 1 && stack.get(0).equals("")) {
            return "/";
        }

        return String.join("/", stack);
    }

    public static boolean isImportantToken(String token) {
        return token.length() > 0 && !token.equals(".");
    }

    public static void main(String[] args) {
        String pathOne = "/foo/../test/../test/../foo//bar/./baz";
        String pathTwo = "../../foo/bar/baz";
        String pathThree = "foo/bar/baz";
        System.out.println(shortenPath(pathTwo));
    }
}
