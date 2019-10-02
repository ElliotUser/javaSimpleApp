package ru.rickSanchez.winderton.app.events.types;

import ru.rickSanchez.winderton.app.events.Event;

public class MouseMotionEvent extends Event {

    private int x, y;
    private boolean dragged;

    protected MouseMotionEvent(int x, int y, boolean dragged) {
        super(Type.MOUSE_MOVED);
        this.x = x;
        this.y = y;
        this.dragged = dragged;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDragged() {
        return dragged;
    }
}
