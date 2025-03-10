package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    // 全件取得
    @Select("SELECT id, name, age, DATE_FORMAT(startDate, '%Y/%m/%d') AS startDate, DATE_FORMAT(endDate, '%Y/%m/%d') AS endDate FROM kensakukadai.kensyuEmployee")
    List<Employee> findAll();

    // ID検索
    @Select("SELECT id, name, age, DATE_FORMAT(startDate, '%Y/%m/%d') AS startDate, DATE_FORMAT(endDate, '%Y/%m/%d') AS endDate FROM kensakukadai.kensyuEmployee WHERE id = #{id}")
    Employee findById(@Param("id") int id);

    // 名前検索（部分一致）
    @Select("SELECT id, name, age, DATE_FORMAT(startDate, '%Y/%m/%d') AS startDate, DATE_FORMAT(endDate, '%Y/%m/%d') AS endDate FROM kensakukadai.kensyuEmployee WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Employee> findByName(@Param("name") String name);

    // 年齢範囲検索
    @Select("SELECT id, name, age, DATE_FORMAT(startDate, '%Y/%m/%d') AS startDate, DATE_FORMAT(endDate, '%Y/%m/%d') AS endDate FROM kensakukadai.kensyuEmployee WHERE age BETWEEN #{minAge} AND #{maxAge}")
    List<Employee> findByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

    // 期間検索（開始日 - 終了日）
    @Select("SELECT id, name, age, DATE_FORMAT(startDate, '%Y/%m/%d') AS startDate, DATE_FORMAT(endDate, '%Y/%m/%d') AS endDate FROM kensakukadai.kensyuEmployee WHERE startDate >= #{startDate} AND endDate <= #{endDate}")
    List<Employee> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}