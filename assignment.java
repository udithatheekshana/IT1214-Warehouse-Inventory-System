import java.util.*;

class Item {
    String name;
    int quantity;

    Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

public class Main {

    static ArrayList<Item> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Warehouse Inventory System =====");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewItems();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Add Item
    public static void addItem() {
        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        inventory.add(new Item(name, quantity));
        System.out.println("Item added successfully!");
    }

    // View Items
    public static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\n--- Inventory List ---");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.println((i + 1) + ". " + item.name + " - " + item.quantity);
        }
    }

    // Update Item
    public static void updateItem() {
        viewItems();
        if (inventory.isEmpty()) return;

        System.out.print("Enter item number to update: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < inventory.size()) {
            sc.nextLine(); // clear buffer
            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new quantity: ");
            int quantity = sc.nextInt();

            inventory.get(index).name = name;
            inventory.get(index).quantity = quantity;

            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Invalid item number!");
        }
    }

    // Delete Item
    public static void deleteItem() {
        viewItems();
        if (inventory.isEmpty()) return;

        System.out.print("Enter item number to delete: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < inventory.size()) {
            inventory.remove(index);
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Invalid item number!");
        }
    }
}