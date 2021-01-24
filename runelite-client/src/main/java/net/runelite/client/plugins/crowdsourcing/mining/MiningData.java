package net.runelite.client.plugins.crowdsourcing.mining;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.crowdsourcing.skilling.SkillingEndReason;

import java.util.List;

@Data
@AllArgsConstructor
public class MiningData
{
    private final int level;
    private final int startTick;
    private final int endTick;
    private final List<Integer> oreTicks;
    private final List<Integer> gemTicks;
    private final boolean ranToRock;
    private final int pickaxe;
    private final int amulet;
    private final int rockId;
    private final WorldPoint rockLocation;
    private final SkillingEndReason reason;
}
