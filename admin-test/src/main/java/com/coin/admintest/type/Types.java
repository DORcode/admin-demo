package com.coin.admintest.type;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Types
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-30 11:16
 * @Version V1.0
 **/
public class Types {

    public static void main(String[] args) throws NoSuchMethodException {
        User user = new User();
        TypeVariable<? extends Class<? extends User>>[] typeParameters = user.getClass().getTypeParameters();
        System.out.printf("1-------",typeParameters);
        Method[] methods = user.getClass().getDeclaredMethods();
        System.out.println(methods);
        Field[] fields = user.getClass().getDeclaredFields();
        Type genericType = fields[0].getGenericType();
        System.out.println(genericType);
        Class<?> type = fields[0].getType();
        System.out.println(type.getTypeName());
        System.out.println(type.getTypeParameters());
        if (genericType instanceof TypeVariable) {
            TypeVariable<?> type1 = (TypeVariable<?>) genericType;
            System.out.printf("5-------", type1.getBounds()[0]);
        }

        if (genericType instanceof ParameterizedType) {
            ParameterizedType genericType1 = (ParameterizedType) genericType;
            System.out.printf("6----------", genericType1);
        }

        System.out.println("-------------------------");


        Method get = Types.class.getDeclaredMethod("get", List.class, Map.class, List.class, Map.Entry.class);

        Type[] genericParameterTypes = get.getGenericParameterTypes();
        for (Type t : genericParameterTypes) {
            System.out.println(t.getTypeName());
            if (t instanceof ParameterizedType) {
                ParameterizedType t1 = (ParameterizedType) t;
                System.out.println(Arrays.toString(t1.getActualTypeArguments()));
                System.out.println(t1.getOwnerType());
                System.out.println(t1.getRawType());

                System.out.println("------------");
            }
        }


    }

    public <T, U> void get(List<String> strs, Map<String, List<Integer>> map, List<T> ts, Map.Entry<T, U> mapEntry) {
        System.out.println(123);
    }

    static class User<T> {
        private List<String> cs;
        private String name;
        private Integer age;
        private String[] other = {"A", "B"};

        private T t;
    }
}
