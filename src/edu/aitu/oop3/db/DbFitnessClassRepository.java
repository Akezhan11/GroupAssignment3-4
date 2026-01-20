package edu.aitu.oop3.db;


import entities.FitnessClass;
import repositories.FitnessClassRepository;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbFitnessClassRepository implements FitnessClassRepository{
    @Override
    public void save(FitnessClass fitnessClass){
        String sql = """
            INSERT INTO fitness(type,description,date,time,cost,trainer_first_name,trainer_last_name,max_places) VALUES (?,?,?,?,?,?,?,?,?);
        """;
        try(Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){

        }catch (Exception e){
            throw new  RuntimeException("There are some errors with saving fitnessClass", e);
        }
    }
    @Override
    public FitnessClass findById(int id){

    }
    @Override
    public FitnessClass findByType(String fitnessType){

    }
    @Override
    public FitnessClass findByTrainerName(String fitnessTrainerName){

    }
    @Override
    public FitnessClass findByCost(int fitnessCost){

    }
    @Override
    public  List<FitnessClass> findAll(){

    }
}
