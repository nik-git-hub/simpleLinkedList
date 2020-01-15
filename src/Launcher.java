public class Launcher {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add(22);
        list.add(83);
        list.add(12);
        list.add(78);

        display(list);

        list.remove(22);
        display(list);

        contains(list, 83);

        list.add(55);
        display(list);

        list.remove(12);
        display(list);

        contains(list, 120);

        list.remove(55);
        display(list);

    }

    private static void contains(LinkedList list, Object value) {
        if (list.contains(value)) {
            System.out.println("List contains this value. " + value.toString());
        } else {
            System.out.println("The value isn't found. " + value.toString());
        }
    }

    private static void display(LinkedList list){
        boolean desc = false;
        list.show(desc);

        desc = true;
        list.show(desc);
        System.out.println("Amount of elements: " + list.getSize());
    }
}
