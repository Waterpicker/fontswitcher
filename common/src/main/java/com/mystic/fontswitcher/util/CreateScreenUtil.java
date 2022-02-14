package com.mystic.fontswitcher.util;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;

import java.nio.charset.StandardCharsets;

public class CreateScreenUtil {
    public static Screen createConfigScreen(Screen screen) {
        final String[] currentValueNamespace = {"fontswitcher"};
        final String[] currentValuePath = {"atlantean_font"};
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(screen)
                .setTitle(new TranslatableComponent("title.fontswitcher.config"));
        builder.setSavingRunnable(() -> {});
        ConfigCategory general = builder.getOrCreateCategory(new TranslatableComponent("category.fontswitcher.general"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
                general.addEntry(entryBuilder
                        .startStrField(new TranslatableComponent("option.fontswitcher.fontnamespace"), currentValueNamespace[0])
                        .setDefaultValue("fontswitcher")
                        .setTooltip(new TranslatableComponent("Namespace for the font used")).requireRestart()
                        .setSaveConsumer(newValue -> currentValueNamespace[0] = newValue)
                        .build()
                ).addEntry(entryBuilder
                        .startStrField(new TranslatableComponent("option.fontswitcher.fontpath"), currentValuePath[0])
                        .setDefaultValue("atlantean_font")
                        .setTooltip(new TranslatableComponent("Path for the font used")).requireRestart()
                        .setSaveConsumer(newValue -> currentValuePath[0] = newValue)
                        .build()
                );
                return builder.build();
        }
    }
