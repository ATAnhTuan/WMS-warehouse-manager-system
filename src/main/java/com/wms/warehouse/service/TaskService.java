package com.wms.warehouse.service;

import com.wms.warehouse.entity.TaskEntity;
import com.wms.warehouse.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public TaskEntity getTimeintext(String input) throws ParseException {
        System.out.println(input);
        String regex = "([01]?[0-9]|2[0-3])([Hh])([0-5][0-9])|([01]?[0-9]|2[0-3])([Hh])";
        String[] words = input.split("\\s");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for (String time : words) {
            matcher = pattern.matcher(time);
            if (matcher.matches()) {
                TaskEntity task = new TaskEntity(input,time);
                setTime(input,time);
                taskRepository.save(task);
                return task;
            }
        }
        return null;
    }
    public List<TaskEntity> getAllTask () {
        return taskRepository.findAll();
    }
    public boolean deleteTask (String id) {
        if (taskRepository.findById(Long.parseLong(id)).isEmpty()) {
            return false;
        }
        taskRepository.deleteById(Long.parseLong(id));
        return true;
    }
    public void setTime (String input, String time) {
        Calendar calendar = Calendar.getInstance();
        String[] times = time.split("h");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(times[0]));
        calendar.set(Calendar.MINUTE, Integer.valueOf(times[1]));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dateSchedule = calendar.getTime();
        long period =  5 * 1000;
        // 24 * 60 * 60 * 1000
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(input);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, dateSchedule, period);
    }
}
