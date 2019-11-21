package com.zxp.label.config;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {

    @Value("${settings.probability}")
    private Integer probability;

    public Integer getProbability(){
        return probability;
    }
}
