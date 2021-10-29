package com.company.player;

import com.company.Item;
import com.company.monsters.Monster;

public interface PlayerInterface {


    void equipItem(Item item, Inventory inventory, EquippedItems equippedItems, Player player);
    void unEquipItem(Item item, EquippedItems equippedItems, Inventory inventory, Player player);
    void openMonsterLoot(Monster monster);
    void takeAllLoot(Monster monster, Inventory inventory);
    void takeLoot(Monster monster, Inventory inventory, int position, Player player);
    void checkHit(Monster monster, Player player);


}
