package me.zegs.signfix.mixin;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Mixin(SignBlockEntity.class)
public class SignLoadMixin {

    @Inject(at = @At("RETURN"), method = "readNbt")
    void readNbt(NbtCompound nbt, CallbackInfo ci) {
        SignBlockEntity self = ((SignBlockEntity) (Object) this);

        List<Text> lines = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            lines.add(self.getTextOnRow(i, false));
        }

        for (int i = 0; i < 4; i++) {
            ((SignBlockEntity) (Object) this).setTextOnRow(i, lines.get(i));
        }
    }
}
