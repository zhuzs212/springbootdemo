package com.zhuzs.admin.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
  * @Description JacksonConfig配置
  * 
  * @Author zhu_zishuang
  * @Date 2020-04-25 19:20
  */
@Configuration
public class JacksonConfig {
    /**
     * 生成ObjectMapper对象
     *
     * @return ObjectMapper对象
     */
    @Bean
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException, JsonProcessingException {
                gen.writeNumber(value.toInstant(ZoneOffset.of("+8")).toEpochMilli());
            }
        });
        javaTimeModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException, JsonProcessingException {
                return LocalDateTime.ofEpochSecond(jsonParser.getLongValue() / 1000, 0, ZoneOffset.ofHours(8));
            }
        });
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }
}