package com.asd.backened.dto;

import com.asd.backened.entity.Setmeal;
import com.asd.backened.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
