package com.github.coss.common.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.github.coss.common.utils.lang.ArrayUtils;
import com.github.coss.common.utils.lang.reflect.ObjectUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CollectionUtils<E> {

    /**
     * Return <code>true</code> if the supplied Collection is <code>null</code>
     * or empty. Otherwise, return <code>false</code>.
     * 
     * @param collection the Collection to check
     * @return whether the given Collection is empty
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * Return <code>true</code> if the supplied Map is <code>null</code> or
     * empty. Otherwise, return <code>false</code>.
     * 
     * @param map the Map to check
     * @return whether the given Map is empty
     */
    public static boolean isEmpty(Map map) {
        return (map == null || map.isEmpty());
    }

    /**
     * Convert the supplied array into a List. A primitive array gets converted
     * into a List of the appropriate wrapper type.
     * <p>
     * A <code>null</code> source value will be converted to an empty List.
     * 
     * @param source the (potentially primitive) array
     * @return the converted List result
     * @see ObjectUtils#toObjectArray(Object)
     */
    public static List arrayToList(Object source) {
        return Arrays.asList(ObjectUtils.toObjectArray(source));
    }

    /**
     * Merge the given array into the given Collection.
     * 
     * @param array the array to merge (may be <code>null</code>)
     * @param collection the target Collection to merge the array into
     */
    public static void mergeArrayIntoCollection(Object array, Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        Object[] arr = ObjectUtils.toObjectArray(array);
        for (Object elem : arr) {
            collection.add(elem);
        }
    }

    /**
     * Merge the given Properties instance into the given Map, copying all
     * properties (key-value pairs) over.
     * <p>
     * Uses <code>Properties.propertyNames()</code> to even catch default
     * properties linked into the original Properties instance.
     * 
     * @param props the Properties instance to merge (may be <code>null</code>)
     * @param map the target Map to merge the properties into
     */
    public static void mergePropertiesIntoMap(Properties props, Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        if (props != null) {
            for (Enumeration en = props.propertyNames(); en.hasMoreElements();) {
                String key = (String) en.nextElement();
                Object value = props.getProperty(key);
                if (value == null) {
                    // Potentially a non-String value...
                    value = props.get(key);
                }
                map.put(key, value);
            }
        }
    }

    /**
     * Check whether the given Iterator contains the given element.
     * 
     * @param iterator the Iterator to check
     * @param element the element to look for
     * @return <code>true</code> if found, <code>false</code> else
     */
    public static boolean contains(Iterator iterator, Object element) {
        if (iterator != null) {
            while (iterator.hasNext()) {
                Object candidate = iterator.next();
                if (ObjectUtils.nullSafeEquals(candidate, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check whether the given Enumeration contains the given element.
     * 
     * @param enumeration the Enumeration to check
     * @param element the element to look for
     * @return <code>true</code> if found, <code>false</code> else
     */
    public static boolean contains(Enumeration enumeration, Object element) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                Object candidate = enumeration.nextElement();
                if (ObjectUtils.nullSafeEquals(candidate, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check whether the given Collection contains the given element instance.
     * <p>
     * Enforces the given instance to be present, rather than returning
     * <code>true</code> for an equal element as well.
     * 
     * @param collection the Collection to check
     * @param element the element to look for
     * @return <code>true</code> if found, <code>false</code> else
     */
    public static boolean containsInstance(Collection collection, Object element) {
        if (collection != null) {
            for (Object candidate : collection) {
                if (candidate == element) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return <code>true</code> if any element in '<code>candidates</code>' is
     * contained in '<code>source</code>'; otherwise returns <code>false</code>.
     * 
     * @param source the source Collection
     * @param candidates the candidates to search for
     * @return whether any of the candidates has been found
     */
    public static boolean containsAny(Collection source, Collection candidates) {
        if (isEmpty(source) || isEmpty(candidates)) {
            return false;
        }
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the first element in '<code>candidates</code>' that is contained
     * in '<code>source</code>'. If no element in '<code>candidates</code>' is
     * present in '<code>source</code>' returns <code>null</code>. Iteration
     * order is {@link Collection} implementation specific.
     * 
     * @param source the source Collection
     * @param candidates the candidates to search for
     * @return the first present object, or <code>null</code> if not found
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        if (isEmpty(source) || isEmpty(candidates)) {
            return null;
        }
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return candidate;
            }
        }
        return null;
    }

    /**
     * Find a single value of the given type in the given Collection.
     * 
     * @param collection the Collection to search
     * @param type the type to look for
     * @return a value of the given type found if there is a clear match, or
     *         <code>null</code> if none or more than one such value found
     */
    public static <T> T findValueOfType(Collection<?> collection, Class<T> type) {
        if (isEmpty(collection)) {
            return null;
        }
        T value = null;
        for (Object element : collection) {
            if (type == null || type.isInstance(element)) {
                if (value != null) {
                    // More than one value found... no clear single value.
                    return null;
                }
                value = (T) element;
            }
        }
        return value;
    }

    /**
     * Find a single value of one of the given types in the given Collection:
     * searching the Collection for a value of the first type, then searching
     * for a value of the second type, etc.
     * 
     * @param collection the collection to search
     * @param types the types to look for, in prioritized order
     * @return a value of one of the given types found if there is a clear
     *         match, or <code>null</code> if none or more than one such value
     *         found
     */
    public static Object findValueOfType(Collection<?> collection, Class<?>[] types) {
        if (isEmpty(collection) || ObjectUtils.isEmpty(types)) {
            return null;
        }
        for (Class<?> type : types) {
            Object value = findValueOfType(collection, type);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    /**
     * Determine whether the given Collection only contains a single unique
     * object.
     * 
     * @param collection the Collection to check
     * @return <code>true</code> if the collection contains a single reference
     *         or multiple references to the same instance, <code>false</code>
     *         else
     */
    public static boolean hasUniqueObject(Collection collection) {
        if (isEmpty(collection)) {
            return false;
        }
        boolean hasCandidate = false;
        Object candidate = null;
        for (Object elem : collection) {
            if (!hasCandidate) {
                hasCandidate = true;
                candidate = elem;
            } else if (candidate != elem) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find the common element type of the given Collection, if any.
     * 
     * @param collection the Collection to check
     * @return the common element type, or <code>null</code> if no clear common
     *         type has been found (or the collection was empty)
     */
    public static Class<?> findCommonElementType(Collection collection) {
        if (isEmpty(collection)) {
            return null;
        }
        Class<?> candidate = null;
        for (Object val : collection) {
            if (val != null) {
                if (candidate == null) {
                    candidate = val.getClass();
                } else if (candidate != val.getClass()) {
                    return null;
                }
            }
        }
        return candidate;
    }

    /**
     * Adapts an enumeration to an iterator.
     * 
     * @param enumeration the enumeration
     * @return the iterator
     */
    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new EnumerationIterator<E>(enumeration);
    }

    /**
     * Iterator wrapping an Enumeration.
     */
    private static class EnumerationIterator<E> implements Iterator<E> {

        private Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration) {
            this.enumeration = enumeration;
        }

        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        public E next() {
            return this.enumeration.nextElement();
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    /**
     * <p>
     * Contact Collection A to Collection B
     * </p>
     * 
     * @param <E>
     * @param c1
     * @param c2
     * @return
     */
    public static <E extends Object> Collection<E> contact(Collection<E> c1, Collection<E> c2) {
        if (c1 == null) {
            return c2;
        } else if (c2 == null) {
            return c1;
        }
        c1.addAll(c2);
        return c1;
    }

    /**
     * <p>
     * Get sub List form source list
     * </p>
     * 
     * @param sourceList source list
     * @param fromIndex start index, if less than 0, start form 0
     * @param toIndex end index, if large than sourceList.size(), ends with
     *            sourceList.size()
     * @return
     */
    public static <E extends Object> List<E> subList(List<E> sourceList, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            fromIndex = toIndex;
        }
        int endIndex = sourceList.size();
        if (fromIndex > endIndex) {
            fromIndex = endIndex;
        } else if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (toIndex > endIndex) {
            toIndex = endIndex;
        }
        return sourceList.subList(fromIndex, toIndex);
    }

    /**
     * <p>
     * Get sub List form source list
     * </p>
     * 
     * @param sourceList source list, if less than 0, start form 0
     * @param fromIndex start index
     * @return
     */
    public static <E extends Object> List<E> subList(List<E> sourceList, int fromIndex) {
        return subList(sourceList, fromIndex, sourceList.size());
    }

    /**
     * <p>
     * Convert Object[] to Object List
     * </p>
     * 
     * @param os object array
     * @return
     */
    public static <T> List<T> toList(T... os) {
        return Arrays.asList(os);
    }

    /**
     * <p>
     * Convert String[] to String List
     * </p>
     * 
     * @param strings string array
     * @return
     */
    public static List<String> toStringList(String... strings) {
        return toList(strings);
    }

    /**
     * <p>
     * Convert int[] to int List
     * </p>
     * 
     * @param ints int array
     * @return
     */
    public static List<Integer> toIntList(int... ints) {
        int len = ints.length;
        List<Integer> list = new ArrayList<Integer>(len);
        for (int i : ints) {
            list.add(i);
        }
        return list;
    }

    /**
     * <p>
     * Return subMap from target Map where the key start with appointing
     * keyPrefix, subMap's remove keyPrefix
     * </p>
     * <p>
     * subMap([key1:value1,key21:value21,key22:value22], new HashMap(), key2)
     * return [1:value21,2:value22]
     * </p>
     * 
     * @param sourceMap
     * @param targetMap
     * @param keyPrefix
     * @return
     */
    public static <E extends Object> Map<String, E> subMap(Map<String, E> sourceMap,
                                                           Map<String, E> targetMap,
                                                           String keyPrefix) {
        Set<Map.Entry<String, E>> entrys = sourceMap.entrySet();
        for (Map.Entry<String, E> entry : entrys) {
            String key = entry.getKey();
            if (key != null && key.startsWith(keyPrefix)) {
                targetMap.put(key.replace(keyPrefix, ""), entry.getValue());
            }
        }
        return targetMap;
    }

    /**
     * <p>
     * For program debug use , print each item of collection
     * </p>
     * 
     * @param c
     */
    public static void print(Collection<?> c) {
        ArrayUtils.print(c.toArray());
    }

    public static <E extends Object> boolean inList(String id, List<E> idList) {
        for (E i : idList) {
            if (i.equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * make args params to Collection
     * </p>
     * 
     * @param <T>
     * @param args
     * @return
     */
    public static <T> Collection<T> makeCollection(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args)
            result.add(item);
        return result;
    }
}
