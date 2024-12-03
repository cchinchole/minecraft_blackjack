package net.me.minecraft_blackjack;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.me.minecraft_blackjack.item.ModItems;
import net.me.minecraft_blackjack.item.ModCreativeModeTabs;
import net.minecraft.world.item.CreativeModeTabs;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(blackjack.MODID)
public class blackjack
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "minecraft_blackjack";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public blackjack(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.CARD_ACE_OF_HEARTS);
            event.accept(ModItems.CARD_TWO_OF_HEARTS);
            event.accept(ModItems.CARD_THREE_OF_HEARTS);
            event.accept(ModItems.CARD_FOUR_OF_HEARTS);
            event.accept(ModItems.CARD_FIVE_OF_HEARTS);
            event.accept(ModItems.CARD_SIX_OF_HEARTS);
            event.accept(ModItems.CARD_SEVEN_OF_HEARTS);
            event.accept(ModItems.CARD_EIGHT_OF_HEARTS);
            event.accept(ModItems.CARD_NINE_OF_HEARTS);
            event.accept(ModItems.CARD_TEN_OF_HEARTS);
            event.accept(ModItems.CARD_JACK_OF_HEARTS);
            event.accept(ModItems.CARD_QUEEN_OF_HEARTS);
            event.accept(ModItems.CARD_KING_OF_HEARTS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
