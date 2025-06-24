package com.mogumogumo.aether_tinker.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class uu extends Item{
    public uu(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> list, @NotNull TooltipFlag flag) {

        list.add(Component.translatable("aether_tinker.item.tooltip.uu").withStyle(ChatFormatting.LIGHT_PURPLE));

        super.appendHoverText(stack, level, list, flag);
    }
}

