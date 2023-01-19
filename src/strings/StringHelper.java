package strings;

/**
 * HelpeClass that offers helper methods
 * related with strings
 * @author Manuel
 * @version 1.0.0
 */
public class StringHelper {

    private  StringHelper(){}
    /**
     * Method that returns a boolean if the password contains at least
     * a digit, a lowercase letter, an uppercase letter and a symbol,
     * besides the length of the password has to be between minLen and maxLen
     * @param minLen minimum length
     * @param maxLen maximum length
     * @param password password to check
     * @return true if the password has the conditions, false on the another case
     */
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

    /**
     * Method that returns a boolean if the password contains at least
     *  a digit, a lowercase letter, an uppercase letter and a symbol,
     *  besides the length of the password has to be between 8 and 12,
     *  values included
     * @param password password to check
     * @return true if the password has the conditions, false on the another case
     */
    public static boolean isSafePasswordDefault(String password) {
        return isSafePassword(8, 12, password);
    }
    /*public static void main(String[] args) {
        System.out.println(isSafePassword(12, 12, "1aÁabc$Nñg"));
        System.out.println(isSafePasswordDefault("1aÁabc_Nñg"));
    }*/
}
