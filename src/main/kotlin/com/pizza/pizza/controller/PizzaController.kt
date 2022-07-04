package com.pizza.pizza.controller

import com.pizza.pizza.model.Pizza
import com.pizza.pizza.service.PizzaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PizzaController(@Autowired val pizzaService: PizzaService) {

    @RequestMapping(value = ["/add"])
    fun addingForm(model: Model): String? {
        model.addAttribute("pizza", Pizza())
        return "add-pizza"
    }

    @RequestMapping(value = ["/edit/{id}"])
    fun editForm(@PathVariable id: Long, model: Model): String {
        model.addAttribute("pizza", pizzaService.getById(id))
        return "edit-pizza"
    }

    @GetMapping(value = ["/"])
    fun getAll(model: Model): String {
        model.addAttribute("pizzas", pizzaService.getAll())
        return "index"
    }

    @PostMapping(value = ["/add"])
    fun add(@ModelAttribute pizza: Pizza): String {
        pizzaService.saveOrUpdate(pizza)
        return "redirect:/"
    }

    @DeleteMapping(value = ["/{id}"])
    fun remove(@PathVariable id: Long): String {
        pizzaService.remove(id)
        return "redirect:/"
    }
}
