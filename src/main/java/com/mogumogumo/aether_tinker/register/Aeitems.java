package com.mogumogumo.aether_tinker.register;

import com.mogumogumo.aether_tinker.aether_tinker;
import com.mogumogumo.aether_tinker.item.gongxianzhe;
import com.mogumogumo.aether_tinker.item.uu;
import com.mogumogumo.aether_tinker.item.uuu;
import com.mogumogumo.aether_tinker.tool.ArmorDefinitions;
import com.mogumogumo.aether_tinker.tool.tinkeritem.gun;
import com.mogumogumo.aether_tinker.tool.tinkeritem.lance;
import com.mogumogumo.aether_tinker.tool.tinkeritem.blowripe;
import com.mogumogumo.aether_tinker.tool.toolDefinitions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.item.armor.ModifiableArmorItem;
import slimeknights.tconstruct.library.tools.item.ranged.ModifiableBowItem;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.stats.PlatingMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.mogumogumo.aether_tinker.aether_tinker.MODID;


public class Aeitems {


    public static final ItemDeferredRegisterExtension OTHER_ITEM = new ItemDeferredRegisterExtension(MODID);
    public static final DeferredRegister<Item> ITEM=DeferredRegister.create(Registries.ITEM,MODID);
    protected static final ItemDeferredRegisterExtension ModifiableItem = new ItemDeferredRegisterExtension(aether_tinker.MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "aether_tinker");
    private static final Item.Properties TOOL = (new Item.Properties()).stacksTo(1);
    private static final Item.Properties PART = (new Item.Properties()).stacksTo(64);
    private static final Item.Properties CASTS = (new Item.Properties()).stacksTo(64);

    public static List<RegistryObject<Item>> commonItem =new ArrayList<>(List.of());
    public static List<RegistryObject<Item>> toolsAndParts =new ArrayList<>(List.of());

    public static RegistryObject<Item> registerCommonMaterials(DeferredRegister<Item> register,String name, Supplier<? extends Item> sup){
        RegistryObject<Item> object = register.register(name,sup);
        commonItem.add(object);
        return object;
    }

    public static final Supplier<Item> firefly=registerCommonMaterials(ITEM,"firefly",()->new Item(new Item.Properties()));
    public static final Supplier<Item> apollo=registerCommonMaterials(ITEM,"apollo",()->new Item(new Item.Properties()));
    public static final Supplier<Item> valkyrie=registerCommonMaterials(ITEM,"valkyrie",()->new Item(new Item.Properties()));
    public static final Supplier<Item> slime_bishop=registerCommonMaterials(ITEM,"slime_bishop",()->new Item(new Item.Properties()));
    public static final Supplier<Item> mushroom_steel=registerCommonMaterials(ITEM,"mushroom_steel",()->new Item(new Item.Properties()));
    public static final Supplier<Item> cloud_steel=registerCommonMaterials(ITEM,"cloud_steel",()->new Item(new Item.Properties()));
    public static final Supplier<Item> ambrosium_copper=registerCommonMaterials(ITEM,"ambrosium_copper",()->new Item(new Item.Properties()));
    public static final Supplier<Item> uranium_ingot=registerCommonMaterials(ITEM,"uranium_ingot",()->new Item(new Item.Properties()));
    public static final Supplier<Item> uranium_heaven = ITEMS.register("uranium_heaven", () -> new uuu(new Item.Properties()));
    public static final RegistryObject<ModifiableItem> crosier = ITEM.register("crosier", () -> new gun(TOOL, toolDefinitions.GUN));
    public static final RegistryObject<ModifiableItem> lance = ITEM.register("lance", () -> new lance(TOOL, toolDefinitions.LANCE));
    public Aeitems(){
    }

    public static void register(IEventBus bus){
        ITEM.register(bus);
        OTHER_ITEM.register(bus);
        ModifiableItem.register(bus);
    }


}
//ambrosium_copper