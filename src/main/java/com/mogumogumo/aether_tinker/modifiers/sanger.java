package com.mogumogumo.aether_tinker.modifiers;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import com.mogumogumo.aether_tinker.register.Aeitems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

public class sanger extends BattleModifier {
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (attacker instanceof Player player) {
            NonNullList<ItemStack> playerInv = player.getInventory().items;
            ItemStack invSlot = playerInv.get(1);
            if (invSlot.is(Aeitems.valkyrie.get())) {
                return damage * 1.1f;
            }if (invSlot.is(AetherItems.ZANITE_GEMSTONE.get())) {
                return damage * 1.1f;
            }if (invSlot.is(AetherBlocks.SKYROOT_PLANKS.get().asItem())) {
                return damage * 1.1f;
            }if (invSlot.is(AetherItems.AMBROSIUM_SHARD.get())) {
                return damage * 1.1f;
            }
        }
        return damage;
    }
}
