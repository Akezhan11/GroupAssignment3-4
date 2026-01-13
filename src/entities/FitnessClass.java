package entities;

public class FitnessClass {
    private String fitnessType;
    private String fitnessDescription;
    private String fitnessDate;
    private String fitnessTime;
    private int fitnessCost;
    private String fitnessTrainerName;
    private String fitnessTrainerSurname;

    public FitnessClass(String fitnessType, String fitnessDescription, String fitnessDate, String fitnessTime, int fitnessCost, String fitnessTrainerName, String fitnessTrainerSurname) {
        setFitnessType(fitnessType);
        setFitnessDescription(fitnessDescription);
        setFitnessDate(fitnessDate);
        setFitnessTime(fitnessTime);
        setFitnessCost(fitnessCost);
        setFitnessTrainerName(fitnessTrainerName);
        setFitnessTrainerSurname(fitnessTrainerSurname);
    }


    public String getFitnessType() {
        return fitnessType;
    }
    public void setFitnessType(String fitnessType) {
        if(fitnessType==null || fitnessType.isEmpty()){
            throw new IllegalArgumentException("Fitness type cannot be empty");
        }
        this.fitnessType = fitnessType;
    }


    public String getFitnessDescription() {
        return fitnessDescription;
    }
    public void setFitnessDescription(String fitnessDescription) {
        if(fitnessDescription==null || fitnessDescription.isEmpty()){
            throw new IllegalArgumentException("Fitness description cannot be empty");
        }
        this.fitnessDescription = fitnessDescription;
    }


    public String getFitnessDate() {
        return fitnessDate;
    }
    public void setFitnessDate(String fitnessDate) {
        if(fitnessDate == null || fitnessDate.isEmpty()){
            throw new IllegalArgumentException("Fitness date cannot be empty");
        }
        this.fitnessDate = fitnessDate;
    }


    public String getFitnessTime() {
        return fitnessTime;
    }
    public void setFitnessTime(String fitnessTime) {
        if(fitnessTime == null || fitnessTime.isEmpty()){
            throw new IllegalArgumentException("Fitness time cannot be empty");
        }
        this.fitnessTime = fitnessTime;
    }


    public int getFitnessCost(){
        return fitnessCost;
    }
    public void setFitnessCost(int fitnessCost){
        if (fitnessCost <0){
            throw new IllegalArgumentException("Fitness cost cannot be less than 0");
        }
        this.fitnessCost = fitnessCost;
    }


    public String getFitnessTrainerName() {
        return fitnessTrainerName;
    }
    public void setFitnessTrainerName(String fitnessTrainerName) {
        if(fitnessTrainerName==null|| fitnessTrainerName.isEmpty()){
            throw new IllegalArgumentException("Fitness Trainer Name cannot be empty");
        }
        this.fitnessTrainerName = fitnessTrainerName;
    }


    public String getFitnessTrainerSurname(){
        return fitnessTrainerSurname;
    }
    public void setFitnessTrainerSurname(String fitnessTrainerSurname){
        if(fitnessTrainerSurname==null || fitnessTrainerSurname.isEmpty()){
            throw new IllegalArgumentException("Fitness Trainer Surname cannot be empty");
        }
        this.fitnessTrainerSurname = fitnessTrainerSurname;
    }
}