package com.pizza.pizza.model

import java.io.Serializable

data class Pizza(val id: Long? = null, val name: String? = null, val price: Int? = null) : Serializable
