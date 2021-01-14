package Medium;

import java.util.*;

class Program {

    public static ArrayList<String> validIPAddresses(String string) {

        // Time:  O(1)
        // Space: O(1)
        ArrayList<String> ipAddressesFound = new ArrayList<>();

        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] currIPAddressParts = new String[] {"", "", "", ""};

            currIPAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currIPAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                currIPAddressParts[1] = string.substring(i, j);

                if (!isValidPart(currIPAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    currIPAddressParts[2] = string.substring(j, k);
                    currIPAddressParts[3] = string.substring(k, string.length());

                    if (isValidPart(currIPAddressParts[2]) && isValidPart(currIPAddressParts[3])) {
                        ipAddressesFound.add(join(currIPAddressParts));
                    }
                }
            }
        }

        return ipAddressesFound;
    }

    public static boolean isValidPart(String string) {
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }

        // Check for leading zeroes
        return string.length() == String.valueOf(stringAsInt).length();
    }

    public static String join(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i < strings.length - 1) {
                sb.append(".");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String IPAddress = "1921680";
        System.out.println(validIPAddresses(IPAddress));
    }
}
