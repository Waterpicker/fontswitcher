package com.mystic.fontswitcher.fabric;

import com.mystic.fontswitcher.FontSwitcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class FontSwitcherFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FontSwitcher.clientInit();
    }
}
