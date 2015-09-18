package com.example;

public class MetricToEnglishClass {

    public static void main(String[] args){
        // Constants
        final double M_IN_FT = 3.28084,        // meters * 3.28084 = feet
                    M_IN_YARDS = 1.09361,      // meters * 1.09361 = yards
                    KM_IN_MILES = 0.62137,     // kilometers * .62137 = miles
                    CM_IN_INCHES = 0.39370,    // centimeters * .3937 = inches
                    L_TO_QT = 1.0567,          // liters * 1.0567 = quarts
                    QT_TO_GALLONS = 4,         // quarts / 4 = gallons
                    KG_TO_LBS = 2.2046,        // kilograms * 2.2046 = pounds
                    KPH_TO_FPS = .9133;        // kilometers per hour * .9133 = feet per second

        final int ERROR_CASE = 0,          // define cases for switch statement
                  METER_CASE = 1,
                  KILOM_CASE = 2,
                  CENT_CASE = 3,
                  KPH_CASE = 4,
                  LITER_CASE = 5,
                  KILOG_CASE = 6;

        // Declare and Initialize Input arrays
        double metricAmount[] = {28, 168, 47, 27, 92, 200};
        String metricUnit[] = {"Meters","Kilometers","Centimeters","Kilometers per hour","Liters","Kilograms"};

        double englishAmount;             // double holding converted metric amount
        String currentUnit, englishUnit;  // strings to hold current metric unit and the corresponding english unit
        int thisCase = 0;

        // Introduce program on console
        System.out.println("This program converts from metric units to English units.");
        System.out.println("");

        // Iterate through input arrays performing conversion and printing to console
        for (int i = 0; i<metricAmount.length; i++) {
            // print inputs - metric amount and unit - no newline - will append later
            System.out.print(metricAmount[i] + "  " + metricUnit[i]);
            currentUnit = metricUnit[i];       // save current unit

            // based on the string in currentUnit, set thisCase variable
            if (currentUnit.matches("Meters")) {thisCase = METER_CASE;}
            else if (currentUnit.matches("Kilometers")){thisCase = KILOM_CASE;}
            else if (currentUnit.matches("Centimeters")){thisCase = CENT_CASE;}
            else if (currentUnit.matches("Kilometers per hour")){thisCase = KPH_CASE;}
            else if (currentUnit.matches("Liters")){thisCase = LITER_CASE;}
            else if (currentUnit.matches("Kilograms")){thisCase = KILOG_CASE;}
            else {thisCase = ERROR_CASE;}

            //  Based on thisCase perform appropriate conversion
            switch (thisCase) {
                case METER_CASE: //
                    englishAmount = metricAmount[i] * M_IN_FT;  // perform conversion  to feet and
                    englishUnit = "Feet";                       //    set english unit
                    System.out.println(" is " + englishAmount + // append output line
                            " " + englishUnit);
                    System.out.print("         OR ");           // this case also converts to yards
                    englishAmount = metricAmount[i] * M_IN_YARDS; // so perform conversion to yards
                    englishUnit = "Yards";                        //  and set english unit
                    break;
                case KILOM_CASE:
                    englishAmount = metricAmount[i] * KM_IN_MILES; // perform conversion to miles
                    englishUnit = "Miles";                         //    and set english unit
                    break;
                case CENT_CASE:
                    englishAmount = metricAmount[i] * CM_IN_INCHES; // perform conversion to inches
                    englishUnit = "Inches";                         //  and set english unit
                    break;
                case KPH_CASE:
                    englishAmount = metricAmount[i] * KPH_TO_FPS;  // perform conversion to Ft/sec
                    englishUnit = "Feet per second";               //   and set english unit
                    break;
                case LITER_CASE:
                    englishAmount = metricAmount[i] * L_TO_QT;     // perform conversion to quarts
                    englishUnit = "Quarts";                        //   and set english units
                    System.out.println(" is " + englishAmount +    //append output line
                            " " + englishUnit);
                    System.out.print("         OR ");            // this case also converts to gallons
                    englishAmount = englishAmount / QT_TO_GALLONS; // so perform conversion to gallons
                    englishUnit = "Gallons";                       //    and set english units
                    break;
                case KILOG_CASE:
                    englishAmount = metricAmount[i] * KG_TO_LBS;   // perform conversion to pounds
                    englishUnit = "Pounds";                        //  and set english units
                    break;
                case ERROR_CASE:                                   // ERROR and default the same
                default:                                           //   (falls through)
                    englishAmount = 0;                             // set amount to zero
                    englishUnit = "moonunits";                     // and unit to something silly
            }
            // finish appending converted amounts to console
            System.out.println(" => " + englishAmount + " " + englishUnit);

        }  // end of for loop
    }  // end main
}
