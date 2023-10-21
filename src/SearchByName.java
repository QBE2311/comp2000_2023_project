import java.util.ArrayList;

public class SearchByName implements SearchBy{
    
    @Override
    public ArrayList<ItemInterface> searchItems(String term, ArrayList<ItemInterface> result) {
        for (int i = 0; i < result.size(); i++) {
            ItemInterface curItem = result.get(i);
            if (!curItem.getName().contains(term)) {
                result.remove(i);
                i--;  // Go back to revisit current index on next run of loop
            }
        }
        return result;
    }
}