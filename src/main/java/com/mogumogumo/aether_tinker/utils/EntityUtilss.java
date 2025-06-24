package com.mogumogumo.aether_tinker.utils;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EntityUtilss {
    public static int getBeneficialEffectCount(LivingEntity entity) {
        return (int)entity.getActiveEffects().stream().filter((e) -> e.getEffect().getCategory() == MobEffectCategory.BENEFICIAL).count();
    }
}
