package com.simple.test;

import com.simple.collection.MessageCollection;
import com.simple.message.Indexable;
import com.simple.message.SimpleMessage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTest {

    @Test
    public void testIndexableCollectionReflection() {
        List<MessageCollection> messageCollectionList = new ArrayList<>();
        MessageCollection messageCollection = new MessageCollection().setName("messages");

        for (long i = 0; i < 10; i++) {
            messageCollection.getMessages().add(new SimpleMessage().setId(i).setMessage("Message "+i));
        }

        messageCollectionList.add(messageCollection);

        messageCollectionList.forEach(collection -> {
            try {
                Field field = Class.forName(MessageCollection.class.getName()).getDeclaredField(collection.getName());
                field.setAccessible(true);
                if (field.getType().equals(List.class)) {
                    List<SimpleMessage> messageList = (List<SimpleMessage>) field.get(Object[].class);
                    messageList.forEach(m -> {
                        System.out.println(m);
                    });
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }


}
