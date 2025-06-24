package com.mogumogumo.aether_tinker.register;

import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import com.mogumogumo.aether_tinker.modifiers.XunModifiers.*;

import static com.mogumogumo.aether_tinker.aether_tinker.MODID;

public class AeCModifiers {

    public static ModifierDeferredRegister XunModifier = ModifierDeferredRegister.create(MODID);
    public static final StaticModifier<no_look_c> noLookCStaticModifier = XunModifier.register("no_look_c", no_look_c::new);
    public static final StaticModifier<c_moon_c> cMoonCStaticModifier = XunModifier.register("c_moon_c", c_moon_c::new);
    public static final StaticModifier<elegant_c> elegantCStaticModifier = XunModifier.register("elegant_c", elegant_c::new);
    public static final StaticModifier<cloud_armor_c> cloudArmorCStaticModifier = XunModifier.register("cloud_armor_c", cloud_armor_c::new);

}
