package model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public interface JSONSerializable<T> {
    //将java对象序列化成JSON格式
    JSONObject toJSON(T model);
    default JSONArray toJSON(List<T> modelList){
        JSONArray array=new JSONArray();
        for(T model:modelList){
            array.add(toJSON(model));
        }
        return array;
    }

    //把JSON格式反序列化为java对象
    T fromJSON(JSONObject object);
    default List<T> fromJSON(JSONArray array){
        return array.stream().map(o->(JSONObject)o)     //Object -> JSONObject
                .map(this::fromJSON)                    //fromJSON(JSONObject object) -> T
                .collect(Collectors.toList());          //List<T>
    }
}
