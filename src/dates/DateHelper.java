package dates;

public class DateHelper {
    public static boolean checkDate(String date){
        String dias  = "(0?[1-9]|[12][0-9]|3[01])";
        String meses = "([1-9]|0[1-9]|1[0-2])";
        String annos = "[12][0-9]{3}";
        String separadores = "[/-]";
        return date.matches(
                dias + separadores + meses + separadores + annos);
    }

    public static void main(String[] args) {
        System.out.println(checkDate("01-2-2999"));
    }
}
