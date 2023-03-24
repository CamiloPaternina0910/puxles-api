package com.puxles.product_manager.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataPage {

    int page = 1;
    int elements = 10;

}
