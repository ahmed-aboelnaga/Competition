package date;

import date.util.*;

public class DateMain {
    
    public static void main(String[] args) {

        Date date = new Date(14,Month.february,2020);
        Date date_2 = new Date(23,Month.march,2020);
        
        if (date.equals(date)) {
            System.out.println("Nous sommes le : " + date.getDay()+" "+date.getMonth()+" "+date.getYear());
        }
        if (!date.equals(date_2)) {
            System.out.println("Demain nous serrons le : " + date.tomorrow());
        }
        
        System.out.println("Dans une semaine nous serrons le : "+date.nDaysLater(7));
        System.out.println("Il reste "+date_2.differenceInDays(date)+" jours avant le "+ date_2);
        
        if (date.isBefore(date_2)) {
            System.out.println("Le "+date+" est avant le "+date_2);
        }
        if (date_2.isAfter(date)) {
            System.out.println("Le "+date_2+" est après le "+date);
        }

        if (date.isLeap(date.getYear())) {
            System.out.println("L'année "+ date.getYear()+" est une année bissextile");
        }

    }
}