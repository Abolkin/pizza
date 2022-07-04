package com.pizza.pizza.service

import com.pizza.pizza.model.Pizza

interface PizzaService {
    fun saveOrUpdate(pizza: Pizza)
    fun remove(id: Long)
    fun getById(id: Long): Pizza?
    fun getAll(): List<Pizza>
}
