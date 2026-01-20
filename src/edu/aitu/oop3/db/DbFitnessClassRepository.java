package edu.aitu.oop3.db;


import entities.ClassBooking;
import entities.FitnessClass;
import entities.Member;
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
            INSERT INTO fitness(type,description,date,time,cost,trainer_first_name,trainer_last_name,max_places) VALUES (?,?,?,?,?,?,?,?);
        """;
        try(Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,fitnessClass.getFitnessType());
            ps.setString(2,fitnessClass.getFitnessDescription());
            ps.setString(3,fitnessClass.getFitnessDate());
            ps.setString(4,fitnessClass.getFitnessTime());
            ps.setInt(5,fitnessClass.getFitnessCost());
            ps.setString(6,fitnessClass.getFitnessTrainerName());
            ps.setString(7,fitnessClass.getFitnessTrainerSurname());
            ps.setInt(8,fitnessClass.getMaxPlaces());
            ps.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException("Error saving fitness class ", e);
        }
    }
    @Override
    public FitnessClass findById(int id){
        String sql = """
                SELECT * FROM fitness WHERE id=? ;
                """;
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String type = rs.getString("type");
                String description = rs.getString("description");
                String date = rs.getString("date");
                String time = rs.getString("time");
                int cost = rs.getInt("cost");
                String name = rs.getString("trainer_first_name");
                String surname = rs.getString("trainer_last_name");
                int maxPlace = rs.getInt("max_places");
                return new FitnessClass(type,description,date,time,cost,name,surname,maxPlace);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error finding fitness by id " + id, e);
        }
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
