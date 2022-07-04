package com.pizza.pizza.service

import com.pizza.pizza.dao.PizzaRepository
import com.pizza.pizza.model.Pizza
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PizzaServiceImpl(@Autowired val pizzaRepository: PizzaRepository) : PizzaService {
    override fun saveOrUpdate(pizza: Pizza) {
        if (pizza.name != null && pizza.price != null) {
            pizzaRepository.save(pizza.toPizzaData())
        }
    }

    override fun remove(id: Long) { pizzaRepository.deleteById(id) }

    override fun getById(id: Long): Pizza? {
        return pizzaRepository.findById(id).orElse(null)?.toPizza()
    }

    override fun getAll(): List<Pizza> {
        return pizzaRepository.findAll().map { it.toPizza() }
    }
}
