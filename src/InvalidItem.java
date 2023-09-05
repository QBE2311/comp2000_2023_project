/**
 * This Item is only used when an Item is expected to be returned, but no valid Item exists.
 * (i.e. attempting to remove an item from an inventory that does not contain it.)
 */

public class InvalidItem implements ItemInterface {
    int expiry;

    public InvalidItem(int expiry) {
        this.expiry = expiry;
    }
    
    @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow("Invalid Item", "This item shouldn't be here.", "0.0", expiry + "");
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow("Invalid Item", "0.0", column3);
    }
}
