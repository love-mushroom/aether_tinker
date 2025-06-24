package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

public class lance_thing extends BattleModifier {
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (attacker instanceof Player player) {
            Objects.requireNonNull(context.getLivingTarget()).hurt(context.getAttacker().damageSources().fall(), (float) (player.getDeltaMovement().length() * damage));
            return damage;
        }
        return damage;
    }
}
