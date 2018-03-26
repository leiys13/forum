package org.applesline.forum.common;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * Created by liuyaping on 2018/3/26
 */
public class GsonFunction implements Function {

    public String call(Object[] paras, Context ctx) {
        JsonPrimitive json = (JsonPrimitive) paras[0];
        return String.valueOf(json).replace("\"","");

    }
}
