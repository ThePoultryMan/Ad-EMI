package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.widget.TankWidget;
import io.github.thepoultryman.ademi.AdEMI;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class CustomTankWidget extends TankWidget {
    public CustomTankWidget(EmiIngredient stack, int x, int y, int width, int height, long capacity) {
        super(stack, x, y, width, height, capacity);
        this.drawBack(false);
    }

    @Override
    public List<ClientTooltipComponent> getTooltip(int mouseX, int mouseY) {
        List<ClientTooltipComponent> tooltip = super.getTooltip(mouseX, mouseY);
        tooltip.set(
                tooltip.size() - 2,
                ClientTooltipComponent.create(FormattedCharSequence.forward(
                        this.stack.getAmount() + " " + Component.translatable(AdEMI.MOD_ID + ".millibuckets").getString(), Style.EMPTY)
                )
        );
        return tooltip;
    }
}
