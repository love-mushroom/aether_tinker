package com.mogumogumo.aether_tinker.modifiers.XunModifiers;

import com.xiaoyue.tinkers_ingenuity.content.generic.SimpleModifier;
import com.xiaoyue.tinkers_ingenuity.content.shared.holder.CurioStackView;
import com.xiaoyue.tinkers_ingenuity.content.shared.hooks.specail.TinkersCurioModifierHook;
import com.xiaoyue.tinkers_ingenuity.register.TIHooks;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class cloud_armor_c extends SimpleModifier implements TinkersCurioModifierHook {

    public boolean canImmuneAttack(CurioStackView curio, int level, LivingEntity entity, DamageSource source, float damage) {
        if (source.is(DamageTypes.MAGIC)) {
            return true;
        }
        return false;
    }
    protected void addHooks(ModuleHookMap.Builder builder) {
        builder.addHook(this, TIHooks.TINKERS_CURIO);
    }
}

