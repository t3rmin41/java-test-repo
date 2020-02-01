package com.simple.test;

import com.simple.collection.MessageCollection;
import com.simple.message.Indexable;
import com.simple.message.SimpleMessage;
import org.apache.jute.Index;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {

    @Test
    public void testIndexableCollectionReflection() {
        List<MessageCollection> messageCollectionList = new ArrayList<>();
        MessageCollection messageCollection = new MessageCollection().setName("messages");

        for (long i = 1; i < 11; i++) {
            messageCollection.getMessages().add(new SimpleMessage().setId(i).setMessage("Message "+i));
        }

        messageCollectionList.add(messageCollection);

        messageCollectionList.forEach(collection -> {
            try {
                Field field = Class.forName(MessageCollection.class.getName()).getDeclaredField(collection.getName());
                // field gets only metadata of field, to get concrete value one should pass to field concrete instance of class, e.g. instance of List<Indexable>
                field.setAccessible(true);
                List<Indexable> indexables = (List<Indexable>) field.get(collection);
                indexables.forEach(i -> {
                    System.out.println(i);
                });
                System.out.println();
                List<SimpleMessage> messages = (List<SimpleMessage>) field.get(collection);
                messages.forEach(m -> {
                    System.out.println(m);
                });
            } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }


}
