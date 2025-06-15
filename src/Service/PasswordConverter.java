package Service;

public class PasswordConverter implements IPasswordConverter {

    public static String convertToHex(String password) {
        StringBuilder hexString = new StringBuilder();
        for (char c : password.toCharArray()) {
            hexString.append(String.format("%02X ", (int) c));
        }
        return hexString.toString().trim();
    }

}






