package entities;

public class MembershipType{
    private String type;
    private int cost;
    private String description;
    private int day;
    private int month;
    private int year;

    public MembershipType(String type, int cost, String description, int day, int month, int year) {
        setType(type);
        setCost(cost);
        setDescription(description);
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        this.type = type;
    }


    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        if(cost < 0) {
            throw new IllegalArgumentException("cost cannot be negative");
        }
        this.cost = cost;
    }


    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        this.description = description;
    }


    public int getDay(){
        return day;
    }
    public void setDay(int day){
        if(day < 0) {
            throw new IllegalArgumentException("day cannot be negative");
        } else if (day>31) {
            throw new IllegalArgumentException("day cannot be greater than 31");
        }
        this.day = day;
    }


    public int getMonth(){
        return month;
    }
    public void setMonth(int month){
        if(month < 0) {
            throw new IllegalArgumentException("month cannot be negative");
        } else if (month>12) {
            throw new IllegalArgumentException("month cannot be greater than 12");
        }
        this.month = month;
    }


    public int getYear(){
        return year;
    }
    public void setYear(int year){
        if (year < 0) {
            throw new IllegalArgumentException("year cannot be negative");
        }else if (year<2025) {
            throw new IllegalArgumentException("year cannot be smaller than 2025");
        }
        this.year = year;
    }
    @Override
    public String toString() {
        return "type: " + getType() + "\n"
                + "Description: " + description + "\n"
                + "cost of the membership" + cost + "Date of becoming our member: " +
                day + "."+ month + "." + year;
    }
}
