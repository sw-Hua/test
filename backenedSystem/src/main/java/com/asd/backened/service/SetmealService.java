package com.asd.backened.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.asd.backened.dto.SetmealDto;
import com.asd.backened.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /**
     * Add a set meal and save the association between the set meal and dishes
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * To delete a set meal, delete the data associated with the set meal and dishes
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
