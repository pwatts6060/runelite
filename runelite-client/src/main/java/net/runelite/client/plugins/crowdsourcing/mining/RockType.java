package net.runelite.client.plugins.crowdsourcing.mining;

public enum RockType {
    BLURITE( "You manage to mine some blurite."),
    TIN("You manage to mine some tin."),
    COPPER("You manage to mine some copper."),
    CLAY("You manage to mine some clay."),
    IRON("You manage to mine some iron."),
    SILVER("You manage to mine some silver."),
    GOLD("You manage to mine some gold."),
    COAL("You manage to mine some coal."),
    SANDSTONE("You manage to quarry some sandstone."),
    GRANITE("You manage to quarry some granite."),
    MITHRIL("You manage to mine some mithril."),
    ADAMANT("You manage to mine some adamantite."), //?
    RUNITE("You manage to mine some runite."), //?
    AMETHYST("You manage to mine some amethyst."),
    GEMROCK("") {
        @Override
        boolean isSuccessMsg(String message) {
            return message.startsWith("You just mined");
        }
    },
    LIMESTONE("You manage to mine some limestone.");

    final String successMessage;

    RockType(String successMsg) {
        this.successMessage = successMsg;
    }

    boolean isSuccessMsg(String message) {
        return message.equals(this.successMessage);
    }
}
