/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;


public interface AvailableForBooking {
    
  public static final double VAT = 0.15;

    public abstract boolean Availability();

    public abstract void book();

    public abstract void cancelBooking();

}