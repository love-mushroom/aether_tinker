package com.mogumogumo.aether_tinker.tool;

import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.tools.definition.ModifiableArmorMaterial;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.tools.TinkerTools;

import static slimeknights.tconstruct.TConstruct.getResource;

public class ArmorDefinitions {
    public static final ModifiableArmorMaterial GUAN = ModifiableArmorMaterial.create(getResource("guan"), Sounds.EQUIP_PLATE.getSound());
}
