package my.azimovua.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import static my.azimovua.commands.GiveItem.giveItem;

public class PolymereCommands {
    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("giveitem").executes(context -> {
            ServerCommandSource source = context.getSource();
            giveItem(source.getPlayer());
            return 1;
        }));
    }
}
