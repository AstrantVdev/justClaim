package fr.astrantv.justClaim;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import fr.astrantv.justClaim.handler.CommandExecutor;
import fr.astrantv.justClaim.handler.TabCompleter;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public final class Main extends JavaPlugin {
    final static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    public static final CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    public final static MongoDatabase mongoD = mongoClient.getDatabase("database").withCodecRegistry(pojoCodecRegistry);
    public static Plugin plugin = null;
    public FileConfiguration config = this.getConfig();
    private static HashMap<String, YamlConfiguration> configs = new HashMap<>();
    @Override
    public void onEnable() {
        plugin = this;
        configs.put("gui", new YamlConfiguration());
        configs.put("FR_fr", new YamlConfiguration());

        loadConfigs();

        PluginCommand foxy = getCommand("foxy");
        foxy.setExecutor(new CommandExecutor());
        foxy.setTabCompleter(new TabCompleter());

        System.out.println("\u001B[46m\u001B[34m--------------------------------------------------------------");
        System.out.println("Foxy enabled !");
        System.out.println("\u001B[46m\u001B[34m--------------------------------------------------------------");

    }

    @Override
    public void onDisable() {
        System.out.println("\u001B[46m\u001B[34m--------------------------------------------------------------");
        System.out.println("Foxy disabled !");
        System.out.println("\u001B[46m\u001B[34m--------------------------------------------------------------");

    }

    private void createConfig(File file, String name) {

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource(name+ ".yml", false);

        }

    }

    public void loadConfigs(){
        this.saveDefaultConfig();

        for(String name : configs.keySet()){

            File file = new File(getDataFolder(), name+".yml");
            createConfig(file, name);

            configs.replace(name, YamlConfiguration.loadConfiguration(file));

        }

    }

    public static final FileConfiguration configs(String name) {
        return configs.get(name);
    }

}
