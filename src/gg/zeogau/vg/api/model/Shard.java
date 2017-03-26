package gg.zeogau.vg.api.model;

/**
 * Created by geekyguy on 3/4/17.
 */
public enum Shard {
    NA("North America", "na"), EU("Europe", "eu"), SEA("South East Asia", "sg"),
    EA("East Asia", "ea"), SA("South America", "sa"), CN("China", "cn");

    private String longName;
    private String shortCode;

    Shard(String shardRegion, String shortCode) {
        this.longName = longName;
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getLongName() {
        return longName;
    }

    public static Shard findByCode(final String shortCode) {
        for (Shard shard : Shard.values()) {
            if (shard.shortCode.equalsIgnoreCase(shortCode)) {
                return shard;
            }
        }
        return null;
    }
}
