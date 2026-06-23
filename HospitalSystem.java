/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalsystem;


import java.util.Scanner;

public class HospitalSystem {

    
    private SinglyLinkedList<Appointment> appointments = new SinglyLinkedList<>();

    private LLQueue<ScheduleAppointment> bookings = new LLQueue<>();

    private BinaryTree<Patient> patients = new BinaryTree<Patient>();
    
    private BinaryTree<Medicine> medicalitems = new BinaryTree<Medicine>();
    
    Doctor d1 = new Doctor(1, "Khaled", "Male", "Cardiology",1111);
    Doctor d2 = new Doctor(2, "Amira", "Female", "Neurology",2222);
    Doctor d3 = new Doctor(3, "Omar", "Male", "Pediatrics",3333);
    Doctor d4 = new Doctor(3, "Arwa", "Female", "Dermatology",4444);
    
    
    
    Scanner input = new Scanner(System.in);
    
    private String name;

    public HospitalSystem(String name) {
        this.name = name;
        fillData();
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addNewMedical() {
        System.out.println("Med Name: ");
        String name = input.nextLine();
        System.out.println("quantity: ");
        int quantity = input.nextInt();
        System.out.println("Price: ");
        double price = input.nextDouble();
        System.out.println("Expire date: ");
        String expiryDate = input.next();
        Medicine medicalitem = new Medicine(name, quantity, price, expiryDate);
        medicalitems.addNewMedical(medicalitem);

        System.out.println("New Medical has been added successfully.");
    }

    public void searchItem() {
        System.out.println("Med Name:");
        String name = input.nextLine();
        Medicine m = medicalitems.searchItem(name);
        if (m != null) {
            System.out.println(m);
        } else {
            System.out.println("Invalid Name");
        }
    }
    
    

    public void AddNewPatient() {

        System.out.print("Patient ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Patient Name: ");
        String name = input.nextLine();
        System.out.print("Gender (Female/Male): ");
        String gender = input.next();
        System.out.print("Medical Record ID: ");
        int medicalRecordId = input.nextInt();
        Patient patient = new Patient(id, name, gender, medicalRecordId);

        patients.AddNewPatient(patient);

        System.out.println("New patient has been added successfully.");

    }

    public void SearchForPatient() {

        System.out.println("Patient Medical Record ID: ");
        int id = input.nextInt();

        Patient p = patients.SearchForPatient(id);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Invalid ID");
        }
    }

    public void PatientIsFemale() {
        SinglyLinkedList<Patient> p = patients.PatientIsFemale();
        System.out.println("");
        System.out.println("Female patients: ");
        p.DisplayList();
    }
    
     public void PatientIsMale() {
        SinglyLinkedList<Patient> p = patients.PatientIsMale();
        System.out.println("");
        System.out.println("Male patients: ");
        p.DisplayList();
    }
     
     public void AllPatients() {
        SinglyLinkedList<Patient> p = patients.AllPatients();
        System.out.println("");
        p.DisplayList();
    }
    

    public void displayAllApp() {
        appointments.DisplayAllAppoinrment();
    }

    public void AddNewAppointment() {
        System.out.print("Enter the price to the appointment: ");

        double price = input.nextDouble();

        System.out.println("Doctor's ID: ");
        int id = input.nextInt();
        System.out.println("Doctor's name: ");
        String name = input.next();
        System.out.print("The gender (Female/Male): ");
        String gender = input.next();

        System.out.print("Specialization: ");
        String specialization = input.next();

        Doctor doctor = new Doctor(id, name, gender, specialization,0);

        Appointment ap = new Appointment(price, doctor);
        appointments.addLast(ap);
    }

    public void NewBooking() {

        displayAllApp();
        System.out.println("");
        System.out.print("Appointment number: ");
        int NUMBER = input.nextInt();
        Appointment ap = appointments.SearchApp(NUMBER);

        if (ap == null) {
            System.out.println("Invalid Appointment number.");
            return;
        }
        if (!ap.Availability()) {
            System.out.println("The Appointment is not available.");
            return;
        }
        System.out.println("Medical record id: ");

        int id = input.nextInt();

        Patient PP = patients.SearchForPatient(id);

        if (PP == null) {
            System.out.println("Invalid id patient ");
            return;
        }
        ScheduleAppointment booking = new ScheduleAppointment(PP, ap, ap.getDoctor().getName());
        booking.confirm();
        bookings.enqueue(booking);
        System.out.println(booking);

        System.out.println("The Appointment has been booked successfully.\n\n");
    }

    public void NextPatient() {
        bookings.NextPatient();
    }

    public void ReleaseNextPatient() {

        bookings.ReleaseNextPatient();
    }

    public void DoctorAppointments() {

        System.out.println("Enter name doctor: ");
        String name = input.next();

        appointments.SearchApp(name);

    }

    public void BookingInfo() {

        System.out.println("Enter booking id: ");
        int id = input.nextInt();

        ScheduleAppointment book = bookings.BookingInfo(id);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("invalid Booking id.");
        }

    }

    public void fillData() {
        Patient p1 = new Patient(1, "Shahad", "Female", 1001);
        Patient p2 = new Patient(2, "Mohammed", "Male", 1002);
        Patient p3 = new Patient(3, "Sara", "Female", 1003);
        Patient p4 = new Patient(4, "Saif", "Male", 1004);

        patients.addRoot(p1);
        patients.AddNewPatient(p2);
        patients.AddNewPatient(p3);
        patients.AddNewPatient(p4);
        

        Doctor d1 = new Doctor(1, "Khaled", "Male", "Cardiology",1111);
        Doctor d2 = new Doctor(2, "Amira", "Female", "Neurology",2222);
        Doctor d3 = new Doctor(3, "Omar", "Male", "Pediatrics",3333);
        Doctor d4 = new Doctor(3, "Arwa", "Female", "Dermatology",4444);
        
        Medicine m1 = new Medicine("Advil", 288, 180, "27.12");
        Medicine m2 = new Medicine("Caplyta", 465, 90, "29.9");
        Medicine m3 = new Medicine("Haloperidol", 120, 120, "26.11");
        Medicine m4 = new Medicine("Meclizine", 632, 340, "28.7");

        medicalitems.addRoot(m1);
        medicalitems.addNewMedical(m2);
        medicalitems.addNewMedical(m3);
        medicalitems.addNewMedical(m4);

        Appointment ap1 = new Appointment(120, d1);
        Appointment ap2 = new Appointment(450, d2);
        Appointment ap3 = new Appointment(670, d3);
        Appointment ap4 = new Appointment(890, d4);

        appointments.addLast(ap1);
        appointments.addLast(ap2);
        appointments.addLast(ap3);
        appointments.addLast(ap4);

        ScheduleAppointment b1 = new ScheduleAppointment(p1, ap1, d1.getName());
        ScheduleAppointment b2 = new ScheduleAppointment(p2, ap2, d2.getName());
        ScheduleAppointment b3 = new ScheduleAppointment(p3, ap3, d3.getName());
        ScheduleAppointment b4 = new ScheduleAppointment(p4, ap4, d4.getName());
        
        bookings.enqueue(b1);
        b1.setStatus("Confirmed");
        bookings.enqueue(b2);
        b2.setStatus("Confirmed");
        bookings.enqueue(b3);
        b3.setStatus("Confirmed");
        bookings.enqueue(b4);
        b4.setStatus("Confirmed");
        
    }
    
   
}
