package top.atstudy.mybatis.service;

import top.atstudy.mybatis.dao.dto.GoodsDTO;

public interface GoodsService {

    GoodsDTO getById(Long goodsId);

}
