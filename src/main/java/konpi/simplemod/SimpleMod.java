package konpi.simplemod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
@Mod(value = SimpleMod.MOD_ID)
public class SimpleMod {
    public static final String MOD_ID = "simplemod";
    public static final String NAME = "Simple Mod";
    public static final String MC_VERSION = "1.15.2";
    public static final String MOD_VERSION = "1.0.0";
    public static final String VERSION = MC_VERSION + "-" + MOD_VERSION;

public static SimpleMod INSTANCE = null;

    public static Logger Log = LogManager.getLogger(SimpleMod.NAME);

    public SimpleMod() {
        INSTANCE = this;

        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::setupClient);
        bus.addListener(this::setupServer);

        new Items(bus);
    }

    public static SimpleMod getInstance() {
        return INSTANCE;
    }

    private static Logger get() {
        return LogManager.getLogger(SimpleMod.NAME);
    }

    public Logger getLog() {
        return Log;
    }

    private void setup(final FMLCommonSetupEvent event) {
        Log.info("Hello Minecraft!");
    }

    private void setupClient(final FMLClientSetupEvent event) {
        Render.ChangeRender();
    }

    private void setupServer(final FMLDedicatedServerSetupEvent event) {

    }
}
