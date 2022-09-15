public class ThisDate {

    static int day;
    static int month;
    static int year;





    public ThisDate(){
    }
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

    public int daysSinceChrist(ThisDate date){
        int daysInYrears= (Integer)(date.year / 4)+date.year*365;
        int daysInMonths=0;
        switch (date.month){
            case 1:
                daysInMonths=0;
                break;

            case 2:
                daysInMonths=31;
                break;

            case 3:
                daysInMonths=59;
                break;

            case 4:
                daysInMonths=90;
                break;

            case 5:
                daysInMonths=120;
                break;

            case 6:
                daysInMonths=151;
                break;

            case 7:
                daysInMonths=181;
                break;

            case 8:
                daysInMonths=212;
                break;

            case 9:
                daysInMonths=243;
                break;

            case 10:
                daysInMonths=273;
                break;

            case 11:
                daysInMonths=304;
                break;

            case 12:
                daysInMonths=334;
                break;
        }
        int numberOfDays = daysInYrears + daysInMonths + date.day;

        return numberOfDays;
    }


    public int daysPased(ThisDate dateOne, ThisDate dateTwo){

        int numberOfDaysDateOne = daysSinceChrist(dateOne);
        int numberOfDaysDateTwo = daysSinceChrist(dateTwo);

        int daysPased;

        if (numberOfDaysDateOne>numberOfDaysDateTwo){
            daysPased = numberOfDaysDateOne-numberOfDaysDateTwo;
        }else{
            daysPased = numberOfDaysDateTwo-numberOfDaysDateOne;
        }
        return daysPased;
    }
}