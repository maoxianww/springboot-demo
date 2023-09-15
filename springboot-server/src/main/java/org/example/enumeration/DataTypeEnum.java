package org.example.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.dto.DataTypeEnumDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum DataTypeEnum {
    TEXT("text", "文本类型"),
    NUMBER("number", "数值类型"),
    DATE("data", "日期类型");

    private final String code;
    private final String desc;

    public static DataTypeEnum getByCode(String code) {
        return Arrays.stream(DataTypeEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public static List<DataTypeEnumDto> getEnumList(){
        return Arrays.stream(DataTypeEnum.values())
                .map( e -> new DataTypeEnumDto(e.getCode(),e.getDesc()))
                .collect(Collectors.toList());
    }

}
