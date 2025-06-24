package com.mogumogumo.aether_tinker.register;

import com.mogumogumo.aether_tinker.aether_tinker;
import com.mogumogumo.aether_tinker.item.tool.ArmorDefinitions;
import com.mogumogumo.aether_tinker.item.tool.tinkeritem.SoarArmor;
import com.mogumogumo.aether_tinker.item.tool.tinkeritem.gun;
import com.mogumogumo.aether_tinker.item.tool.tinkeritem.lance;
import com.mogumogumo.aether_tinker.item.tool.toolDefinitions;
import com.mogumogumo.aether_tinker.item.uuu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.EnumObject;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.item.armor.ModifiableArmorItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.mogumogumo.aether_tinker.aether_tinker.MODID;


public class Aeitems {


    public static final ItemDeferredRegisterExtension OTHER_ITEM = new ItemDeferredRegisterExtension(MODID);
    public static final DeferredRegister<Item> ITEM=DeferredRegister.create(Registries.ITEM,MODID);
    public static final ItemObject<ToolPartItem> soar_heart = OTHER_ITEM.register("soar_heart", () -> new ToolPartItem(PART, StatlessMaterialStats.SHIELD_CORE.getIdentifier()));
    protected static final ItemDeferredRegisterExtension ModifiableItem = new ItemDeferredRegisterExtension(aether_tinker.MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "aether_tinker");
    private static final Item.Properties TOOL = (new Item.Properties()).stacksTo(1);
    private static final Item.Properties PART = (new Item.Properties()).stacksTo(64);
    private static final Item.Properties CASTS = (new Item.Properties()).stacksTo(64);

    public static List<RegistryObject<Item>> commonItem =new ArrayList<>(List.of());
    public static List<RegistryObject<Item>> toolsAndParts =new ArrayList<>(List.of());
    public static final Supplier<Item> warding_steel = registerCommonMaterials(ITEM, "warding_steel", () -> new Item(new Item.Properties()));
    private static final ItemDeferredRegisterExtension ModifiableArmor = new ItemDeferredRegisterExtension(aether_tinker.MODID);

    public static final Supplier<Item> firefly=registerCommonMaterials(ITEM,"firefly",()->new Item(new Item.Properties()));
    public static final Supplier<Item> apollo=registerCommonMaterials(ITEM,"apollo",()->new Item(new Item.Properties()));
    public static final EnumObject<ArmorItem.Type, ModifiableArmorItem> soar_armor = ModifiableArmor.registerEnum("soar_armor", ArmorItem.Type.values(), type -> new SoarArmor(ArmorDefinitions.soar_armor, type, TOOL));
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

    public static RegistryObject<Item> registerCommonMaterials(DeferredRegister<Item> register,String name, Supplier<? extends Item> sup){
        RegistryObject<Item> object = register.register(name, sup);
        StatlessMaterialStats.SHIELD_CORE.getIdentifier();
        commonItem.add(object);
        return object;
    }

    public static void register(IEventBus bus){
        ITEM.register(bus);
        OTHER_ITEM.register(bus);
        ModifiableItem.register(bus);
        ModifiableArmor.register(bus);
    }


}
//ambrosium_copper