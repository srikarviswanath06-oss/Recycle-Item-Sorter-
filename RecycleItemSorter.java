import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    public Plastic(String itemName) {
        super(itemName);
    }

    @Override
    public String getRecycleBin() {
        return "Plastic Bin";
    }
}
class Glass extends RecyclableItem {
    public Glass(String itemName) {
        super(itemName);
    }

    @Override
    public String getRecycleBin() {
        return "Glass Bin";
    }
}
class Metal extends RecyclableItem {
    public Metal(String itemName) {
        super(itemName);
    }

    @Override
    public String getRecycleBin() {
        return "Metal Bin";
    }
}
class Paper extends RecyclableItem {
    public Paper(String itemName) {
        super(itemName);
    }

    @Override
    public String getRecycleBin() {
        return "Paper Bin";
    }
}

public class RecycleItemSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<RecyclableItem> items = new ArrayList<>();

        System.out.println("Enter number of items to sort: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter item name:");
            String name = sc.nextLine();

            System.out.println("Enter item type (plastic/glass/metal/paper):");
            String type = sc.nextLine().toLowerCase();

            switch (type) {
                case "plastic":
                    items.add(new Plastic(name));
                    break;
                case "glass":
                    items.add(new Glass(name));
                    break;
                case "metal":
                    items.add(new Metal(name));
                    break;
                case "paper":
                    items.add(new Paper(name));
                    break;
                default:
                    System.out.println("Unknown item type. Skipping...");
            }
        }

        System.out.println("\nSorting Recyclable Items:\n");
        for (RecyclableItem item : items) {
            System.out.println(item.getItemName() + " -> " + item.getRecycleBin());
        }

        sc.close();
    }
}

