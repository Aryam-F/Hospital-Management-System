/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

public class Appointment implements AvailableForBooking {

    private final int NUMBER;
    private boolean available;
    private Doctor doctor;
    private double price;

    
    public Appointment(double price, Doctor doctor) {
        this.NUMBER = AppNum();
        setAvailable(true);
        setDoctor( doctor);
        setPrice(price);
    }

    public Appointment() {
        this(0.0, null);
    }

    
    private final int AppNum() {
        int min = 0;
        int max = 999;
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

    @Override
    public void book() {
        setAvailable(false);
        System.out.println("The appointment is booked\n");
    }

    @Override
    public void cancelBooking() {
        setAvailable(true);
        System.out.println("The appointment is available now.\n");
    }

 
    @Override
    public boolean Availability() {
        if (available) {
            return true;
        } else {
            return false;
        }

    }

    
    public int getNumber() {
        return NUMBER;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void displayApp() {
        System.out.println("Appointment Number: " + getNumber());
        System.out.println(doctor);
        System.out.printf("Price: %.2f SAR.\n", getPrice());
    }

    @Override
    public String toString() {
        return String.format("\nAppointment Number: %d\n",
                getNumber());
    }
}
