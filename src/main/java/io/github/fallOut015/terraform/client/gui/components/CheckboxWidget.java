package io.github.fallOut015.terraform.client.gui.components;

import io.github.fallOut015.terraform.tool.Tool;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

public class CheckboxWidget extends Checkbox implements IToolSetting<Boolean> {
    final Tool tool;
    final String key;
    final Component translated;

    public CheckboxWidget(final Tool tool, final String key, int x, int y, boolean currentValue) {
        super(x, y, 20, 20, Component.nullToEmpty(""), currentValue, false);

        this.tool = tool;
        this.key = key;
        this.translated = new TranslatableComponent("gui." + key);
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setSettingValue(Object value) {
        if((Boolean) value != this.getSettingValue()) {
            this.onPress();
        }
    }
    @Override
    public Boolean getSettingValue() {
        return this.selected();
    }

    @Override
    public Tool getTool() {
        return this.tool;
    }

    @Override
    public Component getTranslated() {
        return this.translated;
    }
}