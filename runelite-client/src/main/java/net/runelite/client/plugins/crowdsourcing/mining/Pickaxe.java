package net.runelite.client.plugins.crowdsourcing.mining;

import net.runelite.api.*;
import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public enum Pickaxe {
    CRYSTAL(71, ItemID.CRYSTAL_PICKAXE, 3, AnimationID.MINING_CRYSTAL_PICKAXE, AnimationID.MINING_MOTHERLODE_CRYSTAL),
    INFERNAL(61, ItemID.INFERNAL_PICKAXE, 3, AnimationID.MINING_INFERNAL_PICKAXE, AnimationID.MINING_MOTHERLODE_INFERNAL),
    DRAGON(61, ItemID.DRAGON_PICKAXE, 3, AnimationID.MINING_DRAGON_PICKAXE, AnimationID.MINING_MOTHERLODE_DRAGON),
    THIRD_AGE(61, ItemID._3RD_AGE_PICKAXE, 3, AnimationID.MINING_3A_PICKAXE, AnimationID.MINING_MOTHERLODE_3A),
    DRAGON_OR(61, ItemID.DRAGON_PICKAXE_OR, 3, AnimationID.MINING_DRAGON_PICKAXE_OR, AnimationID.MINING_MOTHERLODE_DRAGON_OR),
    DRAGON_UPGRADED(61, ItemID.DRAGON_PICKAXE_OR_25376, 3, AnimationID.MINING_DRAGON_PICKAXE_UPGRADED, AnimationID.MINING_MOTHERLODE_DRAGON_UPGRADED),
    DRAGON_OR_TRAILBLAZER(61, ItemID.DRAGON_PICKAXE_OR_25376, 3, AnimationID.MINING_DRAGON_PICKAXE_OR_TRAILBLAZER, AnimationID.MINING_MOTHERLODE_DRAGON_OR_TRAILBLAZER),
    CRYSTAL_INACTIVE(71, ItemID.CRYSTAL_PICKAXE_INACTIVE, 3, AnimationID.MINING_CRYSTAL_PICKAXE, AnimationID.MINING_MOTHERLODE_CRYSTAL),
    INFERNAL_UNCHARGED(61, ItemID.INFERNAL_AXE_UNCHARGED, 3, AnimationID.MINING_INFERNAL_PICKAXE, AnimationID.MINING_MOTHERLODE_INFERNAL),
    GILDED(41, ItemID.GILDED_PICKAXE, 3, AnimationID.MINING_GILDED_PICKAXE, AnimationID.MINING_MOTHERLODE_GILDED),
    RUNE(41, ItemID.RUNE_PICKAXE, 3, AnimationID.MINING_RUNE_PICKAXE, AnimationID.MINING_MOTHERLODE_RUNE),
    ADAMANT(31, ItemID.ADAMANT_PICKAXE, 4, AnimationID.MINING_ADAMANT_PICKAXE, AnimationID.MINING_MOTHERLODE_ADAMANT),
    MITHRIL(21, ItemID.MITHRIL_PICKAXE, 5, AnimationID.MINING_MITHRIL_PICKAXE, AnimationID.MINING_MOTHERLODE_MITHRIL),
    BLACK(11, ItemID.BLACK_PICKAXE, 5, AnimationID.MINING_BLACK_PICKAXE, AnimationID.MINING_MOTHERLODE_BLACK),
    STEEL(6, ItemID.STEEL_PICKAXE, 6, AnimationID.MINING_STEEL_PICKAXE, AnimationID.MINING_MOTHERLODE_STEEL),
    IRON(1, ItemID.IRON_PICKAXE, 7, AnimationID.MINING_IRON_PICKAXE, AnimationID.MINING_MOTHERLODE_IRON),
    BRONZE(1, ItemID.BRONZE_PICKAXE, 8, AnimationID.MINING_BRONZE_PICKAXE, AnimationID.MINING_MOTHERLODE_BRONZE),
    ;


    private static final Pickaxe[] values = Pickaxe.values();

    final int level;
    final int itemId;
    final int maxTicks;
    final int[] animIds;

    Pickaxe(int level, int itemId, int maxTicks, int... animIds) {
        this.level = level;
        this.itemId = itemId;
        this.maxTicks = maxTicks;
        this.animIds = animIds;
    }

    boolean meetsReqs(Client client) {
        return client.getRealSkillLevel(Skill.MINING) >= level;
    }

    static Optional<Pickaxe> getPickaxeFromAnim(int animId) {
        for (Pickaxe pickaxe : values) {
            if (ArrayUtils.contains(pickaxe.animIds, animId))
                return Optional.of(pickaxe);
        }
        return Optional.empty();
    }

    static Optional<Pickaxe> getPickaxeFromPlayer(Client client) {
        List<Item> items = new LinkedList<>();
        Item weapon = client.getItemContainer(InventoryID.EQUIPMENT).getItem(EquipmentInventorySlot.WEAPON.getSlotIdx());
        Item[] inv = client.getItemContainer(InventoryID.INVENTORY).getItems();
        for (Pickaxe pickaxe : values) {
            if (weapon.getId() == pickaxe.itemId || client.getItemContainer(InventoryID.INVENTORY).contains(pickaxe.itemId))
                return Optional.of(pickaxe);
        }
        return Optional.empty();
    }




















}
