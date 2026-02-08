import java.time.LocalDate;

/**
 * Represents pieces of furniture in the university inventory. Examples include
 * desks, chairs, cabinets, etc. This version is uniquely named to distinguish
 * it from other projects. It has a material property and overrides the maintenance
 * calculation from {@link NiranInventoryItem}.
 */
public class NiranFurniture extends NiranInventoryItem {
    private String materialType; // renamed from material

    /**
     * Constructs a new furniture item.
     *
     * @param id           unique identifier for the furniture
     * @param name         name of the furniture
     * @param materialType material of the furniture (e.g. wood, metal)
     * @param purchaseDate date of purchase
     * @param price        purchase price
     * @param warrantyEnd  warranty expiration date
     */
    public NiranFurniture(String id, String name, String materialType, LocalDate purchaseDate, double price,
            LocalDate warrantyEnd) {
        super(id, name, purchaseDate, price, warrantyEnd);
        this.materialType = materialType;
    }

    /**
     * Returns the material type of the furniture.
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * Provides a maintenance fee calculation specific to furniture. Furniture
     * typically requires less maintenance, so we use 2% of the price.
     *
     * @return maintenance fee
     */
    @Override
    public double getMaintenanceFee() {
        return getPrice() * 0.02; // 2% of purchase price
    }

    @Override
    public String toString() {
        return String.format("[NiranFurniture] %s, Material: %s, Maintenance Fee: %.2f",
                super.toString(), materialType, getMaintenanceFee());
    }
}
