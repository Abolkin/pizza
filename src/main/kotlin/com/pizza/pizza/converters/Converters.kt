package com.pizza.pizza.service

import com.pizza.pizza.model.Pizza
import com.pizza.pizza.dao.model.PizzaData

fun Pizza.toPizzaData(): PizzaData = PizzaData(
    id = this.id ?: 0,
    name = this.name.orEmpty(),
    price = this.price ?: 0,
)

fun PizzaData.toPizza(): Pizza = Pizza(
    id = this.id,
    name = this.name,
    price = this.price,
)