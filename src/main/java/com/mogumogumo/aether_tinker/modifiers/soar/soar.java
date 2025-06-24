package com.mogumogumo.aether_tinker.modifiers.soar;

import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.shared.TinkerAttributes;

import java.util.UUID;
import java.util.function.BiConsumer;

public class soar extends ArmorModifier {
    public float TrueDamageamount(IToolStackView armor, int level, EquipmentContext context, EquipmentSlot slot, DamageSource source, float amount, boolean isDirectDamage, LivingEntity entity, LivingEntity enemy) {
        if (context.getEntity() instanceof Player player) {
            IToolStackView feet = ToolStack.from(player.getItemBySlot(EquipmentSlot.FEET));
            if (feet.getModifierLevel(this.getId()) > 0 && !player.onGround()) {
                return amount * 0.4f;
            }
        }
        return amount;
    }

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        if (slot == EquipmentSlot.LEGS) {
            consumer.accept(Attributes.FLYING_SPEED, new AttributeModifier(UUID.fromString("9bf29a55-81e2-4ba5-957f-596fb2a4082b"), Attributes.FLYING_SPEED.getDescriptionId(), 0.3f, AttributeModifier.Operation.ADDITION));
        }
        if (slot == EquipmentSlot.HEAD) {
            consumer.accept(TinkerAttributes.USE_ITEM_SPEED.get(), new AttributeModifier(UUID.fromString("9bf29a55-81e2-4ba5-957f-596fb2a4082b"), Attributes.FLYING_SPEED.getDescriptionId(), 0.3f, AttributeModifier.Operation.ADDITION));
        }
    }
}
