/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

public class LLQueue<E> {

    static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    protected Node<E> front;
    protected Node<E> rear;
    protected int size;

    public LLQueue() { // constructor
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest; // special case of a previously empty queue 
        } else {
            rear.setNext(newest); // add node at the tail of the list 
        }
        rear = newest; // update the reference to the tail node 
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; // the queue is now empty
        }
        return answer;
    }

    
    
    
//code start here
    
    
    
    
    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int s = size();

        for (int i = 0; i < s; i++) {
            E ele = dequeue();
            System.out.println(ele);

            enqueue(ele);
        }

    }

    public void NextPatient() {
        if (isEmpty()) {
            System.out.println("No reservations yet.");
        } else {
            ScheduleAppointment booking = (ScheduleAppointment) first();
            String patientName = booking.getPatient().getName();
            System.out.println("The next patient is '" + patientName + "'");
        }
    }

    public void ReleaseNextPatient() {

        if (isEmpty()) {
            System.out.println("No reservations yet.");
        } else {
            ScheduleAppointment booking = (ScheduleAppointment) dequeue();
            String customerName = booking.getPatient().getName();
            System.out.println("\nNext patient is: " + customerName);
            booking.setStatus("Checked out");
            System.out.println(booking);
            System.out.println("the lineup of patient bookings has been revised.\nThank you.\n");

        }
    }

    public ScheduleAppointment BookingInfo(int id) {

        int s = size();
        ScheduleAppointment book = null;
        for (int i = 0; i < s; i++) {
            ScheduleAppointment ele = (ScheduleAppointment) dequeue();
            if (ele.getPID() == id) {
                book = ele;
            }

            enqueue((E) ele);
        }
        return book;

    }
}
