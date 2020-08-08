package model;

import com.alibaba.fastjson.JSONObject;
//用户数据
public class User {
    public Integer uid;
    public String username;
    public String nickname;

    public static class JSONUtil implements JSONSerializable<User>{

        @Override
        public JSONObject toJSON(User model) {
            JSONObject object=new JSONObject();
            if(model.uid!=null){
                object.put("uid",model.uid);
            }
            if(model.username!=null){
                object.put("username",model.username);
            }
            if(model.nickname!=null){
                object.put("nickname",model.nickname);
            }
            return object;
        }

        @Override
        public User fromJSON(JSONObject object) {
            return null;
        }
    }

    public static final JSONUtil jsonUtil=new JSONUtil();
}
