package konpi.simplemod;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraftforge.registries.ForgeRegistries.*;

public class Items {
    public static final DeferredRegister<Item> REGISTRY =
            new DeferredRegister<>(ForgeRegistries.ITEMS, SimpleMod.MOD_ID);

    public Items(IEventBus bus) {
        SimpleMod.getInstance().getLog().info("Registering items.");
        REGISTRY.register(bus);
    }
}