import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtils;

import java.util.List;

public class mybatisTest {
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectByExample(null);
        int i = mapper.countByExample(null);
        Integer all=0;
        if(i/5!=0){
            all=i/5+1;
        }
        System.out.println(all);
        Integer a=200;
        Integer b=20;
        System.out.println(a);


    }
}
