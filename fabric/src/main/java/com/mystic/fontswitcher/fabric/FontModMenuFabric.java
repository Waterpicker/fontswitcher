package com.mystic.fontswitcher.fabric;

import com.mystic.fontswitcher.util.CreateScreenUtil;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class FontModMenuFabric implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return CreateScreenUtil::createConfigScreen;
    }
}
