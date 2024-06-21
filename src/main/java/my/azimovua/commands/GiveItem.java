package my.azimovua.commands;

import my.azimovua.item.NewItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class GiveItem {
    public static void giveItem(PlayerEntity player) {
        // Create ItemStack with polymer item
        ItemStack itemStack = new ItemStack(NewItems.POLYMER_ITEM, 1);

        // Give the item to the player
        if (player != null) {
            player.getInventory().insertStack(itemStack);
            player.sendMessage(Text.literal("You have been given a diamond!"), false);
        }
    }
}
