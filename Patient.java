/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author aryam
 */
public final class Patient extends Individual {

    private final int PATIENT_RECORD_NUM;

   
    public Patient(int id, String name, String gender, int PATIENT_RECORD_NUM) {
        super(id, name, gender);
        this.PATIENT_RECORD_NUM = PATIENT_RECORD_NUM;

    }

    public Patient() {
        this(0, "","", 0);
    }

    public int getPATIENT_RECORD_NUM() {
        return PATIENT_RECORD_NUM;
    }

  
    @Override
    public String toString() {
        return String.format("%s\nMedical Record Id: %d\n", super.toString(), getPATIENT_RECORD_NUM());
    }

}
