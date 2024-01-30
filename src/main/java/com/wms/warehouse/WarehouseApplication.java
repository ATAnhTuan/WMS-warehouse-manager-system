package com.wms.warehouse;

import com.wms.warehouse.entity.TaskEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class WarehouseApplication {


    public static void main(String[] args) throws ParseException {
        SpringApplication.run(WarehouseApplication.class, args);
    }
}
