import java.util.ArrayList;

public class Item implements ItemInterface {
    private ItemDefinition definition;
    private ArrayList<ItemInterface> componentList;

    /**
     * Creates an Item instance with a set definition.
     * The composition list is (created but) left empty. For composite items, the sub-components
     * should be retrieved/removed from some item source, and added with Item::Add(ItemInterface).
     * @param def
     */
    public Item(ItemDefinition def) {
        definition = def;
        componentList = new ArrayList<ItemInterface>();
    }

    @Override
    public double getWeight() {
        double weight = definition.getWeight().orElse(0.0);
        // If the item is made up of other items, we should find the sum of weights
        if(componentList != null && !componentList.isEmpty()) {
            for(ItemInterface component : componentList) {
                weight += component.getWeight();
            }
        }
        return weight;
    }

    @Override
    public String getName() {
        return definition.getName();
    }

    @Override
    public String getDescription() {
        return definition.getDescription();
    }

    @Override
    public ItemDefinition getDefinition() {
        return definition;
    }

    @Override
    public String getCompositionDescription() {
        // For craftable items, this method should return a description describing/listing the
        // other items which make up this item.
        // When a non-empty String is returned, the uncraft button will appear in the UI.
        String description = "";

        if(!componentList.isEmpty()) {
            for(ItemInterface item : componentList) {
                description += item.getName() + ", ";
            }
            description = description.substring(0,description.length()-2) + ".";
        }
        return description;
    }

    @Override
    public boolean equals(ItemInterface other) {
        return isOf(other.getDefinition());
    }

    @Override
    public boolean isOf(ItemDefinition def) {
        return getName().equals(def.getName());
    }

    @Override
    public String toString() {
        String output = String.format("Item: %s\nDescription: %s\nWeight: %.2f",
            getName(), getDescription(), getWeight());
        output += "\nHashCode: " + Integer.toHexString(this.hashCode());
        return output;
    }

    @Override
    public void Add(ItemInterface component) {
        if(componentList == null){
            componentList = new ArrayList<ItemInterface>();
        }
        componentList.add(component);
    }

}