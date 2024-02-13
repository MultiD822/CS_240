public class TestList {
    public static void main(String[] arge){
        Link_List<Integer> list1 = new Link_List<>();
        Link_List<Integer> list2 = new Link_List<>();

        //Items in first linked list 
        list1.addNode_toFront(9);
        list1.addNode_toFront(0);
        list1.addNode_toFront(8);
        list1.addNode_toFront(5);
        Node<Integer> current1Node = list1.headNode;

        //Items in second linked list
        list2.addNode_toFront(1);
        list2.addNode_toFront(5);
        list2.addNode_toFront(2);
        list2.addNode_toFront(7);
        Node<Integer> current2Node = list2.headNode;

        //Print the lists
        System.out.println("[]==================================[]");
        printLists(current1Node, current2Node);
        System.out.println("[]==================================[]");

         
         
        
        
        if (current2Node != null){
            current2Node.pointerNode = current2Node.pointerNode.pointerNode;
        }
        
        System.out.println("[]==================================[]");
        printLists(current1Node, current2Node);
        System.out.println("[]==================================[]");
        
    }

    public static void printLists(Node<Integer> current1Node, Node<Integer> current2Node){
        for (int i = 0; i < 4; i++){
            if (current1Node != null) {
                System.out.println("[] List 1: " + current1Node.data);
                current1Node = current1Node.pointerNode;
            }
        }
        System.out.println("[]==============[]");
        for (int i = 0; i < 4; i++){
            if (current2Node != null) {
                System.out.println("[] List 2: " + current2Node.data);
                current2Node = current2Node.pointerNode;
            }
        }
    }
}
