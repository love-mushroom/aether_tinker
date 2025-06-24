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

public class c_moon_c extends SimpleModifier implements TinkersCurioModifierHook {
    protected void addHooks(ModuleHookMap.Builder builder) {
        builder.addHook(this, TIHooks.TINKERS_CURIO);
    }
    public void onCurioTick(CurioStackView curio, int level, LivingEntity entity) {
        if (entity.tickCount %20 == 0) {
            TinkerModifiers.repulsiveEffect.get().apply(entity, 15,level*5);
        }
    }
}
