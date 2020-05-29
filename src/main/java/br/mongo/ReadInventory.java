package br.mongo;

import br.Models.Inventory;
import com.mongodb.client.MongoCollection;

import java.util.function.Consumer;

import static com.mongodb.client.model.Projections.*;

public class ReadInventory {
    public static void read(MongoCollection<Inventory> collection){
        collection.find().projection(fields(excludeId())).forEach(new Consumer<Inventory>() {
            public void accept(Inventory inventory) {
                System.out.println(inventory);
            }
        });
    }

}
