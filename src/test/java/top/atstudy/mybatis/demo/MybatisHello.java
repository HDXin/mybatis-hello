package top.atstudy.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.atstudy.mybatis.dao.dto.GoodsDTO;
import top.atstudy.mybatis.dao.mapper.GoodsMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisHello {

    @Test
    public void testConnection(){

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            System.out.println(" ===>> sqlSession: " + sqlSessionFactory.openSession().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(" ===>> sqlSession: " + sqlSession.toString());

            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            GoodsDTO goodsDTO = goodsMapper.getById(11L);
            System.out.println(" goodsId: " + goodsDTO.getGoodsId());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
