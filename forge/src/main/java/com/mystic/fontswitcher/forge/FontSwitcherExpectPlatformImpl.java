package com.mystic.fontswitcher.forge;

import com.mystic.fontswitcher.FontSwitcherExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class FontSwitcherExpectPlatformImpl {
    /**
     * This is our actual method to {@link FontSwitcherExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
