package de.diddiz.LogBlock.listeners;

import de.diddiz.LogBlock.Actor;
import de.diddiz.LogBlock.LogBlock;
import de.diddiz.LogBlock.Logging;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockFormEvent;

import static de.diddiz.LogBlock.config.Config.isLogging;

public class SnowFormLogging extends LoggingListener {
    public SnowFormLogging(LogBlock lb) {
        super(lb);
    }

//	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
//	public void onLeavesDecay(LeavesDecayEvent event) {
//		if (isLogging(event.getBlock().getWorld(), Logging.SNOWFORM))
//			consumer.queueBlockBreak("LeavesDecay", event.getBlock().getState());
//	}

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockForm(BlockFormEvent event) {
        if (isLogging(event.getBlock().getWorld(), Logging.SNOWFORM)) {
            final int type = event.getNewState().getTypeId();
            if (type == 78 || type == 79) {
                consumer.queueBlockReplace(new Actor("SnowForm"), event.getBlock().getState(), event.getNewState());
            }
        }
    }
}
