package org.example.domain.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @auth: w
 * @desc:
 * @date: 2023/10/17 10:32
 */

@Component
@Data
public class NeoProperties {

    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.desc}")
    private String desc;
}
