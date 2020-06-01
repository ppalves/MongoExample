package br.Morphia;

import br.Models.Morphia.MorphiaInventory;
import br.Models.Morphia.MorphiaSize;
import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class MorphiaExample {
    public static void main(String[] args) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("br.Models");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "TesteDB");
        datastore.ensureIndexes();

        datastore.save(new MorphiaInventory(new ObjectId(), "headset", 50.0, "T", new MorphiaSize(13.0, 36.8, "cm"), new ArrayList<>(Arrays.asList("red", "blue"))));
        Query<MorphiaInventory> inventories = datastore.find(MorphiaInventory.class);
        inventories.forEach(new Consumer<MorphiaInventory>() {
            @Override
            public void accept(MorphiaInventory morphiaInventory) {
                System.out.println(morphiaInventory);
            }
        });
    }
}
