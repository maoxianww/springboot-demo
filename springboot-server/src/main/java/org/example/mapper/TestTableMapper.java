package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.entity.TestTable;
import org.example.domain.entity.TestTableExample;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestTableMapper {
    long countByExample(TestTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestTable record);

    int insertSelective(TestTable record);

    TestTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKey(TestTable record);
}