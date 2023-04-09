public class ArrayLizt<E> implements Lizt<E> {

    private E[] arr;
    private int currLoc;
    private int arrLen;

    @SuppressWarnings("unchecked")
    public ArrayLizt() {
        arrLen = 10;
        currLoc = 0;
        arr = (E[]) (new Object[arrLen]);
    }

    @Override
    public int size() {
        return this.currLoc;
    }

    @Override
    public boolean add(E obj) {
        if ((currLoc + 1) >= arrLen) {
            resize();
        }
        arr[currLoc] = obj;
        currLoc += 1;
        return true;
    }

    @Override
    public void add(int index, E obj) {
        isValidIndex(index);
        if ((currLoc + 1) >= arrLen) {
            resize();
        }
        for (int i = (arrLen - 1); i >= index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = obj;
        currLoc += 1;
    }

    @Override
    public E get(int index) {
        isValidIndex(index);
        return arr[index];
    }

    @Override
    public E set(int index, E obj) {
        isValidIndex(index);
        E temp = arr[index];
        arr[index] = obj;
        return temp;
    }

    @Override
    public E remove(int index) {
        isValidIndex(index);
        E temp = arr[index];
        for (int i = index; i < (arrLen - 1); i++) {
            arr[i] = arr[i + 1];
        }
        arr[currLoc + 1] = null;
        currLoc--;
        return temp;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] arrTemp = (E[]) (new Object[arrLen * 2]);
        for (int i = 0; i < arrLen; i++) {
            arrTemp[i] = arr[i];
        }
        arr = (E[]) (new Object[arrLen * 2]);
        for (int i = 0; i < arrLen; i++) {
            arr[i] = arrTemp[i];
        }
        arrLen *= 2;
    }

    private void isValidIndex(int index) {
        if (!(index >= 0 && index < currLoc)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}