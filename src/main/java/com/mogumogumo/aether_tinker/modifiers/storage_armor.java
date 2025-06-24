package com.mogumogumo.aether_tinker.modifiers;

import com.aetherteam.aether.AetherTags;
import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import com.mogumogumo.aether_tinker.extend.superclass.HajimiModifier;
import com.mogumogumo.aether_tinker.register.Aeeffects;
import com.mogumogumo.aether_tinker.utils.ModifierLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static net.minecraft.world.damagesource.DamageTypes.MAGIC;

public class storage_armor extends HajimiModifier {
    @Override
    public Component getDisplayName(int level) {
        return super.getDisplayName();
    }
    public void LivingHurtEvent(LivingHurtEvent event) {
        if (event.getEntity() != null) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player player && ModifierLevel.getTotalArmorModifierlevel(entity, this.getId()) > 0) {
                player.setAbsorptionAmount(1);
                event.setAmount(event.getAmount() *0.95f);
            }
        }
    }
}
