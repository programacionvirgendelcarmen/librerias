package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DateHelper {
    private static String separadores = "[/-]";
    public static boolean checkDate(String date){

        String dias  = "(0?[1-9]|[12][0-9]|3[01])";
        String meses = "([1-9]|0[1-9]|1[0-2])";
        String annos = "[12][0-9]{3}";

        StringBuilder  stringBuilderInicial = new StringBuilder();
        stringBuilderInicial.append(dias);
        stringBuilderInicial.append(separadores);
        stringBuilderInicial.append(meses);
        stringBuilderInicial.append(separadores);
        stringBuilderInicial.append(annos);
        String patronInicial = stringBuilderInicial.toString();
        if (! date.matches(patronInicial))
            return false;
        boolean bisiesto = esAnnoBisiesto(date);

        String mes31  = "(0?[1-9]|[12][0-9]|3[01])[/-](0?[13578]|1[02])";
        String mes30  = "(0?[1-9]|[12][0-9]|30)[/-](0?[469]|11)";
        String mesFeb = "\"(0?[1-9]|[12][0-8])[/-]0?2\";";
        if (bisiesto)
            mesFeb = "(0?[1-9]|[12][0-9])[/-]0?2";
        StringBuilder stringBuilderFinal = new StringBuilder("(");
        stringBuilderFinal.append(mes31);
        stringBuilderFinal.append('|');
        stringBuilderFinal.append(mes30);
        stringBuilderFinal.append('|');
        stringBuilderFinal.append(mesFeb);
        stringBuilderFinal.append(')');
        String diasMeses = stringBuilderFinal.toString();

        return date.matches(
                diasMeses + separadores + annos);
    }

    public static boolean esAnnoBisiesto(String date) {
        String[] tokens = date.split(separadores);
        int iAnno = Integer.parseInt(tokens[2]);
        if (iAnno % 4 != 0)
            return false;
        if (iAnno % 100 == 0)
            if ( iAnno % 400 != 0)
                return false;
        return true;
    }
    public static int calcularEdad(LocalDate fecha) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaActual, fecha);
        return periodo.getYears();
    }

   /* public static void main(String[] args) {
       if (checkDate("29-02-2100")) {
            LocalDate dateTime = LocalDate.of(2100, 02, 29);
            System.out.println(dateTime);
        } else {
            System.out.println("Fecha no valida");
        }
    }*/
}
