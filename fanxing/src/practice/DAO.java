package practice;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : practice
 * @ClassName : .java
 * @createTime : 2022/4/27 15:37
 * @Description :
 */
public class DAO <T>{
    private Map<String, T> map = new HashMap<>();

    public DAO() {
//        hashmap.put();
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){

        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }
    public List<T> list(){
//        这样的写法是错误的
//        return (List<T>) hashmap.values();
        // 正确写法
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t: values
             ) {
            list.add(t);
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }

//    public void show(){
//        Set<Map.Entry<String, T>> entries = map.entrySet();
//        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, T> entry = iterator.next();
//            String key = entry.getKey();
//            T value = entry.getValue();
//            System.out.println( key + ":" + value);
//        }
//    }
}
