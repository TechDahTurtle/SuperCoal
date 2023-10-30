package techdahturtle.super_coal.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.item.custom.BurnableItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperCoal.MOD_ID);

    public static final RegistryObject<Item> TINY_COAL = ITEMS.register("tiny_coal", () -> new BurnableItem(new Item.Properties(), 1));
    public static final RegistryObject<Item> TINY_NETHER_COAL = ITEMS.register("tiny_nether_coal", () -> new BurnableItem(new Item.Properties(), 2));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}