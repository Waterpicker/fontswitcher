package com.mystic.fontswitcher.fabric;

import com.mystic.fontswitcher.FontSwitcherExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class FontSwitcherExpectPlatformImpl {
    /**
     * This is our actual method to {@link FontSwitcherExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
