package com.nus.service.impl;

import com.nus.mapper.DishMapper;
import com.nus.pojo.entity.Dish;
import com.nus.pojo.vo.DishVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class DishServiceImplTest {

    @InjectMocks
    private DishServiceImpl dishService;

    @Mock
    private DishMapper dishMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAllDishesOfChef() {
        // 模拟 dishMapper 返回的假数据
        List<Dish> mockDishList = new ArrayList<>();
        Dish dish1 = new Dish();
        dish1.setId(1L);
        dish1.setName("Dish 1");
        Dish dish2 = new Dish();
        dish2.setId(2L);
        dish2.setName("Dish 2");
        mockDishList.add(dish1);
        mockDishList.add(dish2);

        // 设置模拟的行为
        when(dishMapper.getByChefId(1L)).thenReturn(mockDishList);

        // 调用被测试的方法
        List<DishVO> result = dishService.showAllDishesOfChef(1L);

        // 验证结果
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Dish 1", result.get(0).getName());
        Assertions.assertEquals("Dish 2", result.get(1).getName());
    }
}
