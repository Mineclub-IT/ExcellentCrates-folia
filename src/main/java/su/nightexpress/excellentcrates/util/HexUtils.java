package su.nightexpress.excellentcrates.util;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HexUtils {

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String getHex(String msg) {
        Matcher matcher = pattern.matcher(msg);
        while (matcher.find()) {
            String color = msg.substring(matcher.start(), matcher.end());
            msg = msg.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            matcher = pattern.matcher(msg);
        }
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String colour(String s) {
        return ChatColor.translateAlternateColorCodes('&', getHex(s));
    }

    public static List<String> colourList(List<String> given) {
        List<String> list = new ArrayList<>();
        for (String s : given) {
            list.add(colour(s));
        }

        return list;
    }
}

