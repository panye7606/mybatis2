package com.how2java;

import com.how2java.pojo2.BMTableReflection;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //根据配置文件mybatis-config.xml得到sqlSessionFactory 。
        String resource ="mybatis2-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //然后再根据sqlSessionFactory 得到session
        SqlSession session=sqlSessionFactory.openSession();
        BMTableReflection student = new BMTableReflection();
        student.setName("新增加的同学");
        session.insert("insertBMTableReflection",student);

        BMTableReflection student2 = new BMTableReflection();
        student2.setId(4);
        session.delete("deleteBMTableReflection",student2);

        BMTableReflection student3=session.selectOne("getBMTableReflection",3);

        student3.setName("王五");
        session.update("updateBMTableReflection",student3);
        BMTableReflection student4=session.selectOne("getBMTableReflection",3);
        List<BMTableReflection> cs2 = session.selectList("listBMTableReflection2","新增");


        Map<String,Object> params = new HashMap<>();
        params.put("id", 3);
        params.put("name", "新增");
        List<BMTableReflection> cs3 = session.selectList("listBMTableReflection3",params);
        for(BMTableReflection s:cs3){
            System.out.println(s.getName());
        }



        //listAll(session);

        session.commit();
        session.close();

    }


    private static void listAll(SqlSession session) {
        List<BMTableReflection> cs = session.selectList("listBMTableReflection");
        for (BMTableReflection student : cs) {
            System.out.println(student.getName());
        }
    }
}
