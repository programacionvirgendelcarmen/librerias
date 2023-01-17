package cadenas;

public class Helper {
    public static boolean isSafePassword(int minLen, int maxLen, String password){
        if (maxLen < minLen)
            return false;
        if (! (password.length() >= minLen && password.length() <= maxLen))
            return false;
        if (! password.matches(".*[a-záéíóúüñ].*"))
            return false;
        if (! password.matches(".*[A-ZÁÉÍÓÚÜÑ].*"))
            return false;
        //if (! password.matches(".*[\\d].*"))
        if (! password.matches(".*[0-9].*"))
            return false;
        if (! password.matches(".*[^a-zA-ZáéíóúüÁÉÍÓÚÜñÑ0-9].*"))
            return false;
        return true;
    }
    public static boolean isSafePasswordDefault(String password) {
        return isSafePassword(8, 12, password);
    }
    /*public static void main(String[] args) {
        System.out.println(isSafePassword(12, 12, "1aÁabc$Nñg"));
        System.out.println(isSafePasswordDefault("1aÁabc_Nñg"));
    }*/
}
