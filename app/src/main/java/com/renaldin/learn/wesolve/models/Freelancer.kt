package com.renaldin.learn.wesolve.models

data class Freelancer (
    var name: String = "",
    var shortAddress: String = "",
    var lastOrder: String = "",
    var services: String = "",
    var description: String = "",
    var price: String = "",
    var photo: Int = 0,
    var phoneNumber: String = ""
)