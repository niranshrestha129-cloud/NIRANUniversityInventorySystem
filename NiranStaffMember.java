import java.util.Arrays;

/**
 * Represents a university staff member who can borrow inventory items.
 * Each staff member has a unique ID, a name, and can be assigned up to a
 * fixed number of inventory items. Methods are provided to assign and
 * return items while enforcing limits and checking availability.
 */
public class StaffMember {
    private static final int MAX_ASSIGNED_ITEMS = 5;

    private String id;
    private String fullName;
    private InventoryItem[] itemsAssigned;
    private int currentItemCount;

    /**
     * Constructs a new StaffMember.
     *
     * @param id       unique identifier for the staff member
     * @param fullName full name of the staff member
     */
    public StaffMember(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.itemsAssigned = new InventoryItem[MAX_ASSIGNED_ITEMS];
        this.currentItemCount = 0;
    }

    /**
     * Returns the staff ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the staff member's full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Assigns an inventory item to this staff member.
     * Throws exceptions if limits are exceeded or the item is unavailable.
     *
     * @param item the inventory item to assign
     * @throws AssignmentLimitExceededException if staff has reached the maximum
     * @throws ItemUnavailableException         if the item is not available
     */
    public void assignItem(InventoryItem item) throws AssignmentLimitExceededException, ItemUnavailableException {
        if (currentItemCount >= MAX_ASSIGNED_ITEMS) {
            throw new AssignmentLimitExceededException("Staff has reached the maximum allowed items.");
        }
        if (!item.isAvailable()) {
            throw new ItemUnavailableException("This item is currently unavailable.");
        }

        itemsAssigned[currentItemCount++] = item;
        item.setAvailable(false);
    }

    /**
     * Returns an assigned item back to the inventory.
     *
     * @param item the inventory item to return
     */
    public void returnItem(InventoryItem item) {
        for (int i = 0; i < currentItemCount; i++) {
            if (itemsAssigned[i] != null && itemsAssigned[i].getId().equals(item.getId())) {
                item.setAvailable(true);
                // Shift items down to fill the gap
                for (int j = i; j < currentItemCount - 1; j++) {
                    itemsAssigned[j] = itemsAssigned[j + 1];
                }
                itemsAssigned[currentItemCount - 1] = null;
                currentItemCount--;
                break;
            }
        }
    }

    /**
     * Returns a copy of the assigned items array (without nulls).
     */
    public InventoryItem[] getAssignedItems() {
        return Arrays.copyOf(itemsAssigned, currentItemCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Staff ID: %s, Name: %s, Total Assigned Items: %d\n", id, fullName, currentItemCount));
        for (int i = 0; i < currentItemCount; i++) {
            sb.append("  -> ").append(itemsAssigned[i]).append("\n");
        }
        return sb.toString();
    }
}
