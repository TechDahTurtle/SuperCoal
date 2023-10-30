package techdahturtle.super_coal.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.item.ModItems;
import techdahturtle.super_coal.item.custom.BurnableBlockItem;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperCoal.MOD_ID);

    public static final RegistryObject<Block> NETHER_COAL_BLOCK = registerBurnableBlock("nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)), 144);
    public static final RegistryObject<Block> COMPRESSED_NETHER_COAL_BLOCK = registerBurnableBlock("compressed_nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)), 1296);
    public static final RegistryObject<Block> COMPRESSED_COAL_BLOCK = registerBurnableBlock("compressed_coal_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)), 648);
    public static final RegistryObject<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.STONE)));

    /******************************** Registry ********************************/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBurnableBlock(String name, Supplier<T> block, int items) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBurnableBlockItem(name, toReturn, items);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<Item> registerBurnableBlockItem(String name, RegistryObject<T> block, int items) {
        return ModItems.ITEMS.register(name, () -> new BurnableBlockItem(block.get(), new Item.Properties(), items));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
