package com.dear.mapper;

import com.dear.model.Articles;
import java.util.List;

public interface ArticlesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Articles record);

    Articles selectByPrimaryKey(Integer id);

    List<Articles> selectAll();

    int updateByPrimaryKey(Articles record);
}