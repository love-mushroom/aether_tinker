package com.mogumogumo.aether_tinker;

import com.mogumogumo.aether_tinker.register.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;

import java.security.SecureRandom;
import java.util.Random;

@Mod(aether_tinker.MODID)
public class aether_tinker {
    public static boolean xiaoyue = ModList.get().isLoaded("tinkers_ingenuity");
    public static final Random random = new Random();
    public static final String MODID = "aether_tinker";
    public aether_tinker(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        Aeitems.register(modEventBus);
        Aemodifiers.MODIFIERS.register(modEventBus);
        Aefuild.FLUIDS.register(modEventBus);
        AeTab.creative_mode_tab.register(modEventBus);
        Aeeffects.EFFECT.register(modEventBus);
        if (xiaoyue) {
            AeCModifiers.XunModifier.register(modEventBus);
        }
    }

    public static ResourceLocation location(String id) {
        return new ResourceLocation("aether_tinker", id);
    }

    public static ResourceLocation getResource(String string) {
        return new ResourceLocation(MODID, string);
    }

    public static <T> TinkerDataCapability.TinkerDataKey<T> createKey(String name) {
        return TinkerDataCapability.TinkerDataKey.of(getResource(name));
    }

    public static String makeDescriptionId(String type, String name) {
        return type + ".aether_tinker." + name;
    }
}
