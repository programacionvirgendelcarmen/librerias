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
     * @return true if the password has the conditions, otherwise false
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
     * @return true if the password has the conditions, otherwise false
     */
    public static boolean isSafePasswordDefault(String password) {
        return isSafePassword(8, 12, password);
    }

    //FALTA DOCUMENTAR
    public static boolean checkPhoneNumber(String number) {
        return number.matches("[679][0-9]{8}");
    }

    //FALTA DOCUMENTAR
    public static boolean isValideID(String id) {
        id = id.toLowerCase();
        if (! id.matches("[0-9]{8}[a-hj-np-tv-z]")) {
            return false;
        }
        char letraID = id.charAt(id.length() - 1);
        String sNumero = id.substring(0 , id.length() - 1);
        int iNumero = Integer.parseInt(sNumero);
        int resto = iNumero % 23;
        //char[] datos = {'t', 'r', ...};
        String datos = "trwagmyfpdxbnjzsqvhlcke";
        char letraDatos = datos.charAt(resto);
        return letraDatos == letraID;
    }

    /*public static void main(String[] args) {
        //System.out.println(isSafePassword(12, 12, "1aÁabc$Nñg"));
        // System.out.println(isSafePasswordDefault("1aÁabc_Nñg"));
        //System.out.println(checkPhoneNumber("723456789"));
        System.out.println(isValideID("00123456S".replaceAll("[- ]", "")));
    }*/
}
