import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import entities.*;
import repositories.*;
import repositories.implementations.*;
import service.*;

public class Main {
    private Member currentMember;
        MemberRepository memberRepository = new InMemoryMemberRepository();
        ClassBookingRepository bookingRepository = new InMemoryClassBookingRepository();

        MemberService memberService = new MemberService(memberRepository);
        MembershipService membershipService = new MembershipService(memberRepository);
        BookingService bookingService = new BookingService(bookingRepository);

        ArrayList<Member> members = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        public void run() {
            boolean running = true;
            while (running) {
                System.out.println("Welcome to FitNation");
                System.out.println("System for managing memberships, fitness classes and bookings in a gym or fitness club");
                System.out.println("1. Print all members");
                System.out.println("2. Add new member");
                System.out.println("3. Add new fitness class");
                System.out.println("4. Show information about member");
                System.out.println("5. Booking the class");
                System.out.println("6. Membership checking");
                System.out.println("7. Quit");

                int choice = scanner.nextInt();

                scanner.nextLine();


                switch (choice) {
                    case 1 -> printVehicles();
                    case 2 -> addMember();
                    case 3 -> addFitnessClass();
                    case 4 -> InsuranceFee();
                    case 5 -> BookingClass();
                    case 6 -> MembershipChecking();
                    case 7 -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            }
        }
        private void printVehicles () {
            if (vehicles == null || vehicles.isEmpty()) {
                System.out.println("No vehicles in the fleet");
            } else {
                for  (Vehicle v : vehicles) {
                    System.out.println(v);
                }
            }
        }
        private void addMember() {
            System.out.println("Enter first name:");
            String name = scanner.nextLine();

            System.out.println("Enter last name:");
            String surname = scanner.nextLine();

            System.out.println("Enter phone number (+7XXXXXXXXXX):");
            String phoneNumber = scanner.nextLine();

            System.out.println("Enter email:");
            String email = scanner.nextLine();
            System.out.println("Enter gender:");
            String gender = scanner.nextLine();

            Member member = new Member(name,surname,phoneNumber, gender, email);
            memberService.addMember(member);
            currentMember = member;
            System.out.println("Member registered successfully!\n");
        }


        private void addFitnessClass() {
            System.out.println("Enter fitness class type (e.g., Yoga):");
            String classType = scanner.nextLine();

            System.out.println("Enter class description:");
            String classDescription = scanner.nextLine();

            System.out.println("Enter class date (dd.MM.yyyy):");
            String classDate = scanner.nextLine();

            System.out.println("Enter class time (HH:mm):");
            String classTime = scanner.nextLine();

            System.out.println("Enter class cost:");
            int classCost = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter trainer first name:");
            String trainerFirst = scanner.nextLine();

            System.out.println("Enter trainer last name:");
            String trainerLast = scanner.nextLine();

            System.out.println("Enter max places:");
            int maxPlaces = Integer.parseInt(scanner.nextLine());

            ClassBooking booking = new ClassBooking(
                    classType,
                    classDescription,
                    classDate,
                    classTime,
                    classCost,
                    trainerFirst,
                    trainerLast,
                    maxPlaces,
                    0
            );
        }


        private void InsuranceFee() {
            double total = 0;
            for (Vehicle v : vehicles) {
                total += v.calculateInsuranceFee();
            }
            System.out.println("Total insurance fee: " + total);
        }
        private void BookingClass() {
            System.out.println("Enter fitness class type (e.g., Yoga):");
            String classType = scanner.nextLine();

            System.out.println("Enter class description:");
            String classDescription = scanner.nextLine();

            System.out.println("Enter class date (dd.MM.yyyy):");
            String classDate = scanner.nextLine();

            System.out.println("Enter class time (HH:mm):");
            String classTime = scanner.nextLine();

            System.out.println("Enter class cost:");
            int classCost = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter trainer first name:");
            String trainerFirst = scanner.nextLine();

            System.out.println("Enter trainer last name:");
            String trainerLast = scanner.nextLine();

            System.out.println("Enter max places:");
            int maxPlaces = Integer.parseInt(scanner.nextLine());

            ClassBooking booking = new ClassBooking(
                    classType,
                    classDescription,
                    classDate,
                    classTime,
                    classCost,
                    trainerFirst,
                    trainerLast,
                    maxPlaces,
                    0
            );
        }

    private void MembershipChecking() {
        if (currentMember != null) {
            membershipService.checkMembershipActive(currentMember);
            System.out.println("Membership is active");
        } else {
            System.out.println("No member selected!");
        }
    }

        void main(){
            new Main().run();
            try (Connection connection = DatabaseConnection.getConnection()){
                System.out.println("Connection successful!");

                String sql = "SELECT CURRENT_TIMESTAMP";
                try (PreparedStatement stmt = connection.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()){

                    if(rs.next()){
                        System.out.println("Database time:" + rs.getTimestamp(1));
                    }
                }
            }catch (SQLException e){
                System.out.println("Error while connecting to database:");
                e.printStackTrace();
        }
        }
    }