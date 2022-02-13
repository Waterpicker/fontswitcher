package net.examplemod;

import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Set;

import static dev.architectury.event.events.client.ClientTickEvent.CLIENT_POST;
import static dev.architectury.registry.client.keymappings.KeyMappingRegistry.*;

public class ExampleMod {
    public static final String MOD_ID = "examplemod";
    private static KeyMapping binding;

    public static void clientInit() {
        register(binding = new KeyMapping("key.fontswitcher", 76, "key.categories.misc"));
        CLIENT_POST.register(new ClientTickEvent.Client() {
            @Override
            public void tick(Minecraft instance) {
                if(instance.screen == null) {
                    if(binding.isDown()) {
                        instance.setScreen(new Screen(new TextComponent("Font Switcher")) {
                            private int index = 0;

                            @Override
                            protected void init() {
                                super.init();

                                addRenderableWidget(new Button(0, 0, 100,20, new TextComponent("Toggle"), a -> {
                                    List<ResourceLocation> locations = minecraft.fontManager.fontSets.keySet().stream().sorted().toList();

                                    ResourceLocation location = locations.get(index = (index + 1) % locations.size());

                                    Minecraft.DEFAULT_FONT = location;
                                    Style.DEFAULT_FONT = location;
                                }));

                                addRenderableWidget(new Button(0, 20, 100,20, new TextComponent("Reset").setStyle(Style.EMPTY.withFont(new ResourceLocation("minecraft", "default"))), a -> {
                                    Minecraft.DEFAULT_FONT = new ResourceLocation("minecraft", "default");
                                    Style.DEFAULT_FONT = new ResourceLocation("minecraft", "default");
                                }));
                            }
                        });
                    }
                }
            }
        });
    }
}
