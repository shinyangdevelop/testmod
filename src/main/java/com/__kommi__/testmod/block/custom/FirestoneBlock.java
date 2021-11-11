package com.__kommi__.testmod.block.custom;
import com.__kommi__.testmod.item.custom.Firestone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class FirestoneBlock extends Block {
    public FirestoneBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            if(handIn == Hand.MAIN_HAND) {
                System.out.println("I right-clicked a FirestoneBlock. Called for the Main Hand!");
            }
            if(handIn == Hand.OFF_HAND) {
                System.out.println("I right-clicked a FirestoneBlock. Called for the Off Hand!");
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        float chance = 0.25f;

        if(chance < p_180655_4_.nextFloat()) {
            p_180655_2_.addParticle(ParticleTypes.FLAME, p_180655_3_.getX() + p_180655_4_.nextDouble(),
                    p_180655_3_.getY(), p_180655_3_.getZ()+p_180655_4_.nextDouble(),
                    0d, 0.05d, 0d);

            p_180655_2_.addParticle(new BlockParticleData(ParticleTypes.BLOCK, p_180655_1_), p_180655_3_.getX()+p_180655_4_.nextDouble(),
                    p_180655_3_.getY(), p_180655_3_.getZ()+p_180655_4_.nextDouble(),
                    0.0d, 0.05d, 0.0d);
        }


        super.animateTick(p_180655_1_, p_180655_2_, p_180655_3_, p_180655_4_);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote()) {
            System.out.println("I left-clicked a FirestoneBlock");
        }
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn, 5);
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}