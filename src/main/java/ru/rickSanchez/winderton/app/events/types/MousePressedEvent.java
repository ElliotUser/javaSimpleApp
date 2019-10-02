package ru.rickSanchez.winderton.app.events.types;

import ru.rickSanchez.winderton.app.events.Event;

public class MousePressedEvent extends MouseButtonEvent {
    protected MousePressedEvent(int keyCode, int x, int y) {
        super(Type.MOUSE_PRESSED, keyCode, x, y);
    }
}
