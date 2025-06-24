package com.mogumogumo.aether_tinker.modifiers;

import com.c2h6s.etstlib.entity.specialDamageSources.LegacyDamageSource;
import com.c2h6s.etstlib.entity.specialDamageSources.PercentageBypassArmorSource;
import com.c2h6s.etstlib.tool.modifiers.base.EtSTBaseModifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

public class mushroom_boom extends EtSTBaseModifier {
    @Override
    public LegacyDamageSource modifyDamageSource(IToolStackView tool, ModifierEntry entry, LivingEntity attacker, InteractionHand hand, Entity target, EquipmentSlot sourceSlot, boolean isFullyCharged, boolean isExtraAttack, boolean isCritical, LegacyDamageSource source) {
        if (attacker.hasEffect(MobEffects.INVISIBILITY))
        {
            return PercentageBypassArmorSource.Any(source.typeHolder(),attacker,attacker,0.6f);
        }
        return PercentageBypassArmorSource.Any(source.typeHolder(),attacker,attacker,0.2f);
    }

    @Override
    public LegacyDamageSource modifyArrowDamageSource(ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier, AbstractArrow arrow, @Nullable LivingEntity attacker, @NotNull Entity target, LegacyDamageSource source) {
        if (attacker!=null&&attacker.hasEffect(MobEffects.INVISIBILITY))
        {
            return PercentageBypassArmorSource.Any(source.typeHolder(),arrow,attacker,0.6f);
        }
        return PercentageBypassArmorSource.Any(source.typeHolder(),arrow,attacker,0.2f);
    }
}
