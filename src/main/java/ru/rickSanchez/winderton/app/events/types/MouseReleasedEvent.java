package ru.rickSanchez.winderton.app.events.types;

import ru.rickSanchez.winderton.app.events.Event;

public class MouseReleasedEvent extends MouseButtonEvent {

    protected MouseReleasedEvent(int keyCode, int x, int y) {
        super(Type.MOUSE_RELEASED, keyCode, x, y);
    }
}
