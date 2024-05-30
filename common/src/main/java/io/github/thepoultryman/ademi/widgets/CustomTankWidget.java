package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.widget.TankWidget;
import io.github.thepoultryman.ademi.AdEMI;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTextTooltip;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class CustomTankWidget extends TankWidget {

    public CustomTankWidget(EmiIngredient stack, int x, int y, int width, int height, long capacity) {
        super(stack, x - 1, y - 1, width + 2, height + 2, capacity);
        this.drawBack(false);
    }

    @Override
    public List<ClientTooltipComponent> getTooltip(int mouseX, int mouseY) {
        List<ClientTooltipComponent> tooltip = super.getTooltip(mouseX, mouseY);
        int volumeIndex = tooltip.size() - 3;
        if (tooltip.get(tooltip.size() - 1) instanceof ClientTextTooltip) {
            volumeIndex += 1;
        }
        tooltip.set(
                volumeIndex,
                ClientTooltipComponent.create(FormattedCharSequence.forward(
                        Component.translatable(AdEMI.MOD_ID + ".millibuckets", this.stack.getAmount()).getString(), Style.EMPTY)
                )
        );
        return tooltip;
    }
}
