/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

public class Doctor extends Individual {

    private String specialization;
    private int AccessNumber;

    
    public Doctor(int ID, String name, String gender, String specialization, int AccessNumber) {
        super(ID, name, gender);
        setSpecialization(specialization);
        this.AccessNumber=AccessNumber;
        
    }

    public Doctor() {
        this(0, "", "", "",0);
    }

    
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAccessNumber() {
        return AccessNumber;
    }


  
    @Override
    public String toString() {
        return String.format("%s\nSpecialization: %s", super.toString(), getSpecialization());
    }

}
