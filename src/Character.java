public abstract class Character {
    String name;
    Inventory inventory;


    public Character(String passedName, Inventory startingInventory) {
        name = passedName;
        inventory = startingInventory;
    }


    /**
     * Purchases an item. As the Seller does not have a money attribute,
     * and the Seller is the default, the item will always be "bought"
     * (unless the buy method is overridden).
     */
    public void buy(ItemInterface item) {
        inventory.addOne(item);
    }

    /**
     * Attempt to sell an item by name. If an item with a matching name is
     * found, the item is removed and returned.
     * @param itemName
     * @return The sold item.
     */
    public ItemInterface sell(String itemName) {
        ItemInterface result = removeItem(itemName);
        if (result != null && !(result.getItemName().equals("Invalid Item"))) {
            return result;
        }
        return new Item(-1);
    }

    /**
     * Adds an item to the held Inventory.
     * @param item
     */
    public void addItem(ItemInterface item) {
        inventory.addOne(item);
    }

    /**
     * Removes and returns an item from the held Inventory that matches
     * the `itemName` parameter.
     * @param itemName
     */
    public ItemInterface removeItem(String itemName) {
        return inventory.removeOne(itemName);
    }
    
    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }
}
