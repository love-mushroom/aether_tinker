package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import com.mogumogumo.aether_tinker.utils.ModifierLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.slotless.OverslimeModifier;

import java.util.UUID;
import java.util.function.BiConsumer;

public class god extends ArmorModifier {
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.ATTRIBUTES);
    }

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
            OverslimeModifier overslime = TinkerModifiers.overslime.get();
            float a =tool.getModifierLevel(overslime)*4f;
            if (a != 0) {
                consumer.accept(Attributes.MAX_HEALTH, new AttributeModifier(UUID.fromString("9bf29a55-81e2-4ba5-957f-596fb2a4082b"), Attributes.MAX_HEALTH.getDescriptionId(), a, AttributeModifier.Operation.ADDITION));
            }
    }

}
