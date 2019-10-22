package com.example.hjw_front.repositories;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class ScheduleRepository {
    private static ScheduleRepository instance;
    private CollectionReference reference;

    private ScheduleRepository() {
        reference = FirebaseFirestore.getInstance().collection("schedules");
    }
    public static ScheduleRepository getInstance() {
        if (instance == null) instance = new ScheduleRepository();
        return instance;
    }

    public void create(String uid, Integer year, Integer month, Integer day, Integer hour, Integer minutes, String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("year", year);
        map.put("month", month);
        map.put("day", day);
        map.put("hour", hour);
        map.put("minutes", minutes);
        map.put("content", content);

        reference.add(map);
    }

    public Task<QuerySnapshot> findByUid(String uid) {
        return reference.whereEqualTo("uid", uid).get();
    }
}
