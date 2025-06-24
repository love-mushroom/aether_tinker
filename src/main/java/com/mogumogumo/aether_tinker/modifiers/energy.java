package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import com.mogumogumo.aether_tinker.utils.EntityUtilss;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class energy extends BattleModifier {
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (attacker instanceof Player player&&!context.isExtraAttack()) {
            player.setAbsorptionAmount(player.getAbsorptionAmount()+1);
            return damage + (float) tool.getCurrentDurability() /2000*player.getAbsorptionAmount();
        }
        return damage;
    }
}
