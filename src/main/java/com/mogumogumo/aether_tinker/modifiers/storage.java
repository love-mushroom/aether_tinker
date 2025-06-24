package com.mogumogumo.aether_tinker.modifiers;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import com.mogumogumo.aether_tinker.register.Aeitems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

public class storage extends BattleModifier {
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (livingTarget!=null &&!context.isExtraAttack()&& attacker instanceof Player player) {
            Objects.requireNonNull(context.getLivingTarget()).hurt(context.getAttacker().damageSources().magic(), (float) (tool.getCurrentDurability()) /300);
        }
        return damage;
    }
}
