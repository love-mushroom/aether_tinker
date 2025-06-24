package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.TinkerModifiers;

import java.util.List;

public class incomplete_dream extends BattleModifier {
    @Override
    public Component getDisplayName(int level) {
        return super.getDisplayName();
    }
    @Override
    public void afterMeleeHit(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (context.getLivingTarget()!=null&&!context.isExtraAttack()) {
            LivingEntity attacker = context.getAttacker();
            LivingEntity target = context.getLivingTarget();
            if (target == null) return;

            BlockPos pos = target.getOnPos();
            Level world = target.getCommandSenderWorld();
            float temp = world.getBiome(pos).value().getBaseTemperature();
            if (target.isOnFire()) temp += 0.3f; // new flavor

            if (temp < 0.15) return;

            final float damage = damageDealt * 1.2f;
            int level = 5;
            List<Mob> list = world.getEntitiesOfClass(Mob.class, new AABB(attacker.getX() - level, attacker.getY() - level, attacker.getZ() - level, attacker.getX() + level, attacker.getY() +  level, attacker.getZ() +  level));
            if (!world.isClientSide) // server - deal damage
            {
                for (Mob en : list) {
                    if (en == attacker) continue;
                    en.invulnerableTime = 0;
                    en.hurt(new DamageSource(attacker.getCommandSenderWorld().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), damage);
                }
            }
            if (attacker instanceof Player player) {
                TinkerModifiers.repulsiveEffect.get().apply(player, 15,  6);
                TinkerModifiers.repulsiveEffect.get().apply(target, 15, -6);
            }
        }
    }
}
