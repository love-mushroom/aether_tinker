package com.mogumogumo.aether_tinker.modifiers.crosier;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import com.mogumogumo.aether_tinker.utils.EntityUtilss;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class Help extends BattleModifier {
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (livingTarget instanceof Player player) {
            player.heal(0.25f*level+ player.getMaxHealth()/100);
            return damage * 0;
        }
        return damage;
    }
}
