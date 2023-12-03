package techdahturtle.super_coal.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import techdahturtle.super_coal.SuperCoal;
import techdahturtle.super_coal.item.ModItems;
import techdahturtle.super_coal.item.custom.BurnableBlockItem;

import java.util.function.Supplier;

import static techdahturtle.super_coal.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SuperCoal.MOD_ID);

    public static final DeferredBlock<Block> NETHER_COAL_BLOCK = registerBurnableBlock("nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)), 144);
    public static final DeferredBlock<Block> COMPRESSED_NETHER_COAL_BLOCK = registerBurnableBlock("compressed_nether_coal_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)), 1296);
    public static final DeferredBlock<Block> COMPRESSED_COAL_BLOCK = registerBurnableBlock("compressed_coal_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)), 648);
    public static final DeferredBlock<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.STONE)));

    /******************************** Registry ********************************/
    public static <T extends Block> DeferredBlock<Block> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<Block> registerBurnableBlock(String name, Supplier<T> block, int items) {
        DeferredBlock<Block> toReturn = BLOCKS.register(name, block);
        registerBurnableBlockItem(name, toReturn, items);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<Block> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredItem<Item> registerBurnableBlockItem(String name, DeferredBlock<Block> block, int items) {
        return ITEMS.register(name, () -> new BurnableBlockItem(block.get(), new Item.Properties(), items));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
