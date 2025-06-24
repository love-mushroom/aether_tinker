package com.mogumogumo.aether_tinker.register;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.mogumogumo.aether_tinker.effects.*;

import static com.mogumogumo.aether_tinker.aether_tinker.MODID;

public class Aeeffects {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);

    //注册固定这个格式就行
//    public static final RegistryObject<MobEffect> HongWen = EFFECT.register("hongwen", HongWen::new);
    public static final RegistryObject<MobEffect> lengque = EFFECT.register("lengque", lengque::new);

    public static final RegistryObject<MobEffect> legend_lengque = EFFECT.register("legend_lengque", legend_lengque::new);
    public static final RegistryObject<MobEffect> legend_armor = EFFECT.register("legend_armor", legend_armor::new);
    public static final RegistryObject<MobEffect> wudi = EFFECT.register("wudi", lengque::new);
}
