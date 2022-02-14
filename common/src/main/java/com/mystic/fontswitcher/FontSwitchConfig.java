package com.mystic.fontswitcher;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "fontswitcher")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public final class FontSwitchConfig implements ConfigData {

    public String FontNamespace = "fontswitcher";
    public String FontPath = "atlantean_font";
    public static FontSwitchConfig get() {
        return AutoConfig.getConfigHolder (FontSwitchConfig.class).getConfig();
    }

}
