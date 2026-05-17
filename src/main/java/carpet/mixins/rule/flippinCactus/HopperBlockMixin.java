package carpet.mixins.rule.flippinCactus;

import carpet.helpers.BlockRotator;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.HopperBlock;
import net.minecraft.entity.living.LivingEntity;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HopperBlock.class)
public class HopperBlockMixin {
    @ModifyExpressionValue(
            method = "getPlacementState",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/Direction;getOpposite()Lnet/minecraft/util/math/Direction;"
            )
    )
    private Direction flipHopperFacing(Direction original, @Local(argsOnly = true) LivingEntity entity) {
        if (BlockRotator.playerHoldsCactusOffHand(entity)) {
            return original.getOpposite();
        }

        return original;
    }
}
