package ru.rickSanchez.winderton.app.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import ru.rickSanchez.winderton.app.events.Event;
import ru.rickSanchez.winderton.app.layers.Layer;

@SuppressWarnings("serial")
public class Window extends Canvas {

    private BufferStrategy bs;
    private Graphics graphics;
    private JFrame frame;
    private List<Layer> layers  = new ArrayList<Layer>();

    public Window(String name, int width, int height){
        setPreferredSize(new Dimension(width, height));
        init(name);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

            }
        });
        render();

    }

    private void render() {
        if(bs == null){
            createBufferStrategy(3);
        }
        bs = getBufferStrategy();

        graphics = bs.getDrawGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, getWidth(),getHeight());
        onRender(graphics);
        graphics.dispose();
        bs.show();

        try {
            Thread.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        //мб ошибка
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Window.this.render();
            }
        });
    }



    private void init(String name){
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void onRender(Graphics graphics) {
        for(int i = 0; i < layers.size(); i++) {
            layers.get(i).onRender(graphics);
        }
    }

    private void onEvent(Event event){
        for(int i = layers.size(); i >= 0; i++) {
            layers.get(i).onEvent(event);
        }
    }

    public void addLayer(Layer layer){
        layers.add(layer);
    }
}
