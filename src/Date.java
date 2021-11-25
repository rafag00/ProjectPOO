public class Date {
    private int day, month, year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean compareDate(Date date){
        return this.day == date.day && this.month == date.month && this.year == date.year;
    }

}
