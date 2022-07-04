package com.pizza.pizza.dao

import com.pizza.pizza.dao.model.PizzaData
import org.springframework.data.jpa.repository.JpaRepository

interface PizzaRepository : JpaRepository<PizzaData, Long>
