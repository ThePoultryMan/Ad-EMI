package io.github.thepoultryman.ademi.widgets;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.widget.TankWidget;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;

import java.util.List;

public class CustomTankWidget extends TankWidget {
    public CustomTankWidget(EmiIngredient stack, int x, int y, int width, int height, long capacity) {
        super(stack, x, y, width, height, capacity);
        this.drawBack(false);
    }

    @Override
    public List<ClientTooltipComponent> getTooltip(int mouseX, int mouseY) {
        return super.getTooltip(mouseX, mouseY);
    }
}