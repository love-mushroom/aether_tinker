package com.mogumogumo.aether_tinker.register;

import com.mogumogumo.aether_tinker.modifiers.*;
import com.mogumogumo.aether_tinker.modifiers.soar.soar;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

import static com.mogumogumo.aether_tinker.aether_tinker.MODID;

public class Aemodifiers {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MODID);
    public static final StaticModifier<magical> magicalStaticModifier = MODIFIERS.register("magical", magical::new);
    public static final StaticModifier<elegant> elegantStaticModifier = MODIFIERS.register("elegant", elegant::new);
    public static final StaticModifier<elegant_armor> elegantArmorStaticModifier = MODIFIERS.register("elegant_armor", elegant_armor::new);
    public static final StaticModifier<sky_tinker_thing> skyTinkerThingStaticModifier = MODIFIERS.register("sky_tinker_thing", sky_tinker_thing::new);
    public static final StaticModifier<heroic_spirit> heroicSpiritStaticModifier = MODIFIERS.register("heroic_spirit", heroic_spirit::new);
    public static final StaticModifier<soft> softStaticModifier = MODIFIERS.register("soft", soft::new);
    public static final StaticModifier<warding> wardingStaticModifier = MODIFIERS.register("warding", warding::new);
    public static final StaticModifier<warding_armor> wardingArmorStaticModifier = MODIFIERS.register("warding_armor", warding_armor::new);
    public static final StaticModifier<die> dieStaticModifier = MODIFIERS.register("die", die::new);
    public static final StaticModifier<mushroom_boom> mushroomBoomStaticModifier = MODIFIERS.register("mushroom_boom", mushroom_boom::new);
    public static final StaticModifier<no_look> noLookStaticModifier = MODIFIERS.register("no_look", no_look::new);
    public static final StaticModifier<hajimi> HAJIMI_STATIC_MODIFIER = MODIFIERS.register("hajimi", hajimi::new);
    public static final StaticModifier<storage> storageStaticModifier = MODIFIERS.register("storage", storage::new);
    public static final StaticModifier<god> godStaticModifier = MODIFIERS.register("god", god::new);
    public static final StaticModifier<cardinal> cardinalStaticModifier = MODIFIERS.register("cardinal", cardinal::new);
    public static final StaticModifier<storage_armor> storageArmorStaticModifier = MODIFIERS.register("storage_armor", storage_armor::new);
    public static final StaticModifier<incomplete_dream> incompleteDreamStaticModifier = MODIFIERS.register("incomplete_dream", incomplete_dream::new);
    public static final StaticModifier<cloud_armor> cloudArmorStaticModifier = MODIFIERS.register("cloud_armor", cloud_armor::new);
    public static final StaticModifier<c_moon> c_moonStaticModifier = MODIFIERS.register("c_moon", c_moon::new);
    public static final StaticModifier<soar> soarStaticModifier = MODIFIERS.register("soar", soar::new);
    public static final StaticModifier<sanger> sangerStaticModifier = MODIFIERS.register("sanger", sanger::new);
    public static final StaticModifier<sky_fire> skyFireStaticModifier = MODIFIERS.register("sky_fire", sky_fire::new);
    public static final StaticModifier<maid_thing> maidThingStaticModifier = MODIFIERS.register("maid_thing", maid_thing::new);
    public static final StaticModifier<fight_for_live> fightForLiveStaticModifier = MODIFIERS.register("fight_for_live", fight_for_live::new);
    public static final StaticModifier<legend_head> legendHeadStaticModifier = MODIFIERS.register("legend_head", legend_head::new);
}
