import java.util.*;

abstract class RecyclableItem {
    protected String itemName;

    public RecyclableItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public abstract String getRecycleBin();
}


class Plastic extends RecyclableItem {
    public Plastic(String itemName) { super(itemName); }
    @Override
    public String getRecycleBin() { return "Plastic Bin"; }
}

class Glass extends RecyclableItem {
    public Glass(String itemName) { super(itemName); }
    @Override
    public String getRecycleBin() { return "Glass Bin"; }
}

class Metal extends RecyclableItem {
    public Metal(String itemName) { super(itemName); }
    @Override
    public String getRecycleBin() { return "Metal Bin"; }
}

class Paper extends RecyclableItem {
    public Paper(String itemName) { super(itemName); }
    @Override
    public String getRecycleBin() { return "Paper Bin"; }
}


public class RecycleItemSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lists to store sorted items
        List<String> plasticItems = new ArrayList<>();
        List<String> glassItems = new ArrayList<>();
        List<String> metalItems = new ArrayList<>();
        List<String> paperItems = new ArrayList<>();

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter the item: ");
            String itemName = sc.nextLine();

            System.out.print("Enter the type of item (plastic/glass/metal/paper): ");
            String type = sc.nextLine().toLowerCase();

            switch (type) {
                case "plastic":
                    plasticItems.add(itemName);
                    break;
                case "glass":
                    glassItems.add(itemName);
                    break;
                case "metal":
                    metalItems.add(itemName);
                    break;
                case "paper":
                    paperItems.add(itemName);
                    break;
                default:
                    System.out.println("Unknown type, skipping...");
            }
        }

        
        System.out.println("\nThe Items in Plastic Bin are:");
        for (String item : plasticItems)
            System.out.println(item);

        System.out.println("\nThe Items in Glass Bin are:");
        for (String item : glassItems)
            System.out.println(item);

        System.out.println("\nThe Items in Metal Bin are:");
        for (String item : metalItems)
            System.out.println(item);

        System.out.println("\nThe Items in Paper Bin are:");
        for (String item : paperItems)
            System.out.println(item);

        sc.close();
    }
}

