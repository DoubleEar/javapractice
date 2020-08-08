package model;

import com.alibaba.fastjson.JSONObject;
//问卷数据
public class Survey {
    public Integer sid;
    public User user;
    public String title;
    public String brief;
    public String coverUrl;
    public String thanks;

    public static class JSONUtil implements JSONSerializable<Survey>{

        @Override
        public JSONObject toJSON(Survey model) {
            JSONObject object=new JSONObject();
            if(model.sid!=null){
                object.put("sid",model.sid);
            }
            if(model.title!=null){
                object.put("title",model.title);
            }
            if(model.brief!=null){
                object.put("brief",model.brief);
            }
            if(model.coverUrl!=null){
                object.put("coverUrl",model.coverUrl);
            }
            if(model.user!=null){
                object.put("user",User.jsonUtil.toJSON(model.user));
            }
            return object;
        }

        @Override
        public Survey fromJSON(JSONObject object) {
            return null;
        }
    }

    public static final JSONUtil jsonUtil=new JSONUtil();
}
