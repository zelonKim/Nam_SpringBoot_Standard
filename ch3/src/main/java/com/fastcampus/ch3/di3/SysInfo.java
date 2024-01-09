package com.fastcampus.ch3.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("setting.properties")
public class SysInfo {
    @Value("#{systemProperties['user.timezone']}")
    String timeZone; // 'Asia/Seoul'

    @Value("#{systemEnvironment['PWD']}")
    String currDir; // /Users/gimseongjin/IdeaProjects/ch3




    @Value("${autosaveDir}")
    String autosaveDir; // /auto/save

    @Value("${autosaveInterval}")
    int autosaveInterval; // 30

    @Value("${autosave}")
    boolean autosave; // true


    @Override
    public String toString() {
        return "SysInfo{" +
                "timeZone='" + timeZone + '\'' +
                ", currDir='" + currDir + '\'' +
                ", autosaveDir='" + autosaveDir + '\'' +
                ", autosaveInternal=" + autosaveInterval +
                ", autosave=" + autosave +
                '}';
    }
}
