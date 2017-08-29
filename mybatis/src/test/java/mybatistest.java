import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
import java.util.*;
import io.ntzyz.mybatis.dao.*;
import io.ntzyz.mybatis.dao.impl.*;
import io.ntzyz.mybatis.pojo.*;


public class mybatistest {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initFactory() throws IOException{
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindAll() {
        SqlSession session = sqlSessionFactory.openSession();
        List<User> user = new ArrayList<User>();
        user = session.selectList("ntzyz.findAll");
        for (User u : user) {
            System.out.println(u.toString());
        }
    }
}
