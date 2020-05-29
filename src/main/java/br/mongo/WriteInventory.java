package br.mongo;

import br.Models.Inventory;
import com.mongodb.client.MongoCollection;

import java.util.List;

public class WriteInventory {
    public static void writeOne(MongoCollection<Inventory> collection, Inventory inventory){
        collection.insertOne(inventory);
    }

    public static void writeMany(MongoCollection<Inventory> collection, List<Inventory> inventories){
        collection.insertMany(inventories);
    }
}
