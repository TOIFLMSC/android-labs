package com.example.lab2;

import java.util.ArrayList;
import java.util.List;

public class ItemHand{
  static ItemHand instance;
  List<Item> items;
  private  ItemHand(List<Item> items) {
      this.items = new ArrayList<Item>();
      for(Item item : items) {
          if(item.getName() != null) {
              this.items.add(item);
          }
      }

  }
  public static ItemHand createInstance(List<Item> items) {
      if(instance == null) {
          instance = new ItemHand(items);
      }
      return instance;
  }
  public static ItemHand getInstance() {
      return instance;
  }
  public List<Item> getItems() {
      return items;
  }

}
