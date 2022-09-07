public class ThisDate {

    static int day;
    static int month;
    static int year;




    public ThisDate(int date){
        this.day=date/1_000_000;
        date=date-day*1_000_000;
        this.month=date/10_000;
        this.year=date-month*10_000;
    }

    public static int getDay() {
        return day;
    }

    public static int getMonth() {
        return month;
    }

    public static int getYear() {
        return year;
    }
}
