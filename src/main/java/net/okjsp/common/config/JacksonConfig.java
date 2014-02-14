package net.okjsp.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

/**
 * User: langerhans
 * Date: 2014. 2. 11.
 * Time: 오후 3:14
 * Description : JacksonConfig
 */
@Component
public class JacksonConfig implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof MappingJackson2HttpMessageConverter) {
            MappingJackson2HttpMessageConverter jsonConverter =
                    (MappingJackson2HttpMessageConverter) bean;
            ObjectMapper objectMapper = jsonConverter.getObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            jsonConverter.setObjectMapper(objectMapper);
        }
        return bean;
    }
}