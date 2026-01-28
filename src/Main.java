import edu.aitu.oop3.db.*;
import entities.FitnessClass;
import entities.Member;
import repositories.MemberRepository;
import service.BookingService;
import service.FitnessClassService;
import service.MemberService;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void run(){
        Scanner sc = new Scanner(System.in);
        DbFitnessClassRepository fitnessRepo = new DbFitnessClassRepository();
        DbClassBookingRepository bookingRepo = new DbClassBookingRepository();

        FitnessClassService fitnessService = new FitnessClassService(fitnessRepo);
        BookingService bookingService = new BookingService(bookingRepo);

        Member member = new Member();
        while (true){
            System.out.println("Fitness application");
            System.out.println("Menu");
            System.out.println("1: Show all fitness classes");
            System.out.println("2: Find fitness class by type");
            System.out.println("3: Find fitness class by id");
            System.out.println("4: Find classes by trainer name");
            System.out.println("5: Find classes by cost");
            System.out.println("6: Book fitness class");
            System.out.println("7: Cancel booking");
            System.out.println("8: Show bookings by fitness class");
            System.out.println("9: Add new fitness class");
            System.out.println("10: Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> {
                    List<FitnessClass> classes = fitnessService.getAll();
                    classes.forEach(System.out::println);
                }

                case 2 -> {
                    System.out.print("Enter class ID: ");
                    int id = sc.nextInt();
                    FitnessClass fc = fitnessService.getById(id);
                    System.out.println(fc != null ? fc : "Not found");
                }

                case 3 -> {
                    System.out.print("Trainer name: ");
                    String name = sc.nextLine();
                    fitnessService.getByTrainerName(name)
                            .forEach(System.out::println);
                }

                case 4 -> {
                    System.out.print("Cost: ");
                    int cost = sc.nextInt();
                    fitnessService.getByCost(cost)
                            .forEach(System.out::println);
                }

                case 5 -> {
                    System.out.print("Class ID to book: ");
                    int id = sc.nextInt();
                    FitnessClass fc = fitnessService.getById(id);
                    bookingService.bookClass(member, fc);
                    System.out.println("Booked successfully");
                }

                case 6 -> {
                    System.out.print("Class ID to cancel: ");
                    int id = sc.nextInt();
                    FitnessClass fc = fitnessService.getById(id);
                    bookingService.cancelBooking(member, fc);
                    System.out.println("Booking cancelled");
                }

                case 7 -> {
                    System.out.print("Fitness class ID: ");
                    int id = sc.nextInt();
                    bookingService.getBookingsByFitness(id)
                            .forEach(System.out::println);
                }

                case 8 -> {
                    FitnessClass fc = new FitnessClass();

                    System.out.print("Type: ");
                    fc.setFitnessType(sc.nextLine());

                    System.out.print("Description: ");
                    fc.setFitnessDescription(sc.nextLine());

                    System.out.print("Date: ");
                    fc.setFitnessDate(sc.nextLine());

                    System.out.print("Time: ");
                    fc.setFitnessTime(sc.nextLine());

                    System.out.print("Cost: ");
                    fc.setFitnessCost(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Trainer name: ");
                    fc.setFitnessTrainerName(sc.nextLine());

                    System.out.print("Trainer surname: ");
                    fc.setFitnessTrainerSurname(sc.nextLine());

                    System.out.print("Max places: ");
                    fc.setMaxPlaces(sc.nextInt());

                    fitnessService.create(fc);
                    System.out.println("Fitness class added");
                }
                case 9 -> main();
                case 10 -> {
                    System.out.println("Closing the program");
                    return;
                }

                default -> System.out.println("Unknown command");
            }
        }
    }
    void main(){
        DataBaseCreation.init();
        new Main().run();
    }
}