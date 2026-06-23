/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

public class BinaryTree<E> {

    public TreeNode<E> Root;
    public int size;

    public BinaryTree() {
        Root = null;
        size = 0;
    }

    public boolean hasLeft(TreeNode<E> node) {
        return (node.left != null);
    }

    public boolean hasRight(TreeNode<E> node) {
        return (node.right != null);

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TreeNode<E> addRoot(E e) {
        if (!isEmpty()) {
            System.out.println("Invalid action: Tree is not empty");
        } else {
            Root = new TreeNode<E>(e);
            size = 1;
        }
        return Root;
    }

    public TreeNode<E> search(TreeNode<E> root, E e, TreeNode<E> result) {
        if (root == null) {
            return null;
        }
        if (e == root.element) {
            return root;
        } else {
            if (root.left != null) {
                result = search(root.left, e, result);
            }

            if (root.right != null) {
                result = search(root.right, e, result);
            }

            return result;
        }

    }
   
    public void addLeft(E e, E p) {
        TreeNode<E> n = search(Root, p, null);
        if (n != null) {
            if (n.left != null) {
                System.out.println("parent already has a left child");
            } else {
                TreeNode<E> child = new TreeNode(e);
                n.left = child;
                child.parent = n;
                size++;
            }
        } else {
            System.out.println("parent does not exist");
        }
    }

    public void addRight(E e, E p) {
        TreeNode<E> n = search(Root, p, null);
        if (n != null) {
            if (n.right != null) {
                System.out.println("parent already has a left child");
            } else {
                TreeNode<E> child = new TreeNode(e);
                n.right = child;
                child.parent = n;
                size++;
            }
        } else {
            System.out.println("parent does not exist");
        }
    }
    
    
    
    

    //code start here
    
    
    
    
    
    
    private void Display(TreeNode<E> node) {
        if (node != null) {
            Display(node.left);           
            System.out.println(node.element + " ");  
            System.out.println("");
            Display(node.right);          
        }

    }

    public void Display() {
        Display(Root);
    }

    
    public Patient SearchForPatient(int id) {
        return SearchForPatient(Root, id);
    }

    private Patient SearchForPatient(TreeNode<E> root, int id) {
        if (root == null) {
            return null;
        }

        if (((Patient) root.element).getPATIENT_RECORD_NUM()== id) {

            return (Patient) root.element;

        }
        if (id < ((Patient) root.element).getPATIENT_RECORD_NUM()) {
            return SearchForPatient(root.left, id);
        } else {
            return SearchForPatient(root.right, id);
        }
    }
    
    public SinglyLinkedList<Patient> AllPatients() {
        SinglyLinkedList<Patient> AllPatients = new SinglyLinkedList<>();
        return AllPatients(Root, AllPatients);
    }

    private SinglyLinkedList<Patient> AllPatients(TreeNode<E> node, SinglyLinkedList<Patient> AllPatients) {

        if (node != null) {
            AllPatients(node.left, AllPatients);          
            AllPatients.addLast((Patient) node.element);
            

            AllPatients(node.right, AllPatients);
        }

        return AllPatients;
    }
    
    
    public SinglyLinkedList<Patient> PatientIsFemale() {
        SinglyLinkedList<Patient> patientsFemale = new SinglyLinkedList<>();
        return PatientIsFemale(Root, patientsFemale);
    }

    private SinglyLinkedList<Patient> PatientIsFemale(TreeNode<E> node, SinglyLinkedList<Patient> patientsFemale) {

        if (node != null) {
            PatientIsFemale(node.left, patientsFemale);           
            if (((Patient) node.element).getGender().equals("Female") ) {
                patientsFemale.addLast((Patient) node.element);
            }

            PatientIsFemale(node.right, patientsFemale);
        }

        return patientsFemale;
    }
    

     public SinglyLinkedList<Patient> PatientIsMale() {
        SinglyLinkedList<Patient> patientsMale = new SinglyLinkedList<>();
        return PatientIsMale(Root, patientsMale);
    }

    private SinglyLinkedList<Patient> PatientIsMale(TreeNode<E> node, SinglyLinkedList<Patient> patientsMale) {

        if (node != null) {
            PatientIsMale(node.left, patientsMale);           
            if (((Patient) node.element).getGender().equals("Male")) {
                patientsMale.addLast((Patient) node.element);
            }

            PatientIsMale(node.right, patientsMale);
        }

        return patientsMale;
    }


    public TreeNode<E> AddNewPatient(Patient patient) {
        return AddNewPatient(Root, patient);

    }

    public TreeNode<E> AddNewPatient(TreeNode<E> root, Patient patient) {
        if (root == null) {
            root = new TreeNode<E>((E) patient);
            return root;
        }

        if (patient.getPATIENT_RECORD_NUM() < ((Patient) root.element).getPATIENT_RECORD_NUM()) {
            root.left = AddNewPatient(root.left, patient);
        } else if (patient.getPATIENT_RECORD_NUM() > ((Patient) root.element).getPATIENT_RECORD_NUM()) {
            root.right = AddNewPatient(root.right, patient);
        }
        return root;

    }
    
    public TreeNode<E> addNewMedical(Medicine medicalitem) {
        return addNewMedical(Root, medicalitem);
    }

    public TreeNode<E> addNewMedical(TreeNode<E> root, Medicine medicalitem) {
    if (root == null) {
        root = new TreeNode<>((E) medicalitem);
        return root;
    }

    Medicine currentItem = (Medicine) root.element;

    if (medicalitem.getName().compareTo(currentItem.getName()) < 0) {
        root.left = addNewMedical(root.left, medicalitem);
    } else if (medicalitem.getName().compareTo(currentItem.getName()) > 0) {
        root.right = addNewMedical(root.right, medicalitem);
    }
    return root;
    }

    public Medicine searchItem(String name) {
        return searchItem(Root, name);
    }

    private Medicine searchItem(TreeNode<E> root, String name) {
        if (root == null) {
            return null;
        }

        if (((Medicine) root.element).getName().equals(name)) {
            return (Medicine) root.element;

        }

        if (((Medicine) root.element).getName().compareTo(name) > 0) {
            return searchItem(root.left, name);
        } else {
            return searchItem(root.right, name);
        }
    }

}
