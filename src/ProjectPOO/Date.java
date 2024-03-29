package ProjectPOO;

import java.io.Serializable;

/**
 * Date verification and creation.
 */
public class Date implements Serializable {
    private int day, month, year;

    /**
     * Constructor of the Date class.
     * It has security except on the leap year.
     * @param day of the class.
     * @param month of the class.
     * @param year of the class.
     */
    public Date(int day, int month, int year){
        if(day > 0 && day <=31){
            if(month > 0 && month <=12){
                if(month == 2 && day > 28){
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

    /**
     * Validates the created data.
     * @return true if valid, false if not.
     */
    public boolean isValid(){
        return this.day != 0 && this.month != 0 && this.year != 0;
    }

    @Override
    public String toString() {
        return day+ "/"+month+"/"+year;
    }
}
