package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.ToolDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class die extends BattleModifier {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.TOOL_STATS);
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        float a = 0.21f;
        ToolStats.DRAW_SPEED.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.DURABILITY.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.MINING_SPEED.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.ATTACK_SPEED.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.ATTACK_DAMAGE.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.VELOCITY.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.ACCURACY.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.ARMOR.multiply(builder, 1 + a * modifier.getLevel());
        ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 + a * modifier.getLevel());
    }

    @Override
    public void addVolatileData(IToolContext context, ModifierEntry modifier, ToolDataNBT toolDataNBT) {
        toolDataNBT.addSlots(SlotType.ABILITY, -1);
    }
}
