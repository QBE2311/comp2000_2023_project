public class Item implements ItemInterface{
    String itemName = "Invalid Item";
    String itemDesc = "This item shouldn't be here.";
    double itemValue = 0.0;
    int itemExpiry = -1;

    public Item(int expiry) {
        itemExpiry = expiry;
    }
    
    public Item(String name, String desc, double value, int expiry) {
        itemName = name;
        itemDesc = desc;
        itemValue = value;
        itemExpiry = expiry;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow(itemName + "", itemDesc + "", itemValue + "", itemExpiry + "");

    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow(itemName + "", itemValue + "", column3);
    }
}
