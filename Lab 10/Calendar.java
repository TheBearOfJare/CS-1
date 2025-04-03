
/*
* Name:
*
* Date:
*
* Assignment Number:
*
* Instructor:
*
*
*/
public class Calendar {
    long year;
    boolean isLeapYear;

    Calendar(long y) {
        year = y;
        if ( (((year % 400) == 0) || ((year % 4) == 0) && ((year % 100) != 0)) == (((year%4) == 0) && ((year%100) != 0) || ((year%400) == 0)))
            isLeapYear = true;
        else
            isLeapYear = false;
    }
}
