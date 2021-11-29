import java.io.Serializable;

public class Date implements Serializable {
    private int day, month, year;

    public Date(int day, int month, int year){
        if(day > 0 && day <=31){
            if(month > 0 && month <=12){
                if(month == 2 && day > 29){
                    System.out.println("Day "+day+" is impossible in February.");
                }
                else if((month == 4 || month == 6 || month == 9 || month == 11) && day == 31){
                    if(month == 4){
                        System.out.println("Day "+day+" is impossible in April");
                    }
                    else if(month == 6){
                        System.out.println("Day "+day+" is impossible in June");
                    }
                    else if(month == 9){
                        System.out.println("Day "+day+" is impossible in September");
                    }
                    else{
                        System.out.println("Day "+day+" is impossible in November");
                    }
                }
                else {
                    this.day = day;
                    this.month = month;
                    this.year = year;
                }
            }else {System.out.println("Month "+month+" is invalid");}
        }else{System.out.println("Day "+day+" is invalid");}
    }

    public boolean isValid(){
        if(this.day != 0 && this.month!=0 && this.year!=0){
            return true;
        }
        return false;
    }
    public boolean compareDate(Date date){
        return this.day == date.day && this.month == date.month && this.year == date.year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
