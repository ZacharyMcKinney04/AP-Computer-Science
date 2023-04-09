/*
 * This interface mimics the interface of List
 * It has a size, get, set, remove, add, and 
 * add (boolean) methods
 * 
 * @version 1.0
 */
public interface Lizt<T> {

    /**
     * Returns the number of elements in this list. If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     * @return the number of elements in this list
     * precondition: none
     * postcondition: this list is unaffected 
     */
    public int size();

    /**
     * Appends the specified element to the end of this list (optional operation).
     * Lists that support this operation may place limitations on what elements may
     * be
     * added to this list. In particular, some lists will refuse to add null
     * elements,
     * and others will impose restrictions on the type of elements that may be
     * added.
     * List classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     * 
     * @param obj element to be appended to this list
     * @return true (as specified by Collection.add(T))
     * pre condition - none
     * post condition - a boolean is returned, list unaffected
     */

    public boolean add(T obj);

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation). Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * precondition index < 0 || index >= size()
     * post condition an obj is added to the list at the index and other objs
     * after in the list are shifted once 
     */
    public void add(int index, T obj);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     * precondtion index < 0 || index >= size()
     * postcondition  list unchanged
     */
    public T get(int index);

    /**
     * sets the element at the given index location
     * to the element supplied as the parameter
     * returns the element previously at the location
     * precondition: 0 <= index < size
     * post condition: the List size is unchanged
     */
    public T set(int index, T obj);

    /**
     * Removes the element at the specified position in this list (optional
     * operation). Shifts any subsequent elements to the left (subtracts one
     * from their indices). Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     * precondition index < 0 || index >= size()
     * post condition the list shrinks by one
     * elements after the obj removed after shift down once
     */
    public T remove(int index);

}
