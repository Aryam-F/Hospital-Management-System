/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;



public class TreeNode<E> {

    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public TreeNode<E> parent;

    public TreeNode(E elem) {
        element = elem;
        left = null;
        right = null;
        parent = null;
    }

    @Override
    public String toString() {
        return element + " ";
    }
}
