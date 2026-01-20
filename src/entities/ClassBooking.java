package entities;

public class ClassBooking{
    private Member member;
    private FitnessClass fitnessClass;

    public ClassBooking(Member member, FitnessClass fitnessClass){
        this.member = member;
        this.fitnessClass = fitnessClass;
    }
    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }
}
