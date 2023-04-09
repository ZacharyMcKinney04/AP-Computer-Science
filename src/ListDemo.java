import java.util.List;
import java.util.ArrayList;

public class ListDemo{

    public static void main(String[] args ) {
        // String[] arr = new String[10]; // declare an array
        
        // declarecs a reference to a list
        // then creating a new arralist to go into that reference
        // <String> identifies what tpy eof list we are working with
        List<String> list = new ArrayList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add(1, "M"); // add at specific index
        list.remove(0);
        System.out.println(list);
        String removed = list.remove(0);
        System.out.println("Removed: " + removed);
        System.out.println(list);
        System.out.println("Now the first item in the list is: " + list.get(0));
        
        System.out.println(list);
        String bumped = list.set(0, "V");
        System.out.println(list);
        System.out.println(bumped + " was bumped out of the list");

        System.out.println("The number of items in the list is: " + list.size());

        // traditional traverse
        for(int i = 0; i < list.size(); i++) {
            if ( list.get(i).equals("B")) { 
                System.out.println("Got B");
            }
        }
        
        for (String s : list) {
            if ( s.equals("B")) { 
                System.out.println("Got B");
            }
        }

        int size = list.size();
        for ( int i = 0; i < size; i++) {
            list.add("X");
            System.out.println(list);
        }

        list.add("C");
        list.add("C");
        list.add("T");
        list.add("C");
        System.out.println(list);
        System.out.println();
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("C")) {
                list.remove(i);
                System.out.println(list);
            }
        }
    }
}
