/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HospitalSystem hms = new HospitalSystem(" Dr. Sulaiman Al-Habib Hospital");
        HospitalInformation hospitalInfo = new HospitalInformation();
        System.out.println("*** Welcome To " + hms.getName() + " ***");
        int choice = 0;
        int c = 0;
        int h = 0;
        do {
            try {
                System.out.println("--------------------------------------------------");
                System.out.println("How would you like to proceed:\n1. Doctor\n2. Patient\n3. Hospital information\n4. Exit\nYour choice: ");
                choice = input.nextInt();
                switch (choice) {

                    case 1:

                        System.out.println("Enter Your Name: ");
                        String AccessName = input.next();

                        Doctor matchedDoctor = null;

                        if (AccessName.equals(hms.d1.getName())) {
                            matchedDoctor = hms.d1;
                        } else if (AccessName.equals(hms.d2.getName())) {
                            matchedDoctor = hms.d2;
                        } else if (AccessName.equals(hms.d3.getName())) {
                            matchedDoctor = hms.d3;
                        } else if (AccessName.equals(hms.d4.getName())) {
                            matchedDoctor = hms.d4;
                        }

                        if (matchedDoctor != null) {
                            System.out.println("Enter Your Access Number: ");
                            int AccessNum = input.nextInt();

                            if (matchedDoctor.getAccessNumber() == AccessNum) {

                                do {
                                    System.out.println("\nplease choose the service you want:\n");
                                    System.out.println("1. Search Patient\n"
                                            + "2. Retrive Patients\n"
                                            + "3. Show The Next Patient\n"
                                            + "4. Release Next Patient\n"
                                            + "5. add new Medicine\n"
                                            + "6. search for a Medicine \n"
                                            + "7. Display all appointment\n"
                                            + "8. Search for a doctor Appointments\n"
                                            + "9. Add a New appointmen\n"
                                            + "10. Return To The Main Menu");
                                    c = input.nextInt();
                                    switch (c) {
                                        case 1:
                                            hms.SearchForPatient();
                                            System.out.println("");
                                            break;

                                        case 2:

                                            System.out.println("1. All patients\n2. Female patients\n3. Male patients");
                                            int pg = input.nextInt();
                                            if (pg == 1) {
                                                hms.AllPatients();
                                                System.out.println("");
                                                break;
                                            } else if (pg == 2) {
                                                hms.PatientIsFemale();
                                                System.out.println("");
                                                break;
                                            } else if (pg == 3) {
                                                hms.PatientIsMale();
                                                System.out.println("");
                                                break;
                                            } else {
                                                System.out.println("invalid input");
                                                break;
                                            }
                                        case 3:
                                            hms.NextPatient();
                                            System.out.println("");
                                            break;

                                        case 4:
                                            hms.ReleaseNextPatient();
                                            System.out.println("");
                                            break;

                                        case 5:
                                            hms.addNewMedical();
                                            System.out.println("");
                                            break;

                                        case 6:
                                            hms.searchItem();
                                            System.out.println("");
                                            break;
                                        case 7:
                                            hms.displayAllApp();
                                            System.out.println("");
                                            break;
                                        case 8:
                                            hms.DoctorAppointments();
                                            System.out.println("");
                                            break;
                                        case 9:
                                            hms.AddNewAppointment();
                                            System.out.println("");
                                            break;
                                        case 10:
                                            System.out.println("Returning To The Main Menu..");
                                            break;

                                        default:
                                            System.out.println("Invalid Choice!");
                                    }
                                } while (c != 10);
                                break;
                            } else {
                                System.out.println("Wrong Access Number");
                                break;
                            }

                        } else {
                            System.out.println("\nYOU DO NOT HAVE AN ACCESS TO THE SYSTEM!");
                            break;
                        }

                    case 2:
                        do {
                            System.out.println("\nplease choose the service you want:\n");
                            System.out.println("1. Register\n"
                                    + "2. Make an appointment\n"
                                    + "3. Show booking information\n"
                                    + "4. pharmacy\n"
                                    + "5. Return To The Main Menu\n"
                                    + "Your choice:");
                            h = input.nextInt();
                            switch (h) {
                                case 1:
                                    hms.AddNewPatient();
                                    System.out.println("");
                                    break;
                                case 2:
                                    hms.NewBooking();
                                    System.out.println("");
                                    break;
                                case 3:
                                    hms.BookingInfo();
                                    System.out.println("");
                                    break;

                                case 4:
                                    hms.searchItem();
                                    System.out.println("");
                                    break;
                                case 5:
                                    System.out.println("Returning To The Main Menu..");
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                            }

                        } while (h != 5);
                        break;
                    case 3:
                        System.out.println(hospitalInfo.toString());
                        break;
                    default:
                        System.out.println("Invalid option!");

                    case 4:
                        System.out.println("Thank you for using our system..");
                        break;
                    

                }

            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
                input.next();
            }
        } while (choice!= 4);

    }
}
