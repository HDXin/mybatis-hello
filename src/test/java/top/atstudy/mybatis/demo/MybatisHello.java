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
import java.util.List;

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

    @Test
    public void testCreate() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(" ===>> sqlSession: " + sqlSession.toString());

        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        GoodsDTO goods = new GoodsDTO();
        goods.setGoodsId(126L);
        goods.setStoreId(589L);
        goods.setTitle("测试");
        goods.setTags("cc");

        long rows = goodsMapper.create(goods);
        sqlSession.commit();


        System.out.println(" ===>> rows: " + rows);
    }


    @Test
    public void testFind() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(" ===>> sqlSession: " + sqlSession.toString());

        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        GoodsDTO goods = new GoodsDTO();
        goods.setGoodsId(12356L);
        goods.setStoreId(56789L);
        goods.setTitle("测试");
        goods.setTags("cc");

        List<GoodsDTO> list = goodsMapper.find();
        System.out.println(" ===>> rows: " + list.toString());
    }

}
