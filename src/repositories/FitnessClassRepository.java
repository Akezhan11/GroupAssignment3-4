package repositories;

import entities.FitnessClass;
import java.util.ArrayList;
import java.util.List;
public interface FitnessClassRepository {
    void save(FitnessClass fitnessClass);
    FitnessClass findById(int id);
    FitnessClass findByType(String phoneNumber);
    FitnessClass findByTrainerName(String email);
    FitnessClass findByCost(String email);
    List<FitnessClass> findAll();
}
