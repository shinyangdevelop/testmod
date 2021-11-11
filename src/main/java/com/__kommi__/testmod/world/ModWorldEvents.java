package com.__kommi__.testmod.world;

import com.__kommi__.testmod.TestMod;
import com.__kommi__.testmod.world.gen.ModFlowerGeneration;
import com.__kommi__.testmod.world.gen.ModOreGeneration;
import com.__kommi__.testmod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModFlowerGeneration.generateFlowers(event);
        ModTreeGeneration.generateTrees(event);
    }
}
