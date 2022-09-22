package me.zegs.signfix;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Signfix implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("SRPData");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Loading SignFix!");
    }
}