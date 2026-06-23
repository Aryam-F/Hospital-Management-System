/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;


public class ScheduleAppointment {
    

    private final int PID;
    private Patient patient;
    private Appointment appointment;
    private String doctorName;

    private String status;

  
    public ScheduleAppointment(Patient patient, Appointment appointment, String doctorName) {
        this.PID = SetNewId();
        setPatient(patient);
        setAppointment(appointment);
        setDoctorName(doctorName);
      
        setStatus("New");
    }

    public ScheduleAppointment() {
        this(null, null, "");
    }

    
    private final int SetNewId() {
        int min = 1;
        int max = 999;
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

    public double CalculateTheCost() {
        double price = appointment.getPrice();
        return price + price * AvailableForBooking.VAT;
    }

    public final void confirm() {
        setStatus("Confirmed");
        appointment.book();
        System.out.println("Your booking has been successfully confirmed. \nThank you\n");
    }

    public final void cancel() {
        setStatus("Cancelled");
        appointment.cancelBooking();
        System.out.println("Your booking has been cancelled. \nThank you\n");
    }

    
    public int getPID() {
        return PID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Booking ID: %d\nDoctor Name: %s\nPatient: %s\nAppointment: %s\nStatus: %s\nTotal Payemnt: %.2f SAR.", getPID(), getDoctorName(), getPatient(), getAppointment(), getStatus(), CalculateTheCost());
    }
}
