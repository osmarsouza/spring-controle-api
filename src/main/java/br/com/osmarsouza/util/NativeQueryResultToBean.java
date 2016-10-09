package br.com.osmarsouza.util;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NativeQueryResultToBean {
	
    public static <T> T map(Class<T> type, Object[] tuple) throws ClassNotFoundException{
 	   List<Class<?>> tupleTypes = new ArrayList<>();
 	   for(Object field : tuple){
 		   if(field == null)
 			   tupleTypes.add(Class.forName("java.lang.String"));
 		   else
 	          tupleTypes.add(field.getClass());
 	   }
 	   try {
 	      Constructor<T> ctor = type.getConstructor(tupleTypes.toArray(new Class<?>[tuple.length]));
 	      return ctor.newInstance(tuple);
 	   } catch (Exception e) {
 	      throw new RuntimeException(e);
 	   }
 	}
 
    public static <T> List<T> map(Class<T> type, List<Object[]> records) throws ClassNotFoundException{
 	   List<T> result = new LinkedList<>();
 	   for(Object[] record : records){
 	      result.add(map(type, record));
 	   }
 	   return result;
    }
}
