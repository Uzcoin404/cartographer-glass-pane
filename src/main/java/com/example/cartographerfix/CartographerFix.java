package com.example.cartographerfix;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.TradeOffers;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartographerFix implements ModInitializer {

    public static final String MOD_ID = "cartographerfix";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.CARTOGRAPHER)
                .put(2, new TradeOffers.Factory[] {
                        (entity, random) -> new TradeOffer(
                                new TradedItem(Items.GLASS_PANE, 11),
                                new ItemStack(Items.EMERALD, 1),
                                16, 10, 0.05f)
                });

        LOGGER.info("[CartographerFix] Level 2 trade replaced with guaranteed glass pane trade.");
    }
}