package io.github.thepoultryman.ademi.fabric;

import io.github.thepoultryman.ademi.AdEMI;
import net.fabricmc.api.ModInitializer;

public class AdEMIFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AdEMI.init();
    }
}