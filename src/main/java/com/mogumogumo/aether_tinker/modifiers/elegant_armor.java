package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.aether_tinker;
import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import com.mogumogumo.aether_tinker.register.Aeeffects;
import com.mogumogumo.aether_tinker.utils.ModifierLevel;
import com.mogumogumo.aether_tinker.utils.commout.ele;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class elegant_armor extends ArmorModifier {
    @Override
    public Component getDisplayName(int level) {
        return super.getDisplayName();
    }

    public void LivingHurtEvent(LivingHurtEvent event) {
        if (event.getEntity() != null) {
            LivingEntity entity = event.getEntity();
                if (entity instanceof Player player && ModifierLevel.getTotalArmorModifierlevel(entity, this.getId()) > 0) {
                    MobEffectInstance instance =entity.getEffect(Aeeffects.lengque.get());
                    if (event.getAmount()>=player.getHealth() && instance == null){
                        event.setCanceled(true);
                        player.heal(5-player.getHealth());
                        player.addEffect(new MobEffectInstance(Aeeffects.lengque.get(),2400, 0));
                        player.addEffect(new MobEffectInstance(Aeeffects.wudi.get(),40, 0));
                    }
            }
        }
    }
}
