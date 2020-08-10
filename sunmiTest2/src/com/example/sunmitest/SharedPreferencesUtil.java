package com.example.sunmitest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import org.apache.commons.codec.binary.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 缓存工具类
 *
 * @author longtao.li
 */
public class SharedPreferencesUtil {

    public static final String PREFERENCE_FILE_NAME = "obj_cache"; // 缓存文件名

    /**
     * 读取一个对象
     */
    public static Object readObj(Context context, String key) {
        Object obj = null;
        SharedPreferences pre = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, 0);
        String reply = pre.getString(key, "");
        if (TextUtils.isEmpty(reply)) {
            return null;
        }
        // 读取字节
        byte[] base64 = Base64.decodeBase64(reply.getBytes());
        // 封装到字节读取流
        ByteArrayInputStream bis = new ByteArrayInputStream(base64);
        try {
            // 封装到对象读取流
            ObjectInputStream ois = new ObjectInputStream(bis);
            try {
                // 读取对象
                obj = ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * 存储一个对象
     */
    @SuppressLint("NewApi")
	public static <T> void saveObj(Context context, T obj, String key) {
        SharedPreferences spf = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, 0);
        // 创建字节输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            // 创建对象输出流,封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            // 将对象写入字节流
            oos.writeObject(obj);
            // 将字节流编码成base64的字符串
            String list_base64 = new String(Base64.encodeBase64(bos
                    .toByteArray()));
            Editor editor = spf.edit();
            editor.putString(key, list_base64);
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除某个key对应的缓存
     */
    @SuppressLint("NewApi")
	public static void clearByKey(String key, Context context) {
        SharedPreferences spf = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, 0);
        Editor editor = spf.edit();
        editor.putString(key, "");
        editor.apply();
    }


    @SuppressLint("NewApi")
	public  static void put(Context context, String key, long value){
        SharedPreferences spf = context.getSharedPreferences(
                PREFERENCE_FILE_NAME, 0);
        Editor editor = spf.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLong(Context context, String key){
        try{
            SharedPreferences spf = context.getSharedPreferences(
                    PREFERENCE_FILE_NAME, 0);
            return  spf.getLong(key, -1L);
        }catch (Exception e){
            return -1L;
        }
    }


}
