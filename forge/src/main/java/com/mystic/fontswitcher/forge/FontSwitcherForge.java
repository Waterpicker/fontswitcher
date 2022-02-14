package com.mystic.fontswitcher.forge;

import com.mystic.fontswitcher.FontSwitchConfig;
import com.mystic.fontswitcher.FontSwitcher;
import com.mystic.fontswitcher.util.CreateScreenUtil;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FontSwitcher.MOD_ID)
public class FontSwitcherForge {
    public FontSwitcherForge() {
        // Submit our event bus to let architectury register our content on the right time
//        EventBuses.registerModEventBus(ExampleMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(FontSwitcherForge::InitClient);
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () ->
                new ConfigGuiHandler.ConfigGuiFactory((mc, screen) -> CreateScreenUtil.createConfigScreen(screen)));
    }

    public static void InitClient(FMLClientSetupEvent event) {
        FontSwitcher.clientInit();
    }
}
