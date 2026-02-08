import java.time.LocalDate;

/**
 * Abstract base class representing a generic inventory item in the university system.
 *
 * Each inventory item has a unique ID, name, purchase date, price, and warranty information.
 * Subclasses should implement {@code getMaintenanceFee()} to calculate the maintenance cost
 * specific to that item type. This class also keeps track of whether the item is currently available.
 */
public abstract class NiranInventoryItem {
    private String itemId;          // renamed from id
    private String itemName;        // renamed from name
    private LocalDate purchaseDate;
    private double price;
    private LocalDate warrantyEndDate;
    private boolean isAvailable;

    /**
     * Constructs a new inventory item.
     *
     * @param itemId        unique identifier for the item
     * @param itemName      descriptive name of the item
     * @param purchaseDate  date the item was purchased
     * @param price         purchase price
     * @param warrantyEnd   date the warranty expires
     */
    public NiranInventoryItem(String itemId, String itemName, LocalDate purchaseDate, double price, LocalDate warrantyEnd) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.warrantyEndDate = warrantyEnd;
        this.isAvailable = true; // items are available by default
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Price: %.2f, Purchased: %s, Warranty End: %s, Available: %s",
                itemId, itemName, price, purchaseDate, warrantyEndDate, isAvailable);
    }

    /**
     * Calculates the maintenance fee for the item.
     * Subclasses must override this method to provide item-specific calculation.
     *
     * @return maintenance fee
     */
    public abstract double getMaintenanceFee();
}
