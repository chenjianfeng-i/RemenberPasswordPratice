package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static List<Activity> activities = new ArrayList<>();

    // 添加一个活动
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    // 移除一个活动
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    // 移除所有活动
    public static void finishAll(){
        for (Activity activity : activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
