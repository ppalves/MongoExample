package br.mongo;

import br.Models.Inventory;
import br.Models.Size;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoController {

    public static void main(String[] args) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("TesteDB").withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Inventory> collection = database.getCollection("inventory", Inventory.class);
        ReadInventory.read(collection);
        System.out.println("");
        WriteInventory.writeOne(collection, new Inventory("chair", 20.0, "C", new Size(13.0, 24.0, "cm"), new ArrayList<>(Arrays.asList("red", "blue"))));
        ReadInventory.read(collection);
        System.out.println("");
        List<Inventory> inventories = new ArrayList<>();
        inventories.add(new Inventory("table", 5.0, "D", new Size(13.0, 24.0, "cm"), new ArrayList<>(Arrays.asList("red", "blue"))));
        inventories.add(new Inventory("pencil", 15.0, "A", new Size(13.0, 24.0, "cm"), new ArrayList<>(Arrays.asList("red", "blue"))));
        WriteInventory.writeMany(collection, inventories);
        ReadInventory.read(collection);
        mongoClient.close();
    }
}
