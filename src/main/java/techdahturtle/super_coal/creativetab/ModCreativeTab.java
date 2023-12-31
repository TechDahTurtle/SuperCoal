package techdahturtle.super_coal.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.block.ModBlocks;
import techdahturtle.super_coal.item.ModItems;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperCoal.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SUPER_COAL_TAB = CREATIVE_MODE_TABS.register("super_coal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.super_coal"))
            .icon(() -> new ItemStack(ModItems.TINY_COAL.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SUPER_COAL_TAB.get()) {
            event.accept(ModItems.NETHER_COAL.get());
            event.accept(ModItems.TINY_COAL.get());
            event.accept(ModItems.TINY_NETHER_COAL.get());

            event.accept(ModBlocks.NETHER_COAL_BLOCK.get());
            event.accept(ModBlocks.COMPRESSED_NETHER_COAL_BLOCK.get());
            event.accept(ModBlocks.COMPRESSED_COAL_BLOCK.get());
            event.accept(ModBlocks.NETHER_COAL_ORE.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
