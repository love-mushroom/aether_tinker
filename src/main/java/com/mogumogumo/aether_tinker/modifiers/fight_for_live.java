package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import java.util.Objects;

public class fight_for_live extends BattleModifier {
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        Entity entity = context.getTarget();
        if (modifier.getLevel() > 0 && entity instanceof LivingEntity target) {
            AttributeInstance attribute = target.getAttributes().getInstance(Attributes.ARMOR);
            if (attribute != null && !(target instanceof Player) && target.getArmorValue()>0) {
                attribute.setBaseValue(attribute.getBaseValue() - 2);
            }
            if (attribute != null && !(target instanceof Player) && target.getArmorValue()==0) {
                attribute.setBaseValue(attribute.getBaseValue() + 20);
            }
        }
    }
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (attacker instanceof Player player) {
            if (livingTarget.getArmorValue()==0) {
                Objects.requireNonNull(context.getLivingTarget()).hurt(context.getAttacker().damageSources().inFire(), 0.1f*livingTarget.getMaxHealth());
                return damage;
            }
        }
        return damage;
    }
    public boolean modifierOnProjectileHitEntity(ModifierNBT modifiers, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @javax.annotation.Nullable LivingEntity attacker, @javax.annotation.Nullable LivingEntity target) {
        if (modifier.getLevel() > 0 && target != null) {
            AttributeInstance attribute = target.getAttributes().getInstance(Attributes.ARMOR);
            if (attribute != null && !(target instanceof Player)&& target.getArmorValue()>0) {
                attribute.setBaseValue(attribute.getBaseValue() - 2);
            }
        }
        return false;
    }
}
