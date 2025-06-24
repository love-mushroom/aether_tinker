package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import com.mogumogumo.aether_tinker.register.Aeeffects;
import com.mogumogumo.aether_tinker.utils.ModifierLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class cloud_armor extends ArmorModifier {
    @Override
    public Component getDisplayName(int level) {
        return super.getDisplayName();
    }

    public void LivingHurtEvent(LivingHurtEvent event) {
        if (event.getEntity() != null) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player player && ModifierLevel.getTotalArmorModifierlevel(entity, this.getId()) > 0) {
                if (event.getAmount()>=player.getMaxHealth()/2){
                    event.setAmount(event.getAmount() *0.85f);
                    player.heal(player.getMaxHealth()/20);
                }if (event.getAmount()<=player.getMaxHealth()/10){
                    event.setCanceled(true);
                }
            }
        }
    }
}
