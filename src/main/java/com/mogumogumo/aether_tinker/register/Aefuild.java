package com.mogumogumo.aether_tinker.register;

import com.mogumogumo.aether_tinker.aether_tinker;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;

import static com.mogumogumo.aether_tinker.aether_tinker.MODID;

public class Aefuild {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(MODID);
    public static final FluidObject<ForgeFlowingFluid> molten_zanite_gemstone = register("molten_zanite_gemstone", 999);
    public static final FluidObject<ForgeFlowingFluid> molten_valkyrie = register("molten_valkyrie", 999);
    public static final FluidObject<ForgeFlowingFluid> molten_warding_steel = register("molten_warding_steel", 999);
    public static final FluidObject<ForgeFlowingFluid> molten_mushroom_steel = register("molten_mushroom_steel", 999);
    public static final FluidObject<ForgeFlowingFluid> molten_stratus = register("molten_stratus", 999);//stratus
    public static final FluidObject<ForgeFlowingFluid> molten_ambrosium = register("molten_ambrosium", 999);//stratus
    public static final FluidObject<ForgeFlowingFluid> molten_ambrosium_copper = register("molten_ambrosium_copper", 999);//stratus

    public Aefuild() {
    }

    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000).descriptionId(aether_tinker.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.ENDER_DRAGON_HURT).sound(SoundActions.BUCKET_EMPTY, SoundEvents.ENDER_DRAGON_DEATH);
    }

    private static FluidType.Properties cool(String name) {
        return cool().descriptionId(aether_tinker.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.ENDER_DRAGON_HURT).sound(SoundActions.BUCKET_EMPTY, SoundEvents.ENDER_DRAGON_HURT);
    }

    private static FluidType.Properties cool() {
        return FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.ENDER_DRAGON_HURT).sound(SoundActions.BUCKET_EMPTY, SoundEvents.ENDER_DRAGON_HURT);
    }

    private static FlowingFluidObject<ForgeFlowingFluid> register(String name, int temp) {
        return FLUIDS.register(name).type(hot(name).temperature(temp).lightLevel(12)).bucket().flowing();
    }

}
