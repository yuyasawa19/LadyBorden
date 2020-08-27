package tokuronI.group1.denpyoukun.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DishListDto {
    List<Dish> dishList;
    Resident resident;
}