package my.azimovua.item;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import my.azimovua.TestPolymere;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class NewItems {

    // the same as in Fabric, but we use our ExamplePolymerItem class instead of vanilla Item
    public static final Item POLYMER_ITEM = registerItem("polymer_item", new ExamplePolymerItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestPolymere.MOD_ID, name), item);
    }


    public static void registerItems() {
        TestPolymere.LOGGER.info("Registering items for " + TestPolymere.MOD_ID);

        // We build our own ItemGroup and register it
        // In vanilla(Fabric) new tab would be shown in Creative Menu.
        // But in Polymer, client need to have mod installed OR use /polymer creative (AzimovUA)

        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();
        builder.icon(() -> new ItemStack(NewItems.POLYMER_ITEM, 1));
        builder.displayName(Text.of("Polymer Items"));

        // Add items to the group
        builder.entries(new ItemGroup.EntryCollector() {
            @Override
            public void accept(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
                entries.add(NewItems.POLYMER_ITEM);
            }
        });

        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(TestPolymere.MOD_ID), polymerGroup);
    }
}
