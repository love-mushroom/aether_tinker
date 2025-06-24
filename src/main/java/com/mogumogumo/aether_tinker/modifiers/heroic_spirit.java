package com.mogumogumo.aether_tinker.modifiers;

import com.aetherteam.aether.entity.monster.dungeon.Valkyrie;
import com.mogumogumo.aether_tinker.aether_tinker;
import com.mogumogumo.aether_tinker.extend.superclass.BattleModifier;
import com.mogumogumo.aether_tinker.register.Aeitems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Objects;

public class heroic_spirit extends BattleModifier {

    public heroic_spirit() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.LOWEST,this::onEntityDeath);
        MinecraftForge.EVENT_BUS.addListener(this::LivingDeathEvent);
    }
    @Override
    public Component getDisplayName(int level) {
        return super.getDisplayName();
    }
    private void LivingDeathEvent(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Valkyrie valkyrie){
            ModifierUtil.dropItem(valkyrie, new ItemStack(Aeitems.valkyrie.get()));}
    }
    public static final ResourceLocation heroic_spirit = aether_tinker.getResource("heroic_spirit");
    private void onEntityDeath(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player&&event.getEntity()!=null) {
            ModDataNBT a = ToolStack.from(player.getItemBySlot(EquipmentSlot.MAINHAND)).getPersistentData();
            if (a.getFloat(heroic_spirit)<player.getMaxHealth()){
                a.putFloat(heroic_spirit, a.getFloat(heroic_spirit) + 1);
            }
        }
    }
    public float staticdamage(IToolStackView tool, int level, ToolAttackContext context, LivingEntity attacker, LivingEntity livingTarget, float baseDamage, float damage) {
        if (attacker instanceof Player player) {
            return baseDamage - tool.getPersistentData().getFloat(heroic_spirit);
        }
        return damage;
    }
}
