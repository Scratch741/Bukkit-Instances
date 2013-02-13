/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cyberiantiger.minecraft.instances;

import org.bukkit.inventory.ItemStack;


/**
 *
 * @author antony
 */
public class PortalPair implements Comparable<PortalPair> {
    private final InstanceEntrancePortal enter;
    private final InstanceDestinationPortal destination;
    private final String name;
    private double entryPrice;
    private ItemStack entryItem;
    private double createPrice;
    private ItemStack createItem;
    private int unloadTime;
    private int reenterTime;

    public PortalPair(String name, InstanceEntrancePortal enter, InstanceDestinationPortal destination) {
        this(name, enter, destination, 0, 0, null, null, 0, 0);
    };

    public PortalPair(String name, InstanceEntrancePortal enter, InstanceDestinationPortal destination, double entryPrice, double createPrice, ItemStack entryItem, ItemStack createItem, int unloadTime, int reenterTime) {
        this.name = name;
        this.enter = enter;
        this.destination = destination;
        this.entryPrice = entryPrice;
        this.entryItem = entryItem;
        this.createPrice = createPrice;
        this.createItem = createItem;
        this.unloadTime = unloadTime;
        this.reenterTime = reenterTime;
        enter.setPortalPair(this);
        destination.setPortalPair(this);
    }

    public double getCreateOrEntryPrice() {
        return createPrice > 0.0D ? createPrice : entryPrice;
    }

    public ItemStack getCreateOrEntryItem() {
        return createItem == null ? entryItem : createItem;
    }

    public ItemStack getCreateItem() {
        return createItem;
    }

    public void setCreateItem(ItemStack createItem) {
        this.createItem = createItem;
    }

    public double getCreatePrice() {
        return createPrice;
    }

    public void setCreatePrice(double createPrice) {
        this.createPrice = createPrice;
    }

    public ItemStack getEntryItem() {
        return entryItem;
    }

    public void setEntryItem(ItemStack entryItem) {
        this.entryItem = entryItem;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public int getReenterTime() {
        return reenterTime;
    }

    public void setReenterTime(int reenterTime) {
        this.reenterTime = reenterTime;
    }

    public int getUnloadTime() {
        return unloadTime;
    }

    public void setUnloadTime(int unloadTime) {
        this.unloadTime = unloadTime;
    }

    public String getName() {
        return name;
    }

    public InstanceDestinationPortal getDestination() {
        return destination;
    }

    public InstanceEntrancePortal getEnter() {
        return enter;
    }

    public int compareTo(PortalPair o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(name);
        ret.append(" entrance: ");
        ret.append(enter.getCuboid().toString());
        ret.append(" destination: ");
        ret.append(destination.getCuboid().toString());
        return ret.toString();
    }
}