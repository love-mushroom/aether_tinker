package com.mogumogumo.aether_tinker.tool.tinkeritem;

import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import com.mogumogumo.aether_tinker.aether_tinker;
import java.util.function.Predicate;

import com.mogumogumo.aether_tinker.register.Aemodifiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.BowAmmoModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.tools.capability.EntityModifierCapability;
import slimeknights.tconstruct.library.tools.capability.PersistentDataCapability;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.item.ranged.ModifiableLauncherItem;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class blowripe extends ModifiableLauncherItem {
    private final ResourceLocation BLOWPIPE_CHANCE = aether_tinker.location("blowpipe_chance");
    public blowripe(Item.Properties properties, ToolDefinition toolDefinition) {
        super(properties, toolDefinition);
    }
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.NONE;
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ProjectileWeaponItem.ARROW_ONLY;
    }

    public int getDefaultProjectileRange() {
        return 10;
    }

    public InteractionResultHolder<ItemStack> world(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ToolStack tool = ToolStack.from(stack);
        ModDataNBT toolData = tool.getPersistentData();
        boolean hasUA = ModifierUtil.getModifierLevel(stack, Aemodifiers.HAJIMI_STATIC_MODIFIER.getId()) > 0;
        if (!tool.isBroken() && toolData.getInt(this.BLOWPIPE_CHANCE) == 20) {
            boolean hasAmmo = BowAmmoModifierHook.hasAmmo(tool, stack, player, this.getSupportedHeldProjectiles());
            boolean creative = player.getAbilities().instabuild;
            float velocity = ConditionalStatModifierHook.getModifiedStat(tool, player, ToolStats.VELOCITY);
            float power = 0.85F * velocity;
            if (!level.isClientSide()) {
                ItemStack ammo = BowAmmoModifierHook.findAmmo(tool, stack, player, this.getSupportedHeldProjectiles());
                if (!player.getAbilities().instabuild && !hasAmmo) {
                    return InteractionResultHolder.fail(stack);
                }

                Item startAngle = ammo.getItem();
                ArrowItem var10000;
                if (startAngle instanceof ArrowItem) {
                    ArrowItem arrow = (ArrowItem)startAngle;
                    var10000 = arrow;
                } else {
                    var10000 = (ArrowItem)Items.ARROW;
                }

                ArrowItem arrowItem = var10000;
                float inaccuracy = ModifierUtil.getInaccuracy(tool, player);
                float startAngle2 = getAngleStart(ammo.getCount());
                int primaryIndex = ammo.getCount() / 2;

                for(int arrowIndex = 0; arrowIndex < ammo.getCount(); ++arrowIndex) {
                    AbstractArrow arrow = arrowItem.createArrow(level, ammo, player);
                    float angle = startAngle2 + (float)(10 * arrowIndex);
                    arrow.shootFromRotation(player, player.getXRot() + angle, player.getYRot(), 0.0F, power * 3.0F, inaccuracy);
                    float baseArrowDamage = (float)(arrow.getBaseDamage() - (double)2.0F + (double)(Float)tool.getStats().get(ToolStats.PROJECTILE_DAMAGE));
                    arrow.setBaseDamage((double)ConditionalStatModifierHook.getModifiedStat(tool, player, ToolStats.PROJECTILE_DAMAGE, baseArrowDamage));
                    ModifierNBT modifiers = tool.getModifiers();
                    arrow.getCapability(EntityModifierCapability.CAPABILITY).ifPresent((cap) -> cap.setModifiers(modifiers));
                    ModDataNBT arrowData = PersistentDataCapability.getOrWarn(arrow);
                    if (creative || hasUA) {
                        arrow.pickup = Pickup.CREATIVE_ONLY;
                    }

                    for(ModifierEntry entry : modifiers.getModifiers()) {
                        ((ProjectileLaunchModifierHook)entry.getHook(ModifierHooks.PROJECTILE_LAUNCH)).onProjectileLaunch(tool, entry, player, arrow, arrow, arrowData, arrowIndex == primaryIndex);
                    }

                    level.addFreshEntity(arrow);
                    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) * 0.5F + angle / 10.0F);
                    if (hasUA) {
                        player.addItem(arrowItem.getDefaultInstance());
                    }

                    toolData.putInt(this.BLOWPIPE_CHANCE, 0);
                }

                ToolDamageUtil.damageAnimated(tool, ammo.getCount(), player, player.getUsedItemHand());
            }
        } else if (!tool.isBroken()) {
            float drawSpeed = ConditionalStatModifierHook.getModifiedStat(tool, player, ToolStats.DRAW_SPEED);
            toolData.putInt(this.BLOWPIPE_CHANCE, (int)Math.min((double)20.0F, (double)toolData.getInt(this.BLOWPIPE_CHANCE) + (double)drawSpeed / 0.025));
        }

        return InteractionResultHolder.consume(stack);
    }
}