package top.atstudy.mybatis.dao.mapper;

import top.atstudy.mybatis.dao.dto.GoodsDTO;
public interface GoodsMapper {

    GoodsDTO getById(Long goodsId);

}
