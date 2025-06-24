package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import com.mogumogumo.aether_tinker.register.Aeeffects;
import com.mogumogumo.aether_tinker.utils.ModifierLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class legend_head extends ArmorModifier {
    @Override
    public Component getDisplayName(int level) {
        return super.getDisplayName();
    }

    public void LivingHurtEvent(LivingHurtEvent event) {
        if (event.getEntity() != null) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof Player player && ModifierLevel.getTotalArmorModifierlevel(entity, this.getId()) > 0) {
                MobEffectInstance armor =entity.getEffect(Aeeffects.legend_lengque.get());
                MobEffectInstance lengque =entity.getEffect(Aeeffects.legend_armor.get());
                if (event.getAmount()>=player.getHealth() && armor == null){
                    event.setCanceled(true);
                    player.addEffect(new MobEffectInstance(Aeeffects.legend_armor.get(),80, 0));
                    player.addEffect(new MobEffectInstance(Aeeffects.legend_lengque.get(),240, 0));
                }
                if (!(lengque == null)){
                    event.setCanceled(true);
                }
            }
        }
    }
}
