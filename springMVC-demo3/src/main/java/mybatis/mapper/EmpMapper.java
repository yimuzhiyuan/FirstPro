package mybatis.mapper;

import java.util.List;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int countByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int deleteByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int deleteByPrimaryKey(Integer employeeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int insertSelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    List<Emp> selectByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    Emp selectByPrimaryKey(Integer employeeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employees
     *
     * @mbggenerated Wed Sep 14 14:41:17 GMT+08:00 2022
     */
    int updateByPrimaryKey(Emp record);
}