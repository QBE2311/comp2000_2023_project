# Task 1
Behavioural pattern - Options: *Strategy* or *Observer* pattern.
You chose: Strategy

## Itemise changes made (which class files were modified)
1. App.java - Altered setupSearching to work with improved Search framework
2. Inventory.java - Implemented SearchBy interface and distributed Search code into individual functions
3. SearchBy.java - Base interface for new Search framework
4. SearchByAll.java - Encapsulated "Search By All" code into this file
5. SearchByDescription - Encapsulated "Search By Description" code into this file
6. SearchByName - Encapsulated "Search By Name" code into this file

# Task 2
Structural pattern - *Composite* pattern.

## Itemise changes made (which class files were modified)
1. App.java - setupCrafting now calls player.craftItem
2. Item.java - Added the missing componentList, implemented Item.Add to add component items to a crafted item
3. ItemDefinition.java - Created the ItemDefinition.craftItem method
4. ItemInterface.java - Added an Add method without implementation for use in Item.java
5. Player.java - Added Player.craftItem to call ItemDefinition.craftItem with the passed recipe, in order for setupCrafting to not need another variable

# Task 3

## Itemised changes or new files
1. Item.java
2. ItemDefinition.java

## What was changed
1. Item.java - Item.getWeight now properly calculates the weight of composite items by adding the weight of components.
2. Item.java - Item.getCompositionDescription is now functional.
3. ItemDefinition.java - ItemDefinition.create() now creates component items as well, when creating composite items.

## Why it was changed
1. Item.getWeight previously did not calculate the weight of composite items at all, making them weightless.
2. Item.getCompositionDescription was previously a stub method that always returned an empty string.
3. ItemDefinition.create previously would simply create the composite item without considering its components, leading to a number of possible issues with calculating weight and uncrafting.

## The benefits of the change
1. With composite item weight now taken into account, player encumbrance can be properly calculated, preventing the player from carrying more than they should be able to via crafting heavy items into weightless ones.
2. Composite items' components can now be seen in their product pages. Additionally, uncrafting is now accessible, although it remains unimplemented (as recommended by the iLearn announcement).
3. Items created via the create() method, (i.e. for generating quest rewards or loot at runtime) are now properly comprised of other items, allowing the player to uncraft them just like any other item, and preventing any errors that uncrafting a composite item with no components may have caused.