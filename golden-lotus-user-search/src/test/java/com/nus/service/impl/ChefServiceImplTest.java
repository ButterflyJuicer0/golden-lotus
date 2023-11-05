package com.nus.service.impl;

import com.nus.mapper.ChefMapper;
import com.nus.pojo.vo.ChefVO;
import com.nus.service.impl.ChefServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ChefServiceImplTest {

    @Mock
    private ChefMapper chefMapper;

    @InjectMocks
    private ChefServiceImpl chefService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowAllChefsOfCategory() {
        // 模拟输入的categoryId
        Long categoryId = 1L;

        // 模拟ChefMapper的getByCategoryId方法返回的数据
        List<ChefVO> mockChefs = new ArrayList<>();
        ChefVO chef1 = new ChefVO();
        chef1.setId(1L);
        chef1.setName("Chef 1");
        ChefVO chef2 = new ChefVO();
        chef2.setId(2L);
        chef2.setName("Chef 2");
        mockChefs.add(chef1);
        mockChefs.add(chef2);

        // 使用Mockito来模拟chefMapper.getByCategoryId方法的行为
        when(chefMapper.getByCategoryId(categoryId)).thenReturn(mockChefs);

        // 调用被测试的方法
        List<ChefVO> result = chefService.showAllChefsOfCategory(categoryId);

        // 验证chefMapper.getByCategoryId方法是否被调用
        verify(chefMapper).getByCategoryId(categoryId);

        // 验证结果是否与模拟数据一致
        Assertions.assertEquals(mockChefs, result);
    }

    @Test
    public void testShowAll() {
        // 模拟ChefMapper的showAllEnableChefs方法返回的数据
        List<ChefVO> mockChefs = new ArrayList<>();
        ChefVO chef1 = new ChefVO();
        chef1.setId(1L);
        chef1.setName("Chef 1");
        ChefVO chef2 = new ChefVO();
        chef2.setId(2L);
        chef2.setName("Chef 2");
        mockChefs.add(chef1);
        mockChefs.add(chef2);

        // 使用Mockito来模拟chefMapper.showAllEnableChefs方法的行为
        when(chefMapper.showAllEnableChefs()).thenReturn(mockChefs);

        // 调用被测试的方法
        List<ChefVO> result = chefService.showAll();

        // 验证chefMapper.showAllEnableChefs方法是否被调用
        verify(chefMapper).showAllEnableChefs();

        // 验证结果是否与模拟数据一致
        Assertions.assertEquals(mockChefs, result);
    }
}
