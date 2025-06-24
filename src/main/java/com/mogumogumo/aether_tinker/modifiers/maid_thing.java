package com.mogumogumo.aether_tinker.modifiers;

import com.mogumogumo.aether_tinker.extend.superclass.ArmorModifier;
import com.mogumogumo.aether_tinker.utils.ModifierLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorLevelModule;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;

public class maid_thing extends ArmorModifier {
    private static final TinkerDataCapability.TinkerDataKey<Integer> PEACE = TConstruct.createKey("peace_growing_armor");

    public maid_thing() {
        MinecraftForge.EVENT_BUS.addListener(maid_thing::onUpdateApply);
    }

    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addModule(new ArmorLevelModule(PEACE, false, (TagKey)null));
    }

    private static void onUpdateApply(LivingEvent.LivingTickEvent evt) {
        LivingEntity living = evt.getEntity();
        if (!living.isSpectator()) {
            EquipmentContext context = new EquipmentContext(living);
            if (context.hasModifiableArmor() &&  living.tickCount % 20 == 0) {
                living.getCapability(TinkerDataCapability.CAPABILITY).ifPresent((holder) -> {
                    int level = (Integer)holder.get(PEACE, 0);
                    if (level > 0 && living instanceof Player player) {
                        player.heal(1);
                    }
                });
            }
        }

    }
    public boolean havenolevel() {
        return true;
    }

    public void MobEffectEvent(MobEffectEvent.Applicable event) {
        if (event.getEntity() != null && event.getEntity() instanceof LivingEntity) {
            if (ModifierLevel.EquipHasModifierlevel(event.getEntity(), this.getId())){
                if (!event.getEffectInstance().getEffect().isBeneficial()){
                    event.setResult(Event.Result.DENY);
                }}
        }
    }
}
