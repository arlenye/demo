package com.example.serialize;

/**
 * Created by wb-yejian on 2018/7/13.
 */
public interface Serializer {
    /**
     *对象序列化接口
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T obj);

    /**
     *对象反序列化接口
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T deserialize(byte[] data, Class<T> clazz);
}
