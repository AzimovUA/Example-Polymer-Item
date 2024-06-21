package my.azimovua;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import my.azimovua.commands.PolymereCommands;
import my.azimovua.item.NewItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPolymere implements ModInitializer {

    public static final String MOD_ID = "testpolymere";
    
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            PolymereCommands.registerCommands(dispatcher);
        });

        // Register our new items
        NewItems.registerItems();

        LOGGER.info("Hello Fabric world!");

        if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
            LOGGER.info("Successfully added mod assets for " + MOD_ID);
        } else {
            LOGGER.error("Failed to add mod assets for " + MOD_ID);
        }

        // I don't know if it's doing anything (AzimovUA)
        PolymerResourcePackUtils.markAsRequired();
    }
}