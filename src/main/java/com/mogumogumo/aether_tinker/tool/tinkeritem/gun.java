package com.mogumogumo.aether_tinker.tool.tinkeritem;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

public class gun extends ModifiableItem {
    public gun(Properties properties, ToolDefinition toolDefinition) {
        super(properties, toolDefinition);
    }

}
