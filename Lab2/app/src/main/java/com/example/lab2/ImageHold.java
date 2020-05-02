package com.example.lab2;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageHold{
    private static ImageHold instance;
    public Map<String, Bitmap> images = new HashMap<>();
    ListActivityPart adapter;
    public static ImageHold createInstance(List<Item> items, ListActivityPart adapter) {
        if(instance == null) {
            instance = new ImageHold(items, adapter);
        }
        return instance;
    }

    public static ImageHold getInstance() {
        return instance;
    }

    private ImageHold(List<Item> items,ListActivityPart  adapter) {
        this.adapter = adapter;
        int[] colors = new int[300*300];
        Arrays.fill(colors, 0, 300*300, Color.GRAY);
        for(Item item : items) {
            images.put(item.getGraphic(), Bitmap.createBitmap(colors, 300, 300, Bitmap.Config.ARGB_8888));
        }
    }
    public Bitmap getImage(String graphics) {
        return images.get(graphics);
    }

}
