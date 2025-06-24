package com.mogumogumo.aether_tinker.modifiers.XunModifiers;

import com.xiaoyue.tinkers_ingenuity.content.generic.SimpleModifier;
import com.xiaoyue.tinkers_ingenuity.content.shared.holder.CurioStackView;
import com.xiaoyue.tinkers_ingenuity.content.shared.hooks.specail.TinkersCurioModifierHook;
import com.xiaoyue.tinkers_ingenuity.register.TIHooks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class elegant_c extends SimpleModifier implements TinkersCurioModifierHook {
    protected void addHooks(ModuleHookMap.Builder builder) {
        builder.addHook(this, TIHooks.TINKERS_CURIO);
    }
    public void onCurioTick(CurioStackView curio, int level, LivingEntity entity) {
        if (entity.tickCount %50 == 0) {
            int a = RANDOM.nextInt(14);
            if (a == 1){entity.addEffect(new MobEffectInstance(MobEffects.SATURATION,90 * level, level));}
            if (a == 2){entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,90 * level, 1));}
            if (a == 3){entity.addEffect(new MobEffectInstance(MobEffects.LUCK,90 * level, level));}
            if (a == 4){entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE,90 * level, level));}
            if (a == 5){entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER,90 * level, level));}
            if (a == 6){entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,90 * level, level));}
            if (a == 7){entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,90 * level, level));}
            if (a == 8){entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,90 * level, level));}
            if (a == 9){entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,90 * level, level));}
            if (a == 10){entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,90 * level, level));}
            if (a == 11){entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,90 * level, level));}
            if (a == 0){entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,90, level));}
            if (a == 12){entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,90, level));}
            if (a == 13){entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,90, level));}
        }
    }
}
