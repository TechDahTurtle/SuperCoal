package techdahturtle.super_coal.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.item.ModItems;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperCoal.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SUPER_COAL_TAB = CREATIVE_MODE_TABS.register("super_coal", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.super_coal"))
            .icon(() -> new ItemStack(ModItems.TINY_COAL.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SUPER_COAL_TAB.get()) {
            event.accept(ModItems.TINY_COAL.get());
            event.accept(ModItems.TINY_NETHER_COAL.get());
        }
    }

    /******************************** Registry ********************************/
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
