package top.atstudy.mybatis.dao.mapper;

import top.atstudy.mybatis.dao.dto.GoodsDTO;

import java.util.List;

public interface GoodsMapper {

    long create(GoodsDTO create);

//    GoodsDTO update(GoodsDTO update);

    GoodsDTO getById(Long goodsId);

    List<GoodsDTO> find();





}
