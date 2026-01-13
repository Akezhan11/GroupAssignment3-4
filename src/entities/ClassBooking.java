package entities;

public class ClassBooking extends FitnessClass{
    private int maxPlaces;
    private int bookedPlaces;

    public ClassBooking(String fitnessType, String fitnessDescription, String fitnessDate, String fitnessTime, int fitnessCost, String fitnessTrainerName, String fitnessTrainerSurname, int maxPlaces, int bookedPlaces) {
        super(fitnessType,fitnessDescription,fitnessDate,fitnessTime,fitnessCost,fitnessTrainerName,fitnessTrainerSurname);
        setMaxPlaces(maxPlaces);
        this.bookedPlaces = 0;
    }

    public int getMaxPlaces() {
        return maxPlaces;
    }
    public void setMaxPlaces(int maxPlaces) {
        if (maxPlaces <= 0) {
            throw new IllegalArgumentException("Max place must be > 0");
        }
        this.maxPlaces = maxPlaces;
    }


    public  int getBookedPlaces() {
        return bookedPlaces;
    }

    public boolean hasFreePlaces(){
        return bookedPlaces < maxPlaces;
    }

    public void cancelPlace(){
        if(bookedPlaces <=0){
            throw new IllegalArgumentException("there is no places for booking");
        }
        bookedPlaces--;
    }
    @Override
    public void bookPlace(){
        if (!hasFreePlaces()){
            throw new IllegalArgumentException("No places left");
        }
        bookedPlaces++;
    }
}
