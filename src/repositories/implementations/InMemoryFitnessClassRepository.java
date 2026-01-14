package repositories.implementations;

import java.util.List;
import java.util.ArrayList;
import entities.FitnessClass;
import repositories.FitnessClassRepository;

public class InMemoryFitnessClassRepository implements FitnessClassRepository {
    private List<FitnessClass> fitnessClasses = new ArrayList<>();
    @Override
    public void save(FitnessClass fitnessClass){
        fitnessClasses.add(fitnessClass);
    }
    @Override
    public List<FitnessClass> findAll(){
        return fitnessClasses;
    }
    @Override
    public FitnessClass findById(int id){
        for(FitnessClass fitnessClass : fitnessClasses){
            if(fitnessClass.getId() == id){
                return fitnessClass;
            }
        }
        return null;
    }
    @Override
    public FitnessClass findByType(String fitnessType){
        for(FitnessClass f : fitnessClasses){
            if(f.getFitnessType().equals(fitnessType)){
                return f;
            }
        }
        return null;
    }
    @Override
    public FitnessClass findByTrainerName(String fitnessTrainerName){
        for(FitnessClass f : fitnessClasses){
            if(f.getFitnessTrainerName().equals(fitnessTrainerName)){
                return f;
            }
        }
        return null;
    }
    @Override
    public FitnessClass findByCost(int fitnessCost){
        for(FitnessClass f : fitnessClasses){
            if(fitnessCost == f.getFitnessCost()){
                return f;
            }
        }
        return null;
    }
}
