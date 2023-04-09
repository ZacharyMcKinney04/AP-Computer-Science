public class LiztUnitTest{

    public static void main(String[] args) {
        
        Lizt<Character> testList = new LinkedLizt<Character>();

        System.out.println("Initial size expected to be 0, got:" + testList.size());

        testList.add('A');
        testList.add('C');
        testList.add('E');
        testList.add(1, 'B');
        testList.add(3, 'D');
        System.out.println();
        System.out.print("Added A, B, C, D, E...");
        System.out.println("size expected to be 5, got: " + testList.size());
        System.out.println("Element at index 0 should be A, got: " + testList.get(0));
        System.out.println("Element at index 1 should be B, got: " + testList.get(1));
        System.out.println("Element at index 2 should be C, got: " + testList.get(2));
        System.out.println("Element at index 3 should be D, got: " + testList.get(3));
        System.out.println("Element at index 4 should be E, got: " + testList.get(4));

        System.out.println();
        System.out.println("Removing element at index 0. Expected: A, got: " + testList.remove(0));
        System.out.println("Getting element at index 0.  Expected B, got: " + testList.get(0));
        System.out.println("Now, size expected to be 4, got: " + testList.size());
        System.out.println();

        System.out.print("Setting element at index 3 to F, returning previous element..");
        System.out.println("Returned element should be E, got: " + testList.set(3, 'F'));
        System.out.println("Element at index 3 should now be F, got:" + testList.get(3));
        System.out.println();

        System.out.print("Testing resize by adding 8 new elements...");
        testList.add('G');
        testList.add('H');
        testList.add('I');
        testList.add('J');
        testList.add('K');
        testList.add('L');
        testList.add('M');
        testList.add('N');
        System.out.println("List size should be 12, got: " + testList.size());
        System.out.println();

        System.out.print("Removng all items from list...");
        while(testList.size() > 0){
           testList.remove(0);
        }
        System.out.println("List size should now to be 0, got:" + testList.size());
        System.out.println(); 

        try {
            System.out.print("Setting element at index 1 should throw an error...");
            testList.set(1, 'T');
            System.out.println("but it did NOT.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("error successfully thrown (and caught)");
        }

        try {
            System.out.print("Adding element at index 1 should throw an error...");
            testList.add(1, 'T');
            System.out.println("but it did NOT.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("error successfully thrown (and caught)");
        }

        try {
            System.out.print("Getting element at index 0 should throw an error...");
            testList.get(0);
            System.out.println("but it did NOT.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("error successfully thrown (and caught)");
        }

        try {
            System.out.print("Removing element at index 0 should throw an error...");
            testList.remove(0);
            System.out.println("but it did NOT.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("error successfully thrown (and caught)");
        }
    }

}