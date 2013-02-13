/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cyberiantiger.minecraft.instances.command;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyberiantiger.minecraft.instances.Instances;
import org.cyberiantiger.minecraft.instances.Party;

/**
 *
 * @author antony
 */
public class PartyJoin extends AbstractCommand {

    public PartyJoin() {
        super(SenderType.PLAYER);
    }

    @Override
    public List<String> execute(Instances instances, Player player, String[] args) {
        if (args.length != 1) {
            return null;
        }
        Party party = instances.getParty(player);
        if (party != null) {
            return error("You are already in a party.");
        }
        party = instances.getParty(args[0]);
        if (party == null || !party.getInvites().contains(player)) {
            // Don't leak information about the existance or non-existance of the party.
            return error("You have not been invited to join " + args[0] + ".");
        }
        instances.partyAdd(party, player);
        party.emote(instances, player, " has joined the party.");
        return msg();
    }
}