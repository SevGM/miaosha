package com.example.stock.Dao;

import com.example.stock.Entity.Spu;
import com.example.stock.Entity.SpuDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface SpuMapper {
    @Select("SELECT * FROM tb_spu WHERE id = #{spuId}")
    List<Spu> searchSpu(@Param("spuId") BigInteger spuId);

    // 从tb_spu、tb_spu_detail中查询，返回商品详情
//    @Results({@Result(column = "id", property = "id",jdbcType=JdbcType.BIGINT, id=true),
//            @Result(column = "name", property = "name",jdbcType=JdbcType.VARCHAR),
//            @Result(column = "sub_title", property = "subTitle",jdbcType=JdbcType.VARCHAR),
//            @Result(column = "description", property = "description",jdbcType=JdbcType.VARCHAR),
//            @Result(column = "brand_id", property = "brandId",jdbcType=JdbcType.BIGINT),
//            @Result(column = "saleable", property = "saleable",jdbcType=JdbcType.TINYINT),
//    })
    @Select("SELECT tb_spu.id,tb_spu.name,tb_spu.sub_title," +
            "tb_spu_detail.description,tb_spu.brand_id,tb_spu.saleable " +
            "FROM tb_spu " +
            "INNER JOIN tb_spu_detail " +
            "ON tb_spu_detail.spu_id=tb_spu.id " +
            "WHERE tb_spu.id = #{spuId}")
    List<SpuDetail> spuDetail(@Param("spuId") BigInteger spuId);
}
