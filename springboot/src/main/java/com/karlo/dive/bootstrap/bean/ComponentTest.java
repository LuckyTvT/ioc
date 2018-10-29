package com.karlo.dive.bootstrap.bean;

import com.karlo.dive.annotation.ConditionOnSystemProperties;
import org.springframework.stereotype.Component;

@ConditionOnSystemProperties(name="user",value = "karlo")
@Component
public class ComponentTest {

//    public static void main(String[] args) {
//        Integer sum = sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(sum);
//    }
//
//
//    public static Integer sum(Integer... values){
//        int sum = Stream.of(values).reduce(0,Integer::sum);
//        return sum;
//    }

}
